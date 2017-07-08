import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.glass.events.KeyEvent;


public class TelaPrincipal extends Tela {


	JMenuBar barraMenu = new JMenuBar();
	JMenu menu[] = new JMenu[1];		
	JMenuItem menuItem[] = new JMenuItem[2];
	
	public TelaPrincipal(){
		super ("Faz Consertos",1,1,2);
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		//Instancia objeto que controla os eventos
		ControlaEvento controlaEvento = new ControlaEvento();
		
		//Instancia a barra e os menus superiores
		container.add(barraMenu);
		
		//Cria o menu de registros
		menu[0] = new JMenu("Registrar");
		barraMenu.add(menu[0]);

			//Cria o bot�o de registro de t�cnico
			menuItem[0] = new JMenuItem("Novo t�cnico");
			menuItem[0].addActionListener(controlaEvento);
			menu[0].add(menuItem[0]);
			
			//Cria o bot�o de registro de cliente
			menuItem[1] = new JMenuItem("Novo cliente");
			menuItem[1].addActionListener(controlaEvento);
			menu[0].add(menuItem[1]);
		
		//--Botão de Registro Técnico --//

		
		//--Solicitar servi�o --//
		botao[0] = new JButton("Solicitar servi�o");
		container.add(botao[0]);
		layout.putConstraint(SpringLayout.EAST, botao[0], -10 , SpringLayout.EAST, container);
		layout.putConstraint(SpringLayout.SOUTH, botao[0], -10, SpringLayout.SOUTH, container);
		botao[0].addActionListener(controlaEvento);

		//--Login tecnico --//
		botao[1] = new JButton("Login (t�cnico)");
		container.add(botao[1]);
		layout.putConstraint(SpringLayout.EAST, botao[1], -10 , SpringLayout.WEST, botao[0]);
		layout.putConstraint(SpringLayout.SOUTH, botao[1], 0, SpringLayout.SOUTH, botao[0]);
		botao[1].addActionListener(controlaEvento);

		//--Login cliente --//
		botao[2] = new JButton("Login (cliente)");
		container.add(botao[2]);
		layout.putConstraint(SpringLayout.EAST, botao[2], -10 , SpringLayout.WEST, botao[1]);
		layout.putConstraint(SpringLayout.SOUTH, botao[2], 0, SpringLayout.SOUTH, botao[1]);
		botao[2].addActionListener(controlaEvento);

		//Configurações de tamanho da janela
		setSize(500,150);
		
		//Posiciona a janela no centro da tela
		setLocationRelativeTo(null);
		
		//Destr�i a tela quando fechada
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//Ativa a visibilidade da janela
		setVisible(true);
	}	
	
	private class ControlaEvento implements ActionListener	{
		public void actionPerformed(ActionEvent evento) {
			
			//Se é o botão de registro de técnico
			if(evento.getSource() == menuItem[0]){
				TelaRegistroTecnico telaNovoTecnico = new TelaRegistroTecnico();
			}
			//Se é o botão de registro de cliente
			else if(evento.getSource() == menuItem[1]){
				TelaRegistroCliente telaRegistro = new TelaRegistroCliente("","","");
			}
			
			//Solicitar servi�o
			else if(evento.getSource() == botao[0]){
				TelaSolicitaServico telaSolicita = new TelaSolicitaServico();
			}
			
			//Login tecnico
			else if(evento.getSource() == botao[1]){
				TelaLoginTecnico telaLogin = new TelaLoginTecnico();
			}
			
			//Login cliente
			else if(evento.getSource() == botao[2]){
				TelaLoginCliente telaLogin = new TelaLoginCliente();
			}
			//Fecha a janela depois de abrir outra
			setVisible(false);
			dispose();			
		}
	}
}
