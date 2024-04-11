package projeto;

public class Venda {
	
	private double valor;
	private String formaDePagamento;
	private String matricula;
	
	public Venda(double valor, String formaDePagamento, String matricula) {
		this.valor = valor;
		this.formaDePagamento = formaDePagamento;
		this.matricula = matricula;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}