package assinatura_digital;

import java.security.PrivateKey;
import java.security.PublicKey;

public class RSA {
	private Criptografia cripto;
	private Chaves chaves;
	private static final String PATH_CHAVE_PRIVADA = "key/privada.key";
	private static final String PATH_CHAVE_PUBLICA = "key/publica.key";
	
	public RSA() {
		cripto = new Criptografia();
		chaves = new Chaves();
	}
	
	// Método responsável por gerar um par de chaves usando o
	// algoritmo RSA e
	// armazena as chaves nos seus respectivos arquivos.
	public boolean criaChave() {
		if(!chaves.verificaChave()) {
			chaves.geraChave();
			return true;
		}
		
		return false;
	}
	
	public byte[] criptografa(String texto, PublicKey chave) {
		return cripto.criptografa(texto, chave);
	}
	
	public String decriptografa(byte[] textoCriptografado, PrivateKey chave) {
		return cripto.decriptografa(textoCriptografado, chave);
	}

	public String getPathChavePrivada() {
		return PATH_CHAVE_PRIVADA;
	}

	public String getPathChavePublica() {
		return PATH_CHAVE_PUBLICA;
	}
}
