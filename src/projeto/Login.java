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
		
		while(true) {
			
			System.out.println("--------------------\n"
					         + "BEM VINDO AO PETSHOP\n"
					         + "--------------------");
			 
			System.out.println("Informe sua matricula: ");
			String matricula = input.nextLine();
			
			System.out.println("Informe sua senha: ");
			String senha = input.nextLine();
			
			boolean verificaLogin = realizarLogin(matricula, senha);
			
			if(verificaLogin) {
				if(this.usuarioLogado.getTipo().equals("Gerente")) {
					Gerente gerente = (Gerente) this.getUsuarioLogado();
					
					System.out.println("---------------------------------\n"
							         + "ESCOLHA UMA OPCAO PARA O CADASTRO\n"
							         + "---------------------------------"
							         + "1- CADASTRAR UM VENDEDOR\n"
							         + "2- REMOVER UM VENDEDOR\n"
							         + "3-LOGOUT\n"
							         + "---------------------------------");
					
					System.out.println("Informe uma opcao: ");
					int opcao = input.nextInt();
					
					if(opcao == 1) {
						
						System.out.println("Informe o nome para o cadastro: ");
						String nomeCadastro = input.nextLine();
						
						System.out.println("Informe a matricula para o cadastro: ");
						String matriculaCadastro = input.nextLine();
						
						System.out.println("Informe uma senha para o cadastro: ");
						String senhaCadastro = input.nextLine();
						
						gerente.adicionarVendedor(nomeCadastro, matriculaCadastro, senhaCadastro);
						
					} else if(opcao == 2) {
						
						System.out.println("Informe a matricula do vendedor: ");
						String removerVendedor = input.nextLine();
						
						gerente.removerVendedor(matricula);
						
					} else if(opcao == 3) {
						this.setUsuarioLogado(null);
						break;
						
					} else {
						System.out.println("Opcao invalida, informe novamente!");
					}
				}
			} else if(this.usuarioLogado.getTipo().equals("Vendedor")) {
				
				while(true) {
					
					System.out.println("-------------------\n"
							         + "Informe uma opcao\n"
							         + "1- LOGOUT\n"
							         + "-------------------");
					
					System.out.println("Informe uma opcao: ");
					int opcao = input.nextInt();
					
					if(opcao == 1) {
						this.setUsuarioLogado(null);
						break;
					} else {
						System.out.println("Opcao invalida, informe novamente!");
					}
				}
			}
		}
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