package app.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botoes implements ActionListener{

	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		if(arg.getActionCommand().equals("a��o1")){
			System.out.println("salvar");
		}else if(arg.getActionCommand().equals("a��o2")){
			System.out.println("abrir");
		}
	}
}
