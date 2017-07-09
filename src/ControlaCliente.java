import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class ControlaCliente {

	//Dados de debug
	private ArrayList<Cliente>	listaCliente;
	
	ControlaCliente(){

		listaCliente = new ArrayList<Cliente>();
	}
	
	void salvaCliente(Cliente cliente)
	{
			listaCliente.add(cliente);
			//DEBUG
			System.out.println("cliente adicionado, nova lista:");
			for(int i = 0; i < listaCliente.size(); i++) {   
			    System.out.print(listaCliente.get(i).toString()+System.lineSeparator());
			}
			JOptionPane.showMessageDialog(null,"Cliente  "+cliente.getNome()+" registrado!","Cliente registrado!",JOptionPane.INFORMATION_MESSAGE);
	}
			
	
	Cliente buscaCliente(int cpf)
	{
		for (int i = 0; i < listaCliente.size(); i++) {
			if(listaCliente.get(i).getCpf() == cpf)
				return listaCliente.get(i);
		}
		//Retorna null se não encontrar nada
		return null;
		
	}
}
