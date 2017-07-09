import java.time.LocalDate;
import java.time.LocalTime;

public class OrdemServico{
	private int id;
	private String especialidade;
	private String descricao;
	private Orcamento orcamento;
	private Estado estado;
	private String anotacoes;
	private LocalDate dataConclusao;
	private LocalTime horaConclusao;
	private DadosPagamento pagamento;
	
	public OrdemServico(int id, String especialidade, String descricao, Orcamento orcamento, Estado estado,
			String anotacoes, LocalDate dataConclusao, LocalTime horaConclusao, DadosPagamento pagamento) {
		this.id = id;
		this.especialidade = especialidade;
		this.descricao = descricao;
		this.orcamento = orcamento;
		this.estado = estado;
		this.anotacoes = anotacoes;
		this.dataConclusao = dataConclusao;
		this.horaConclusao = horaConclusao;
		this.pagamento = pagamento;
	}

	public int getId() {
		return id;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Orcamento getOrcamento() {
		return orcamento;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public String getAnotacoes() {
		return anotacoes;
	}
	
	public LocalDate getDataConclusao() {
		return dataConclusao;
	}
	
	public LocalTime getHoraConclusao() {
		return horaConclusao;
	}
	
	public DadosPagamento getPagamento() {
		return pagamento;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}
	
	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	
	public void setHoraConclusao(LocalTime horaConclusao) {
		this.horaConclusao = horaConclusao;
	}
	
	public void setPagamento(DadosPagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrdemServico [id=");
		builder.append(id);
		builder.append(", especialidade=");
		builder.append(especialidade);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", orcamento=");
		builder.append(orcamento);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", anotacoes=");
		builder.append(anotacoes);
		builder.append(", dataConclusao=");
		builder.append(dataConclusao);
		builder.append(", horaConclusao=");
		builder.append(horaConclusao);
		builder.append(", pagamento=");
		builder.append(pagamento);
		builder.append("]");
		return builder.toString();
	}
}