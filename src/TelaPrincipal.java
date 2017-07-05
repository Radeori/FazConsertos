import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TelaPrincipal extends JFrame { 
	
	JLabel		label[] = new JLabel[1];
	JButton 	botao[] = new JButton[1];
	
	public TelaPrincipal(){
		super ("Menu");
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		//Instancia objeto que controla os eventos
		ControlaEventoTelaPrincipal controlaEvento = new ControlaEventoTelaPrincipal();
		
		//--Botao de Confimação --//
		
		botao[0] = new JButton("Registrar Técnico");
		container.add(botao[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, botao[0], 0 , SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.NORTH, botao[0], 10, SpringLayout.NORTH, container);
		botao[0].addActionListener(controlaEvento);
		

		

		
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
				TelaRegistroTecnico tela = new TelaRegistroTecnico();
			}
		}

	}
}
