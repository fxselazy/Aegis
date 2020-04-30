package lib.model;

import java.util.ArrayList;

public interface LibraryDao<db> {

    void insert(db obj);

    void delete(db obj);

    void update(db obj);

    db findById(String id);

    ArrayList<db> getAll();
}
