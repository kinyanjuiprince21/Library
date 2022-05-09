package models;
import java.sql.Timestamp;


public class IssueBooks {
    private int issuedBook_id;
    private String book_call_no;
    private int student_id;
    private String student_name;
    private String student_contact;
    private Timestamp issued_date;

    public IssueBooks() {
    }

    public IssueBooks(int issuedBook_id, String book_call_no, int student_id, String student_name, String student_contact, Timestamp issued_date) {
        this.issuedBook_id = issuedBook_id;
        this.book_call_no = book_call_no;
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_contact = student_contact;
        this.issued_date = issued_date;
    }

    public int getIssuedBook_id() {
        return issuedBook_id;
    }

    public void setId(int issuedBook_id) {
        this.issuedBook_id = issuedBook_id;
    }

    public String getBook_call_no() {
        return book_call_no;
    }

    public void setBook_call_no(String book_call_no) {
        this.book_call_no = book_call_no;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_contact() {
        return student_contact;
    }

    public void setStudent_contact(String student_contact) {
        this.student_contact = student_contact;
    }

    public Timestamp getIssued_date() {
        return issued_date;
    }

    public void setIssued_date(Timestamp issued_date) {
        this.issued_date = issued_date;
    }

    @Override
    public String toString() {
        return "issue_books{" +
                "id=" + issuedBook_id +
                ", book_call_no='" + book_call_no + '\'' +
                ", student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_contact='" + student_contact + '\'' +
                ", issued_date=" + issued_date +
                '}';
    }
}