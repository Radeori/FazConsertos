import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TelaLoginTecnico extends JFrame{
	
	JLabel		label[] = new JLabel[1];
	JTextField 	entrada[] = new JTextField[1];
	JButton 	botaoConfirma;
	
	public TelaLoginTecnico() {
		super("Login(Técnico)");
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		//Instancia objeto que controla os eventos
		ControlaEventoLoginTecnico controlaEvento = new ControlaEventoLoginTecnico();
		
		//--Matrícula do técnico--//

		entrada[0] = new JTextField(10);
		container.add(entrada[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, entrada[0], 0, SpringLayout.HORIZONTAL_CENTER, container); //
		layout.putConstraint(SpringLayout.SOUTH, entrada[0], -3, SpringLayout.VERTICAL_CENTER, container); //
		
		label[0] = new JLabel("Matrícula");
		container.add(label[0]);
		layout.putConstraint(SpringLayout.EAST, label[0], -5, SpringLayout.WEST, entrada[0]); //
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, label[0], 0, SpringLayout.VERTICAL_CENTER, entrada[0]); //
				
		//--Botao de Confimação --//
		
		botaoConfirma = new JButton("Login");
		container.add(botaoConfirma);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botaoConfirma, 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.NORTH, botaoConfirma, 3, SpringLayout.VERTICAL_CENTER, container);
		botaoConfirma.addActionListener(controlaEvento);
		
		//Configurações de tamanho da janela
		setSize(300,150);
		
		//Posiciona a janela no centro da tela
		setLocationRelativeTo(null);
		
		//Ativa a visibilidade da janela
		setVisible(true);
	}
	
	
	//Metodo usado para checar se os campos de texto estão vazios antes de pegar seu conteúdo
	private String pegaTexto(JTextField texto) throws CampoNaoPreenchidoException{
		
		if(texto.getText().equals(""))
			throw new CampoNaoPreenchidoException(texto.getName());
		
		return texto.getText();
	}

	private class ControlaEventoLoginTecnico implements ActionListener {

		public void actionPerformed(ActionEvent evento) {
			String resultado[] = new String[1];
			if(evento.getSource() == botaoConfirma) {
				try {
					resultado[0] = pegaTexto(entrada[0]);
				}
				catch (CampoNaoPreenchidoException e) {
					JOptionPane.showMessageDialog(null,"Matrícula não pode estar em branco","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				//DEBUG, caixa de diálogo com os os dados dos textos.
				JOptionPane.showMessageDialog(null, "Olá, " + resultado[0] + "!","DEBUG",JOptionPane.INFORMATION_MESSAGE);
				
				
				
				//Fecha a janela depois de abrir outra
				setVisible(false);
				dispose();
				
				//Volta pra tela principal
				TelaPrincipal tela = new TelaPrincipal();
			}
		}
	}

	//Exceção caso algum campo esteja vazio
	private class CampoNaoPreenchidoException extends Exception{
		public String nomeCampo;
		public CampoNaoPreenchidoException(String campo){
			super("Campo de nome: "+ campo + " não preenchido.");
			nomeCampo= campo;
		}
	}
}