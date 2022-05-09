package dao;

import database.CrudUtils;
import models.Books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDAOImpl implements DAO<Books, Integer> {

    private static BooksDAOImpl booksDAOImpl;

    public BooksDAOImpl() {
    }

    public static BooksDAOImpl getInstance() {
        if (booksDAOImpl == null)
            booksDAOImpl = new BooksDAOImpl();
        return booksDAOImpl;
    }

    @Override
    public int add(Books books) {
        String sql = "insert into books (callno,name,author,publisher," +
                "quantity,issued,added_date) value(?,?,?,?,?,?,?)";

        return CrudUtils.executeUpdate(sql, books.getCallNo(), books.getName(),
                books.getAuthor(), books.getPublisher(), books.getQuantity(),
                books.getIssued(), books.getAdded_date());
    }

    @Override
    public int update(Books books) {
        String sql = "update books set callno=?, name=?, author=?," +
                "publisher=?, quantity=?, issued=? where book_id=?";

        return CrudUtils.executeUpdate(sql, books.getCallNo(), books.getName(),
                books.getAuthor(), books.getPublisher(), books.getQuantity(),
                books.getIssued(), books.getBook_id());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from books where book_id=?";

        return CrudUtils.executeUpdate(sql, id);
    }

    @Override
    public Books get(Integer id) {
        String sql = "Select * from books where book_id=?";
        ResultSet rst = CrudUtils.executeQuery(sql, id);
        Books book = null;

        try {
            if (rst.next()) {
                book = new Books();
                book.setId(rst.getInt("book_id"));
                book.setCallNo(rst.getString("callno"));
                book.setName(rst.getString("name"));
                book.setAuthor(rst.getString("author"));
                book.setPublisher(rst.getString("publisher"));
                book.setQuantity(rst.getInt("quantity"));
                book.setIssued(rst.getInt("issued"));
                book.setAdded_date(rst.getTimestamp("added_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public Books getByCallNo(String callNo) {
        String sql = "Select * from books where callno=?";
        ResultSet rst = CrudUtils.executeQuery(sql, callNo);
        Books book = null;

        try {
            if (rst.next()) {
                book = new Books();
                book.setId(rst.getInt("book_id"));
                book.setCallNo(rst.getString("callno"));
                book.setName(rst.getString("name"));
                book.setAuthor(rst.getString("author"));
                book.setPublisher(rst.getString("publisher"));
                book.setQuantity(rst.getInt("quantity"));
                book.setIssued(rst.getInt("issued"));
                book.setAdded_date(rst.getTimestamp("added_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Books> getAll() {
        String sql = "Select * from books";
        List<Books> books = new ArrayList<>();
        ResultSet rst = CrudUtils.executeQuery(sql);

        while (true) {

            try {
                if (!rst.next()) break;
                Books book = new Books();
                book.setId(rst.getInt("book_id"));
                book.setCallNo(rst.getString("callno"));
                book.setName(rst.getString("name"));
                book.setAuthor(rst.getString("author"));
                book.setPublisher(rst.getString("publisher"));
                book.setQuantity(rst.getInt("quantity"));
                book.setIssued(rst.getInt("issued"));
                book.setAdded_date(rst.getTimestamp("added_date"));

                books.add(book);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }
}
