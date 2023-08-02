package br.com.produtos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    private Integer preco;

    public Produto(CadastrarProduto cadastrar) {
        this.nome = cadastrar.nome();
        this.quantidade = cadastrar.quantidade();
        this.preco = cadastrar.preco();
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Integer getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }

    public void atualizaDados(AlterarProduto alterar) {
        this.quantidade = alterar.getQuantidade();
        this.preco = alterar.getPreco();
    }
}
