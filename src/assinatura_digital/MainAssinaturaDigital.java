package assinatura_digital;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
 
 
public class MainAssinaturaDigital {
 
       public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
           //Remetente Gera Assinatura Digital para uma Mensagem
             Remetente remetente = new Remetente();
             String mensagem = "Exemplo de mensagem.";
           byte[] assinatura = remetente.geraAssinatura(mensagem);
           //Guarda Chave Pública para ser Enviada ao Destinatário
           PublicKey pubKey = remetente.getPubKey();
 
           //Destinatário recebe dados correto
           Destinatario destinatario = new Destinatario();
           destinatario.recebeMensagem(pubKey, mensagem, assinatura);
           
           //Destinatário recebe mensagem alterada
           String msgAlterada = "Exemplo de mensagem alterada.";
           destinatario.recebeMensagem(pubKey, msgAlterada, assinatura);
 
           //Criando outra Assinatura
             String mensagem2 = "Exemplo de outra mensagem.";  
           byte[] assinatura2 = remetente.geraAssinatura(mensagem2);
           //Guarda Chave Pública para ser Enviada ao Destinatário
           PublicKey pubKey2 = remetente.getPubKey();
 
           //Destinatário recebe outra assinatura
           destinatario.recebeMensagem(pubKey, mensagem, assinatura2);
           
           //Destinatário recebe outra chave pública
           destinatario.recebeMensagem(pubKey2, mensagem, assinatura);
 
 
       }
       
}
