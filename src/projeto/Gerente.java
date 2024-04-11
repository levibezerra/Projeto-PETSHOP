package projeto;

public class Gerente extends Usuario{
	
	public static Vendas vendas = Vendas.getInstance();
	
	Usuarios usuario;
	
	public Gerente(String nome, String matricula, String senha) {
		super(nome, matricula, senha, "Gerente");
	}
	
	public void adicionarVendedor(String nome, String matricula, String senha) {
		usuario.adicionarUsuarios(nome, matricula, senha, "Vendedor");
	}
	
	public void removerVendedor(String matricula) {
		usuario.removerUsuario(matricula);
	}
	
	public void gerarRelatorio() {
		vendas.relatorioDeVendasGeral();
	}
	
	public void gerarRelatorioIndividual() {
		vendas.relatorioDeVendasIndividual(getMatricula());
	}
}
