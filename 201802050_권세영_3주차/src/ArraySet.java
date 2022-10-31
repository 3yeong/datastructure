public class ArraySet implements Set{
    private Object[] objects = new Object[1000];
    private int size, i;
    @Override
    public void add(Object object) {
        for(int i=0; i<size; i++){
            if(objects[i].equals(object)) {
                System.out.println("이미 원소가 있습니다.");
                return;
            }
        }
        objects[size++] = object;
    }

    @Override
    public boolean contains(Object object) {
            for(int i=0;i<size; i++) {
                if (objects[i] == object) return true;
            }
            return false;
    }

    @Override
    public Object getFirst() {
            i=0;
            return objects[i++];
    }

    @Override
    public Object getNext() {
        return objects[i++];
    }

    @Override
    public boolean remove(Object object) {
        Object[] ob = new Object[1000];
        for(int k = 0; k<size; k++){
            if(objects[k].equals(object)){
               System.arraycopy(objects, k+1, objects, k,size);
               return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
