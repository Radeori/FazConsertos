public class Estado{
	private String nome;

	public Estado(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Estado [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
}