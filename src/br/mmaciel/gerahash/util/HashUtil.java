package br.mmaciel.gerahash.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utilitário para Hash.
 * 
 * @author Marco Maciel
 */

public class HashUtil {

	private String valorCalculado = null;
	private String algoritimo = "MD5";
	private int BUFSIZE = 8192;

	/**
	 * Método usado para obter o código de hash de determinado arquivo. Por
	 * exemplo: MD5, SHA-1, SHA-256, SHA-384, SHA-512, RSA.
	 * 
	 * @param nomeDoArquivo
	 *            nome completo do arquivo (com caminho absoluto) que terá o
	 *            código de hash gerado.
	 * @param algoritimo
	 *            código do hash utilizado Classe (Algoritimo).
	 * @return valor calculado do hash.
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 */
	public String geraHashDoArquivo(String nomeDoArquivo, Algoritimo algoritimo)
			throws NoSuchAlgorithmException, FileNotFoundException {
		this.algoritimo = algoritimo.valor();
		return this.geraHashDoArquivo(nomeDoArquivo);
	}

	public String geraHashDoTexto(String texto, Algoritimo algoritimo){
		this.algoritimo = algoritimo.valor();
		String retorno = null;
		try {
			retorno = this.geraHashDoTexto(texto);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	/**
	 * Método usado para obter o código de hash de determinado arquivo. O padrão
	 * é MD5.
	 * 
	 * @param texto
	 *            texto que terá o código de hash gerado.
	 * @return valorCalculado calculado do hash.
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 */	
	public String geraHashDoTexto(String texto) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(algoritimo);
		BigInteger hash = new BigInteger(1, md.digest(texto.getBytes()));
		valorCalculado = hash.toString(16);
		return valorCalculado;
	}


	/**
	 * Método usado para obter o código de hash de determinado arquivo. O padrão
	 * é MD5.
	 * 
	 * @param nomeDoArquivo
	 *            nome completo (com caminho absoluto) do arquivo que terá o
	 *            código de hash gerado.
	 * @return valor calculado do hash.
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 */
	public String geraHashDoArquivo(String nomeDoArquivo)
			throws NoSuchAlgorithmException, FileNotFoundException {
		MessageDigest digest = MessageDigest.getInstance(algoritimo);
		File f = new File(nomeDoArquivo);
		InputStream is = new FileInputStream(f);
		byte[] buffer = new byte[BUFSIZE];
		int read = 0;
		try {
			while ((read = is.read(buffer)) > 0) {
				digest.update(buffer, 0, read);
			}
			byte[] checkSum = digest.digest();
			BigInteger bigInt = new BigInteger(1, checkSum);
			valorCalculado = bigInt.toString(16);
		} catch (IOException e) {
			throw new RuntimeException("Impossivel calcular.", e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				throw new RuntimeException(
						"Impossiel abrir arquivo para calcular!", e);
			}
		}
		return valorCalculado;
	}

}
