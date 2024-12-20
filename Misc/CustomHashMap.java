package Misc;

public class CustomHashMap<K, V> {

    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Entry<K, V> temp = this;
            for(int i = 0; i < SIZE; i++) {
                while(temp != null) {
                    sb.append(temp.getKey() + " -> " + temp.getValue() + ", ");
                    temp = temp.next;
                }
            }
            return sb.toString();
        }
    }

    private final int SIZE = 4;
    private Entry<K, V> table[];
    private V nullValue;

    public CustomHashMap() {
        table = new Entry[SIZE];
    }

    public void put(K key, V value) {
        if(key == null) { 
            nullValue = value;
            return;
        }

        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = table[hash];

        if(entry == null) {
            table[hash] = new Entry<K, V>(key, value);
        } else {
            while(entry.next != null) {
                if(entry.getKey() == key) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }

            if(entry.getKey() == key) {
                entry.setValue(value);
                return;
            }

            entry.next = new Entry<K, V>(key, value);
        }
    }

    public V get(K key) {
        if(key == null) {
            return nullValue;
        }

        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = table[hash];

        if(entry == null) {
            return null;
        }

        while(entry.next != null) {
            if(entry.getKey() == key) {
                return entry.getValue();
            }
            entry = entry.next;
        }

        return null;
    }

    public Entry<K, V> remove(K key) {
        if(key == null) {
            nullValue = null;
            return new Entry<K,V>(key, nullValue);
        }
        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = table[hash];

        if(entry == null) {
            return null;
        }

        if(entry.getKey() == key) {
            table[hash] = entry.next;
            entry.next = null;
            return entry;
        }

        // delete at nth position of a linked list
        Entry<K, V> prev = entry;
        entry = entry.next;
        while(entry != null) {
            if(entry.getKey() == key) {
                prev.next = entry.next;
                entry.next = null;
                return entry;
            }
            prev = entry;
            entry = entry.next;
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < SIZE; i++) {
            if(table[i] != null) { 
                sb.append(i + ":: " + table[i] + " \n");
            } else {
                sb.append(i + ":: null" + " \n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomHashMap<String, String> customHashMap = new CustomHashMap<>();
        customHashMap.put("A", "B");
        customHashMap.put("E", "F");
        customHashMap.put("H", "P");
        customHashMap.put("P", "2");
        customHashMap.put("1",  "G");
        customHashMap.put("2", "6");
        customHashMap.put("3", "2");
        customHashMap.put("4", "4");
        customHashMap.put("1",  "H");
        customHashMap.put(null,  "Q");
    
        System.out.println(customHashMap);
        System.out.println(customHashMap.get(null));
        System.out.println(customHashMap.remove("E"));
        // System.out.println(customHashMap);
        // System.out.println(customHashMap.remove(null));
        System.out.println(customHashMap);
    }

}
