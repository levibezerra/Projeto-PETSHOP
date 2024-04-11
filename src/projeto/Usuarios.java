package projeto;

import java.util.ArrayList;
import java.util.List;

public final class Usuarios {
	
	private static Usuarios instance;
	private List<Usuario> usuarios;
	
	public Usuarios() {
		this.usuarios = new ArrayList();
	}
	
	public Usuario adicionarUsuarios(String nome, String matricula, String senha, String tipo) {
		Usuario usuario = new Usuario(nome, matricula, senha, tipo);
		usuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
		return usuario; 
	}
	
	public int encontarUsuario(String matricula) {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getMatricula().equals(matricula)) {
				return i;
			}
		}
		return -1; 
	}
	
	public void removerUsuario(String matricula) {
		int indice = this.encontarUsuario(matricula);
		if(indice != -1) {
			usuarios.remove(indice);
			System.out.println("Usuario removido com sucesso!");
		} else {
			System.out.println("Usuario nao encontrado!");
		}
	}
	
	public List<Usuario> getUsuarios() {
		return this.usuarios; 
	}
	
	public static Usuarios getInstance() {
		if(instance == null) {
			instance = new Usuarios();
		}
		return instance; 
	}
}