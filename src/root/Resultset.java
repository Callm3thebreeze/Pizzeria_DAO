package root;
import java.sql.SQLException;
import java.sql.ResultSet;

public interface Resultset<T> {
    public void run(ResultSet resulSet, T entity) throws SQLException;
}
