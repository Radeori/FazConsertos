import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TelaListasOrdensServico extends Tela{
	
	JScrollPane scrollLista[] = new JScrollPane[2];
	JList lista[] = new JList[2];
	BotaoVoltar botaoVoltar;
	
	public TelaListasOrdensServico() {
		super("Menu (Técnico)",1,1,1);
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		//Instancia objeto que controla os eventos
		ControlaEventoLoginTecnico controlaEvento = new ControlaEventoLoginTecnico();

		lista[0] = new JList();
		
		scrollLista[0] = new JScrollPane(lista[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollLista[0], 0, SpringLayout.HORIZONTAL_CENTER, container);
		layout.putConstraint(SpringLayout.NORTH, scrollLista[0], 5, SpringLayout.NORTH, container);
		
		container.add(scrollLista[0]);
		
		lista[1] = new JList();
		
		scrollLista[1] = new JScrollPane(lista[1]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollLista[1], 0, SpringLayout.HORIZONTAL_CENTER, scrollLista[0]);
		layout.putConstraint(SpringLayout.NORTH, scrollLista[1], 5, SpringLayout.SOUTH, scrollLista[0]);
		
		container.add(scrollLista[1]);
		
		botaoVoltar = new BotaoVoltar("TelaLoginTecnico");
		container.add(botaoVoltar);
		layout.putConstraint(SpringLayout.WEST, botaoVoltar, 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.SOUTH, botaoVoltar, -5, SpringLayout.SOUTH, container);
		
		//Configurações de tamanho da janela
		setSize(350,350);
		
		//Posiciona a janela no centro da tela
		setLocationRelativeTo(null);
		
		//Ativa a visibilidade da janela
		setVisible(true);
	}

	private class ControlaEventoLoginTecnico implements ActionListener {

		public void actionPerformed(ActionEvent evento) {
			
		}
			
	}
}