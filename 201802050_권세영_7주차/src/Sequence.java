
import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.*;

public class Sequence extends AbstractSequentialList {
    private Node head = new Node(null, null, null);
    private int size;
    public Sequence(){
        head.prev = head.next = head;
    }

    public Sequence(Collection collection){
        this();
        addAll(collection);
    }

    @Override
    public ListIterator listIterator(int index) {
        return new SequenceIterator(index);
}

    @Override
    public int size() {
        return size;
    }
    private static class Node{
        Node prev, next;
        Object object;
        Node(Node p, Node n, Object o){
            this.prev = p;
            this.next = n;
            this.object = o;
        }
    }

    private  class SequenceIterator implements ListIterator{
        private Node last, next;
        private int nextIndex;
        public SequenceIterator(int i){
            if(i<0||i>size) throw new IndexOutOfBoundsException();
            nextIndex = i;
            next = head.next;
            for(int j =0; j<i; j++)
                next = next.next;
        }

        @Override
        public boolean hasNext() {
            return nextIndex<size;
        }

        @Override
        public Object next() {
            if(!hasNext()) throw new NoSuchElementException();
            last = next;
            next = next.next;
            ++nextIndex;
            return last.object;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex>0;
        }

        @Override
        public Object previous() {
            if(!hasPrevious())throw new NoSuchElementException();
            next = last = next.prev;
            --nextIndex;
            return last.object;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex -1;
        }

        @Override
        public void remove() {
            if(last == null) throw new IllegalStateException();
            last.prev.next = last.next;
            last.next.prev = last.prev;
            last = null;
            --size;
            --nextIndex;
        }

        @Override
        public void set(Object o) {
            if(last == null) throw new IllegalStateException();
            last.object = o;
        }

        @Override
        public void add(Object o) {
            Node newNode = new Node(next.prev, next, o);
            newNode.prev.next = next.prev = newNode;
            ++size;
            ++nextIndex;
            last = null;
        }

    }
}
