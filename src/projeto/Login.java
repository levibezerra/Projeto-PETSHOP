package projeto;

import java.util.Scanner;

public final class Login {
	
	Scanner input = new Scanner(System.in);
	
	private static Login instance;
	private Usuario usuarioLogado;
	public Usuarios usuarios = Usuarios.getInstance();
	
	public static Login getInstance() {
		if(instance == null) {
			instance = new Login();
		}
		return instance;
	}
	
	public void exibeLogin() {
		System.out.println("--------------------\n"
				         + "BEM VINDO AO PETSHOP\n"
				         + "--------------------");
		
		System.out.println("Informe sua matricula: ");
		String matricula = input.nextLine();
		
		System.out.println("Informe sua senha: ");
		String senha = input.nextLine();
	}
	
	public boolean realizarLogin(String matricula, String senha) {
		Usuario usuario = usuarios.verificarCredenciais(matricula, senha);
		if(usuario != null) {
			this.usuarioLogado = usuario;
			System.out.println("Login realizado com sucesso!");
			return true;
		}
		System.out.println("Credenciais invalidas!");
		return false; 
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}