package repositories;

import org.hibernate.Session;

import java.util.List;

public abstract class Repository<T> {
    private final Session session;

    public Repository(Session session) {
        this.session = session;
    }

    public List<T> getAll() {
        return session.createQuery(String.format("from %s", getTableName()), getEntityClass()).list();
    }

    public T getById(long id) {
        return session.get(getEntityClass(), id);
    }

    abstract String getTableName();

    abstract Class<T> getEntityClass();
}
