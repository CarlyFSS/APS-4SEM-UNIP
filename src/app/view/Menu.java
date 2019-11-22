package app.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame implements WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TelaRelatorio relatorio;
	private JButton btnAleatorio;
	private JButton btnDados;
	private JButton btnRelatorio;
	private JPanel pnl1;
	private JPanel pnl2;
	
	public Menu() {
		// TODO Auto-generated constructor stub
		this.setTitle("Menu pricipal");
		this.setSize(400, 200);
		this.setLayout(new GridLayout(2,2));
		this.setResizable(false);
		
		btnAleatorio = new JButton("Dados aleatorios");
		btnDados = new JButton("Arquivo pre-definido");
		btnRelatorio = new JButton("Relatorio");
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		
		pnl1.setLayout(new GridLayout(1,2));
		pnl2.setLayout(new GridLayout(1,1));
		
		btnRelatorio.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					relatorio = new TelaRelatorio();
					relatorio.setVisible(true);
				}
			}
		);
		
		btnAleatorio.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					TelaRandom.umTelaRandom();			
				}
			}
		);
		
		btnDados.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					TelaDados.umTelaDados();
				}
			}
		);
		
		addWindowListener(this);
		
		pnl1.add(btnAleatorio);
		pnl1.add(btnDados);
		pnl2.add(btnRelatorio);
		this.add(pnl1);
		this.add(pnl2);
	}
	
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
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
