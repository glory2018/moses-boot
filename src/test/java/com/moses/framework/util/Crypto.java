package com.moses.framework.util;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Crypto {
    public static String encryptDES(String encryptString, String encryptKey) throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(encryptKey.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(StandardCharsets.UTF_8), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes(StandardCharsets.UTF_8));
        return toHexString(encryptedData);
    }

    public static byte[] convertHexString(String ss) {
        byte digest[] = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }
        return digest;
    }

    public static String decryptDES(String decryptString, String decryptKey) throws Exception {
        byte[] byteMi = convertHexString(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(decryptKey.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(StandardCharsets.UTF_8), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);
        return new String(decryptedData, Charset.forName("GBK"));
    }

    public static String decryptDES(String decryptString, String ivString, String keyString) throws Exception {
        byte[] byteMi = convertHexString(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(ivString.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec key = new SecretKeySpec(keyString.getBytes(StandardCharsets.UTF_8), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);
        return new String(decryptedData, Charset.forName("GBK"));
    }

    @Test
    public void testName() throws Exception {
        System.out.println(encryptDES("gda38", "LlEhahqD"));
    }

    @Test
    public void testNamess() throws Exception {
        System.out.println(decryptDES("6D6F9294C478E076B77D7AA96D19E52D6C24E111280472290C7A6D547AF68E4623DF6F0FDA2267D84E93647E197317F6",
                "industry", "lizhenyu"));
    }

    public static String toHexString(byte b[]) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        return hexString.toString();
    }
}
