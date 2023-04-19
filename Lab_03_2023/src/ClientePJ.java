import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
	private String CNPJ;
	private Date dataFundacao;
	
	public ClientePJ (String nome, String endereco, List<Veículo> listaVeiculos, String CNPJ, Date dataFundacao) {
		super (nome,endereco,listaVeiculos);
		this.CNPJ = CNPJ;
		this.dataFundacao = dataFundacao;
	}

	public String getCNPJ() {
		return this.CNPJ;
	}
	
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	public Date getDataFundacao() {
		return this.dataFundacao;
	}
	
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao=dataFundacao;
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
		
	public String toString() {
        return "Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", Lista de Veiculos: " + this.getListaVeiculos() + ", CNPJ: " + this.CNPJ + ", Data Fundação: " + this.dataFundacao;
    }

}

