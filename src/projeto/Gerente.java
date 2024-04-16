package projeto;

public class Gerente extends Usuario implements IUsuario{
	
	public static Vendas vendas = Vendas.getInstance();
	
	Usuarios usuario;
	
	public Gerente(String nome, String matricula, String senha) {
		super(nome, matricula, senha, "Gerente");
		this.usuario = Usuarios.getInstance();
	}
	
	public void adicionarVendedor(String nome, String matricula, String senha) {
		usuario.adicionarUsuarios(nome, matricula, senha, "Vendedor");
	}
	
	public void removerVendedor(String matricula) {
		usuario.removerUsuario(matricula);
	}
	
	public void gerarRelatorioIndividual(String matricula) {
		vendas.relatorioDeVendasIndividual(matricula); 
	}
}