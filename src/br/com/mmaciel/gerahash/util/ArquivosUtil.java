package br.com.mmaciel.gerahash.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.PrintWriter;

/**
 * Utilitário para arquivos (file system).
 * 
 * @author Marco Maciel
 */
public class ArquivosUtil {
	
	/**
	 * Lista todos os arquivos do diretório informado. 
	 * @param caminhoDoDiretorio caminho do diretório que contem os arquivos que serão listados. 
	 * @return array com os arquivos do diretório informado. 
	 */
	public File[] listaArquivosDoDiretorio(String caminhoDoDiretorio) {
		File diretorio = new File(caminhoDoDiretorio);
		File listaDeArquivos[] = diretorio.listFiles();
		return listaDeArquivos;
	}
	
	/**
	 * Lista todos os arquivos do diretório informado. 
	 * @param caminhoDoDiretorio caminho do diretório que contem os arquivos que serão listados. 
	 * @param extensaoDoArquivo extensão dos arquivos que serão listados. Exemplo: ".jar". 
	 * @return array com os arquivos do diretório informado. 
	 */	
	public File[] listaArquivosDoDiretorio(String caminhoDoDiretorio, final String extensaoDoArquivo) {
		File diretorio = new File(caminhoDoDiretorio);
		File listaDeArquivos[] = diretorio.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return (name.endsWith(extensaoDoArquivo));
			}
		});
		return listaDeArquivos;
	}	

	public void gravaArquivo(String arquivo, String texto) {

		try {
			PrintWriter saida = new PrintWriter(new FileOutputStream(arquivo));
			saida.write(texto);
			saida.flush();
			saida.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
