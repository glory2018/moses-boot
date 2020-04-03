package com.moses.framework.samples.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Cryption {
    private final static String KEYSTORE_ALIAS = "testkeypair";
    private final static String CERT_NAME = "C:\\Windows\\System32\\mycert.crt";
    static byte[] desKeyData = {(byte) 0x01, (byte) 0x02, (byte) 0x03,
            (byte) 0x04, (byte) 0x05, (byte) 0x06, (byte) 0x07, (byte) 0x08};

    /**
     * Description
     *
     * @param outFileName 保存加密后文件的文件名
     * @return value Description
     * @since 1.0
     */
    public static void crypt(byte[] cipherText, String outFileName) {
        try {
            DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            Cipher cdes = Cipher.getInstance("DES");
            // 加密
            cdes.init(Cipher.ENCRYPT_MODE, secretKey);
            // 解密
            // cdes.init(Cipher.DECRYPT_MODE, secretKey);
            // ct就是加密后的内容
            byte[] ct = cdes.doFinal(cipherText);
            try {
                FileOutputStream out = new FileOutputStream(outFileName);
                out.write(ct);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description
     *
     * @param sigText      被签名内容的输入数组
     * @param outFileName  保存签名后输出文件的名称
     * @param keyPassword  读取Keystore使用的密码
     * @param keyStorePath 存放.keystore文件的路径
     * @return value Description
     * @since 1.0
     */
    public static void sig(byte[] sigText, String outFileName,
                           String keyPassword, String keyStorePath) {
        char[] kpass;
        int i;
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            FileInputStream ksfis = new FileInputStream(keyStorePath);
            BufferedInputStream ksbufin = new BufferedInputStream(ksfis);
            kpass = new char[keyPassword.length()];
            for (i = 0; i < keyPassword.length(); i++) {
                kpass[i] = keyPassword.charAt(i);
            }
            ks.load(ksbufin, kpass);
            PrivateKey priv = (PrivateKey) ks.getKey(KEYSTORE_ALIAS, kpass);
            Signature rsa = Signature.getInstance("MD5withRSA");
            rsa.initSign(priv);
            rsa.update(sigText);
            byte[] sig = rsa.sign();
            System.out.println("sig is done");
            try {
                FileOutputStream out = new FileOutputStream(outFileName);
                out.write(sig);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void veriSig(byte[] updateData, byte[] sigedText) {
        try {
            CertificateFactory certificatefactory = CertificateFactory
                    .getInstance("X.509");
            FileInputStream fin = new FileInputStream(CERT_NAME);
            X509Certificate certificate = (X509Certificate) certificatefactory
                    .generateCertificate(fin);
            PublicKey pub = certificate.getPublicKey();
            Signature rsa = Signature.getInstance("MD5withRSA");
            rsa.initVerify(pub);
            rsa.update(updateData);
            boolean verifies = rsa.verify(sigedText);
            System.out.println("verified " + verifies);
            if (verifies) {
                System.out.println("Verify is done!");
            } else {
                System.out.println("verify is not successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
