package org.wso2.msf4j.example.service;

import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.model.RSACipher;
import org.wso2.msf4j.example.model.RSAKeyPair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;

/**
 * Created by Longlaptop on 8/17/2016.
 */
@Component
public class RSAService {
    final static String transformation = "RSA/ECB/PKCS1PADDING";
    final static String encoding = "UTF-8";

    public String RSAcrypto(int RSALength, boolean keyexist) throws GeneralSecurityException {
        try{
            String privateKeyPathName = "C://Users/Longlaptop/Desktop/private" + RSALength + ".key";
            String publicKeyPathName = "C://Users/Longlaptop/Desktop/public" + RSALength + ".key";
            if (keyexist == true) {
                if (Files.exists(Paths.get(privateKeyPathName)) == false
                        || Files.exists(Paths.get(publicKeyPathName)) == false) {
                    RSAKeyPair rsaKeyPair = new RSAKeyPair(RSALength);
                    rsaKeyPair.toFileSystem(privateKeyPathName, publicKeyPathName);
                }
            }

            RSACipher rsaCipher = new RSACipher();

            String encryptedString = rsaCipher.encrypt("Hello RSA", publicKeyPathName, transformation, encoding);
            String decryptedString = rsaCipher.decrypt(encryptedString, privateKeyPathName, transformation, encoding);

            System.out.println(encryptedString + '\n');
            System.out.println(decryptedString + '\n');

            if(decryptedString.equals("Hello RSA")) System.out.println("RSA hoạt động tốt");
        }
        catch (Exception e){
            System.out.println("RSA gặp vấn đề bởi: " + e.getMessage());
        }
        return "OK";
    }
}
