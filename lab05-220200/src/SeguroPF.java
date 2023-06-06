import java.util.Date;
import java.util.List;

public class SeguroPF extends Seguro {
	
	private Veículo veiculo;
	private ClientePF cliente;
	
	public SeguroPF(int id, Date dataInicio, Date dataFim, ClientePF cliente) {
        super(id, dataInicio, dataFim,null);
        this.cliente = cliente;
        this.valorMensal = calcularValor();
    }

	public Veículo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veículo veiculo) {
		this.veiculo = veiculo;
	}
	
	public int getid() {
		return this.getid();
	}
	
	public void setid(int id) {
		this.setid(id);
	}
	
	private static final double VALOR_BASE = 10.0;

	public double calcularValor() {
        double valorBase = 10.0;
        double fatorIdade = 1.0;

        if (cliente.getIdade() < 30) {
            fatorIdade = 1.25;
        } else if (cliente.getIdade() > 60) {
            fatorIdade = 1.5;
        }

        int quantidadeVeiculos = cliente.getListaVeiculos().size();
        int quantidadeSinistrosCliente = cliente.getListaSeguros().stream()
                .mapToInt(seguro -> seguro.getListaSinistro().size())
                .sum();

        int quantidadeSinistrosCondutor = getListaCondutor().stream()
                .mapToInt(condutor -> condutor.getQuantidadeSinistros())
                .sum();

        double valorCalculado = valorBase * fatorIdade * (1 + 1 / (quantidadeVeiculos + 2))
                * (2 + quantidadeSinistrosCliente / 10) * (5 + quantidadeSinistrosCondutor / 10);

        return valorCalculado;
    }
	
	public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }
	

    public void gerarSinistro(Condutor condutor, String endereco) {
        Sinistro sinistro = new Sinistro(getProximoIdSinistro(), new Date(), endereco, condutor, this, endereco, null);
        listaSinistro.add(sinistro);
    }

    public void autorizarCondutor(Condutor condutor) {
        listaCondutor.add(condutor);
    }

    public void desautorizarCondutor(Condutor condutor) {
        listaCondutor.remove(condutor);
    }
    
    public String toString() {
        return "SeguroPF{" +
                "cliente=" + cliente +
                ", listaCondutores=" + listaCondutor +
                "} " + super.toString();
    }
    
}