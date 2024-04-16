package projeto;

import java.util.Scanner;

public final class Login {
	
	private static Login instance;
	private static Menu menu = new Menu();
	private static Usuarios usuarios = Usuarios.getInstance();
	private Usuario usuarioLogado;
	
	Scanner input = new Scanner(System.in);
		
	public void exibeLogin() {
		while(true) {
			menu.menuBoasVindas();
			
			System.out.println("Informe sua matricula: ");
			String matricula = input.nextLine();
			
			System.out.println("Informe sua senha: ");
			String senha = input.nextLine();
			
			boolean retornoLogin = this.realizaLogin(matricula, senha);
			if(retornoLogin) {
				if(this.usuarioLogado.getTipo().equals("Gerente")) {
					menu.exibeMenuGerente();
				}else if(this.usuarioLogado.getTipo().equals("Vendedor")) {
					menu.exibeMenuVendedor();
				}
			}
		}
	}
	
	public boolean realizaLogin(String matricula, String senha) {
		
		Usuario usuario = usuarios.verificarCredenciais(matricula, senha);
		
		if(usuario != null) {
			this.usuarioLogado = usuario;
			System.out.println("Login realizado com sucesso!!!");
			return true;
		}
		System.out.println("Credenciais invalidas");
		return false;
		
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public static Login getInstance() {
        if (instance == null) {
        	instance = new Login();
        }
        return instance;
    }
}
