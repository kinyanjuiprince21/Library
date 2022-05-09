# Library
Library management System
The System Conists of several packages.The database package to manage database connection and crud utils operations.
The System has an admin that can add a librarian, delete a librarian and check all the available librarians.
It consists of also a librarian that can add books, issue book and return issued books.
All this operations of the librarian issuing books and returning book are all updated in the database in that a book issued is updated on the issued column its value
is incremented and the quantity column its value is decremented and the book's row is added in the issue_books table and it is the reverse when the book is returned.
Also when the book is returned, its row on the issue_books is deleted.
