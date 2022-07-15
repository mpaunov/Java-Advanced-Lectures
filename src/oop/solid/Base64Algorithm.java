package oop.solid;

import java.util.Base64;

public class Base64Algorithm implements Encryp, Decrypt {
    @Override
    public String encode(String password) {
        return new String(Base64.getEncoder().encode(password.getBytes()));
    }

    @Override
    public String decode(String hash) {
        return new String(Base64.getDecoder().decode(hash.getBytes()));
    }
}
