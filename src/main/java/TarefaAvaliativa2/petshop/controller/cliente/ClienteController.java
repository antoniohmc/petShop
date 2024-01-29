package tarefaavaliativa2.petshop.controller.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tarefaavaliativa2.petshop.model.cliente.Cliente;
import tarefaavaliativa2.petshop.service.cliente.ClienteService;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/clientes")
class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(CREATED)
    ClienteResponse criarCliente(@RequestBody ClienteRequest request) {

        Cliente cliente = ClienteMapper.mapToCliente(request);
        Cliente salvo = clienteService.criarCliente(cliente);

        return ClienteMapper.mapToClienteResponse(salvo);
    }

    @GetMapping
    @ResponseStatus(OK)
    Collection<ClienteResponse> listarClientes() {

        return clienteService.listaDeClientes()
                .stream()
                .map(ClienteMapper::mapToClienteResponse)
                .toList();
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    void excluirCliente(@PathVariable Integer id) {

        clienteService.deletarCliente(id);
    }

    @ResponseStatus(OK)
    @PutMapping(path = "/{id}")
    ClienteResponse atualizarCliente(@PathVariable Integer id, @RequestBody ClienteRequest request) {

        Cliente cliente = ClienteMapper.mapToCliente(request);
        Cliente atualizado = clienteService.atualizarCliente(id, cliente);

        return ClienteMapper.mapToClienteResponse(atualizado);
    }

}