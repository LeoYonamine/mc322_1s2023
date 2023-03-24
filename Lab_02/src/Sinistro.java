
import java.util.concurrent.ThreadLocalRandom;

public class Sinistro 
{
	private int id;
	private String data;
	private String endereco; 
	
	public Sinistro(String data, String endereco) {
		this.id = ThreadLocalRandom.current().nextInt(0,999999 + 1);
		this.data = data;
		this.endereco = endereco; 
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getdata() {
		return data;
	}
	
	public void setData(String data) {
		this.data=data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}

