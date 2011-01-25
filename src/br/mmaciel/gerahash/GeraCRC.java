package br.mmaciel.gerahash;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

import br.mmaciel.gerahash.util.Algoritimo;
import br.mmaciel.gerahash.util.ArquivosUtil;
import br.mmaciel.gerahash.util.HashUtil;

/**
 *
 * @author Marco Maciel
 */
public class GeraCRC extends javax.swing.JFrame {

	private static final long serialVersionUID = 6488012204148753799L;

    public static void main(String args[]) throws NoSuchAlgorithmException, FileNotFoundException  {

    	String caminhoDoDiretorio = "c:/temp";    	
    	Algoritimo algoritimoHash = Algoritimo.MD5; 
    	String extensaoDoArquivoDeSaida = algoritimoHash.valor();
    	
    	HashUtil hashUtil = new HashUtil();    	
    	ArquivosUtil arqUtil = new ArquivosUtil();
    	File[] listaDeArquivos = arqUtil.listaArquivosDoDiretorio(caminhoDoDiretorio,".jar");
    	
    	System.out.println(hashUtil.geraHashDoTexto("Texto",algoritimoHash));
    	    	    	
		for ( int i = 0; i < listaDeArquivos.length; i++ ){									
			String arquivo = listaDeArquivos[i].getAbsolutePath();			
			String hash = hashUtil.geraHashDoArquivo(arquivo, algoritimoHash);						
			System.out.println(listaDeArquivos[i].getName() + " -> "+ hash);			
			String arquivoDeSaida = arquivo + "." +extensaoDoArquivoDeSaida;
			arqUtil.gravaArquivo(arquivoDeSaida, hash);		
		}
    }
} 