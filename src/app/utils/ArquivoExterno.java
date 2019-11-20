package app.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import app.view.TelaDados;

public class ArquivoExterno {
	
	private FileReader arq;
	private BufferedReader lerArq;
	private Dado dado;
	private String[] local;
	private List<Dado> listDados;
	
	public List<Dado> getListDados() {
		return listDados;
	}

	public ArquivoExterno(){
	    try {
	    	dado = new Dado();
	    	listDados = new ArrayList<Dado>();
	    	arq = new FileReader("C:\\Users\\Maxwillian\\Documents\\GitHub\\APS-4SEM-UNIP\\src\\app\\Dados.txt");
	    	lerArq = new BufferedReader(arq);
	    	gravarDados();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			JOptionPane.showMessageDialog(TelaDados.umTelaDados(),"Erro na abertura do arquivo: " + e.getMessage(),"Arquivo Externo", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
	public ArquivoExterno(String arqNome){
	    try {
	    	dado = new Dado();
	    	listDados = new ArrayList<Dado>();
	    	arq = new FileReader("C:\\Users\\Maxwillian\\Documents\\GitHub\\APS-4SEM-UNIP\\src\\app\\" + arqNome);
	    	lerArq = new BufferedReader(arq);
	    	gravarDados();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			JOptionPane.showMessageDialog(TelaDados.umTelaDados(),"Erro na abertura do arquivo: " + e.getMessage(),"Arquivo Externo", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
	//metodo que gera todos os Dados para a class Dado e os adiciona na listDados
	public void gravarDados(){
	    String linha;
	    String[] l;
		try {
			linha = lerArq.readLine(); // le a primeira linha
			local = linha.split(",");  // cria um identificador dos locais verificados
			linha = lerArq.readLine(); // pula a primeira linha que contem o cabeçalho da tabela
			while (linha != null) {
				l = linha.split(",");
				for (int i = 2; i < l.length; i++) {
					dado.setAno(Integer.parseInt(l[0]));
			        dado.setMes(Integer.parseInt(l[1]));
			        dado.setLocal(local[i]);
			        dado.setValor(Integer.parseInt(l[i]));
					listDados.add(new Dado(dado));
				}
	        linha = lerArq.readLine(); // passa para a proxima linha a cada verificação
	      }
	      arq.close();
		} catch (IOException e) {
			System.err.printf("Erro durante a gravação do arquivo: %s.\n", e.getMessage());
			JOptionPane.showMessageDialog(TelaDados.umTelaDados(),"Erro durante a gravação do arquivo: " + e.getMessage(),"Gravar Dados", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
