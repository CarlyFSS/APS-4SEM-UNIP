package app.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import app.utils.Botoes;

public class TelaRelatorio extends JFrame implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSalvar;
	private JButton btnAbrir;
	private JTextArea txtArea;
	private JScrollPane scroll;
	private Botoes b;
	
	public TelaRelatorio() {
		// TODO Auto-generated constructor stub
		this.setTitle("Relatorio");
		this.setSize(400, 280);
		this.setLayout(null);
		this.setResizable(false);
		
		btnSalvar = new JButton("Salvar");
		btnAbrir = new JButton("Abrir");
		txtArea = new JTextArea();
		scroll = new JScrollPane(txtArea);
		b = new Botoes();

		btnSalvar.setBounds(300, 210, 80, 20);
		btnAbrir.setBounds(220, 210, 80, 20);
		scroll.setBounds(10, 10, 380, 190);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		btnSalvar.setActionCommand("ação1");
		btnSalvar.addActionListener(b);
		btnAbrir.setActionCommand("ação2");
		btnAbrir.addActionListener(b);
		
		addWindowListener(this);
		
		this.getContentPane().add(scroll);
		this.add(btnSalvar);
		this.add(btnAbrir);
	}
	
	public TelaRelatorio(String relatorioSF) {
		// TODO Auto-generated constructor stub
		this.setTitle("Relatorio");
		this.setSize(400, 280);
		this.setLayout(null);
		this.setResizable(false);
		
		btnSalvar = new JButton("Salvar");
		btnAbrir = new JButton("Abrir");
		txtArea = new JTextArea(relatorioSF);
		scroll = new JScrollPane(txtArea);
		b = new Botoes();

		btnSalvar.setBounds(300, 210, 80, 20);
		btnAbrir.setBounds(220, 210, 80, 20);
		scroll.setBounds(10, 10, 380, 190);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		btnSalvar.setActionCommand("ação1");
		btnSalvar.addActionListener(b);
		btnAbrir.setActionCommand("ação2");
		btnAbrir.addActionListener(b);
		
		addWindowListener(this);
		
		this.getContentPane().add(scroll);
		this.add(btnSalvar);
		this.add(btnAbrir);
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		dispose();
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
