package com.lalit.convertors;

import java.lang.reflect.Field;
import java.util.List;

public class ObjectToJsonStringConvertor {

    private static String JSON_STRING = "";
    private Object object;

    public ObjectToJsonStringConvertor(Object obj) {
        this.object = obj;
    }

    public ObjectToJsonStringConvertor parse() {
        return this;
    }

    public ObjectToJsonStringConvertor buildJson() throws IllegalAccessException {
        JSON_STRING = "\"" + object.getClass().getSimpleName() + "\": ";
        buildJson(object);
        return this;
    }

    private void buildJson(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        JSON_STRING = JSON_STRING + "{";
        for (Field field : fields) {
            JSON_STRING = JSON_STRING + " \"" + field.getName() + "\":";
            //Primitive Type Check mainly check boolean , number,.........
            if (field.getType().isPrimitive()) {
                field.setAccessible(true);
                JSON_STRING = JSON_STRING + "\"" + field.get(obj) + "\",";
            }
            //Is Array type
            else if (field.getType().isArray()) {
                field.setAccessible(true);
                if (field.getType().getSimpleName().equalsIgnoreCase("String[]")) {
                    JSON_STRING = JSON_STRING + "[";
                    for (String val : ((String[]) field.get(obj))) {
                        JSON_STRING = JSON_STRING + "\"" + val + "\",";
                    }
                    JSON_STRING = JSON_STRING.substring(0, JSON_STRING.length() - 1) + "]";
                }
                JSON_STRING = JSON_STRING + ",";
            }
            //Object Type check
            else {
                //String type ADD for number , Boolean , Integer, Long.....
                if (field.getType().getName().equalsIgnoreCase("java.lang.String")) {
                    field.setAccessible(true);
                    JSON_STRING = JSON_STRING + "\"" + field.get(obj) + "\"";
                }
                //ArrayList array of user object or Wrapper object type
                else if (field.getType().getSimpleName().contains("List")) {
                    field.setAccessible(true);
                    List list = (List) field.get(obj);
                    JSON_STRING = JSON_STRING + "[";
                    for (Object listElement : list) {
                        if (listElement.getClass().getSimpleName().equalsIgnoreCase("String")) {
                            field.setAccessible(true);
                            JSON_STRING = JSON_STRING + "\"" + field.get(obj) + "\"";
                        } else {
                            buildJson(listElement);
                        }
                        JSON_STRING = JSON_STRING + ",";
                    }
                    JSON_STRING = JSON_STRING.substring(0, JSON_STRING.length() - 1) + "]";
                }
                //TODO map
                else if (field.getType().getSimpleName().contains("Map")){

                }
                //User Defined Class
                else {
                    field.setAccessible(true);
                    buildJson(field.get(obj));
                }
                JSON_STRING = JSON_STRING + ",";
            }
        }
        JSON_STRING = JSON_STRING.substring(0, JSON_STRING.length() - 1) + "}";
    }

    public String toString() {
        return "{" + JSON_STRING + "}";
    }

}
