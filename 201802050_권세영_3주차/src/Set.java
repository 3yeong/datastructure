public interface Set {
    void add(Object object);
    boolean contains(Object object);
    Object getFirst();
    Object getNext();
    boolean remove(Object object);
    int size();
}
