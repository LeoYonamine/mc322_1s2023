import java.util.Date;
import java.util.List;

public class Condutor {
	
	private String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private Date dataNasc;
	private List<Sinistro> listaSinistro;
	private int idade;
    private int quantidadeSinistros;
    private Cliente cliente;
    private int id;
	
	public Condutor (int id,String cpf,int idade,int quantidadeSinistros, String nome, List<Sinistro> listaSinistro, String telefone, String endereco, String email, Date dataNasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNasc = dataNasc;
		this.listaSinistro = listaSinistro;
		this.idade = idade;
        this.quantidadeSinistros = quantidadeSinistros;
        this.cliente = null;
        this.id = id;
	}

	public String getcpf() {
		return this.cpf;
	}
	
	public void setcpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void getEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void getEmail(String email) {
		this.email = email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void getDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getQuantidadeSinistros() {
        return quantidadeSinistros;
    }

    public void setQuantidadeSinistros(int quantidadeSinistros) {
        this.quantidadeSinistros = quantidadeSinistros;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
	
	public boolean adicionarSinistro(Sinistro sinistro) {
		return this.listaSinistro.add(sinistro);		
	}
	
	public String toString() {
        return "Condutor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
	
}

