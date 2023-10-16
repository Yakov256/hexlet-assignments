package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> nullObjectList = new LinkedList<>();

        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field: declaredFields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (field.isAnnotationPresent(NotNull.class) & value == null) {
                    nullObjectList.add(field.getName());
                }
                //System.out.println(field.getName() + " - " + field.isAnnotationPresent(NotNull.class)  + " - " + value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        return nullObjectList;
    }
}
// END
