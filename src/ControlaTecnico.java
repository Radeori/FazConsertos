import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class ControlaTecnico {

	//Dados de debug
	private ArrayList<Tecnico>	listaTecnico;
	
	ControlaTecnico(){

		listaTecnico = new ArrayList<Tecnico>();
	}
	
	void salvaTecnico(Tecnico tecnico)
	{
			listaTecnico.add(tecnico);
			//DEBUG
			System.out.println("tecnico adicionado, nova lista:");
			for(int i = 0; i < listaTecnico.size(); i++) {   
			    System.out.print(listaTecnico.get(i).toString()+System.lineSeparator());
			}
			JOptionPane.showMessageDialog(null,"T�cnico  "+tecnico.getNome()+" registrado!","T�cnico registrado!",JOptionPane.INFORMATION_MESSAGE);
	}
			

			
	
	
	Tecnico buscaTecnico(int matricula)
	{
		for (int i = 0; i < listaTecnico.size(); i++) {
			if(listaTecnico.get(i).getMatricula() == matricula)
				return listaTecnico.get(i);
		}
		//Retorna null se n�o encontrar nada
		return null;
		
	}
}
