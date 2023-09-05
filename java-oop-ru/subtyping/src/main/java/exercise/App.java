package exercise;

import java.util.Map;
import java.util.Map.Entry;

// BEGIN
class App {
    public static void main(String[] args) {

        KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));
        // Получение значения по ключу
        System.out.println(storage.get("key", "default")); // "10"
        System.out.println(storage.get("unknown", "default")); // "default"
        // Установка нового значения
        storage.set("key2", "value2");
        storage.get("key2", "default"); // "value2"
        // Удаление ключа
        storage.unset("key2");
        storage.get("key2", "default"); // "default"
        // Получение всех данных из базы
        Map<String, String> data = storage.toMap();
        System.out.println(data); // => {key=10};

        System.out.println("-------------------");
        KeyValueStorage storage1 = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        App.swapKeyValue(storage1);
        System.out.println(storage1.get("key", "default")); // "default"
        System.out.println(storage1.get("value", "default")); // "key"
        System.out.println(storage1.toMap()); // => {value=key, value2=key2}

    }

    public static void swapKeyValue(KeyValueStorage kVS) {
        Map<String, String> originalMap = kVS.toMap();
        for (Map.Entry<String, String> entry : originalMap.entrySet()) {
            kVS.unset(entry.getKey());
            kVS.set(entry.getValue(), entry.getKey());
        }
    }

}


// END
