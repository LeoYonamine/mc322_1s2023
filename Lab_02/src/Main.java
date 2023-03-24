
public class Main {

	public static void main(String[] args) {
		
		Seguradora seg1 = new Seguradora("Porto Seguro","(19)3234-2940","contato@portoseguro.br","Av.Francisco Glicério,1424");
		Sinistro sin1 = new Sinistro("10 de Dezembro de 2022","Rua marquinhos,234");
		Cliente cliente1 = new Cliente("Jose da Silva","450.410.028-27","Rua Luverci Pereira de Souza, Campinas","17/02/1996",27);
		Veiculo veiculo1 = new Veiculo("LYJ2321","Chevrolet","Celta");
		
		System.out.println("Dados do acidente: \n");
		System.out.println(seg1.getNome()+"\n Telefone:"+seg1.getTelefone()+"\n E-mail:"+seg1.getEmail()+"\n Endereço:"+seg1.getEndereco());
		System.out.println("\nSinistro:"+"\n ID:"+sin1.getId()+"\n Data:"+sin1.getdata()+"\n Endereco:"+sin1.getEndereco());
		System.out.println("\nCliente:"+cliente1.getNome()+"\n CPF:"+cliente1.getCpf()+"\n Data Nascimento:"+cliente1.getdataNascimento()+"\n Idade:"+cliente1.getIdade()+"\n Endereço:"+cliente1.getEndereco());
		System.out.println("\nVeiculo:"+"\n Placa:"+veiculo1.getPlaca()+"\n Marca:"+veiculo1.getMarca()+"\n Modelo:"+veiculo1.getModelo());
		
		
		//Cliente xxx = new Cliente("","450.410.028-27", null, null, 0);
		//System.out.println(xxx.validarCPF("450.410.028-27"));
	}

}
