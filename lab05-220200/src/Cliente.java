import java.util.ArrayList;
import java.util.List;

abstract public class Cliente {
	
	
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private double valorMensal;
	private List<Veículo> listaVeiculos;
	private List<Sinistro> listaSinistros;
	
	public Cliente(String nome, String telefone, String endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.valorMensal = 0.0;
		this.listaVeiculos = new ArrayList<>();
        this.setListaSinistros(new ArrayList<>());
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
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
		this.endereco=endereco;
	}
	
	public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }
	
	public List<Veículo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public void setListaVeiculos(List<Veículo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public abstract double calcularValor();

	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	
}
