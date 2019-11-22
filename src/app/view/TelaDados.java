package app.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.utils.ArquivoExterno;
import app.utils.Dado;
import app.utils.FabricaOndenacao;

public class TelaDados extends JFrame implements WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnProximo;
	private JButton btnAnterior;
	private JButton btnVoltar;
	private JButton btnArquivo;
	private JButton btnOrdena;
	private JLabel lblAno;
	private JLabel lblMes;
	private JLabel lblLocal;
	private JLabel lblValor;
	private JPanel pnl1;
	private JPanel pnl2;
	private JPanel pnl3;
	private TelaRelatorio relatorio = null;
	private FabricaOndenacao sf = null;
	private ArquivoExterno arqExterno = null;
	private List<Dado> listDados = null;
	private int[] arr = null;
	private static TelaDados d = null;
	private int contador = 0;
	private int opcao;
	
	public TelaDados() {
		// TODO Auto-generated constructor stub
		this.setTitle("Menu");
		this.setSize(400, 200);
		this.setLayout(new GridLayout(2,1));
		this.setResizable(false);
		
		btnOrdena = new JButton("Ordenar");
		btnArquivo = new JButton("Abrir");
		btnProximo = new JButton("Proximo");
		btnAnterior = new JButton("Anterior");
		btnVoltar = new JButton("Voltar");
		lblAno = new JLabel(" Ano: ");
		lblMes = new JLabel(" Mês: ");
		lblLocal = new JLabel(" Local: ");
		lblValor = new JLabel(" Valor: ");
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		
		btnOrdena.setEnabled(false);
		btnArquivo.setEnabled(true);
		btnProximo.setEnabled(false);
		btnAnterior.setEnabled(false);
		btnVoltar.setEnabled(true);
		pnl1.setLayout(new GridLayout(1,1));
		pnl2.setLayout(new GridLayout(1,4));
		pnl3.setLayout(new GridLayout(4,1));
		
		btnOrdena.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					if(arr == null && listDados != null){
						sf = new FabricaOndenacao(listDados);
						sf.runDadosSortAndGetTime();
						System.out.println("Os valores foram ordenados em " + sf.getDadosTime() + " milisegundos");
						//System.out.println(sf.getListDados().toString());  //linha para visualizar vetor ordenado
					}else if(arr != null && listDados == null){
						sf = new FabricaOndenacao(arr);
						sf.runAllSortAndGetTime();
						relatorio = new TelaRelatorio();
						relatorio.setTxtArea(relatorio.toStringCabecalho());
						relatorio.setTxtArea(sf.toStringCorpo(arqExterno.getContador()));
						relatorio.setVisible(true);
					}
					btnOrdena.setEnabled(false);
				}
			}
		);
		
		btnArquivo.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					String[] opcoes = {"Tipo Dados", "Vetor de int", "Cancelar"};
					String arqNome = "";
					opcao = JOptionPane.showOptionDialog(null, "Qual formato de comparação você desejas ultilizar?",
			                "Comparador de arquivos externos", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
					switch (opcao) {
					case 0:	try{
								while(arqNome.equals("")){
									arqNome = JOptionPane.showInputDialog(null, "Digite o caminho do arquivo de texto: ", "Arquivo Externo", JOptionPane.PLAIN_MESSAGE);
								}
								if(arqNome != null){
									arqExterno = new ArquivoExterno(arqNome, opcao);
									listDados = arqExterno.getListDados();
									apresentaDados();
									btnProximo.setEnabled(true);
									btnAnterior.setEnabled(true);
									btnOrdena.setEnabled(true);
								}
							}catch (NullPointerException e) {
								arqExterno = null;
							}catch (Exception e) {
								JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo: " + e.getMessage(),"Arquivo Externo", JOptionPane.ERROR_MESSAGE);
							}
						break;
					case 1:	try{
								while(arqNome.equals("")){
									arqNome = JOptionPane.showInputDialog(null, "Digite o caminho do arquivo de texto: ", "Arquivo Externo", JOptionPane.PLAIN_MESSAGE);
								}
								if(arqNome != null){
									arqExterno = new ArquivoExterno(arqNome, opcao);
									arr = arqExterno.getArr();
									apresentaVetor();
									btnProximo.setEnabled(true);
									btnAnterior.setEnabled(true);
									btnOrdena.setEnabled(true);
								}
							}catch (NullPointerException e) {
								arqExterno = null;
							}catch (Exception e) {
								JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo: " + e.getMessage(),"Arquivo Externo", JOptionPane.ERROR_MESSAGE);
							}
						break;
					}
				}
			}
		);
		
		btnProximo.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					contador++;
					if(arr == null && listDados != null){
						if(contador > listDados.size()-1)
							contador = 0;
						apresentaDados();
					}else if(arr != null && listDados == null){
						if(contador > arr.length-1)
							contador = 0;
						apresentaVetor();
					}
				}
			}
		);
		
		btnAnterior.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					contador--;
					if(arr == null && listDados != null){
						if(contador < 0)
							contador = listDados.size()-1;
						apresentaDados();
					}else if(arr != null && listDados == null){
						if(contador < 0)
							contador = arr.length-1;
						apresentaVetor();
					}
				}
			}
		);
		
		btnVoltar.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					alteraVisibilidade();
				}
			}
		);
		
		addWindowListener(this);
		
		pnl3.add(lblAno);
		pnl3.add(lblMes);
		pnl3.add(lblLocal);
		pnl3.add(lblValor);
		pnl1.add(pnl3);
		pnl1.add(btnOrdena);
		pnl2.add(btnArquivo);
		pnl2.add(btnAnterior);
		pnl2.add(btnProximo);
		pnl2.add(btnVoltar);
		this.add(pnl1);
		this.add(pnl2);
		this.setVisible(true);
	}
	
	private void alteraVisibilidade() {
		// TODO Auto-generated method stub
		this.setVisible(!isVisible());
	}
	
	private void apresentaDados() {
		// TODO Auto-generated method stub
		lblAno.setText(" Ano: " + listDados.get(contador).getAno());
		lblMes.setText(" Mês: " + listDados.get(contador).getMes());
		lblLocal.setText(" Local: " + listDados.get(contador).getLocal());
		lblValor.setText(" Valor: " + listDados.get(contador).getValor());
	}
	
	private void apresentaVetor() {
		// TODO Auto-generated method stub
		lblAno.setText("");
		lblMes.setText("");
		lblLocal.setText(" Posição Nº: " + contador);
		lblValor.setText(" Valor: " + arr[contador]);
	}
	
	public static TelaDados umTelaDados(){
		if(d == null){
			d = new TelaDados();
			d.setVisible(true);
		}else{
			d.alteraVisibilidade();
		}	
		return d;
	}
	
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		alteraVisibilidade();
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
}