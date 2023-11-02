
package projetopoomercado;

import java.util.Vector;


public class ProdutoHistorico {
    private String idVenda;
    private double preco;
    private int quantidadeVendida;
    private String forma;

    public ProdutoHistorico(String idVenda, double preco, int quantidadeVendida) {
        this.idVenda = idVenda;
        this.preco = preco;
        this.quantidadeVendida = quantidadeVendida;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public String toString() {
        return "ProdutoHistorico{" + "idVenda=" + idVenda + ", preco=" + preco + ", quantidadeVendida=" + quantidadeVendida + ", forma=" + forma + '}';
    }
    
    
    
    
}
