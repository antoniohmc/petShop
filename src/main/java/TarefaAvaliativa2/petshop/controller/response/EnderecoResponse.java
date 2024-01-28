package tarefaavaliativa2.petshop.controller.response;

import lombok.Builder;
import lombok.Data;
import tarefaavaliativa2.petshop.model.Endereco;

import java.util.List;

@Data
@Builder
public class EnderecoResponse {
    private Integer id;

    private String logradouro;

    private Integer numero;

    private String bairro;

    private String cidade;

    private String estado;

    public static List<EnderecoResponse> of(List<Endereco> endereco) {
        return endereco.stream()
                .map(EnderecoResponse::of)
                .toList();
    }

    public static EnderecoResponse of(Endereco endereco) {
        return EnderecoResponse.builder()
                .id(endereco.getId())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .numero(endereco.getNumero())
                .logradouro(endereco.getLogradouro())
                .estado(endereco.getEstado())
                .build();
    }
}