package interfaceG;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Eventos extends JFrame /*implements ActionListener*/{
	
//	JButton botao;
	
	public Eventos(){
		super("Assinatura Digital");
		
//		botao = new JButton("Click aqui!");
//		getContentPane().add(botao);
//		botao.addActionListener(this);
		
		JLabel simples = new JLabel("Label teste");
		simples.setToolTipText("Meu Label");
		
		Container c = new Container();
		c.setLayout(new FlowLayout());
		c.add(simples);
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		botao.setText("Foi clicado");
//		
//	}
	
	public static void main(String[] args){
		new Eventos();
	}



}
