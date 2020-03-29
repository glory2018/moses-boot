package com.ibm.mosesboot.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CollectionUtils {
    public static String getKeys(Map<String, String> fieldsMap) {
        StringBuffer keys = new StringBuffer();
        for (String key : fieldsMap.keySet()) {
            keys.append(key).append(",");
        }
        keys.deleteCharAt(keys.length() - 1);
        return keys.toString();
    }

    public static String getValues(Map<String, String> fieldsMap) {
        StringBuffer values = new StringBuffer();
        for (String value : fieldsMap.values()) {
            values.append(value).append(",");
        }
        values.deleteCharAt(values.length() - 1);
        return values.toString();
    }

    public static void main(String[] args) {
        String fields = "abc,def";
        String[] fieldArr = fields.split(",");
        List<String> list = new ArrayList<String>(Arrays.asList(fieldArr));
        System.out.println(list.contains("ab"));
        System.out.println(list.contains("abc"));
    }
}
