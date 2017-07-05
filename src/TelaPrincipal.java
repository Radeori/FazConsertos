import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TelaPrincipal extends JFrame { 
	
	JLabel		label[] = new JLabel[1];
	JButton 	botao[] = new JButton[2];
	
	public TelaPrincipal(){
		super ("Menu");
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		//Instancia objeto que controla os eventos
		ControlaEventoTelaPrincipal controlaEvento = new ControlaEventoTelaPrincipal();
		
		//--Registro de tecnico --//
		
		botao[0] = new JButton("Registrar técnico");
		container.add(botao[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[0], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.NORTH, botao[0], 10, SpringLayout.NORTH, container);
		botao[0].addActionListener(controlaEvento);
		
		//--Registro de tecnico --//
		
		botao[1] = new JButton("Solicitar servço");
		container.add(botao[1]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[1], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.NORTH, botao[1], 10, SpringLayout.SOUTH, botao[0]);
		botao[1].addActionListener(controlaEvento);
		

		
		
		//centraliza a janela
		setLocationRelativeTo(null);
		
		//Configurações de tamanho da janela
		setSize(300,150);
		
		//Ativa a visibilidade da janela
		setVisible(true);
	}

	

	
	
	private class ControlaEventoTelaPrincipal implements ActionListener 
	{
		public void actionPerformed(ActionEvent evento) {
			//Se é o botão de registro de tecnico
			if(evento.getSource() == botao[0]){
				TelaRegistroTecnico telaTecnico = new TelaRegistroTecnico();
			}
			else if(evento.getSource() == botao[1]){
				TelaSolicitaServico telaSolicita = new TelaSolicitaServico();
			}
			//Fecha a janela depois de abrir outra
			setVisible(false);
			dispose();
			
		}

	}
}
