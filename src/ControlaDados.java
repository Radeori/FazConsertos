
public final class ControlaDados {
	
	private static ControlaDados instanciaUnica;
	ControlaTecnico registraTecnico;
	
	private ControlaDados()
	{
		registraTecnico = new ControlaTecnico();
	}
	
	public static ControlaDados getControlaDados()
	{
		if(instanciaUnica == null)
			instanciaUnica = new ControlaDados();
		return instanciaUnica;
	}
	
	public void registraTecnico(Tecnico tecnico)
	{
		registraTecnico.salvaTecnico(tecnico);
	}
}
