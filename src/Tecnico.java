
public class Tecnico {

	private String 	nome;
	private String 	email;
	private int		telefone;
	private String 	prof;
	private int		matricula;
	
	
	//Construtor
	public Tecnico(String nome, String email,int telefone,String prof){
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
		setProf(prof);
	}
	
	
	//Getters e setters
	String getProf() {
		return prof;
	}
	void setProf(String prof) {
		this.prof = prof;
	}
	int getTelefone() {
		return telefone;
	}
	void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}
	String getNome() {
		return nome;
	}
	void setNome(String nome) {
		this.nome = nome;
	}

	 int getMatricula() {
		return matricula;
	}

	 void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String toString(){
		return getMatricula()+" "+getNome()+" "+getEmail()+" "+getTelefone()+" "+getProf();
	}
	
}
