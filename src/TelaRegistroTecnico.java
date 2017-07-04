import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TelaRegistroTecnico extends JFrame{
	
	JLabel		labelTitulo,labelNome,labelEmail,labelTelefone,labelHabilidade;
	JTextField 	entradaNome,entradaEmail,entradaTelefone,entradaHabilidade;
	JButton 	botaoConfirma;
	
	public TelaRegistroTecnico(){
		super ("Registro de novo tecnico");
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);

		
		//--Nome do tecnico--//

		labelTitulo = new JLabel("Entre com os dados de registro do novo tecnico:");
		container.add(labelTitulo);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelTitulo, 0, SpringLayout.HORIZONTAL_CENTER, container); //Alinhado com o centro
		layout.putConstraint(SpringLayout.NORTH, labelTitulo, 5, SpringLayout.NORTH, container); //5 pixel da borda superior
		
		//--Nome do tecnico--//
		
		labelNome = new JLabel("Nome");
		container.add(labelNome);
		layout.putConstraint(SpringLayout.WEST, labelNome, 5, SpringLayout.WEST, container); //5 pixel da borda esquerda
		layout.putConstraint(SpringLayout.NORTH, labelNome, 5, SpringLayout.SOUTH, labelTitulo); //5 abaixo do titulo
		
		entradaNome = new JTextField(15);
		container.add(entradaNome);
		layout.putConstraint(SpringLayout.WEST, entradaNome, 5, SpringLayout.EAST, labelNome);// 5 pixel a esquerda de labelNome
		layout.putConstraint(SpringLayout.NORTH,entradaNome, 0, SpringLayout.NORTH, labelNome); // mesma posição horizontal que labelNome
		

		
		//--Email de contato do tecnico--//
		
		labelEmail = new JLabel("Email");
		container.add(labelEmail);
		layout.putConstraint(SpringLayout.WEST, labelEmail, 5, SpringLayout.WEST, container); //5 pixel da borda esquerda
		layout.putConstraint(SpringLayout.NORTH, labelEmail, 5, SpringLayout.SOUTH, labelNome); //5 pixel abaixo de labelNome
		

		entradaEmail = new JTextField(15);
		container.add(entradaEmail);
		layout.putConstraint(SpringLayout.WEST, entradaEmail, 0, SpringLayout.WEST, entradaNome);// Mesma posição horizontal que entradaNome
		layout.putConstraint(SpringLayout.NORTH, entradaEmail, 5, SpringLayout.SOUTH, labelNome);//5 pixel abaixo de labelNome
		
		//--Telefone de contato do tecnico--//
		
		labelTelefone = new JLabel("Telefone de contato");
		container.add(labelTelefone);
		layout.putConstraint(SpringLayout.WEST, labelTelefone, 5, SpringLayout.EAST, entradaNome); // 5 pixels a direita de entradaNome
		layout.putConstraint(SpringLayout.NORTH, labelTelefone, 0, SpringLayout.NORTH, labelNome); // mesma posição horizontal que labelNome
		
		entradaTelefone = new JTextField(10);
		container.add(entradaTelefone);
		layout.putConstraint(SpringLayout.WEST, entradaTelefone, 5, SpringLayout.EAST, labelTelefone);// 5 pixels a direita de labelTelefone
		layout.putConstraint(SpringLayout.NORTH,entradaTelefone, 0, SpringLayout.NORTH, labelNome); // mesma posição horizontal que labelNome
		
		//--Habilidade profissional do tecnico--//
		
		labelHabilidade = new JLabel("Hab. Profissional");
		container.add(labelHabilidade);
		layout.putConstraint(SpringLayout.WEST, labelHabilidade, 0, SpringLayout.WEST, labelTelefone); //Mesma posição horizontal que labelTelefone
		layout.putConstraint(SpringLayout.NORTH, labelHabilidade, 5, SpringLayout.SOUTH, labelNome); //5 pixel abaixo de labelNome
		

		entradaHabilidade = new JTextField(10);
		container.add(entradaHabilidade);
		layout.putConstraint(SpringLayout.WEST, entradaHabilidade, 0, SpringLayout.WEST, entradaTelefone);// Mesma posição horizontal que entradaTelefone
		layout.putConstraint(SpringLayout.NORTH, entradaHabilidade, 5, SpringLayout.SOUTH, labelNome);//5 pixel abaixo de labelNome

		//--Botao de Confimação --//
		
		botaoConfirma = new JButton("Confirmar");
		container.add(botaoConfirma);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botaoConfirma, 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.NORTH, botaoConfirma, 10, SpringLayout.SOUTH, labelEmail);
		
		//Instancia objeto que controla os eventos
		ControlaEventoRegistroTecnico controlaEvento = new ControlaEventoRegistroTecnico();
		
		//Adiciona o controlador de eventos para cada componente da tela
		botaoConfirma.addActionListener(controlaEvento);
		
		
		//Configurações de tamanho da janela
		setSize(500,150);
		
		//Ativa a visibilidade da janela
		setVisible(true);
		
	}
	
	//ActionListener referente ao botao de confirmacao
	private class ControlaEventoRegistroTecnico implements ActionListener 
	{
		public void actionPerformed(ActionEvent evento) {
			
			//Strings referentes aos dados preenchidos
			String nomeString = "";
			String emailString = "";
			String telefoneString = "";
			String habilidadeString = "";
			
			//Se o botão de confirmacao é ativado
			if(evento.getSource()== botaoConfirma){
				//Pega o texto digitado nas caixas
				nomeString = entradaNome.getText();
				emailString = entradaEmail.getText();
				telefoneString = entradaTelefone.getText();
				habilidadeString = entradaHabilidade.getText();
				
				//DEBUG, caixa de dialogo com os os dados dos textos.
				JOptionPane.showMessageDialog(null, "Nome: " + nomeString + "\nEmail: "+ emailString + "\nTelefone de contato: "+ telefoneString + "\nHabilidade Profissional: "+ habilidadeString,"DEBUG",JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
	}
	
	private class DadoNaoInseridoException extends Exception{
		//public string 
	}
}


