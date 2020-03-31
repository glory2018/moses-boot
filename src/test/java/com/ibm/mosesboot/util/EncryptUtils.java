/**
 * Copyright &copy; 2017 Fang.com All rights reserved.
 */
package com.ibm.mosesboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangxu-bj@fang.com
 * <p>
 * 2017-11-02
 */
public class EncryptUtils {
    public static String Encode(String str) {
        return JsAsciChange(JsMove(GetRandomString() + str));
    }

    public static String Decode(String str) {
        String source = JsUnMove(JsAsciRevent(str));
        int first = 0;
        boolean tryParse = true;
        try {
            first = Integer.parseInt(String.valueOf(source.charAt(0)));
        } catch (Exception e) {
            tryParse = false;
        }
        if (tryParse) {
            if (first <= 5 && first >= 1) {
                return source.substring(first);
            }
        }
        return source;
    }

    private static String GetRandomString() {
        int first = LocalDateTime.now().getSecond() / 10; // 0-5
        if (first == 0) {
            first = 3;
        }
        if (first == 1) {
            return "1";
        }
        return first + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy")).substring(0, first - 1);
    }

    private static String JsMove(String str) {
        int length = str.length();
        StringBuilder source = new StringBuilder(str);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                int tempLength = source.length();
                sb.append(source.charAt(tempLength - 1));
                source.deleteCharAt(tempLength - 1);
            } else {
                sb.append(source.charAt(0));
                source.deleteCharAt(0);
            }
        }
        sb.append(source);
        return sb.toString();
    }

    private static String JsUnMove(String str) {
        int length = str.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                sb1.insert(0, str.charAt(i));
            } else {
                sb2.append(str.charAt(i));
            }
        }
        return sb2 + sb1.toString();
    }

    private static String JsAsciChange(String str) {
        // 33 - 125
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int intChar = ch;
            if (intChar == 125) {
                intChar = 33;
            } else {
                if (intChar >= 33 && intChar <= 124) {
                    intChar++;
                }
            }
            sb.append((char) intChar);
        }
        return sb.toString();
    }

    private static String JsAsciRevent(String str) {
        // 33 - 125
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int intChar = ch;
            if (intChar == 33) {
                intChar = 125;
            } else {
                if (intChar >= 34 && intChar <= 125) {
                    intChar--;
                }
            }
            sb.append((char) intChar);
        }
        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String a = "CitymapSTD";
        System.out.println(Decode(Encode(a)));
    }
}
