/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decription;

/**
 *
 * @author eliot
 */
    
import java.io.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;

public class DHKeyAgreement2 {
    
    
        KeyPair alphaPair= null;
        KeyAgreement alphaKeyAgreement = null;
        KeyAgreement bravoKeyAgreement= null;
        byte[] alphaPublicKeyEncoded=null;
        byte[] bravoPublicKeyEncoded = null;
        KeyFactory bravoKeyFactory =null;
        X509EncodedKeySpec x509KS= null;
        
        PublicKey alphaPub= null;
        KeyPairGenerator bravoKeyPairGen= null;
        KeyFactory alphaKeyFactory = null;
        PublicKey bravoPub= null;
    
    public void alphaKeyGenerator() throws InvalidKeyException, NoSuchAlgorithmException {
        System.out.println("Alpha: Generate DH keys ...");
            KeyPairGenerator alphaKeyPairGen= KeyPairGenerator.getInstance("DH");
            alphaKeyPairGen.initialize(2048);
            alphaPair = alphaKeyPairGen.generateKeyPair();
            
            System.out.println("Alpha: Initilization");
            alphaKeyAgreement = KeyAgreement.getInstance("DH");
            alphaKeyAgreement.init(alphaPair.getPrivate());
            
            alphaPublicKeyEncoded = alphaPair.getPublic().getEncoded();
    } // close alpha method
    
    public void BravoKeyGenerator(DHParameterSpec dhParamFromAlphaKey) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        System.out.println("Bravo: Generate Dh keys");
            bravoKeyPairGen= KeyPairGenerator.getInstance("DH");
            bravoKeyPairGen.initialize(dhParamFromAlphaKey);
            KeyPair bravoPair = bravoKeyPairGen.generateKeyPair();
            
            System.out.println("Bravo: Initilization");
            bravoKeyAgreement= KeyAgreement.getInstance("DH");
            bravoKeyAgreement.init(bravoPair.getPrivate());
            
            bravoPublicKeyEncoded = bravoPair.getPublic().getEncoded();
            
    }// close bravo method
    
    public void guide() throws Exception {
        
        try {
            //alpha creates key pair with 2048-bit size
            alphaKeyGenerator();
            //now bravo uses this key info to create a message
            bravoKeyFactory = KeyFactory.getInstance("DH");
            x509KS = new X509EncodedKeySpec(alphaPublicKeyEncoded);
            alphaPub = bravoKeyFactory.generatePublic(x509KS);
            
            //embodies the exchange of the keys across some network
            //assuming both computers are speaking Java
            DHParameterSpec dhParamFromAlphaKey = ((DHPublicKey)alphaPub).getParams();
            
            BravoKeyGenerator(dhParamFromAlphaKey);
            //now Alpha uses Bravo's public key
            alphaKeyFactory = KeyFactory.getInstance("DH");
            x509KS = new X509EncodedKeySpec(bravoPublicKeyEncoded);
            bravoPub = alphaKeyFactory.generatePublic(x509KS);
            System.out.println("Alpha: Executing Phase 1 of DH protocol");
            alphaKeyAgreement.doPhase(bravoPub, true);
            
            
            //now Bravo uses Alpha's public key
            System.out.println("Bravo: Executing Phase 1 of DH protocol");
            bravoKeyAgreement.doPhase(alphaPub, true);
            
            //now generate the same secret
            } catch (NoSuchAlgorithmException ex) {
            System.out.println("No such algo");
            System.out.println(ex);
            } catch (InvalidKeyException ex) {
                System.out.println("Invalid Key");
                System.out.println(ex);
            } catch (InvalidKeySpecException ex) {
                System.out.println("InvalidKeySpecException");
                System.out.println(ex);
            } catch (InvalidAlgorithmParameterException ex) {
                System.out.println("Invalid Algo");
                System.out.println(ex);
            }// close catch
            
            byte[] alphSharedSecret = null;
            byte[] bravoSharedSecret = null;
            int alphaLen;
            int bravoLen;
            if(alphaKeyAgreement != null){
                try {
                    alphSharedSecret = alphaKeyAgreement.generateSecret();
                    alphaLen = alphSharedSecret.length;
                    bravoSharedSecret = new byte[alphaLen];
                    if(bravoKeyAgreement != null){
                        bravoLen = bravoKeyAgreement.generateSecret(bravoSharedSecret, 0);

                    }
                    System.out.println("Alpha secret: " + toHexString(alphSharedSecret));
                    System.out.println("Bravo secret: " + toHexString(bravoSharedSecret));
                    if(!java.util.Arrays.equals(bravoSharedSecret, alphSharedSecret)){
                        throw new Exception("Shared secrets differ!");
                    } else {
                        System.out.println("Shared secrets are the same");
                    }
                } catch (IllegalStateException | ShortBufferException ex) {
                    System.out.println(ex);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } // end null check

            System.out.println("Use shared secret as SecretKey object");
            SecretKeySpec deloAESKey = new SecretKeySpec(alphSharedSecret, 0, 16, "AES");
            SecretKeySpec bravoAESKey = new SecretKeySpec(bravoSharedSecret, 0, 16, "AES");

            System.out.println("Secret (symmetric) Key: " + toHexString(deloAESKey.getEncoded()));

            Cipher alphaCipher;
            Cipher bravoCipher;
            byte[] clearText;
            byte[] cipherText;
            byte[] encodedParams;
            byte[] recoveredText;
            AlgorithmParameters aesParams;

            try {
                // USE AES in CBC mode
                bravoCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                bravoCipher.init(Cipher.ENCRYPT_MODE, bravoAESKey);
                clearText = "I'm Vengence, I'm the Knight, I'm Batman".getBytes();
                cipherText = bravoCipher.doFinal(clearText);
                encodedParams = bravoCipher.getParameters().getEncoded();

             

                // alpha decrypts
                aesParams = AlgorithmParameters.getInstance("AES");
                aesParams.init(encodedParams);
                alphaCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                alphaCipher.init(Cipher.DECRYPT_MODE, deloAESKey, aesParams);
                recoveredText = alphaCipher.doFinal(cipherText);
                if(!java.util.Arrays.equals(clearText, recoveredText)){
                    throw new Exception("AES in CBC mode recovered text is diff from clear!");
                } else {
                    System.out.print("Matching recovered text: ");
                    System.out.println(new String(recoveredText, "UTF-8"));

               }

            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
                System.out.println(ex);
            } catch (IllegalBlockSizeException ex) {
                System.out.println("Illegal blocksize ex");
                System.out.println(ex);
            } catch (BadPaddingException ex) {
                System.out.println("Bad Padding");
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println("IO Ex");
                System.out.println(ex);
            } catch (InvalidAlgorithmParameterException ex) {
                System.out.println("Invalid algo");
                System.out.println(ex);
            } catch (Exception ex) {
                System.out.println("Decrypt Doesn't work");
                System.out.println(ex);

            
        }// close main method
      
     
    }
    /*
    Convertys a bute to hex digit and wires to the supplied buffer
    */
   
    private static void byte2hex(byte b, StringBuffer buf) {
        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        int high = ((b & 0xf0) >> 4);
        int low = (b & 0x0f);
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }
    /*
    Converts bute array to hex String
    */
    
    private static String toHexString(byte[] block) {
        StringBuffer buf = new StringBuffer();
        int len = block.length;
        for (int i = 0; i < len; i++) {
            byte2hex(block[i], buf);
            if (i < len-1) {
                buf.append(":");
            }//close if
        }// close for
        return buf.toString();
    }//close method
}// close class