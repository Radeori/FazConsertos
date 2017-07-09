public class Material{
	private String nome;
	private int quantidade;
	private float valorUnitario;
	
	public Material(String nome, int quantidade, float valorUnitario) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Material [nome=");
		builder.append(nome);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", valorUnitario=");
		builder.append(valorUnitario);
		builder.append("]");
		return builder.toString();
	}
}