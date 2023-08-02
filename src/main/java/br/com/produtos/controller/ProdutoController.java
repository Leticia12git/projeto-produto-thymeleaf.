package br.com.produtos.controller;

import br.com.produtos.model.AlterarProduto;
import br.com.produtos.model.CadastrarProduto;
import br.com.produtos.model.Produto;
import br.com.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Classe responsavel pelos endpoints do projeto
 */

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * endpoint para carregar a pagina do formulario
     *
     * @param id
     * @param model
     * @return String
     */

    @GetMapping("/formulario")
    public String carregarPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var produto = produtoRepository.getReferenceById(id);
            model.addAttribute("produto", produto);
        }
        return "produtos/formulario";
    }

    /**
     * endpoint para acrregar a listagem da pagina
     *
     * @param cadastrar
     * @return String
     */

    @GetMapping
    public String carregarPaginaListagem(CadastrarProduto cadastrar) {
        return "produtos/listagem";
    }

    /**
     * endpoint para cadastrar um produto
     *
     * @param cadastrar
     * @return String
     */

    @PostMapping
    @Transactional
    public String cadastrarProduto(CadastrarProduto cadastrar) {
        var produto = new Produto(cadastrar);
        produtoRepository.save(produto);
        return "redirect/produtos";
    }

    /**
     * endpoint para atualizar os dados do produto
     *
     * @param alterar
     * @return String
     */

    @PutMapping
    @Transactional
    public String alterarProduto(AlterarProduto alterar) {
        var produto = produtoRepository.getReferenceById(alterar.getId());
        produto.atualizaDados(alterar);
        return "redirect:/produtos";
    }

    /**
     * endpoint para deletar um produto
     *
     * @param id
     * @return String
     */
    @DeleteMapping
    @Transactional
    public String removeProduto(Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/produtos";
    }
}
