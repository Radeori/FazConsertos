import java.io.*;

public class ControlaTecnico {

	ControlaTecnico(){

	}
	
	void salvaTecnico(Tecnico tecnico)
	{
		try{
			FileWriter fstream = new FileWriter("listaTecnicos.txt");
			
			System.out.println(tecnico.toString());
			fstream.write(tecnico.toString());
			fstream.flush();
		}
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}
