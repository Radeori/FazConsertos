import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class TelaRegistroCliente extends Tela{
	
	boolean solicita;
	
	//Construtor
	public TelaRegistroCliente(String nome,String cpf,String telefone){
		super ("Registro de novo cliente",7,8,2);
		
		
		//Instancia objeto que controla os eventos
		ControlaEvento controlaEvento = new ControlaEvento();
	
		//--T�tulo--//

		label[0] = new JLabel("Entre com os dados de registro do cliente:");
		container.add(label[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label[0], 0, SpringLayout.HORIZONTAL_CENTER, container); //Alinhado com o centro
		layout.putConstraint(SpringLayout.NORTH, label[0], 5, SpringLayout.NORTH, container); //5 pixel da borda superior
		
		//--Nome do cliente--//
		
		label[1] = new JLabel("Nome");
		container.add(label[1]);
		layout.putConstraint(SpringLayout.WEST, label[1], 5, SpringLayout.WEST, container); //5 pixel da borda esquerda
		layout.putConstraint(SpringLayout.NORTH, label[1], 5, SpringLayout.SOUTH, label[0]); //5 abaixo do titulo
		
		entrada[0] = new JTextField(15);
		container.add(entrada[0]);
		layout.putConstraint(SpringLayout.WEST, entrada[0], 5, SpringLayout.EAST, label[1]);// 5 pixel a esquerda de labelNome
		layout.putConstraint(SpringLayout.NORTH,entrada[0], 0, SpringLayout.NORTH, label[1]); // mesma posi��o horizontal que labelNome
		entrada[0].setText(nome); //Nome preenchido pela tela anterior
		

		
		//--CPF do cliente--//
		
		label[2] = new JLabel("CPF");
		container.add(label[2]);
		layout.putConstraint(SpringLayout.WEST, label[2], 5, SpringLayout.WEST, container); //5 pixel da borda esquerda
		layout.putConstraint(SpringLayout.NORTH, label[2], 5, SpringLayout.SOUTH, label[1]); //5 pixel abaixo de labelNome
		

		entrada[1] = new JTextField(10);
		container.add(entrada[1]);
		layout.putConstraint(SpringLayout.WEST, entrada[1], 0, SpringLayout.WEST, entrada[0]);// Mesma posi��o horizontal que entradaNome
		layout.putConstraint(SpringLayout.NORTH, entrada[1], 5, SpringLayout.SOUTH, label[1]);//5 pixel abaixo de labelNome
		entrada[1].setText(cpf); //CPF preenchido pela tela anterior
		
		//--Telefone de contato do cliente--//
		
		label[3] = new JLabel("Telefone de contato");
		container.add(label[3]);
		layout.putConstraint(SpringLayout.WEST, label[3], 5, SpringLayout.EAST, entrada[0]); // 5 pixels a direita de entradaNome
		layout.putConstraint(SpringLayout.NORTH, label[3], 0, SpringLayout.NORTH, label[1]); // mesma posi��o horizontal que labelNome
		
		entrada[2] = new JTextField(10);
		container.add(entrada[2]);
		layout.putConstraint(SpringLayout.WEST, entrada[2], 5, SpringLayout.EAST, label[3]);// 5 pixels a direita de labelTelefone
		layout.putConstraint(SpringLayout.NORTH,entrada[2], 0, SpringLayout.NORTH, label[1]); // mesma posi��o horizontal que labelNome
		entrada[2].setText(telefone); //Telefone preenchido pela tela anterior
		
		//--RG do cliente--//
		
		label[4] = new JLabel("RG");
		container.add(label[4]);
		layout.putConstraint(SpringLayout.WEST, label[4], 0, SpringLayout.WEST, label[2]); //Mesma posi��o horizontal que labelCPF
		layout.putConstraint(SpringLayout.NORTH, label[4], 5, SpringLayout.SOUTH, label[2]); //5 pixel abaixo de labelCPF
		

		entrada[3] = new JTextField(10);
		container.add(entrada[3]);
		layout.putConstraint(SpringLayout.WEST, entrada[3], 0, SpringLayout.WEST, entrada[1]);// Mesma posi��o horizontal que entradaCPF
		layout.putConstraint(SpringLayout.NORTH, entrada[3], 5, SpringLayout.SOUTH, label[2]);//5 pixel abaixo de labelCPF
		
		//--Endereco--//
		
		label[5] = new JLabel(" Endereço");
		container.add(label[5]);
		layout.putConstraint(SpringLayout.WEST, label[5], 5, SpringLayout.EAST, entrada[1]); //5 pixel a direita de entradaCPF
		layout.putConstraint(SpringLayout.NORTH, label[5], 5, SpringLayout.SOUTH, label[1]); //5 pixel abaixo de labelTelefone
		

		entrada[4] = new JTextField(20);
		container.add(entrada[4]);
		layout.putConstraint(SpringLayout.WEST, entrada[4], 5, SpringLayout.EAST, label[5]);// 5 pixel a direita de labelEndereco
		layout.putConstraint(SpringLayout.NORTH, entrada[4], 5, SpringLayout.SOUTH, label[1]);//5 pixel abaixo de labelTelefone
		
		//-- Data de Nascimento --//
		label[6] = new JLabel(" Data de Nasc.");
		container.add(label[6]);
		layout.putConstraint(SpringLayout.WEST, label[6], 5, SpringLayout.EAST, entrada[1]); //5 pixel a direita de entradaCPF
		layout.putConstraint(SpringLayout.NORTH, label[6], 5, SpringLayout.SOUTH, label[2]);//5 pixel abaixo de labelCPF
		
			//dia
			entrada[5] = new JTextField(2);
			container.add(entrada[5]);
			layout.putConstraint(SpringLayout.WEST, entrada[5], 5, SpringLayout.EAST, label[6]); //5 pixel a direita de labelNascimento
			layout.putConstraint(SpringLayout.NORTH, entrada[5], 5, SpringLayout.SOUTH, label[2]);//5 pixel abaixo de labelCPF
			//m�s
			entrada[6] = new JTextField(2);
			container.add(entrada[6]);
			layout.putConstraint(SpringLayout.WEST, entrada[6], 2, SpringLayout.EAST, entrada[5]); //2 pixel a direita de entradaDia
			layout.putConstraint(SpringLayout.NORTH, entrada[6], 5, SpringLayout.SOUTH, label[2]);//5 pixel abaixo de labelCPF
			//ano
			entrada[7] = new JTextField(2);
			container.add(entrada[7]);
			layout.putConstraint(SpringLayout.WEST, entrada[7], 2, SpringLayout.EAST, entrada[6]); //2 pixel a direita de entradaM�s
			layout.putConstraint(SpringLayout.NORTH, entrada[7], 5, SpringLayout.SOUTH, label[2]);//5 pixel abaixo de labelCPF
		
		//--Botao de Confima��o --//
		
		botao[0] = new JButton("Confirmar");
		container.add(botao[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[0], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.SOUTH, botao[0], -10, SpringLayout.SOUTH, container);
		botao[0].addActionListener(controlaEvento);
		
		// - Botao de voltar - //
		container.add(botaoVoltar);
		layout.putConstraint(SpringLayout.WEST, botaoVoltar, 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.SOUTH, botaoVoltar, -5, SpringLayout.SOUTH, container);
		

		//mostra, centraliza e configura tela
		mostraTela(500,180);

	}

	
	//ActionListener referente ao botao de confirmacao
	class ControlaEvento implements ActionListener 
	{
		public void actionPerformed(ActionEvent evento) {
			
			//Strings referentes aos dados preenchidos
			String resultado[] = new String[entrada.length];
			for (int i = 0; i < resultado.length; i++) {
				resultado[i] = "";
			}
			
			//Se o bot�o de confirmacao � ativado
			if(evento.getSource()== botao[0]){
				//Pega o texto digitado nas caixas
				for (int i = 0; i < resultado.length; i++) {
					//Checa se os campos est�o vazios
					try {
						resultado[i] = pegaTexto(entrada[i]);
					} catch (CampoNaoPreenchidoException e) {
						//Exibe um erro e cancela a checagem das caixas at� que todos os campos tenham sido preenchidos
						JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos","Erro!",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				//------------------- AONDE OS DADOS SAEM DA TELA ------------------ //
				//resultado:
				//0 - nome
				//1 - CPF
				//2 - telefone
				//3 - RG
				//4 - Endere�o
				//5 6 e 7 - Data de nascimento (dia,m�s,ano);
				//TODO: Passar os dados pra um controlador
				
				//DEBUG, caixa de dialogo com os os dados dos textos.
				JOptionPane.showMessageDialog(null, "Nome: " + resultado[0] + "\nCPF: "+ resultado[1] + "\nTelefone de contato: "+ resultado[2] + "\nRG: "+ resultado[3] + "\nEndereço: "+ resultado[4] + "\nData de Nascimento: "+ resultado[5]+ "/"+resultado[6]+"/"+resultado[7],"DEBUG",JOptionPane.INFORMATION_MESSAGE);
				
					TelaDadosServico telaDados = new TelaDadosServico();
				
				//Fecha a janela depois de abrir outra
				setVisible(false);
				dispose();

			}
		}
	}

}
