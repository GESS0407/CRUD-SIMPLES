import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClienteService service = new ClienteService();

        int opcao;

        do {
            System.out.println("\n======= MENU =======");
            System.out.println("1 - Cadastrar CLiente");
            System.out.println("2 - Buscar Cliente");
            System.out.println("3 - Listar Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("0 - Sair ");
            System.out.println("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Email: ");
                    String email = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, email);

                    if (service.cadastrarCliente(cliente)) {
                        System.out.println("Cliente cadastrado com sucesso!");
                    } else {
                        System.out.println("CPF já cadastrado!");
                    }
                    break;

                case 2:
                    System.out.println("Digite o CPF para buscar: ");
                    String cpfBusca = scanner.nextLine();

                    Cliente encontrado = service.buscarCliente(cpfBusca);

                    if (encontrado != null) {
                        System.out.println("Cliente encontrado; ");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 3:
                    service.listarClientes();
                    break;

                case 4:
                    System.out.println("Digite o CPF para remover: ");
                    String cpfRemover = scanner.nextLine();

                    if (service.removerCliente(cpfRemover)) {
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção invalida!");

            }
        } while (opcao != 0);

        scanner.close();
    }
}