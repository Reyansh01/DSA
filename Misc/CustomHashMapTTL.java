package Misc;

public class CustomHashMapTTL<K, V> {

    private class Entry<K, V> {
        private K key;
        private V value;
        private long ttl;
        private long timestamp;
        private Entry<K, V> next;

        public Entry(K key, V value, long ttl) {
            this.key = key;
            this.value = value;
            this.ttl = ttl;
            this.timestamp = System.currentTimeMillis();
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > (timestamp + ttl);
        }

        public long getTtl() {
            return this.ttl;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value, long ttl) {
            this.value = value;
            this.timestamp = System.currentTimeMillis();
            this.ttl = ttl;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Entry<K, V> temp = this;
            for(int i = 0; i < SIZE; i++) {
                while(temp != null) {
                    sb.append(temp.getKey() + " -> " + temp.getValue() + "(" + temp.getTtl() + " ms), ");
                    temp = temp.next;
                }
            }
            return sb.toString();
        }
    }

    private final int SIZE = 4;
    private Entry<K, V> table[];

    public CustomHashMapTTL() {
        table = new Entry[SIZE];
    }

    public void put(K key, V value, long ttl) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = table[hash];

        if(entry == null) {
            table[hash] = new Entry<K, V>(key, value, ttl);
        } else {
            while(entry.next != null) {
                if(entry.getKey() == key) {
                    entry.setValue(value, ttl);
                    return;
                }
                entry = entry.next;
            }

            if(entry.getKey() == key) {
                entry.setValue(value, ttl);
                return;
            }

            entry.next = new Entry<K, V>(key, value, ttl);
        }
    }

    public V get(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = table[hash];
        Entry<K, V> prev = null;

        if(entry == null) {
            return null;
        }

        while(entry != null) {
            if(entry.getKey() == key) {
                if(!entry.isExpired()) {
                    return entry.getValue();
                }
                else {
                    if(prev == null) {
                        table[hash] = entry.next;
                    } else {
                        prev.next = entry.next;
                    }
                    return null;
                }
            }

            prev = entry;
            entry = entry.next;
        }

        return null;
    }

    public Entry<K, V> remove(K key) {
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

    public void cleanup() {
        for(int i = 0; i < SIZE; i++) {
            Entry<K, V> entry = table[i];
            Entry<K, V> prev = null;

            while(entry != null) {
                if(entry.isExpired()) {
                    if(prev == null) {
                        table[i] = entry.next;
                    } else {
                        prev.next = entry.next;
                    }
                } else {
                    prev = entry;
                }
                entry = entry.next;
            }
        }
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

    public static void main(String[] args) throws InterruptedException {
        CustomHashMapTTL<String, String> customHashMapTtl = new CustomHashMapTTL<>();
        customHashMapTtl.put("A", "B", 10000);
        customHashMapTtl.put("E", "F", 20000);
        customHashMapTtl.put("H", "P", 10000);
        customHashMapTtl.put("P", "2", 5000);
        customHashMapTtl.put("1",  "G", 8000);
        customHashMapTtl.put("2", "6", 12000);
        customHashMapTtl.put("3", "2", 18000);
        customHashMapTtl.put("4", "4", 15000);
        customHashMapTtl.put("1",  "H", 30000);
    
        System.out.println(customHashMapTtl);
        System.out.println(customHashMapTtl.get("P"));
        Thread.sleep(6000);
        customHashMapTtl.cleanup();
        System.out.println(customHashMapTtl);
    }

}
