package br.com.mmaciel.gerahash.util;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import br.com.mmaciel.gerahash.util.Algoritimo;
import br.com.mmaciel.gerahash.util.HashUtil;

public class HashUtilTest {

	private HashUtil hashUtil = null;
	String hash = null;
	
	@Before
	public void setUp(){
		hashUtil = new HashUtil();
	}

	@Test
	public void calculaHashDoTextoUsandoMetodoPadroMD5() throws NoSuchAlgorithmException {
		hash = hashUtil.geraHashDoTexto("Texto");
		assertEquals("cc99c671f9ea86938e2c6cda65a65bc3", hash);
	}
	
	@Test
	public void calculaHashDoTextoUsandoMD5() throws NoSuchAlgorithmException {
		hash = hashUtil.geraHashDoTexto("Texto", Algoritimo.MD5);
		assertEquals("cc99c671f9ea86938e2c6cda65a65bc3", hash);
	}	
	
	@Test
	public void calculaHashDoTextoUsandoSHA_1() throws NoSuchAlgorithmException {
		hash = hashUtil.geraHashDoTexto("Texto", Algoritimo.SHA_1);
		assertEquals("6eeba656c0f3cafd6e0af4fcd90468390e8ee571", hash);
	}

	@Test
	public void calculaHashDoTextoUsandoSHA_256() throws NoSuchAlgorithmException {
		hash = hashUtil.geraHashDoTexto("Texto", Algoritimo.SHA_256);
		assertEquals("6df3d6661c095ce7546b9e84888f335a1c55208cd3c9e4686747e7b318f348b0", hash);
	}

	@Test
	public void calculaHashDoTextoUsandoSHA_384() throws NoSuchAlgorithmException {
		hash = hashUtil.geraHashDoTexto("Texto", Algoritimo.SHA_384);
		assertEquals("f0318bca3c41ae2b8b53a3e487208bfed5f9a1c3a7eb791274b7becfcda0784fa399080ed5ba0f6ac4f5eb453b78a70e", hash);
	}
	
	@Test
	public void calculaHashDoTextoUsandoSHA_512() throws NoSuchAlgorithmException {
		hash = hashUtil.geraHashDoTexto("Texto", Algoritimo.SHA_512);
		assertEquals("b446ea907034f489d6bfd968c9138c18d63bf7b14534f35cd15437bf3ca17a67ce2e350db028977f4c9eeb320f7e23196b24eb5d8d3d671457f446c0c570d7f5", hash);
	}

	@Test(expected=NullPointerException.class)
	public void algoritimoNaoInformado(){
		hash = hashUtil.geraHashDoTexto("Texto", null);
	}
	
	@Test(expected=NullPointerException.class)
	public void textoNaoInformado(){
		hash = hashUtil.geraHashDoTexto(null, Algoritimo.MD5);
	}	

	
	
}
