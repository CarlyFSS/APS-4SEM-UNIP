package app.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import app.view.TelaDados;

public class Botoes implements ActionListener{

	private String arqNome;
	private JTextArea txtArea;

	public Botoes(JTextArea txtArea) {
		// TODO Auto-generated constructor stub
		this.txtArea = txtArea;
	}
	
	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		if(arg.getActionCommand().equals("ação1")){
			try{
				arqNome = "";
				while(arqNome.equals("")){
					arqNome = JOptionPane.showInputDialog(null, "Digite o caminho/nome do arquivo de texto que desejas criar: ", "Sarvar", JOptionPane.PLAIN_MESSAGE);
				}
				if(arqNome != null){
					FileWriter arq = new FileWriter(arqNome);
					PrintWriter gravarArq = new PrintWriter(arq);
					gravarArq.printf(txtArea.getText());
					arq.close();
				}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro ao salvar o arquivo: " + e.getMessage(),"Salvar", JOptionPane.ERROR_MESSAGE);
			}
		}else if(arg.getActionCommand().equals("ação2")){
			try{
				arqNome = "";
				while(arqNome.equals("")){
					arqNome = JOptionPane.showInputDialog(null, "Digite o caminho/nome do arquivo de texto que desejas criar: ", "Sarvar", JOptionPane.PLAIN_MESSAGE);
				}
				if(arqNome != null){
					FileReader arq = new FileReader(arqNome);
					BufferedReader lerArq = new BufferedReader(arq);
					try {
						txtArea.setText("");
						String linha = lerArq.readLine(); // le a primeira linha
						while (linha != null) {
							txtArea.setText(txtArea.getText() + linha + "\n");
							linha = lerArq.readLine(); // passa para a proxima linha a cada verificação
						}
						arq.close();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(TelaDados.umTelaDados(),"Erro ao abrir o arquivo: " + e.getMessage(),"Abrir", JOptionPane.ERROR_MESSAGE);
					}
				}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro ao salvar o arquivo: " + e.getMessage(),"Salvar", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
