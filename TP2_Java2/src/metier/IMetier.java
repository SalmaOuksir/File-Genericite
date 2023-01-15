package metier;
import java.io.IOException;
import java.util.List;

public interface IMetier<T> {

    public void add(T o);

    public List<T> getAll();

    public T findById(long id);

    public void delete(long id);
    public void SaveAll() throws IOException;


}
