import java.util.ArrayList;
import java.util.List;

public class Frota {

	private String code;
	private ArrayList<Veículo> listaVeiculos;
	
	public Frota (String code) {
		this.code = code;
		this.listaVeiculos = new ArrayList<>();
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public boolean cadastrarVeiculos(Veículo veiculo) {
		return this.listaVeiculos.add(veiculo);		
	}
	
	public boolean removerVeiculos(Veículo veiculo) {
		return this.listaVeiculos.remove(veiculo);
	}
	
	public ArrayList<Veículo> getlistaVeiculos() {
		return this.listaVeiculos;
	}
	
}
