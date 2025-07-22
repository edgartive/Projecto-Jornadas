package model;

public class Produto{
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade_em_stock;

    public Produto(int id, String nome, String descricao, double preco, int quantidade_em_stock) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade_em_stock = quantidade_em_stock;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidade_em_stock() {
        return quantidade_em_stock;
    }
    public void setQuantidade_em_stock(int quantidade_em_stock) {
        this.quantidade_em_stock = quantidade_em_stock;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
                + ", quantidade_em_stock=" + quantidade_em_stock + "]";
    }
    
}