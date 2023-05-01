public class MyHashTable<K, V> {

    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " = " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size = 0;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        chainArray = new HashNode[M];
        this.M = M;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }

    public void put(K key, V value) {
        size++;
        int index = hash(key);
        HashNode<K, V> hashNode = new HashNode<>(key, value);
        if (chainArray[index] == null) {
            chainArray[index] = hashNode;
        } else {
            HashNode<K, V> temp = chainArray[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashNode;
        }
    }


    public V get(K key) throws Exception {
        int index = hash(key);
        HashNode<K, V> hashNode = chainArray[index];
        if (hashNode == null) {
            throw new Exception("key doesn't exist");
        }
        while (hashNode != null && !hashNode.key.equals(key)) {
            hashNode = hashNode.next;
        }

        return hashNode.value;
    }

    public V remove(K key) throws Exception {
        int index = hash(key);
        HashNode<K, V> hashNode = chainArray[index];
        HashNode<K, V> previous = null;
        if (hashNode == null) {
            throw new Exception("key doesn't exist");
        } else {
            while (hashNode != null && !hashNode.key.equals(key)) {
                previous = hashNode;
                hashNode = hashNode.next;
            }
            previous.next = hashNode.next;
            size--;
        }
        return hashNode.value;


    }


    public boolean contains(V value) {
        for (HashNode<K, V> hashNode : chainArray) {
            while (hashNode != null) {
                if (hashNode.value.equals(value)) {
                    return true;
                }
                hashNode = hashNode.next;
            }
        }
        return false;
    }


    public K getKey(V value) {
        for (HashNode<K, V> hashNode : chainArray) {
            while (hashNode != null) {
                if (hashNode.value.equals(value)) {
                    return hashNode.key;
                }
                hashNode = hashNode.next;
            }
        }
        return null;
    }

    public int[] getBucketSize() {
        int[] size = new int[M];
        int i = 0;
        for (HashNode<K, V> hashNode : chainArray) {
            int counter = 0;
            while (hashNode != null) {
                hashNode = hashNode.next;
                counter++;
            }
            size[i] = counter;
            i++;
        }
        return size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String str = "{";
        for (int i = 0; i < M; i++) {
            HashNode<K, V> hashNode = chainArray[i];
            while (hashNode != null) {
                str += hashNode.key + "=" + hashNode.value + ", ";
                hashNode = hashNode.next;
            }
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 2);
        }
        str += "}";

        return str;
    }
}
