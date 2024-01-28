package TarefaAvaliativa2.petshop.service;

import TarefaAvaliativa2.petshop.model.Produto;
import TarefaAvaliativa2.petshop.repository.ProdutoRepositoryService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepositoryService produtoRepository;

    public Produto criarNovoProduto(Produto produto)     {
        return produtoRepository.criarNovo(produto);
    }

    public Produto editarProduto(Integer id, Produto produto) {
        Produto existente = produtoRepository.buscarPorId(id);

        existente.setNome(produto.getNome());
        existente.setValor(produto.getValor());
        existente.setDescricao(produto.getDescricao());

        return produtoRepository.atualizar(produto);
    }

    public Collection<Produto> listarProdutos() {
        return produtoRepository.buscarProdutos();
    }

    public void deletarProduto(Integer id) {
        produtoRepository.deletarProduto(id);

    }

}