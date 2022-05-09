package dao;

import database.CrudUtils;
import models.IssueBooks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IssueBookDAOImpl implements DAO<IssueBooks, Integer> {

    private static IssueBookDAOImpl issueBookDAOImpl;

    public IssueBookDAOImpl() {
    }

    public static IssueBookDAOImpl getInstance() {
        if (issueBookDAOImpl == null)
            issueBookDAOImpl = new IssueBookDAOImpl();
        return issueBookDAOImpl;
    }

    @Override
    public int add(IssueBooks issue_books) {
        String sql = "insert into issue_books (book_call_no, student_id," +
                "student_name, student_contact, issued_date) value(?,?,?,?,?)";
        return CrudUtils.executeUpdate(sql, issue_books.getBook_call_no(),
                issue_books.getStudent_id(), issue_books.getStudent_name(),
                issue_books.getStudent_contact(), issue_books.getIssued_date());
    }

    @Override
    public int update(IssueBooks issue_books) {
        String sql = "update issue_books set book_call_no=?, student_id=?," +
                "student_name=?, student_contact=? where issuedBook_id=?";

        return CrudUtils.executeUpdate(sql, issue_books.getBook_call_no(),
                issue_books.getStudent_id(), issue_books.getStudent_name(),
                issue_books.getStudent_contact(), issue_books.getIssuedBook_id());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete  from issue_books where issuedBook_id=?";

        return CrudUtils.executeUpdate(sql, id);
    }

    public int delete(String CallNo,Integer id) {
        String sql = "delete  from issue_books where book_call_no=? and student_id=?";

        return CrudUtils.executeUpdate(sql, CallNo, id);
    }

    @Override
    public IssueBooks get(Integer id) {
        String sql = "Select * from issue_books where issuedBook_id=?";
        ResultSet rst = CrudUtils.executeQuery(sql, id);
        IssueBooks issue_book = null;

        try {
            if (rst.next()) {
                issue_book = new IssueBooks();
                issue_book.setId(rst.getInt("issuedBook_id"));
                issue_book.setBook_call_no(rst.getString("book_call_no"));
                issue_book.setStudent_id(rst.getInt("student_id"));
                issue_book.setStudent_name(rst.getString("student_name"));
                issue_book.setStudent_contact(rst.getString("student_contact"));
                issue_book.setIssued_date(rst.getTimestamp("issued_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return issue_book;
    }

    public IssueBooks get(String sql,Object... parameters) {
        ResultSet rst = CrudUtils.executeQuery(sql, parameters);
        IssueBooks issue_book = null;

        try {
            if (rst.next()) {
                issue_book = new IssueBooks();
                issue_book.setId(rst.getInt("issuedBook_id"));
                issue_book.setBook_call_no(rst.getString("book_call_no"));
                issue_book.setStudent_id(rst.getInt("student_id"));
                issue_book.setStudent_name(rst.getString("student_name"));
                issue_book.setStudent_contact(rst.getString("student_contact"));
                issue_book.setIssued_date(rst.getTimestamp("issued_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return issue_book;
    }

    @Override
    public List<IssueBooks> getAll() {
        String sql = "Select * from issue_books";
        ResultSet rst = CrudUtils.executeQuery(sql);
        List<IssueBooks> issue_books = new ArrayList<>();

        while (true) {
            try {
                if (!rst.next()) break;
                IssueBooks issue_book = new IssueBooks();
                issue_book.setId(rst.getInt("issuedBook_id"));
                issue_book.setBook_call_no(rst.getString("book_call_no"));
                issue_book.setStudent_id(rst.getInt("student_id"));
                issue_book.setStudent_name(rst.getString("student_name"));
                issue_book.setStudent_contact(rst.getString("student_contact"));
                issue_book.setIssued_date(rst.getTimestamp("issued_date"));

                issue_books.add(issue_book);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return issue_books;
    }
}
