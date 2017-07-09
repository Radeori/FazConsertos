import java.util.Arrays;

public class Orcamento{
	private int horas;
	private float custoHora;
	private Material material[];
	private int validade;
	private boolean aprovado;
	
	public Orcamento(int horas, float custoHora, Material[] material, int validade, boolean aprovado) {
		this.horas = horas;
		this.custoHora = custoHora;
		this.material = material;
		this.validade = validade;
		this.aprovado = aprovado;
	}

	public int getHoras() {
		return horas;
	}

	public float getCustoHora() {
		return custoHora;
	}

	public Material[] getMaterial() {
		return material;
	}

	public int getValidade() {
		return validade;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public void setCustoHora(float custoHora) {
		this.custoHora = custoHora;
	}

	public void setMaterial(Material[] material) {
		this.material = material;
	}

	public void setValidade(int validade) {
		this.validade = validade;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orcamento [horas=");
		builder.append(horas);
		builder.append(", custoHora=");
		builder.append(custoHora);
		builder.append(", material=");
		builder.append(Arrays.toString(material));
		builder.append(", validade=");
		builder.append(validade);
		builder.append(", aprovado=");
		builder.append(aprovado);
		builder.append("]");
		return builder.toString();
	}
}