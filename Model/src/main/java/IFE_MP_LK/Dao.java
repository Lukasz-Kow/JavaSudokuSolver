package IFE_MP_LK;

public interface Dao<T> {

    T read();

    void write(T obj);

}
