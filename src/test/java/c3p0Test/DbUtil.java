package c3p0Test;
import java.sql.Connection;
import java.sql.SQLException;
public class DbUtil {
    public static Connection getConnection() throws SQLException {
        DBPool pool = DBPool.getInstance();
        return pool.getConnection();
    }
}
