import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
	private String CPF;
	private String genero;
	private Date dataLicenca;
	private String educacao;
	private Date dataNascimento;
	private String classeEconomica;
	private List<Veículo> listaVeiculos;
	private int idadeCondutor;
	private int idade;
	private List<Seguro> listaSeguros;
	private List<Seguro> seguros;
	
	public ClientePF (String nome, String endereco, List<Veículo> listaVeiculos, String CPF, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica, int idadeCondutor, int idade) {
		super (nome,endereco, null, null);
		this.CPF = CPF;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
		this.listaVeiculos = listaVeiculos;
		this.idadeCondutor = idadeCondutor;
		this.idade = idade;
		this.listaSeguros = new ArrayList<>();
		this.seguros = new ArrayList<>();
	}

	public String getCPF() {
		return this.CPF;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public void setGenero(String genero) {
		this.genero=genero;
	}
	
	public Date getDataLicenca() {
		return this.dataLicenca;
	}
	
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca=dataLicenca;
	}
	
	public String getEducacao() {
		return this.educacao;
	}
	
	public void setEducacao(String educacao) {
		this.educacao=educacao;
	}
	
	public Date getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento=dataNascimento;
	}
	
	public String getClasseEconomica() {
		return this.classeEconomica;
	}
	
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica=classeEconomica;
	}
	
	public List<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(List<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }
	
	public boolean cadastrarVeiculos(Veículo veiculo) {
		return this.listaVeiculos.add(veiculo);		
	}
	
	public boolean removerVeiculos(Veículo veiculo) {
		return this.listaVeiculos.remove(veiculo);
	}
	
	//Metodo para validar CPF: 
	
	public boolean validarCPF(String cpf) {
		String cpfWithoutLetter = cpf.replaceAll("[^0-9]","");
		if (cpfWithoutLetter.length() != 11) {
			return false;
		}	
		
	    char cpfRepetitive = cpfWithoutLetter.charAt(0);
	    int qtd=1;
	    for (int i = 1; i < cpfWithoutLetter.length(); i++) {
	        if (cpfWithoutLetter.charAt(i) == cpfRepetitive) {
	            qtd++;
	        }  
	    }
	    if(qtd==11)return false;
	    
	    int digito1 = calcularDigito(cpfWithoutLetter.substring(0, 9), 10);
	    int digito2 = calcularDigito(cpfWithoutLetter.substring(0, 9) + digito1, 11);
	    
	    return cpfWithoutLetter.equals(cpfWithoutLetter.substring(0, 9) + digito1 + digito2);
	}
	
	private static int calcularDigito(String str, int peso) {
		 int soma = 0;
		    for (int i = 0; i < str.length(); i++) {
		        soma += Integer.parseInt(str.substring(i, i+1)) * peso--;
		    }
		    int resto = soma % 11;
		    return resto < 2 ? 0 : 11 - resto;
	}
		
	public double calcularValor() {
        double valorBase = 10.0;
        double fatorIdade = 1.0;

        if (idadeCondutor < 30) {
            fatorIdade = 1.25;
        } else if (idadeCondutor > 60) {
            fatorIdade = 1.5;
        }

        int quantidadeVeiculos = getListaVeiculos().size();
        int quantidadeSinistrosCliente = getListaSinistros().size();
        int quantidadeSinistrosCondutor = getListaSinistros().size();

        double valorCalculado = valorBase * fatorIdade * (1 + 1 / (quantidadeVeiculos + 2))
                * (2 + quantidadeSinistrosCliente / 10) * (5 + quantidadeSinistrosCondutor / 10);

        return valorCalculado;
    }
	
	public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void adicionarSeguro(Seguro seguro) {
        seguros.add(seguro);
    }

    public String toString() {
        return "ClientePF{" +
                "idade=" + idade +
                ", listaSeguros=" + listaSeguros +
                "} " + super.toString();
    }
}
