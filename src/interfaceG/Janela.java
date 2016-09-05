package interfaceG;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame{
//	private JFrame frame;
//	private JButton botao;
	
	public Janela(){
		super("Assinatura Digital");
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton botao = new JButton();
		getContentPane().add(botao);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());;
		Container c2 = new JPanel();
		
		c2.setLayout(new GridLayout(4,1));
		c2.add(new JButton("New Arquivo"));
		c2.add(new JButton("VERIFICAR"));
		c2.add(new JButton("Teste"));
		c2.add(new JButton("Teste2"));
		
		c.add(BorderLayout.CENTER, new JButton("Centro"));
		c.add(BorderLayout.EAST , c2);
		

	}
	
	public static void main(String[] args){
		new Janela();
		
	}

}
