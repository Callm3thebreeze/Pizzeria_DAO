package DAO;
import java.util.UUID;
import java.util.Optional;

public interface IDAO<T> {

    void insert(T t);
    Optional<T> select(UUID id);

}

    
