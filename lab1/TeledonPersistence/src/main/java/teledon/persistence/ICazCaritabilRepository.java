package teledon.persistence;


public interface ICazCaritabilRepository<ID,E> {
    E findOne(String s);
    Iterable<E> findAll();
    void save(E entity);
    void update(E entity);
}
