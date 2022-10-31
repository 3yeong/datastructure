import java.util.*;

public class CloseAddressing implements Map {
    private  Entry[] entries;
    private  int size;
    private int capacity;
    private float loadFactor;

    public CloseAddressing(int capacity, float loadFactor)
    {
        entries = new Entry[capacity];
        this.loadFactor = loadFactor;
        this.capacity = capacity;
    }

    public CloseAddressing(int capacity){
        this(capacity, 0.75F);
    }

    public CloseAddressing(){
        this(101);
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        for(int i = 0; i<entries.length; i++){
            if(entries[i].key.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(Object ob : values())
            if(ob.equals(value))
                return true;
        return false;
    }

    @Override
    public Object get(Object key) {
      int h = hash(key);
      for(Entry e = entries[h]; e!=null; e = e.next){
          if(e.key.equals(key)) return e.value;
      }
      return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int h = hash(key);
        for(Entry e = entries[h]; e!=null; e = e.next){
            if(e.key.equals(key)){
                Object oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        entries[h] = new Entry(key,value,entries[h]);
        ++size;
        if(size>loadFactor*entries.length) rehash();
        return null;
    }

    @Override
    public void putAll(Map m) {
        for (Object key : m.keySet()) {
            Object val = m.get(key);
            put(key, val);
        }
    }

    @Override
    public void clear() {
        entries = new Entry[capacity];
    }

    @Override
    public Set keySet() {
        Set<Object> ob = new HashSet<>();
        for(Object key : entries){
            ob.add(key);
        }
        return ob;
    }

    @Override
    public Collection values() {
        Collection<Object> ob = new ArrayList<>();
        for(int i = 0; i<entries.length; i++){
            Entry p = entries[i];
            if(entries[i]!=null){
                ob.add(p.value);
                while (p.next !=null){
                    p = p.next;
                    ob.add(p.value);
                }
            }
        }
        return ob;
}

    @Override
    public Set<Entry> entrySet() {
        Set<Entry> ob = new HashSet<>();
        for(int  i = 0; i<entries.length; i++){
            Entry p = entries[i];
            if(p !=null){
                ob.add(p);
                while (p.next != null){
                    p = p.next;
                    ob.add(p);
                }
            }
        }
        return ob;
    }

    public Object remove(Object key){
        int h = hash(key);
        for(Entry e = entries[h], prev = null; e!=null; prev = e, e = e.next) {
            if(e.key.equals(key)){
                Object oldValuev = e.value;
                if(prev == null) entries[h] = e.next;
                else prev.next = e.next;
                --size;
                return oldValuev;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }

    private class Entry{
        Object key, value;
        Entry next;
        Entry(Object k, Object v, Entry n){
            key = k;
            value = v;
            next = n;
        }
        public String toString(){
            return key + "=" +value;
        }
    }

    private int hash(Object key){
        if(key == null) throw new IllegalArgumentException();
        return (key.hashCode() & 0x7FFFFFF)%entries.length;
     }

     private void rehash(){
        Entry[] oldEntries = entries;
        entries = new Entry[2*oldEntries.length + 1];
        for(int k =0; k<oldEntries.length; k++){
            for(Entry old = oldEntries[k];old !=null;){
                Entry e = old;
                old = old.next;
                int h = hash(e.key);
                e.next = entries[h];
                entries[h] = e;
            }
        }
     }
}
