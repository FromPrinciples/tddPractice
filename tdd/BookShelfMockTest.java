package tdd;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookShelfMockTest extends TestCaseMo {
    public BookShelfMockTest(String s){
        super(s);
    }

    public void testBookShelfClass() {
        MockConnection mockConnection = new MockConnection();
        BookShelf bookShelf = new BookShelf(mockConnection);
        assertTrue(bookShelf != null);
    }
}

public class BookShelf {
    private Connection connection;

    public BookShelf (Connection connection){
        this.connection = connection;
    }

    public void testPut () throws SQLException {
        connection.addExpectedPreparedStatementString(
                "insert into book(num, isbn, title) values(?,?,?)");
        MockPreparedStatement statement = new MockPreparedStatement();
        connection.addExpectedPreparedStatement(statement);
        int num = 1;
        String isbn = "021146530";
        String title = "TestDrivenDevelopmentByExample";
        Book book = new Book(num, isbn, title);
        bookShelf.put(book);
        connection.verify();

    }

    public void put(Book book) throws SQLException{
        PreparedStatement psmt = connection.prepareStatement(PUT_SQL);
    }

    public void testPut() throws SQLException {
        statement.setExpectedExecuteCalls(1);

        int num = 1;
        String isbn = "0321146530";
        String title = "TestDrivenDevelopmentByExample";

        Book book = new Book(num, isbn, title);
        bookShelf.put(book);
        connection.verity();
        statement.verify();
    }

    public static String PUT_SQL = "insert into book (num, isbn) values(?,?,?)";

    public void put (Book book) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(PUT_SQL);
        pstmt.executeUpdate();

        connection.prepareStatement(PUT_SQL);
        pstmt.setInt(1, book.getNumberOfPages());
        pstmt.setString(2, book.getIsbn());
        pstmt.setString(3, book.getTitle());
        pstmt.executeUpdate();

    }

    public void testPut () throws SQLException {
        int num = 1;
        String isbn = "0211146530";
        String title = "TestDrivenDevelopmentByExample";

        statement.addExpectedSetParameter(1, num);
        statement.addExpectedSetParameter(2, isbn);
        statement.addExpectedSetParameter(3, title);

        Book book = new Book(num, isbn, title);
        bookShelf.put(book);
        connection.verify();
        statement.verify();


    }


}
