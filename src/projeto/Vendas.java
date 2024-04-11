package projeto;

import java.util.ArrayList;
import java.util.List;

public final class Vendas {
	
	private static Vendas instance;
	
	List<Venda> vendas;
	
	public Vendas() {
		this.vendas = new ArrayList<>();
	}
	
	public void realizarVendas(double valor, String formaDePagamento, String matricula) {
		Venda venda = new Venda(valor, formaDePagamento, matricula);
		vendas.add(venda);
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