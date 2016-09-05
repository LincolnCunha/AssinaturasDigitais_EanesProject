package assinatura_digital;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
 
 
public class Destinatario {
 
       public void recebeMensagem(PublicKey pubKey, String mensagem, byte[] assinatura) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
           Signature clientSig = Signature.getInstance("DSA");  
           clientSig.initVerify(pubKey);  
           clientSig.update(mensagem.getBytes());  
             
           if (clientSig.verify(assinatura)) {  
               //Mensagem corretamente assinada
              System.out.println("A Mensagem recebida foi assinada corretamente.");
           } else {
               //Mensagem n�o pode ser validada
              System.out.println("A Mensagem recebida N�O pode ser validada.");
           }  
       }
       
}
