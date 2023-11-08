package com.lvwanjie.myapplication.javaTest;


import android.util.Base64;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TestDecode {

    private static final String AES = "AES";
    private static final String CRYPT_KEY = "LcKw5NActFJFU9ap";
    private static final String IV_STRING = "j3efPXZGfvwYNWsU";

    public static void maim(String args[]){
        decryptBasedDes("");
    }

    public static String decryptBasedDes(String content) {
        // base64 解码
        try {
//             byte[] encryptedBytes = new BASE64Decoder().decodeBuffer(content);
            byte[] encryptedBytes = Base64.decode(content.getBytes(), Base64.DEFAULT);
            byte[] enCodeFormat = CRYPT_KEY.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, AES);
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] result = cipher.doFinal(encryptedBytes);
            return new String(result, "UTF-8");
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException |
                 InvalidKeyException | InvalidAlgorithmParameterException |
                 IllegalBlockSizeException | BadPaddingException e) {
        }
        return null;
    }
}
