package projeto;

public class Gerente extends Usuario{
	
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
}
