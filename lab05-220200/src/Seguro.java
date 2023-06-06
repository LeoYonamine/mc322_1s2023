import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Seguro {
	
	private int id;
	private Date dataInicio;
	private Date dataFim;
	private Seguradora seguradora;
	protected ArrayList<Sinistro> listaSinistro;
	protected ArrayList<Condutor> listaCondutor;
	protected double valorMensal;
	private Cliente cliente;
	private ClientePF clientepf;
	private ClientePJ clientepj;
	private static int proximoIdSinistro = 1;
	
	public Seguro (int id, Date dataInicio, Date dataFim, Seguradora seguradora) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.setListaSinistro(new ArrayList<>());
		this.setListaCondutor(new ArrayList<>());
	}
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}

	public Date getdataInicio() {
		return this.dataInicio;
	}
	
	public void setdataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getdataFim() {
		return this.dataFim;
	}
	
	public void setdataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }
    
    public abstract void gerarSinistro(Condutor condutor, String endereco);
	
	public abstract double calcularValor();

	public ArrayList<Sinistro> getListaSinistro() {
		return listaSinistro;
	}

	public void setListaSinistro(ArrayList<Sinistro> listaSinistro) {
		this.listaSinistro = listaSinistro;
	}

	public ArrayList<Condutor> getListaCondutor() {
		return listaCondutor;
	}

	public void setListaCondutor(ArrayList<Condutor> listaCondutor) {
		this.listaCondutor = listaCondutor;
	}

	public Cliente getCliente() {
        return cliente;
    }
	
	public ClientePF getClientePF() {
        return clientepf;
    }
	
	public ClientePJ getClientePJ() {
        return clientepj;
    }
	
	public abstract void autorizarCondutor(Condutor condutor);

	public abstract void desautorizarCondutor(Condutor condutor);

	public static int getProximoIdSinistro() {
        return proximoIdSinistro++;
    }
	
	public void gerarSinistro(String descricao) {
        Sinistro sinistro = new Sinistro(id, dataFim, descricao, null, null, descricao, null);
        listaSinistro.add(sinistro);
    }
	
	 public String toString() {
	        return "Seguro{" +
	                "id=" + getid() +
	                ", valorMensal=" + valorMensal +
	                '}';
	    }
}

