package models;

import java.sql.Timestamp;

public class Books {
    private int book_id;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    private int quantity;
    private int issued;
    private Timestamp added_date;

    public Books() {
    }

    public Books(String callNo, String name, String author, String publisher, int quantity, int issued, Timestamp added_date) {
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.added_date = added_date;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setId(int book_id) {
        this.book_id = book_id;
    }

    public String getCallNo() {
        return callNo;
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public Timestamp getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Timestamp added_date) {
        this.added_date = added_date;
    }

    @Override
    public String toString() {
        return "books{" +
                "id=" + book_id +
                ", callno='" + callNo + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                ", issued=" + issued +
                ", added_date=" + added_date +
                '}';
    }
}
