package exercise;

import java.security.Key;

import static exercise.Validator.validate;

public class App {

    public static void main(String[] args) {
        Address address = new Address(null, "city", "str", "2", "3");
        validate(address);
    }

}
