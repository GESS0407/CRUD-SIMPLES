import java.util.HashMap;
import java.util.Map;

public class ClienteService {

    private Map<String, Cliente> clientes = new HashMap<>();

    public boolean cadastrarCliente(Cliente cliente) {

        if (clientes.containsKey(cliente.getCpf())) {
            System.out.println("Erro: CPF já cadastrados.");
            return false;
        }

        if (cliente.getNome().isBlank() ||
                cliente.getCpf().isBlank() ||
                cliente.getEmail().isBlank()) {

            System.out.println("Erro: todos os campos devem ser preenchidos.");
            return false;
        }

        if (!cliente.getCpf().matches("\\d{11}")) {
            System.out.println("Erro: CPF deve conter a quantidade correta de numeros.");
            return false;

        }

        clientes.put(cliente.getCpf(), cliente);
        return true;

    }

    public Cliente buscarCliente(String cpf) {
        return clientes.get(cpf);
    }

    public void listarClientes() {
        for (Cliente cliente : clientes.values()) {
            System.out.println(cliente);
        }
    }

    public boolean removerCliente(String cpf) {
        if (clientes.containsKey(cpf)) {
            clientes.remove(cpf);
            return true;
        }
        return false;
    }

}
