import java.util.Date;
import java.util.List;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco; 
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;
	
	public Seguradora(String nome, String telefone, String email, String endereco,List<Sinistro> listaSinistros, List<Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco; 
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone=telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
	
	public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		return this.listaClientes.add(cliente);		
	}
	
	public boolean removerCliente(Cliente cliente) {
		return this.listaClientes.remove(cliente);
	}
	
	public boolean listarClientes(String tipoCliente) {
		
		this.listaClientes.forEach(cliente -> {
			if(cliente instanceof ClientePF && tipoCliente == "PF") {
				System.out.println(cliente.toString());
			}else if(cliente instanceof ClientePF && tipoCliente == "PJ"){
				System.out.println(cliente.toString());
			}else if(tipoCliente != "PJ" && tipoCliente != "PF"){
				System.out.println(cliente.toString());
			}
		});
		return true;
	}
	
	public boolean gerarSinistro() {
		Date data = new Date();
		Sinistro sinistro = new Sinistro(0, data.toString(), this.endereco, this, null, null);
		return listaSinistros.add(sinistro);
	}
	
	public boolean visualizarSinistro(Cliente cliente) {
		System.out.println(cliente.toString());
		return true;
	}
	
	public boolean listarSinistros(String tipoSinistro) {
		this.listaSinistros.forEach(sinistro -> 
				System.out.println(sinistro.toString()));
		return true;
	}	
	
}
