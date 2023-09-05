package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage{

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

    public FileKV(String filePath, Map<String, String> map) {
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

/* KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
         // Получение значения по ключу
         storage.get("key", "default"); // "value"
         ```
В процессе работы вам потребуется выполнить сериализацию (представление данных в виде строки) и десериализацию словаря
 `Map`. Удобнее всего представлять словарь в виде JSON.
 Для этого в классе `Utils` уже написаны методы `Utils.serialize()` и `Utils.unserialize()`.
 Для чтения и записи файлов также имеются уже написанные методы `Utils.readFile()` и `Utils.writeFile()`.

   * В файле  *src/test/java/exerciseFileKVTest* допишите тесты на эту реализацию базы данных.
*/