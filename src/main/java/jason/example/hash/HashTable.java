package jason.example.hash;

import jason.example.hash.dataobject.HashRecord;

public class HashTable {
    private final static Integer MAX = 8;

    private HashRecord[] table;

    public HashTable() {
        table = new HashRecord[MAX];
    }

    public void put(String key, String value) {
        int hash = key.hashCode() & 0x7fffffff % MAX;

        HashRecord entry = table[hash];

        // duplicate
        if (entry != null) {
            // overwrite duplicate
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
            }
            // traverse to end
            while (entry.getNext() != null) {
                entry = entry.getNext();
            }

            // have end, put new entry as next
            entry.setNext(new HashRecord(key, value));

        } else {
            // create new entry
            table[hash] = new HashRecord(key, value);
        }
    }

    public String remove(String key) {
        String result = null;

        if (key == null || key.isEmpty()) {
            return result;
        }

        int hash = key.hashCode() & 0x7fffffff % MAX;
        HashRecord entry = table[hash];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                table[hash] = null;
                return entry.getValue();
            }

            entry = entry.getNext();
        }

        return result;
    }

    public String get(String key) {
        String result = null;

        if (key == null || key.isEmpty()) {
            return result;
        }

        int hash = key.hashCode() & 0x7fffffff % MAX;
        HashRecord entry = table[hash];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }

            entry = entry.getNext();
        }

        return result;
    }

    public Integer size() {
        Integer size = 0;

        for (HashRecord record : table) {
            if (record != null) {
                size++;
                while (record.getNext() != null) {
                    record = record.getNext();
                    size++;
                }
            }
        }

        return size;
    }
}
