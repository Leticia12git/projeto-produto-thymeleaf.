package br.com.produtos.model;

public class AlterarProduto {

    private Long id;
    private Integer quantidade;
    private Integer preco;


    public AlterarProduto(Long id, Integer quantidade, Integer preco) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public AlterarProduto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }


}
