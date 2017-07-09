import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

public final class ControlaDados {
	
	private static 		ControlaDados instanciaUnica;
	private int 		ultimaMatricula;
	ControlaTecnico 	controlaTecnico;
	

	
	public ControlaDados()
	{
		controlaTecnico = new ControlaTecnico();
		ultimaMatricula = 1;
		
	}
	
	//Singleton
	public static ControlaDados getControlaDados()
	{
		if(instanciaUnica == null)
			instanciaUnica = new ControlaDados();
		return instanciaUnica;
	}
	
	//função que registra o Tecnico
	public void adicionaTecnico(Tecnico tecnico)
	{
		tecnico.setMatricula(ultimaMatricula+1);
		//Se for adicionado, aumenta o numero da matricula
		controlaTecnico.salvaTecnico(tecnico);
		ultimaMatricula++;

	}
	

	void atualizaDados()
	{

	}
	
	
}
