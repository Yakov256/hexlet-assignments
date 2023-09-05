package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {

    private Map<String, String> storage;
    private String filePath;

    public void saveToFile() {
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    public void loadFromFile() {
        storage = Utils.unserialize(Utils.readFile(filePath));
    }

    @Override
    public void set(String key, String value) {
        this.storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        String value = storage.get(key);
        if (value == null) {
            return defaultValue;
        } else {
            return value;
        }
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> storageCopy = new HashMap<>(this.storage);
        return storageCopy;
    }

    FileKV(String filePath, Map<String, String> map) {
        this.storage = new HashMap<>(map);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
// END
