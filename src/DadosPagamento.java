public class DadosPagamento{
	private int numeroRecibo;
	private String formaPagamento;
	private String instituicao;
	
	public DadosPagamento(int numeroRecibo, String formaPagamento, String instituicao) {
		this.numeroRecibo = numeroRecibo;
		this.formaPagamento = formaPagamento;
		this.instituicao = instituicao;
	}

	public int getNumeroRecibo() {
		return numeroRecibo;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setNumeroRecibo(int numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DadosPagamento [numeroRecibo=");
		builder.append(numeroRecibo);
		builder.append(", formaPagamento=");
		builder.append(formaPagamento);
		builder.append(", instituicao=");
		builder.append(instituicao);
		builder.append("]");
		return builder.toString();
	}
}