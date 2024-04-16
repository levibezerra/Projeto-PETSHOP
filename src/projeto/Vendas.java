package projeto;

import java.util.ArrayList;
import java.util.List;

public final class Vendas {
	
	private static Vendas instance;
	 
	List<Venda> vendas;
	
	public Vendas() {
		this.vendas = new ArrayList<>();
		realizarVendas(230.0, "Credito", "man123");
	}
	
	public void realizarVendas(double valor, String formaDePagamento, String matricula) {
		Venda venda = new Venda(valor, formaDePagamento, matricula);
		vendas.add(venda);
	}
	
	public void gerarRelatorio() {
		System.out.println("  N  |   MATRICULA  | VALOR  | FORMA DE PAGAMENTO");
		for(int i = 0; i < this.vendas.size(); i++) {
			Venda venda = vendas.get(i);
			System.out.println("  " + (i + 1) + "-" + "     " +  venda.getMatricula() + "            " + venda.getValor() + "      " + venda.getFormaDePagamento());
		}
	}
	
	public void relatorioDeVendasIndividual(String matricula) {
		System.out.println("  N  |   MATRICULA   |  VALOR  | FORMA DE PAGAMENTO");
		for(int i = 0; i < this.vendas.size(); i++) {
			Venda venda = vendas.get(i);
			if(vendas.get(i).getMatricula().equals(matricula)) {
				System.out.println("  " + (i + 1) + "-" + "     " +  venda.getMatricula() + "            " + venda.getValor() + "      " + venda.getFormaDePagamento());
			}
		}
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public static Vendas getInstance() {
		if(instance == null) {
			instance = new Vendas();
		}
		return instance;
	}
}