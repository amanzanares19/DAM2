package controller;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import security.AES;
import security.RSA;

public class Controller {
    
    public void init() {
        try {
            RSA rsa = new RSA();
            AES aes = new AES();

            //CLAVES AES
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom());
            SecretKey clave = keyGenerator.generateKey();

            // Generar un par de claves RSA
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair claves = keyGen.generateKeyPair();

            //Textos a encriptar
            
            //AES
            Scanner sc = new Scanner(System.in);
            System.out.println("Texto 1:");
            String text1 = sc.next();
            
            byte[] cifrarText1 = aes.cifrarAES(text1, clave);
            String descifrarText1 = aes.descifrarAES(cifrarText1, clave);
            
            System.out.println("Texto 1: " + text1);
            System.out.println("Texto Cifrado: " + new String(cifrarText1));
            System.out.println("Texto descifrado: " + descifrarText1);

            //RSA
            System.out.println("Texto 2:");
            String text2 = sc.next();  
            sc.close();          
            
            byte[] cifrarText2 = rsa.cifrarRSA(text2.getBytes(), claves);
            byte[] descifrarText2 = rsa.descifrarRSA(cifrarText2, claves);

            System.out.println("Texto 2: " + text2);
            System.out.println("Texto Cifrado: " + new String(cifrarText2));
            System.out.println("Texto descifrado: " + new String(descifrarText2));


        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
