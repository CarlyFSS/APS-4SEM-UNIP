package app.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import app.view.TelaDados;

public class ArquivoExterno {
	
	private FileReader arq = null;
	private BufferedReader lerArq = null;
	private Dado dado = null;
	private int[] arr = null;
	private String[] local = null;
	private List<Dado> listDados = null;
	private String linha = null;
	private String[] l = null;
	private int contador;
	
	public ArquivoExterno(String arqNome, int opcao) throws FileNotFoundException{
    	arq = new FileReader(arqNome);
    	lerArq = new BufferedReader(arq);
    	contador = 0;
    	switch (opcao) {
		case 0:gravarDados();
			break;
		case 1:gravarInt();
			break;
		}
	}
	
	public int getContador() {
		return contador;
	}

	public List<Dado> getListDados() {
		return listDados;
	}
	
	public int[] getArr() {
		return arr;
	}
	
	private void gravarInt(){
	    String split = formasDeSplit();
	    if(split != null){
			try {
				linha = lerArq.readLine();
				int i;
				while (linha != null) {
					l = linha.split(split);
					for (i = 0; i < l.length; i++) {
						arr = aumentaArr();
						arr[contador + i]= Integer.parseInt(l[i]);
					}
					contador += i;
					linha = lerArq.readLine(); // passa para a proxima linha a cada verificação
		      }
		      arq.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(TelaDados.umTelaDados(),"Erro durante a gravação do arquivo: " + e.getMessage(),"Gravar Dados", JOptionPane.ERROR_MESSAGE);
			}
	    }
	}
	
	//cria um vetor ou adiciona mais uma posição para alocar o proximo valor
	private int[] aumentaArr(){
		if(arr == null){
			arr = new int[1];
		}else{
			int[] novoArr = new int[arr.length + 1];
			for (int i = 0; i < arr.length; i++) {
				novoArr[i] = arr[i];
			}
			return novoArr;
		}
		return arr;
	}
	
	private String formasDeSplit(){
		String[] opcoes = {"Espaço", "Virgula", "Cancelar"};
		int opcao = JOptionPane.showOptionDialog(null, "Os dados estaram separados por?",
				"Formato de leitura dos arquivos externos", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
		switch (opcao) {
			case 0:return " ";
			case 1:return ",";
		}
		return null;
	}
	
	//metodo que gera todos os Dados para a class Dado e os adiciona na listDados
	private void gravarDados(){
		dado = new Dado();
		listDados = new ArrayList<Dado>();
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
					contador++;
				}
				linha = lerArq.readLine(); // passa para a proxima linha a cada verificação
	      }
	      arq.close();
		} catch (IOException e) {
			listDados = null;
			JOptionPane.showMessageDialog(TelaDados.umTelaDados(),"Erro durante a gravação do arquivo: " + e.getMessage(),"Gravar Dados", JOptionPane.ERROR_MESSAGE);
		}
	}
}
