package projeto;

public class Vendedor extends Usuario{
	
	public static Vendas vendas = Vendas.getInstance();
	
	public Vendedor(String nome, String matricula, String senha) {
		super(nome, matricula, senha, "Vendedor");
	}
	
	public void realizarVendas(double valor, String formaDePagamento, String matricula) {
		vendas.realizarVendas(valor, formaDePagamento, matricula);
	}
	
	public void gerarRelatorios() {
		vendas.relatorioDeVendasIndividual(getMatricula());
		
	}
}
