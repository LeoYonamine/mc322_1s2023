import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
	
	private String CNPJ;
	private LocalDate dataFundacao;
	private ArrayList<Frota> listaFrota;
	private int quantidadeFunc;
	private List<Seguro> seguros;
	
	public ClientePJ (String nome, String endereco, List<Frota> listaFrota, String CNPJ, LocalDate dataFundacao, int quantidadeFunc) {
		super (nome,endereco,null,null);
		this.CNPJ = CNPJ;
		this.dataFundacao = dataFundacao;
		this.listaFrota = new ArrayList<>();
		this.quantidadeFunc = quantidadeFunc;
		this.seguros = new ArrayList<>();
	}

	public String getCNPJ() {
		return this.CNPJ;
	}
	
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	public LocalDate getDataFundacao() {
		return this.dataFundacao;
	}
	
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao=dataFundacao;
	}
	
	 public int getQuantidadeFunc() {
	        return quantidadeFunc;
	    }

	    public void setQuantidadeFunc(int quantidadeFunc) {
	        this.quantidadeFunc = quantidadeFunc;
	    }
	
	// Metodo para validar CNPJ: 
	
	public static boolean validarCNPJ(String CNPJ) {
	    // Remove caracteres não numéricos
	    CNPJ = CNPJ.replaceAll("[^\\d]", "");

	    // Verifica se o CNPJ tem 14 caracteres após a remoção dos não numéricos
	    if (CNPJ.length() != 14) {
	        return false;
	    }

	    // Calcula o primeiro dígito verificador
	    int soma = 0;
	    int peso = 2;
	    for (int i = 11; i >= 0; i--) {
	        int digito = CNPJ.charAt(i) - '0';
	        soma += digito * peso;
	        peso = peso == 9 ? 2 : peso + 1;
	    }
	    int resto = soma % 11;
	    int dv1 = resto < 2 ? 0 : 11 - resto;

	    // Calcula o segundo dígito verificador
	    soma = 0;
	    peso = 2;
	    for (int i = 12; i >= 0; i--) {
	        int digito = CNPJ.charAt(i) - '0';
	        soma += digito * peso;
	        peso = peso == 9 ? 2 : peso + 1;
	    }
	    soma += dv1 * peso;
	    resto = soma % 11;
	    int dv2 = resto < 2 ? 0 : 11 - resto;

	    // Verifica se os dígitos verificadores calculados são iguais aos do CNPJ informado
	    return CNPJ.charAt(12) - '0' == dv1 && CNPJ.charAt(13) - '0' == dv2;
	}

	public List<Frota> getListaFrota() {
		return listaFrota;
	}

	public void setListaFrota(List<Frota> listaFrota) {
		this.listaFrota = (ArrayList<Frota>) listaFrota;
	}
	
	public boolean cadastrarFrota(Frota veiculo) {
		return this.listaFrota.add(veiculo);		
	}
	
	public boolean removerFrota(Frota veiculo) {
		return this.listaFrota.remove(veiculo);
	}
	
	public void atualizarFrota(Frota frotaAntiga, Frota frotaNova) {
        // Remove a frota antiga da lista de frotas do cliente PJ
        listaFrota.remove(frotaAntiga);

        // Adiciona a frota nova na lista de frotas do cliente PJ
        listaFrota.add(frotaNova);
    }
	
	 public ArrayList<Veículo> getVeiculosPorFrota(Frota frota) {
	        if (listaFrota.contains(frota)) {
	            return frota.getlistaVeiculos();
	        } else {
	            return new ArrayList<>();
	        }
	    }

	 public double calcularValor() {
	        double valorBase = 10.0;
	        int quantidadeFunc = 0;

	        for (Veículo veiculo : getListaVeiculos()) {
	            if (veiculo instanceof VeiculoPJ) {
	                quantidadeFunc += ((VeiculoPJ) veiculo).getQuantidadeFuncionarios();
	            }
	        }

	        int quantidadeVeiculos = getListaVeiculos().size();
	        int anosPosFundacao = calcularAnosPosFundacao();
	        int quantidadeSinistrosCliente = getListaSinistros().size();
	        int quantidadeSinistrosCondutor = getListaSinistros().size();

	        double valorCalculado = valorBase * (10 + quantidadeFunc / 10) * (1 + 1 / (quantidadeVeiculos + 2))
	                * (1 + 1 / (anosPosFundacao + 2)) * (2 + quantidadeSinistrosCliente / 10)
	                * (5 + quantidadeSinistrosCondutor / 10);

	        return valorCalculado;
	    }

	    int calcularAnosPosFundacao() {
	        LocalDate dataAtual = LocalDate.now();
	        Period periodo = Period.between(dataFundacao, dataAtual);
	        return periodo.getYears();
	    }

		public int getQuantidadeFuncionarios() {
			return 0;
		}
		
		public List<Seguro> getSeguros() {
	        return seguros;
	    }

	    public void setListaSeguros(List<Seguro> listaSeguros) {
	        this.seguros = seguros;
	    }
	    
	    public void adicionarSeguro(Seguro seguro) {
	        seguros.add(seguro);
	    }
	    
	    public String toString() {
	        return "ClientePJ{" +
	                "quantidadeFunc=" + quantidadeFunc +
	                ", dataFundacao=" + dataFundacao +
	                ", listaSeguros=" + seguros +
	                "} " + super.toString();
	    }    
}

