package dao;

import database.CrudUtils;
import models.Librarian;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDAOImpl implements DAO<Librarian, Integer> {

    private static LibrarianDAOImpl librarianDAOImpl;

    public LibrarianDAOImpl() {
    }

    public static LibrarianDAOImpl getInstance() {
        if (librarianDAOImpl == null)
            librarianDAOImpl = new LibrarianDAOImpl();
        return librarianDAOImpl;
    }

    @Override
    public int add(Librarian librarian) {
        String sql = "insert into librarian (name, password, email, address, city," +
                "contact) value(?,?,?,?,?,?)";


        return CrudUtils.executeUpdate(sql, librarian.getName(), librarian.getPassword(),
                librarian.getEmail(), librarian.getAddress(), librarian.getCity(),
                librarian.getContact());
    }

    @Override
    public int update(Librarian librarian) {
        String sql = "update librarian set name=?, password=?, email=?, address=?," +
                "city=?, contact=? where librarian_id=?";
        return CrudUtils.executeUpdate(sql, librarian.getName(), librarian.getPassword(),
                librarian.getEmail(), librarian.getAddress(), librarian.getCity(),
                librarian.getContact(), librarian.getLibrarian_id());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from librarian where librarian_id=?";
        return CrudUtils.executeUpdate(sql, id);
    }

    @Override
    public Librarian get(Integer id) {
        String sql = "select * from librarian where librarian_id=?";
        ResultSet rst = CrudUtils.executeQuery(sql, id);
        Librarian Librarian = null;

        try {
            if (rst.next()) {
                Librarian = new Librarian();
                Librarian.setId(rst.getInt("librarian_id"));
                Librarian.setName(rst.getString("name"));
                Librarian.setPassword(rst.getString("password"));
                Librarian.setEmail(rst.getString("email"));
                Librarian.setAddress(rst.getString("address"));
                Librarian.setCity(rst.getString("city"));
                Librarian.setContact(rst.getString("contact"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Librarian;
    }

    public Librarian getByName(String name) {
        String sql = "select * from librarian where name=?";
        ResultSet rst = CrudUtils.executeQuery(sql, name);
        Librarian Librarian = null;

        try {
            if (rst.next()) {
                Librarian = new Librarian();
                Librarian.setId(rst.getInt("librarian_id"));
                Librarian.setName(rst.getString("name"));
                Librarian.setPassword(rst.getString("password"));
                Librarian.setEmail(rst.getString("email"));
                Librarian.setAddress(rst.getString("address"));
                Librarian.setCity(rst.getString("city"));
                Librarian.setContact(rst.getString("contact"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Librarian;
    }
    @Override
    public List<Librarian> getAll() {
        String sql = "Select * from librarian";
        List<Librarian> Librarians = new ArrayList<>();
        ResultSet rst = CrudUtils.executeQuery(sql);

        while (true) {
            try {
                if (!rst.next()) break;
                Librarian Librarian = new Librarian();
                Librarian.setId(rst.getInt("librarian_id"));
                Librarian.setName(rst.getString("name"));
                Librarian.setPassword(rst.getString("password"));
                Librarian.setEmail(rst.getString("email"));
                Librarian.setAddress(rst.getString("address"));
                Librarian.setCity(rst.getString("city"));
                Librarian.setContact(rst.getString("contact"));

                Librarians.add(Librarian);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Librarians;
    }
}
