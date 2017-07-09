
public class Cliente {
	
	private String 	nome;
	private int 	cpf;
	private int 	rg;
	private int 	telefone;
	private String 	endereco;
	private String 	nascimento;
	
	Cliente(String nome,int cpf, int rg, int telefone,String endereco,String nascimento){
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setNascimento(nascimento);
	}
	
	
	
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + telefone
				+ ", endereco=" + endereco + ", nascimento=" + nascimento + "]";
	}


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


}
