package br.com.mmaciel.gerahash.util;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import br.com.mmaciel.gerahash.util.ArquivosUtil;

public class ArquivosUtilTest {

	ArquivosUtil au = new ArquivosUtil();
	
	@Test
	public void listaArquivosDoDiretorio() {		
		File[] f = null;
		f = au.listaArquivosDoDiretorio("\\");
		assertNotNull(f);
			
	}

	@Test
	public void testListaArquivosDoDiretorioStringString() {
		
	}

}
