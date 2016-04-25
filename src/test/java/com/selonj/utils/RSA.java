package com.selonj.utils;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import static com.selonj.utils.PEM.from;

/**
 * Created by Administrator on 2016-04-25.
 */
public class RSA {
  public static PrivateKey privateKey(String uri) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
    return rsa().generatePrivate(new PKCS8EncodedKeySpec(from(uri)));
  }

  public static PublicKey publicKey(String uri) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    return rsa().generatePublic(new X509EncodedKeySpec(from(uri)));
  }

  private static KeyFactory rsa() throws NoSuchAlgorithmException {
    return KeyFactory.getInstance("RSA");
  }
}
