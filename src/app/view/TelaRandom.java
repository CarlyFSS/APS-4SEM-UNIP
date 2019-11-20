package app.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import app.utils.RandomNumberGenerator;
import app.utils.SortFactory;

public class TelaRandom extends JFrame implements WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNum;
	private JButton btnProximo;
	private JButton btnAnterior;
	private JButton btnVoltar;
	private JButton btnAleatorio;
	private JButton btnOrdena;
	private JPanel pnl1;
	private JPanel pnl2;
	private RandomNumberGenerator nr;
	private TelaRelatorio relatorio;
	private SortFactory sf;
	private int[] arr = null;
	private int contador = 0;
	private static TelaRandom r = null;
	
	public TelaRandom() {
		// TODO Auto-generated constructor stub
		this.setTitle("Menu");
		this.setSize(400, 200);
		this.setLayout(new GridLayout(2,1));
		this.setResizable(false);
		
		txtNum = new JTextField();
		btnOrdena = new JButton("Ordenar");
		btnAleatorio = new JButton("Aleatorio");
		btnProximo = new JButton("Proximo");
		btnAnterior = new JButton("Anterior");
		btnVoltar = new JButton("Voltar");
		nr = new RandomNumberGenerator();
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		
		txtNum.setFont(new Font("monospaced", Font.BOLD, 15));
		txtNum.setEnabled(false);
		btnOrdena.setEnabled(false);
		btnAleatorio.setEnabled(true);
		btnProximo.setEnabled(false);
		btnAnterior.setEnabled(false);
		btnVoltar.setEnabled(true);
		txtNum.setEditable(false);
		pnl1.setLayout(new GridLayout(1,2));
		pnl2.setLayout(new GridLayout(1,4));
		
		btnOrdena.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					sf = new SortFactory(arr);
					sf.runBubbleSortAndGetTime();
					sf.runInsertionSortAndGetTime();
					sf.runSelectionSortAndGetTime();
					relatorio = new TelaRelatorio(sf.getToString());
					relatorio.setVisible(true);
				}
			}
		);
		
		btnAleatorio.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					arr = nr.genRandomNumberArray(5000,1,10000);
					txtNum.setText("posição Nº"+(contador+1)+":\t"+Integer.toString(arr[contador]));
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
					if(contador > arr.length-1)
						contador = 0;
					txtNum.setText("posição Nº"+(contador+1)+":\t"+Integer.toString(arr[contador]));
				}
			}
		);
		
		btnAnterior.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					contador--;
					if(contador < 0)
						contador = arr.length-1;
					txtNum.setText("posição Nº"+(contador+1)+":\t"+Integer.toString(arr[contador]));
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
		
		pnl1.add(txtNum);
		pnl1.add(btnOrdena);
		pnl2.add(btnAleatorio);
		pnl2.add(btnAnterior);
		pnl2.add(btnProximo);
		pnl2.add(btnVoltar);
		this.add(pnl1);
		this.add(pnl2);
	}
	
	private void alteraVisibilidade() {
		// TODO Auto-generated method stub
		this.setVisible(!isVisible());
	}

	public static TelaRandom umTelaRandom(){
		if(r == null){
			r = new TelaRandom();
			r.setVisible(true);
		}else{
			r.alteraVisibilidade();
		}
		return r;
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
