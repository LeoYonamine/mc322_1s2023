import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeguroPJ extends Seguro {
	
	private Frota Frota;
	private Cliente ClientePJ;
	
	public SeguroPJ(int id, Date dataInicio, Date dataFim, ClientePJ cliente) {
        super(id, dataInicio, dataFim, null);
        this.ClientePJ = cliente;
	}
	
	private static final double VALOR_BASE = 10.0;

	public double calcularValor() {
	    double valorBase = 10.0;
	    int quantidadeFunc = getClientePJ().getQuantidadeFuncionarios();
	    int quantidadeVeiculos = getClientePJ().getListaFrota().size();
	    int anosPosFundacao = getClientePJ().calcularAnosPosFundacao();
	    int quantidadeSinistrosCliente = getClientePJ().getListaSinistros().size();
	    int quantidadeSinistrosCondutor = getListaSinistro().size();

	    double valorCalculado = valorBase * (10 + quantidadeFunc / 10) * (1 + 1 / (quantidadeVeiculos + 2))
	            * (1 + 1 / (anosPosFundacao + 2)) * (2 + quantidadeSinistrosCliente / 10)
	            * (5 + quantidadeSinistrosCondutor / 10);

	    setValorMensal(valorCalculado);
	    return valorCalculado;
	}

	public void gerarSinistro(Condutor condutor, String endereco) {
        Sinistro sinistro = new Sinistro(1, new Date(), endereco, condutor, this, endereco, null);
        getListaSinistro().add(sinistro);
    }

    public void autorizarCondutor(Condutor condutor) {
        getListaCondutor().add(condutor);
    }

    public void desautorizarCondutor(Condutor condutor) {
        getListaCondutor().remove(condutor);
    }

    public String toString() {
        return "SeguroPJ{" +
                "cliente=" + ClientePJ +
                "} " + super.toString();
    }
}
