package tarefaavaliativa2.petshop.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tarefaavaliativa2.petshop.model.Cliente;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryService {

    private final ClienteRepository clienteRepository;

    public Collection<Cliente> buscarClientes() {

        return clienteRepository.findAll();
    }

    public Cliente criarNovo(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    public void deletarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }


    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado, digite um id válido"));
    }

    public Cliente atualizar(Cliente cliente) {
        return criarNovo(cliente);
    }

}
