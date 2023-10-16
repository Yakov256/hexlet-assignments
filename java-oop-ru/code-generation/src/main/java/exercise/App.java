package exercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path filePath, Car car) throws IOException {
        Files.writeString(filePath, car.serialize());
    }

    public static Car extract(Path filePath) throws IOException{
        User owner = new User(1, "I", "P", 25);
        Car car = new Car(1, "b", "x", "b", owner);

        car = car.unserialize(Files.readString(Paths.get(filePath.toString())));
        return car;
    }

}

/*
    Создайте класс App с публичными статическими методами:
            save() — принимает в качестве аргумента путь к файлу (объект класса Path) и объект класса Car.
            Метод сохраняет представление объекта в файл по переданному пути. Чтобы сохранить объект в файл,
            вам нужно будет представить его в виде строки (сериализовать).

            extract() — принимает в качестве аргумента путь к файлу (объект класса Path), в котором содержится
            JSON представление объекта Car и возвращает инстанс класса Car с соответствующими свойствами.

            Path path1 = Paths.get("/tmp/file1.json");
            Car car1 = new Car(1, "audi", "q3", "black", owner);
            App.save(path1, car1); // Сохраняет представление объекта в файл

            Path path2 = Paths.get("/tmp/file2.json");
            Car car2 = App.extract(path2); // Возвращает инстанс класса Car
            car2.getModel(); // "passat"
*/


// END
