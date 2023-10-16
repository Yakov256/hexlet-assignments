package exercise;

import lombok.AllArgsConstructor;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@AllArgsConstructor
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize(){

        var mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonStr;
    }

    public Car unserialize(String jsonStr) {
        var mapper = new ObjectMapper();
        Car newCar = null;
        try {
            newCar = mapper.readValue(jsonStr, Car.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newCar;
    }
    // END
}
