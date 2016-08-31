package assinatura_digital;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Chaves {
	public static final String ALGORITHM = "RSA";
	/**
	 * Local de acesso a chave privada
	 */
	public static final String PATH_CHAVE_PRIVADA = "key/privada.key";
	/**
	 * Local de acesso a chave publica
	 */
	public static final String PATH_CHAVE_PUBLICA = "key/publica.key";
	
	public void geraChave() {
		try {
			final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
			keyGen.initialize(1024);
			
			final KeyPair key = keyGen.generateKeyPair();
			
			File chavePrivadaFile = new File(PATH_CHAVE_PRIVADA);
			File chavePublicaFile = new File(PATH_CHAVE_PUBLICA);
			
			if (chavePublicaFile.getParentFile() != null) {
				chavePublicaFile.getParentFile().mkdirs();
			}
			
			chavePublicaFile.createNewFile();
			
			if (chavePrivadaFile.getParentFile() != null) {
				chavePrivadaFile.getParentFile().mkdirs();
			}
			
			chavePrivadaFile.createNewFile();
			
			
			ObjectOutputStream chavePublicaOS = new ObjectOutputStream(new FileOutputStream(chavePublicaFile));
			chavePublicaOS.writeObject(key.getPublic());
			chavePublicaOS.close();
			
			ObjectOutputStream chavePrivadaOS = new ObjectOutputStream(new FileOutputStream(chavePrivadaFile));
			chavePrivadaOS.writeObject(key.getPublic());
			chavePrivadaOS.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verfica se o par de chaves já foram geradas;
	 * @return
	 */
	
	public boolean verificaChave() {
		File chavePrivada = new File(PATH_CHAVE_PRIVADA);
		File chavePublica = new File(PATH_CHAVE_PUBLICA);
		
		if (chavePrivada.exists()) {
			if (chavePublica.exists()) {
				return true;
			}
		}
		
		return false;
	}
}
