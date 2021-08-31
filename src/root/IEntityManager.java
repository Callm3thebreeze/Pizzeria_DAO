package root;
import java.util.Optional;

public interface IEntityManager {

    public void save();
    public <T> IEntityManager addStatement(final T entity, String sql, Statement<T> statement);
    public <T> IEntityManager addRangeStatement(final Iterable<T> iterable, String sql, Statement<T> statement);
    public <T> Optional<T> select(Class<T> clazz, Resultset<T> resultset);
}