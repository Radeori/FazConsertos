
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;


public class TelaDadosServico extends Tela{
	
	JTextArea caixaDescricao;
	
	public TelaDadosServico(){
		super ("Dados do servi�o",3,1,1);
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		//Instancia objeto que controla os eventos
		ControlaEvento controlaEvento = new ControlaEvento();
		
		
		//--T�tulo--//

		label[0] = new JLabel("Entre com as demais informa��es do servi�o:");
		container.add(label[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label[0], 0, SpringLayout.HORIZONTAL_CENTER, container); //Alinhado com o centro
		layout.putConstraint(SpringLayout.NORTH, label[0], 5, SpringLayout.NORTH, container); //5 pixel da borda superior
		
		//--Tipo do profissional -- //
		
		label[1] = new JLabel("Tipo do profissional requisitado");
		container.add(label[1]);
		layout.putConstraint(SpringLayout.WEST, label[1], 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, label[1], 5, SpringLayout.SOUTH, label[0]); //5 pixel da borda superior
		
		entrada[0] = new JTextField(10);
		container.add(entrada[0]);
		layout.putConstraint(SpringLayout.WEST,entrada[0], 5, SpringLayout.EAST, label[1]);
		layout.putConstraint(SpringLayout.NORTH, entrada[0], 0, SpringLayout.NORTH, label[1]);
		
		//--Descricao do servico -- //
		
		label[2] = new JLabel("Descricao do servico");
		container.add(label[2]);
		layout.putConstraint(SpringLayout.WEST, label[2], 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, label[2], 5, SpringLayout.SOUTH, label[1]); //5 pixel da borda superior
		
		botao[0] = new JButton("Confirmar");
		container.add(botao[0]);
		botao[0].addActionListener(controlaEvento);
		layout.putConstraint(SpringLayout.EAST, botao[0], -5, SpringLayout.EAST, container);
		layout.putConstraint(SpringLayout.SOUTH, botao[0], -5, SpringLayout.SOUTH, container);
		
		botaoVoltar = new BotaoVoltar();
		container.add(botaoVoltar);
		layout.putConstraint(SpringLayout.WEST, botaoVoltar, 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.SOUTH, botaoVoltar, -5, SpringLayout.SOUTH, container);
		
		caixaDescricao = new JTextArea(10,30);
		caixaDescricao.setWrapStyleWord(true);
		caixaDescricao.setLineWrap(true);
		container.add(caixaDescricao);
		layout.putConstraint(SpringLayout.WEST, caixaDescricao, 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, caixaDescricao, 5, SpringLayout.SOUTH, label[2]);
		layout.putConstraint(SpringLayout.SOUTH, caixaDescricao, -5, SpringLayout.NORTH, botao[0]);
		
		mostraTela(360,720);
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
					
					//Volta pra tela principal
					TelaPrincipal tela = new TelaPrincipal();
					
					//Fecha a janela depois de abrir outra
					setVisible(false);
					dispose();

				}
			}
		}
}
