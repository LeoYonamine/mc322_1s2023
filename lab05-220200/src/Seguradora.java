import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seguradora {
	
	
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco; 
	private List<Cliente> listaClientes;
	private List<Seguro> seguros;
	private ArrayList listaSeguro;
	
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco; 
		this.listaClientes = new ArrayList<>();
		this.listaSeguro = new ArrayList<>();
		seguros = new ArrayList<>();
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj; 
	}
	
	public String getCnpj() {
		return cnpj; 
	}
	
	public String getNome() {
		return nome;
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
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public List<Seguro> getSeguros() {
		return seguros;
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
	
	public double calcularValorMensal(Cliente cliente) {
        double valorMensal = cliente.calcularValor();
        cliente.setValorMensal(valorMensal);
        return valorMensal;
    }

	public Seguro gerarSeguroPF(ClientePF clientePF, int quantidadeVeiculos) {
        int id = seguros.size() + 1;
        Seguradora seguradora;
        SeguroPF seguroPF = new SeguroPF(id,null, null, clientePF);
        seguros.add(seguroPF);
        clientePF.adicionarSeguro(seguroPF);
        return seguroPF;
    }

    public Seguro gerarSeguroPJ(ClientePJ clientePJ, Frota frota) {
        int id = seguros.size() + 1;
        SeguroPJ seguroPJ = new SeguroPJ(id, null,null,clientePJ);
        seguros.add(seguroPJ);
        clientePJ.adicionarSeguro(seguroPJ);
        return seguroPJ;
    }
    
    public void gerarSinistro(Seguro seguro, String descricao) {
        Sinistro sinistro = new Sinistro(0, null, descricao, null, seguro, descricao, null);
    }
    

}
