package com.lalit.java8.collections.newfeatures.annotation;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonBuilder {

    public static String parse(Object obj) throws NoSuchFieldException, IllegalAccessException {
        Map<String, String> map = new LinkedHashMap<>();
        if (obj != null) {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    map.put(getKey(field), (String) field.get(obj));
                } else {
                    map.put(field.getName(), (String) field.get(obj));
                }
            }
        }
        return toJson(map);
    }

    private static String toJson(Map<String, String> map) {
        return "{" + map.entrySet().stream().map(e -> "\"" + e.getKey() + "\":\"" + e.getValue() + "\"").collect(Collectors.joining(",")) + "}";
    }

    private static String getKey(Field field) {
        return field.getAnnotation(JsonField.class).value().equalsIgnoreCase("") ? field.getName() : field.getAnnotation(JsonField.class).value();
    }


    public static void main(String... s) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(JsonBuilder.parse(new Car("Maruti", "Alto", "2012")));
    }
}
