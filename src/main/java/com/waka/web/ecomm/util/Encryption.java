package com.waka.web.ecomm.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    public static String encrypt(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(value.getBytes(),0,value.length());

            BigInteger integer = new BigInteger(1,digest.digest());
           return integer.toString(16);

        } catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
          return null;
        }
    }
}
