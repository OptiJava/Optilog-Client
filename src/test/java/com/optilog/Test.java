package com.optilog;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update("1".getBytes(StandardCharsets.UTF_8));
        
        System.out.println(new BigInteger(1, md.digest()).toString(16));
    }
}
