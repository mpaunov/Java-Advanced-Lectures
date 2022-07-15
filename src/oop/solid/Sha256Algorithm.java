package oop.solid;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Algorithm implements Encryp {
    @Override
    public String encode(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha256");
            return new String(messageDigest.digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
