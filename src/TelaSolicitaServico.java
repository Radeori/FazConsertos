import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class TelaSolicitaServico extends JFrame { 
	
	JLabel		label[] = new JLabel[5];
	JTextField	entrada[] = new JTextField[3];
	JButton 	botao[] = new JButton[1];
	
	public TelaSolicitaServico(){
		super ("Solicar novo serviço");
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		//Instancia objeto que controla os eventos
		ControlaEventoSolicitaServico controlaEvento = new ControlaEventoSolicitaServico();
		
		
		//--T�tulo--//

		label[0] = new JLabel("Entre com os dados do cliente:");
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
		

		
		//--CPF do cliente--//
		
		label[2] = new JLabel("CPF");
		container.add(label[2]);
		layout.putConstraint(SpringLayout.WEST, label[2], 5, SpringLayout.WEST, container); //5 pixel da borda esquerda
		layout.putConstraint(SpringLayout.NORTH, label[2], 5, SpringLayout.SOUTH, label[1]); //5 pixel abaixo de labelNome
		

		entrada[1] = new JTextField(15);
		container.add(entrada[1]);
		layout.putConstraint(SpringLayout.WEST, entrada[1], 0, SpringLayout.WEST, entrada[0]);// Mesma posi��o horizontal que entradaNome
		layout.putConstraint(SpringLayout.NORTH, entrada[1], 5, SpringLayout.SOUTH, label[1]);//5 pixel abaixo de labelNome
		
		//--Telefone de contato do cliente--//
		
		label[3] = new JLabel("Telefone de contato");
		container.add(label[3]);
		layout.putConstraint(SpringLayout.WEST, label[3], 5, SpringLayout.EAST, entrada[0]); // 5 pixels a direita de entradaNome
		layout.putConstraint(SpringLayout.NORTH, label[3], 0, SpringLayout.NORTH, label[1]); // mesma posi��o horizontal que labelNome
		
		entrada[2] = new JTextField(10);
		container.add(entrada[2]);
		layout.putConstraint(SpringLayout.WEST, entrada[2], 5, SpringLayout.EAST, label[3]);// 5 pixels a direita de labelTelefone
		layout.putConstraint(SpringLayout.NORTH,entrada[2], 0, SpringLayout.NORTH, label[1]); // mesma posi��o horizontal que labelNome
		
		
		//--Botao de Solicita��o --//
		
		botao[0] = new JButton("Solicitar");
		container.add(botao[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[0], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.SOUTH, botao[0], -10, SpringLayout.SOUTH, container);
		botao[0].addActionListener(controlaEvento);
		

		//centraliza a janela
		setLocationRelativeTo(null);

		
		//Configura��es de tamanho da janela
		setSize(500,150);

		
		//Ativa a visibilidade da janela
		setVisible(true);
		
	
	}

	
	//Metodo usado para checar se os campos de texto est�o vazios antes de pegar seu conte�do
	private String pegaTexto(JTextField texto) throws CampoNaoPreenchidoException{
		
		if(texto.getText().equals(""))
			throw new CampoNaoPreenchidoException(texto.getName());
		
		return texto.getText();
	}
	

	
	
	private class ControlaEventoSolicitaServico implements ActionListener 
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
				//1 - cpf
				//2 - telefone
				//TODO: Colocar essa parte como exce��o caso o usu�rio n�o seja registrado
				
				JOptionPane.showMessageDialog(null,"Usuário não registrado","Erro",JOptionPane.ERROR_MESSAGE);

				TelaRegistroCliente telaRegistro = new TelaRegistroCliente(resultado[0],resultado[1],resultado[2]);
				
			}
			//Fecha a janela depois de abrir outra
			setVisible(false);
			dispose();
		}
	}
	
	//Exce��o caso algum campo esteja vazio
	private class CampoNaoPreenchidoException extends Exception{
		public String nomeCampo;
		public CampoNaoPreenchidoException(String campo){
			super("Campo de nome: "+ campo + " não preenchido.");
			nomeCampo= campo;
		}
	}
}
