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
import javax.swing.JPanel;
import app.utils.ArquivoExterno;
import app.utils.Dado;

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
	private ArquivoExterno ae;
	private List<Dado> listDados = null;
	private int contador = 0;
	private static TelaDados d = null;
	
	public TelaDados() {
		// TODO Auto-generated constructor stub
		this.setTitle("Menu");
		this.setSize(400, 200);
		this.setLayout(new GridLayout(2,1));
		this.setResizable(false);
		
		ae = new ArquivoExterno();
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
		
		listDados = ae.getListDados();
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
					
				}
			}
		);
		
		btnArquivo.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					apresentaDados();
					btnProximo.setEnabled(true);
					btnAnterior.setEnabled(true);
					btnOrdena.setEnabled(true);
				}
			}
		);
		
		btnProximo.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					contador++;
					if(contador > listDados.size()-1)
						contador = 0;
					apresentaDados();
				}
			}
		);
		
		btnAnterior.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					contador--;
					if(contador < 0)
						contador = listDados.size()-1;
					apresentaDados();
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
	
	private void apresentaDados(){
		lblAno.setText(" Ano: " + listDados.get(contador).getAno());
		lblMes.setText(" Mês: " + listDados.get(contador).getMes());
		lblLocal.setText(" Local: " + listDados.get(contador).getLocal());
		lblValor.setText(" Valor: " + listDados.get(contador).getValor());
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