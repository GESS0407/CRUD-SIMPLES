import java.util.HashMap;
import java.util.Map;

public class ClienteService {

    private Map<String, Cliente> clientes = new HashMap<>();

    public boolean cadastrarCliente(Cliente cliente) {

        if (clientes.containsKey(cliente.getCpf())) {
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
