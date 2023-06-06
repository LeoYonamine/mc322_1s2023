
import java.time.LocalDate;
import java.util.Date;

public class Sinistro 
{
	private int id;
	private Date data;
	private String endereco; 
	private Condutor condutor;
	private Seguro seguro;
	private String descricao;
    private LocalDate dataOcorrencia;
	
	
	public Sinistro(int id, Date data, String endereco, Condutor condutor, Seguro seguro, String descricao, LocalDate dataOcorrencia) {
        this.id = id;
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
        this.descricao = descricao;
        this.dataOcorrencia = dataOcorrencia;     
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getdata() {
		return data;
	}
	
	public void setData(Date data) {
		this.data=data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
        return "ID: " + this.id + ", Endereço: " + this.endereco;
        }
	
	public Condutor getCondutor() {
		return condutor;
	}
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDate getdataOcorrencia() {
		return dataOcorrencia;
	}

	public void setdataOcorrencia(LocalDate dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

}
	
	

