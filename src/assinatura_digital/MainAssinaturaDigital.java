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
           //Guarda Chave P�blica para ser Enviada ao Destinat�rio
           PublicKey pubKey = remetente.getPubKey();
 
           //Destinat�rio recebe dados correto
           Destinatario destinatario = new Destinatario();
           destinatario.recebeMensagem(pubKey, mensagem, assinatura);
           
           //Destinat�rio recebe mensagem alterada
           String msgAlterada = "Exemplo de mensagem alterada.";
           destinatario.recebeMensagem(pubKey, msgAlterada, assinatura);
 
           //Criando outra Assinatura
             String mensagem2 = "Exemplo de outra mensagem.";  
           byte[] assinatura2 = remetente.geraAssinatura(mensagem2);
           //Guarda Chave P�blica para ser Enviada ao Destinat�rio
           PublicKey pubKey2 = remetente.getPubKey();
 
           //Destinat�rio recebe outra assinatura
           destinatario.recebeMensagem(pubKey, mensagem, assinatura2);
           
           //Destinat�rio recebe outra chave p�blica
           destinatario.recebeMensagem(pubKey2, mensagem, assinatura);
 
 
       }
       
}
