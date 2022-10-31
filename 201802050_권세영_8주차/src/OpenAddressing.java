import java.util.*;

public class OpenAddressing implements Map {
    private Entry[] entries;
    private  int size, used;
    private  int capacity;
    private float loadFacor;
    private final Entry NIL = new Entry(null, null);

    public OpenAddressing(int capacity, float loadFacor){
        entries = new Entry[capacity];
        this.capacity = capacity;
        this.loadFacor = loadFacor;
    }
    public OpenAddressing(int capacity){
        this(capacity, 0.75F);
    }
    public OpenAddressing(){
        this(101);
    }
    public void setEntries(Entry[] entries) {
        this.entries = entries;
    }
    @Override
    public int size() {
        return size;
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
        for(int i = 0; i<entries.length; i++){
            int j = nextProbe(h,i);
            Entry entry = entries[j];
            if(entry == null) break;
            if(entry == NIL)continue;
            if(entry.key.equals(key))return entry.value;
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if(used > loadFacor*entries.length) rehash();
        int h = hash(key);
        for(int i = 0; i<entries.length; i++){
            int j = nextProbe(h,i);
            Entry entry = entries[j];
            if(entry == null){
                entries[j] = new Entry(key, value);
                ++size;
                ++used;
                return null;
            }
            if(entry == NIL)continue;
            if(entry.key.equals(key)){
                Object oldValue = entry.value;
                entries[j].value = value;
                return oldValue;
            }
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        int h = hash(key);
        for(int i = 0; i<entries.length; i++){
            int j = nextProbe(h,i);
            Entry entry = entries[j];
            if(entry == null) break;
            if(entry == NIL) continue;
            if(entry.key.equals(key)){
                Object oldValue = entry.value;
                entries[j] = NIL;
                --size;
                return oldValue;
            }
        }
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
            if(entries[i] !=null){
                ((ArrayList<Object>) ob).add(entries[i].value);
                }
            }
        return ob;
    }

    @Override
    public Set<Entry> entrySet() {
        Set<Entry> ob = new HashSet<>();
        for(Entry en : entries){
            ob.add(en);
        }
       return ob;
    }
    private int hash(Object key){
        if(key == null) throw new IllegalArgumentException();
        return (key.hashCode() & 0x7FFFFFFF)%entries.length;
    }

    private int nextProbe(int h, int i){
        return (h+i)%entries.length;
    }
    private void rehash(){
        Entry[] oldEntries = entries;
        entries = new Entry[2*oldEntries.length +1];
        for(int k = 0; k<oldEntries.length; k++){
            Entry entry = oldEntries[k];
            if(entry == null || entry == NIL) continue;
            int h = hash(entry.key);
            for(int i = 0; i<entries.length; i++){
                int j = nextProbe(h,i);
                if(entries[j] == null){
                    entries[j] = entry;
                    break;
                }
            }
        }
        used = size;
    }
    private class Entry{
        Object key, value;
        Entry(Object k, Object v){
            key = k;
            value = v;
        }
        public String toString(){
            return key + "=" +value;
        }
    }
}
