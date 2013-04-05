package org.uli.sha2;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.Charset;

public class SHA2_2 {

    public String sha2hex(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bytesOfMessage = input.getBytes(Charset.defaultCharset());
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] thedigest = md.digest(bytesOfMessage);
        BigInteger bigInt = new BigInteger(1, thedigest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    static public void main(String[] args) throws Exception {
        SHA2_2 sha2_2 = new SHA2_2();
        for (String arg : args) {
            System.out.println(sha2_2.sha2hex(arg));
        }
    }
}
