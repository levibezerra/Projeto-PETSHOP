package projeto;

import java.util.Scanner;

public class Menu {
	
	private static Login login = Login.getInstance();
	
	Scanner input = new Scanner(System.in);
	
	public void exibeMenuGerente() {
		
		Gerente usuarioLogado = (Gerente) login.getUsuarioLogado();
		
		while(true) {
			
			this.opcoesDoGerente();
			
			System.out.println("Informe uma opcao: "); 
			int opcao = input.nextInt();
			
			if(opcao == 1) {
				System.out.println("Informe o nome do vendedor: ");
				String nome = input.nextLine();
				
				input.nextLine();
				
				System.out.println("Informe uma matricula para o vendedor: ");
				String matricula = input.nextLine();
				
				System.out.println("Informe uma senha: ");
				String senha = input.nextLine();
				
				usuarioLogado.adicionarVendedor(nome, matricula, senha);
				
			} else if(opcao == 2) {
				input.nextLine();
				
				System.out.println("Informe a matricula: ");
				String matriculaRemover = input.nextLine();
				
				usuarioLogado.removerVendedor(matriculaRemover);
				
			} else if(opcao == 3) {
				System.out.println("-------------------------\n"
						         + "RELATORIO DE VENDAS GERAL\n"
						         + "-------------------------");
				usuarioLogado.gerarRelatorio();
				
			} else if(opcao == 4) {
				input.nextLine();
				
				System.out.println("Informe a matricula para ter acesso as vendas: ");
				String matriculaAcesso = input.nextLine();
				
				System.out.println("------------------------------\n"
						         + "RELATORIO DE VENDAS INDIVIDUAL\n"
						         + "------------------------------");
				usuarioLogado.gerarRelatorioIndividual(matriculaAcesso);
				
			} else if(opcao == 5) {
				login.setUsuarioLogado(null);
				break;
			} else {
				System.out.println("Opcao invalida!");
			}
		}
	}
	
	public void exibeMenuVendedor() {
		
		Vendedor usuarioLogado = (Vendedor) login.getUsuarioLogado();
		String matricula = usuarioLogado.getMatricula();
		
		while(true) {
			
			this.opcoesDoVendedor();
			
			System.out.println("Informe uma opcao: ");
			int opcao = input.nextInt();
			
			if(opcao == 1) {
				System.out.println("Informe o valor da venda: ");
				double valor = input.nextDouble();
				
				input.nextLine();
				
				System.out.println("Informe a forma de pagamento: ");
				String formaDePagamento = input.nextLine();
				
				System.out.println("Informe sua matricula: ");
				String matriculaVenda = input.nextLine();
				
				usuarioLogado.realizarVendas(valor, formaDePagamento, matriculaVenda);
				
			} else if(opcao == 2) {
				System.out.println("------------------------------\n"
						         + "RELATORIO DE VENDAS INDIVIDUAL\n"
						         + "------------------------------");
				usuarioLogado.gerarRelatorio();
				
			} else if(opcao == 3) { 
				login.setUsuarioLogado(null);
				break;
			} else {
				System.out.println("Opcao invalida!");
			}
		}
	}
	
	public void opcoesDoGerente() {
		System.out.println("-----------------------------------------\n"
				         + "ESCOLHA UMA OPCAO\n"
				         + "-----------------------------------------\n"
				         + "1- CADASTRAR UM VENDEDOR\n"
				         + "2- REMOVER UM VENDEDOR\n"
				         + "3- MOSTRAR RELATORIO DE VENDAS GERAL\n"
				         + "4- MOSTRAR RELATORIO DE VENDAS INDIVIDUAL\n"
				         + "5- SAIR\n"
				         + "-----------------------------------------");
	}
	
	public void opcoesDoVendedor() {
		System.out.println("-----------------------------------------\n"
				         + "ESCOLHA UMA OPCAO\n"
				         + "-----------------------------------------\n"
				         + "1- REALIZAR UMA VENDA\n"
				         + "2- MOSTRAR RELATORIO DE VENDAS INDIVIDUAL\n"
				         + "3- SAIR\n"
				         + "-----------------------------------------");
	}
	
	public void menuBoasVindas() {
		System.out.println("--------------------\n"
				         + "BEM VINDO AO PETSHOP\n"
				         + "--------------------");
	}
}