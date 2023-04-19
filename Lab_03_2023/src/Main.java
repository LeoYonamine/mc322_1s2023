import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Date data = new Date(2022,10,9);
		
		
		System.out.println("Digite os dados do cliente 1 começando pelo nome");
		String nomeCliente1 = scan.nextLine();
		Veículo veiculo1 = new Veículo("XDF1251","Chevrolet","Corsa",2008);
		Veículo veiculo2 = new Veículo("AFF1512","Chevrolet","Celta",2010);
		
		Sinistro sinistro1 = new Sinistro(1223322,null,null,null,null,null);
		
		ArrayList<Veículo> listaVeiculos = new ArrayList<Veículo>();
		listaVeiculos.add(veiculo1);
		listaVeiculos.add(veiculo2);
		listaVeiculos.remove(0);
		Cliente cliente1 = new ClientePJ("Leo", "Rua 0", listaVeiculos, "2333443332", data);
		ClientePF cliente2 = new ClientePF("Yago", "Rua 1", listaVeiculos,"45463903812","masculino",data,null,null,null);
		
		Seguradora seguradora = new Seguradora("Seguradora LEOS", "151251251","yago@oteo.com" ,"Rua marquinhos", new ArrayList<Sinistro>(), new ArrayList<Cliente>());
		seguradora.cadastrarCliente(cliente2);
		seguradora.cadastrarCliente(cliente1);
		seguradora.removerCliente(cliente2);
		System.out.println(seguradora.getListaClientes().get(0));
		
		System.out.println(cliente1.toString());
		System.out.println(cliente2.toString());
		System.out.println(veiculo1.toString());
		System.out.println(sinistro1.toString());
		System.out.println(seguradora.visualizarSinistro(cliente1));
		System.out.println(seguradora.listarSinistros(null));
		}
	}