package test.java.lang.security;

import java.security.Signature;
import org.junit.Test;

import static com.selonj.utils.RSA.privateKey;
import static com.selonj.utils.RSA.publicKey;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-04-25.
 */
public class SHA1WithRSASignatureTest {
  private byte[] data = "content".getBytes();

  @Test public void checking() throws Exception {
    Signature sha1WithRSA = Signature.getInstance("SHA1WithRSA");

    sha1WithRSA.initSign(privateKey("rsa/pk8_private_key.pem"));
    sha1WithRSA.update(data);
    byte[] checksum = sha1WithRSA.sign();

    sha1WithRSA.initVerify(publicKey("rsa/public_key.pem"));
    sha1WithRSA.update(data);
    assertTrue(sha1WithRSA.verify(checksum));
  }
}
