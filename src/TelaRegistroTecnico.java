import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TelaRegistroTecnico extends Tela{

	
	//Construtor
	public TelaRegistroTecnico(){
		super ("Registro de novo t�cnico",5,4,1);
		
		//--Título--//

		label[0] = new JLabel("Entre com os dados de registro do novo t�cnico:");
		container.add(label[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label[0], 0, SpringLayout.HORIZONTAL_CENTER, container); //Alinhado com o centro
		layout.putConstraint(SpringLayout.NORTH, label[0], 5, SpringLayout.NORTH, container); //5 pixel da borda superior
		
		//--Nome do técnico--//
		
		label[1] = new JLabel("Nome");
		container.add(label[1]);
		layout.putConstraint(SpringLayout.WEST, label[1], 5, SpringLayout.WEST, container); //5 pixel da borda esquerda
		layout.putConstraint(SpringLayout.NORTH, label[1], 5, SpringLayout.SOUTH, label[0]); //5 abaixo do titulo
		
		entrada[0] = new JTextField(15);
		container.add(entrada[0]);
		layout.putConstraint(SpringLayout.WEST, entrada[0], 5, SpringLayout.EAST, label[1]);// 5 pixel a esquerda de labelNome
		layout.putConstraint(SpringLayout.NORTH,entrada[0], 0, SpringLayout.NORTH, label[1]); // mesma posi��o horizontal que labelNome
		

		
		//--Email de contato do tecnico--//
		
		label[2] = new JLabel("Email");
		container.add(label[2]);
		layout.putConstraint(SpringLayout.WEST, label[2], 5, SpringLayout.WEST, container); //5 pixel da borda esquerda
		layout.putConstraint(SpringLayout.NORTH, label[2], 5, SpringLayout.SOUTH, label[1]); //5 pixel abaixo de labelNome
		

		entrada[1] = new JTextField(15);
		container.add(entrada[1]);
		layout.putConstraint(SpringLayout.WEST, entrada[1], 0, SpringLayout.WEST, entrada[0]);// Mesma posi��o horizontal que entradaNome
		layout.putConstraint(SpringLayout.NORTH, entrada[1], 5, SpringLayout.SOUTH, label[1]);//5 pixel abaixo de labelNome
		
		//--Telefone de contato do técnico--//
		
		label[3] = new JLabel("Telefone de contato");
		container.add(label[3]);
		layout.putConstraint(SpringLayout.WEST, label[3], 5, SpringLayout.EAST, entrada[0]); // 5 pixels a direita de entradaNome
		layout.putConstraint(SpringLayout.NORTH, label[3], 0, SpringLayout.NORTH, label[1]); // mesma posi��o horizontal que labelNome
		
		entrada[2] = new JTextField(10);
		container.add(entrada[2]);
		layout.putConstraint(SpringLayout.WEST, entrada[2], 5, SpringLayout.EAST, label[3]);// 5 pixels a direita de labelTelefone
		layout.putConstraint(SpringLayout.NORTH,entrada[2], 0, SpringLayout.NORTH, label[1]); // mesma posi��o horizontal que labelNome
		
		//--Habilidade profissional do tecnico--//
		
		label[4] = new JLabel("Hab. Profissional");
		container.add(label[4]);
		layout.putConstraint(SpringLayout.WEST, label[4], 0, SpringLayout.WEST, label[3]); //Mesma posi��o horizontal que labelTelefone
		layout.putConstraint(SpringLayout.NORTH, label[4], 5, SpringLayout.SOUTH, label[1]); //5 pixel abaixo de labelNome
		

		entrada[3] = new JTextField(10);
		container.add(entrada[3]);
		layout.putConstraint(SpringLayout.WEST, entrada[3], 0, SpringLayout.WEST, entrada[2]);// Mesma posi��o horizontal que entradaTelefone
		layout.putConstraint(SpringLayout.NORTH, entrada[3], 5, SpringLayout.SOUTH, label[1]);//5 pixel abaixo de labelNome

		//--Botao de Confimação --//
		
		botao[0] = new JButton("Confirmar");
		container.add(botao[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[0], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.NORTH, botao[0], 10, SpringLayout.SOUTH, label[2]);
		
		//Instancia objeto que controla os eventos
		ControlaEventoRegistroTecnico controlaEvento = new ControlaEventoRegistroTecnico();
		
		//Adiciona o controlador de eventos para cada componente da tela
		botao[0].addActionListener(controlaEvento);
		
		

		layout.putConstraint(SpringLayout.WEST, botaoVoltar, 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.SOUTH, botaoVoltar, -5, SpringLayout.SOUTH, container);
		
		
		//Configurações de tamanho da janela
		mostraTela(500,150);

		
	}
	
	//ActionListener referente ao botao de confirmação
	private class ControlaEventoRegistroTecnico implements ActionListener 
	{
		public void actionPerformed(ActionEvent evento) {
			
			//Strings referentes aos dados preenchidos
			String resultado[] = new String[entrada.length];
			for (int i = 0; i < resultado.length; i++) {
				resultado[i] = "";
			}
			
			//Se o botão de confirmacao é ativado
			if(evento.getSource()== botao[0]){
				//Pega o texto digitado nas caixas
				for (int i = 0; i < resultado.length; i++) {
					//Checa se os campos estão vazios
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
				//1 - email
				//2 - telefone
				//3 - habilidade
				//TODO: Passar os dados pra um controlador
				
				//DEBUG, caixa de diálogo com os os dados dos textos.
				Tecnico tecnico = new Tecnico(resultado[0],resultado[1],Integer.parseInt(resultado[2]),resultado[3]);
				controlaDados.adicionaTecnico(tecnico);
				
				//Fecha a janela depois de abrir outra
				setVisible(false);
				dispose();
				
				new TelaListasOrdensServico();
				
				
				
			}
		}
	}
}


