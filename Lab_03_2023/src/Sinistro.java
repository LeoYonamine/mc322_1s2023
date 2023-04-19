
import java.util.concurrent.ThreadLocalRandom;

public class Sinistro 
{
	private int id;
	private String data;
	private String endereco; 
	private Seguradora seguradora;
	private Veículo veiculo;
	private Cliente cliente;
	
	public Sinistro(int id,String data, String endereco, Seguradora seguradora,Veículo veiculo,Cliente cliente) {
		this.id = ThreadLocalRandom.current().nextInt(0,999999 + 1);
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getdata() {
		return data;
	}
	
	public void setData(String data) {
		this.data=data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public Veículo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veículo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String toString() {
        return "ID: " + this.id + ", Endereço: " + this.endereco + ", Seguradora: " + this.seguradora + ", Veiculo: " + this.veiculo + ", Cliente: " + this.cliente;
        }
}
	
	

