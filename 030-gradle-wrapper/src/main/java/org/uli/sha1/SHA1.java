package org.uli.sha1;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {

    public String sha1hex(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bytesOfMessage = input.getBytes();
        MessageDigest md = MessageDigest.getInstance("SHA1");
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
        SHA1 sha1 = new SHA1();
        for (String arg : args) {
            System.out.println(sha1.sha1hex(arg));
        }
    }
}
