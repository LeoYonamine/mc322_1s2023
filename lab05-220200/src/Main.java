import java.util.List;
import java.util.Scanner;

public class Main {
    private static Seguradora seguradora;
    private static Scanner scanner;

    public static void main(String[] args) {
        seguradora = new Seguradora(null, null, null, null, null);
        scanner = new Scanner(System.in);

        exibirMenu();
    }

    private static void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n----- Menu de Operações -----");
            System.out.println("1. Cadastrar Cliente PF");
            System.out.println("2. Cadastrar Cliente PJ");
            System.out.println("3. Cadastrar Veículo");
            System.out.println("4. Gerar Seguro PF");
            System.out.println("5. Gerar Seguro PJ");
            System.out.println("6. Gerar Sinistro");
            System.out.println("7. Exibir Detalhes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarClientePF();
                    break;
                case 2:
                    cadastrarClientePJ();
                    break;
                case 3:
                    cadastrarVeiculo();
                    break;
                case 4:
                    gerarSeguroPF();
                    break;
                case 5:
                    gerarSeguroPJ();
                    break;
                case 6:
                    gerarSinistro();
                    break;
                case 7:
                    exibirDetalhes();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        }
    }

    private static void cadastrarClientePF() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String CPF = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        ClientePF clientePF = new ClientePF(nome, null, null, CPF, null,null, null, null, null, idade, idade);
        System.out.println("Cliente PF cadastrado: " + clientePF.toString());
    }

    private static void cadastrarClientePJ() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CNPJ: ");
        String CNPJ = scanner.nextLine();
        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();
        System.out.print("Quantidade de Funcionario: ");
        int quantidadeFunc = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        ClientePJ clientePJ = new ClientePJ(nome,endereco,null,CNPJ, null,quantidadeFunc);
        System.out.println("Cliente PJ cadastrado: " + clientePJ.toString());
    }

    private static void cadastrarVeiculo() {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Veículo veiculo = new Veículo(marca, modelo, null, ano);
        Frota frota = new Frota(null);
		frota.cadastrarVeiculos(veiculo);
        System.out.println("Veículo cadastrado: " + veiculo.toString());
    }

    private static void gerarSeguroPF() {
        System.out.print("Documento do Cliente PF: ");
        String documento = scanner.nextLine();
        ClientePF clientePF = buscarClientePF(documento);

        if (clientePF != null) {
            System.out.print("Quantidade de Veículos: ");
            int quantidadeVeiculos = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            SeguroPF seguroPF = (SeguroPF) seguradora.gerarSeguroPF(clientePF, quantidadeVeiculos);
            System.out.println("Seguro PF gerado: " + seguroPF.toString());
        } else {
            System.out.println("Cliente PF não encontrado.");
        }
    }

    private static void gerarSeguroPJ() {
        System.out.print("Documento do Cliente PJ: ");
        String CNPJ = scanner.nextLine();
        ClientePJ clientePJ = buscarClientePJ(CNPJ);

        if (clientePJ != null) {
            System.out.print("Quantidade de Veículos na Frota: ");
            int quantidadeVeiculos = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            Frota frota = new Frota(null);
            for (int i = 0; i < quantidadeVeiculos; i++) {
                System.out.println("Veículo #" + (i + 1));
                cadastrarVeiculo();
            }

            SeguroPJ seguroPJ = (SeguroPJ) seguradora.gerarSeguroPJ(clientePJ, frota);
            System.out.println("Seguro PJ gerado: " + seguroPJ.toString());
        } else {
            System.out.println("Cliente PJ não encontrado.");
        }
    }

    private static void gerarSinistro() {
        System.out.print("Número do Seguro: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Seguro seguro = buscarSeguro(id);

        if (seguro != null) {
            seguradora.gerarSinistro(seguro, null);
            System.out.println("Sinistro gerado com sucesso.");
        } else {
            System.out.println("Seguro não encontrado.");
        }
    }

    private static void exibirDetalhes() {
        System.out.println("\n----- Detalhes da Seguradora -----");
        List<Seguro> seguros = seguradora.getSeguros();
        for (Seguro seguro : seguros) {
            System.out.println(seguro.toString());
        }
        System.out.println("----------------------------------");
    }

    private static ClientePF buscarClientePF(String cpf) {
        List<Seguro> seguros = seguradora.getSeguros();
        for (Seguro seguro : seguros) {
            ClientePF cliente = seguro.getClientePF();
            if (cliente instanceof ClientePF && cliente.getCPF().equals(cpf)) {
                return (ClientePF) cliente;
            }
        }
        return null;
    }

    private static ClientePJ buscarClientePJ(String cnpj) {
        List<Seguro> seguros = seguradora.getSeguros();
        for (Seguro seguro : seguros) {
            ClientePJ cliente = seguro.getClientePJ();
            if (cliente instanceof ClientePJ && cliente.getCNPJ().equals(cnpj)) {
                return (ClientePJ) cliente;
            }
        }
        return null;
    }

    private static Seguro buscarSeguro(int id) {
        List<Seguro> seguros = seguradora.getSeguros();
        for (Seguro seguro : seguros) {
            if (seguro.getid() == id) {
                return seguro;
            }
        }
        return null;
    }
}