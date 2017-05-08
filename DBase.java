import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBase
{
    private static DBase dBase;
    private Connection con;

    private DBase() {
        try {
            connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connectToDatabase() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:mysql://localhost/earning","root","root");
    }

    public static DBase getInstance()
    {
        if (dBase == null)
            dBase = new DBase();
        return dBase;
    }

    public Connection getConnection()
    {
        return con;
    }

    public Statement createStatement() throws SQLException {
        return con.createStatement();
    }
}
