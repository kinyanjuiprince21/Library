package models;

public class Librarian {
    private int librarian_id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private String contact;

    public Librarian() {
    }

    public Librarian(int librarian_id, String name, String password, String email, String address, String city, String contact) {
        this.librarian_id = librarian_id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact = contact;
    }

    public int getLibrarian_id() {
        return librarian_id;
    }

    public void setId(int librarian_id) {
        this.librarian_id = librarian_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "librarian{" +
                "id=" + librarian_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
