import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public abstract class Tela extends JFrame{
	
	JLabel			label[];
	JTextField 		entrada[];
	JButton 		botao[];
	BotaoVoltar 	botaoVoltar;
	Container 		container;
	SpringLayout 	layout;
	
	Tela(String nome, int nLabel, int nEntrada, int nBotao){
		super(nome);
		container = getContentPane();
		layout = new SpringLayout();
		container.setLayout(layout);
		
		label = new JLabel[nLabel];
		entrada = new JTextField[nEntrada];
		botao = new JButton[nBotao];
		botaoVoltar = new BotaoVoltar();
		
	}
	
	void mostraTela(int largura,int altura)
	{
		//Configurações de tamanho da janela
		setSize(largura,altura);
		
		//Posiciona a janela no centro da tela
		setLocationRelativeTo(null);
		
		//Destr�i a tela quando fechada
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//Ativa a visibilidade da janela
		setVisible(true);
	}
	
	//Metodo usado para checar se os campos de texto est�o vazios antes de pegar seu conte�do
	String pegaTexto(JTextField texto) throws CampoNaoPreenchidoException{
		
		if(texto.getText().equals(""))
			throw new CampoNaoPreenchidoException(texto.getName());
		
		return texto.getText();
	}
	
	//Exce��o caso algum campo esteja vazio
	class CampoNaoPreenchidoException extends Exception{
		public String nomeCampo;
		public CampoNaoPreenchidoException(String campo){
			super("Campo de nome: "+ campo + " não preenchido.");
			nomeCampo= campo;
		}
	}
}
