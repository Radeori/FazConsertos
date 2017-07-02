
public class Cliente {
	
	private String 	nome;
	private String 	email;
	private int 	cpf;
	private int 	rg;
	private int 	telefone;
	private String 	endereco;
	private String 	nascimento;
	
	
	//Get e Setters
	String getNome() {
		return nome;
	}
	void setNome(String nome) {
		this.nome = nome;
	}
	int getCpf() {
		return cpf;
	}
	void setCpf(int cpf) {
		this.cpf = cpf;
	}
	int getTelefone() {
		return telefone;
	}
	void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	String getNascimento() {
		return nascimento;
	}
	void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	String getEndereco() {
		return endereco;
	}
	void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	int getRg() {
		return rg;
	}
	void setRg(int rg) {
		this.rg = rg;
	}
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}

}
