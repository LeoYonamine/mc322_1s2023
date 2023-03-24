
public class Cliente {
	
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	public Cliente(String nome,String cpf, String endereco, String dataNascimento,int idade) {
		this.nome = nome;
		this.endereco = endereco; 
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
		
	public String getCpf() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco=endereco;
	}
	
	public String getdataNascimento() {
		return dataNascimento;
	}
	
	public void setdataNascimento(String dataNascimento) {
		this.dataNascimento=dataNascimento;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade=idade;
	}
	
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
}
