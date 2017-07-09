import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TelaLoginCliente extends Tela{
	

	
	public TelaLoginCliente() {
		super("Login(Cliente)",1,1,1);
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		//Instancia objeto que controla os eventos
		ControlaEvento controlaEvento = new ControlaEvento();
		
		//--Matrícula do técnico--//

		entrada[0] = new JTextField(10);
		container.add(entrada[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, entrada[0], 0, SpringLayout.HORIZONTAL_CENTER, container); //
		layout.putConstraint(SpringLayout.SOUTH, entrada[0], -3, SpringLayout.VERTICAL_CENTER, container); //
		
		label[0] = new JLabel("CPF");
		container.add(label[0]);
		layout.putConstraint(SpringLayout.EAST, label[0], -5, SpringLayout.WEST, entrada[0]); //
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, label[0], 0, SpringLayout.VERTICAL_CENTER, entrada[0]); //
				
		//--Botao de Confimação --//
		
		botao[0] = new JButton("Login");
		container.add(botao[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[0], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.NORTH, botao[0], 3, SpringLayout.VERTICAL_CENTER, container);
		botao[0].addActionListener(controlaEvento);
		
		botaoVoltar = new BotaoVoltar();
		container.add(botaoVoltar);
		layout.putConstraint(SpringLayout.WEST, botaoVoltar, 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.SOUTH, botaoVoltar, -5, SpringLayout.SOUTH, container);
		
		//Configurações de tamanho da janela
		mostraTela(300,150);
	}
	

	private class ControlaEvento implements ActionListener {

		public void actionPerformed(ActionEvent evento) {
			String resultado[] = new String[1];
			if(evento.getSource() == botao[0]) {
				try {
					resultado[0] = pegaTexto(entrada[0]);
				}
				catch (CampoNaoPreenchidoException e) {
					JOptionPane.showMessageDialog(null,"CPF n�o pode estar em branco","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				//DEBUG, caixa de diálogo com os os dados dos textos.
				Cliente cliente = controlaDados.controlaCliente.buscaCliente(Integer.parseInt(resultado[0]));
				if(cliente != null)
					System.out.println("o cliente que voc� busca eh:"+cliente.toString());
				
				
				
				//Fecha a janela depois de abrir outra
				setVisible(false);
				dispose();
				
				//Volta pra tela principal
				TelaPrincipal tela = new TelaPrincipal();
			}
		}
	}
}