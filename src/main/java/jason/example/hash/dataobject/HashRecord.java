package jason.example.hash.dataobject;

public class HashRecord {
    private String key;
    private String value;
    private HashRecord next;

    public HashRecord(String k, String v) {
        this.key = k;
        this.value = v;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public HashRecord getNext() {
        return next;
    }

    public void setNext(HashRecord next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("key=[");
        buf.append(key);
        buf.append("] value=[");
        buf.append(value);
        buf.append("]");

        return buf.toString();
    }
}
