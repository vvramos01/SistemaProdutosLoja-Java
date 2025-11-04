package Exercicios;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;


    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }

    public void aumentoPreco(double porcentagem) {
        this.preco += preco * porcentagem/100;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", preco: "+ String.format("%.2f", preco ) +
                '}';
    }

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
}
