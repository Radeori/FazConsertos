import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoVoltar extends JButton{
	private String nomeTelaDestino;
	
	private void initGeral() {
		this.addActionListener(new ControlaBotaoVoltar());
	}
	
	public BotaoVoltar(String nomeBotao, String nomeClasseJanela) {
		super("Voltar");
		this.nomeTelaDestino = nomeClasseJanela;
		initGeral();
	}
	
	public BotaoVoltar(String nomeBotao) {
		super("Voltar");
		this.nomeTelaDestino = "TelaPrincipal";
		initGeral();
	}
	
	public String getDestino() {
		return this.nomeTelaDestino;
	}
	
	private class ControlaBotaoVoltar implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			JFrame janelaOrigem;
			Component componenteGenerico = (Component)evento.getSource();
			while(!(componenteGenerico instanceof JFrame)) {
				componenteGenerico = componenteGenerico.getParent();
			}
			componenteGenerico.setVisible(false);
			((JFrame)componenteGenerico).dispose();
			try {
				Class<?> classeJanela = Class.forName(
						((BotaoVoltar)evento.getSource()).getDestino()
				);
				classeJanela.newInstance();
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}