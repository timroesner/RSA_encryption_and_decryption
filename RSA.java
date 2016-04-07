import java.security.*;
import javax.crypto.*;

/**
 * Tim Roesner
 * Version 0.9
 */

public class RSA
{
    private KeyPairGenerator kpg;
    private KeyPair myPair;
    private String message;
    private SealedObject encryptedMessage;

    public RSA(String message) throws Exception

    {
        this.message = message;
        kpg = KeyPairGenerator.getInstance("RSA");
        myPair = kpg.generateKeyPair();
    }

    public void encrypt() throws Exception
    {
        Cipher c = Cipher.getInstance("RSA");
        c.init(Cipher.ENCRYPT_MODE, myPair.getPublic());
        encryptedMessage = new SealedObject(message, c);
        System.out.println(encryptedMessage);
    }

    public void decrypt() throws Exception
    {
        Cipher dec = Cipher.getInstance("RSA");
        dec.init(Cipher.DECRYPT_MODE, myPair.getPrivate());
        String newMessage = (String) encryptedMessage.getObject(dec);
        System.out.println(newMessage);
    }

}