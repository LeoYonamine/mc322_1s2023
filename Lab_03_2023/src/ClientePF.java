import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
	private String CPF;
	private String genero;
	private Date dataLicenca;
	private String educacao;
	private Date dataNascimento;
	private String classeEconomica;
	
	public ClientePF (String nome, String endereco, List<Veículo> listaVeiculos, String CPF, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica) {
		super (nome,endereco,listaVeiculos);
		this.CPF = CPF;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
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
		
	public String toString() {
        return "Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", Lista de Veiculos: " + this.getListaVeiculos() + ", CPF: " + this.CPF + ", Genero: " + this.genero + 
        		", Data Licenca: " + this.dataLicenca + ", Educacao: " + this.educacao + ", Data Nascimento: " + this.dataNascimento + ", Classe Economica: " + this.classeEconomica;
    }

}
