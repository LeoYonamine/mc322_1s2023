public class Veículo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	public Veículo(String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}
	
	public String getPlaca() {
		return this.placa;
	}
	
	public void setPlaca(String placa) {
		this.placa=placa;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca=marca;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo=modelo;
	}
	
	public int getAnoFabricao() {
		return this.anoFabricacao;
	}
	
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao=anoFabricacao;
	}
	
	public String toString() {
        return "Placa: " + this.placa + ", Marca: " + this.marca + ", Modelo: " + this.modelo + ", Ano Fabricacao: " + this.anoFabricacao;
        }
}
