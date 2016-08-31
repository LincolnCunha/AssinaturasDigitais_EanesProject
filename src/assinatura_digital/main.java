package assinatura_digital;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

public class main {
	
	public static void main(String[] args) {
		try {
			RSA rsa = new RSA();
			

			final String msgOriginal = "Exemplo de mensagem";
			ObjectInputStream inputStreamPublic = null;
			ObjectInputStream inputStreamPrivate = null;

			// Criptografa a Mensagem usando a Chave Pública
			inputStreamPublic = new ObjectInputStream(new FileInputStream(rsa.getPathChavePublica()));
			final PublicKey chavePublica = (PublicKey) inputStreamPublic.readObject();
			final byte[] textoCriptografado = rsa.criptografa(msgOriginal, chavePublica);

			// Decriptografa a Mensagem usando a Chave Privada
			inputStreamPrivate = new ObjectInputStream(new FileInputStream(rsa.getPathChavePrivada()));
			final PrivateKey chavePrivada = (PrivateKey) inputStreamPrivate.readObject();
			final String textoPuro = rsa.decriptografa(textoCriptografado, chavePrivada);

			// Imprime o texto original, o texto criptografado e
			// o texto descriptografado.
			System.out.println("Mensagem Original: " + msgOriginal);
			System.out.println("Mensagem Criptografada: " + textoCriptografado.toString());
			System.out.println("Mensagem Decriptografada: " + textoPuro);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
