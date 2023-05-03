package IFE_MP_LK;

import java.io.IOException;

public interface Dao<T> {

    T read() throws IOException, ClassNotFoundException;

    void write(T obj) throws IOException;

}
