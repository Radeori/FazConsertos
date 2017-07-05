import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TelaPrincipal extends JFrame {
	JLabel		label[] = new JLabel[1];
	JButton 	botao[] = new JButton[3];
	
	public TelaPrincipal(){
		super ("Menu");
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		//Instancia objeto que controla os eventos
		ControlaEventoTelaPrincipal controlaEvento = new ControlaEventoTelaPrincipal();
		
		//--Botão de Registro Técnico --//
		botao[0] = new JButton("Registrar Técnico");
		container.add(botao[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[0], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.SOUTH, botao[0], -10, SpringLayout.SOUTH, container);
		botao[0].addActionListener(controlaEvento);
		
		//--Botão de Login Técnico --//
		botao[1] = new JButton("Login(Técnico)");
		container.add(botao[1]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[1], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.SOUTH, botao[1], -5, SpringLayout.NORTH, botao[0]);
		botao[1].addActionListener(controlaEvento);

		//--Registro de tecnico --//
		
		botao[2] = new JButton("Solicitar serviço");
		container.add(botao[2]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[2], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.SOUTH, botao[2], -50, SpringLayout.NORTH, botao[1]);
		botao[2].addActionListener(controlaEvento);

		//Configurações de tamanho da janela
		setSize(300,150);
		
		//Posiciona a janela no centro da tela
		setLocationRelativeTo(null);
		
		//Ativa a visibilidade da janela
		setVisible(true);
	}	
	
	private class ControlaEventoTelaPrincipal implements ActionListener	{
		public void actionPerformed(ActionEvent evento) {
			//Variáveis do evento
			JButton botaoFonte = (JButton) evento.getSource();
			
			//Se é o botão de registro de técnico
			if(botaoFonte == botao[0]){
				TelaRegistroTecnico telaNovoTecnico = new TelaRegistroTecnico();
			}
			
			//Se é o botão de login de técnico
			else if(botaoFonte == botao[1]){
				TelaLoginTecnico telaLogin = new TelaLoginTecnico();
			}
			
			else if(evento.getSource() == botao[2]){
				TelaSolicitaServico telaSolicita = new TelaSolicitaServico();
			}
			//Fecha a janela depois de abrir outra
			setVisible(false);
			dispose();			
		}
	}
}
