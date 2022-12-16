package Library;

import java.util.HashMap;
import java.util.Set;

public class LibraryStore extends HashMap<Book, Integer> {
    private final HashMap<Book, Integer> hashMap;

    public LibraryStore() {
        this.hashMap = new HashMap<>();
    }

    @Override
    public Set<Entry<Book, Integer>> entrySet() {
        return hashMap.entrySet();
    }

    public LibraryStore(HashMap<Book, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public Integer put(Book key, Integer value) {
        return hashMap.put(key, value);
    }

    public void returnBook(Book key) {
        if (hashMap.containsKey(key)) {
            hashMap.put(key, hashMap.get(key) + 1);
            return;
        }
        hashMap.put(key, 1);
    }

    public void rentBook(Book key) {
        hashMap.put(key, hashMap.get(key) - 1);
    }

    public Integer get(Book key) {
        return hashMap.get(key);
    }

    @Override
    public int size() {
        return hashMap.size();
    }
}
