package root;
import java.sql.*;

public interface Statement<T> {
    void run(PreparedStatement statement, T entity) throws SQLException;
}
