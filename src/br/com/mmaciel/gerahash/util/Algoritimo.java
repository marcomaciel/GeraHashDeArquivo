package br.com.mmaciel.gerahash.util;

/**
*
* @author Marco Maciel
*/
public enum Algoritimo {

	// public static String MD5 = "MD5";
	// public static String SHA_1 = "SHA-1";
	// public static String SHA_256 = "SHA-256";
	// public static String SHA_384 = "SHA-1";
	// public static String SHA_512 = "SHA-512";

	MD5("MD5"), SHA_1("SHA-1"), SHA_256("SHA-256"), SHA_384("SHA-384"), SHA_512(
			"SHA-512");

	private String valor = null;

	Algoritimo(String valor) {
		this.valor = valor;
	}

	public String valor() {
		return this.valor;
	}
}
