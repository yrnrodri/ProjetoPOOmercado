
package projetopoomercado.produtos;

public class ProdutoComestivel extends Produto {
    
      private String validade;
    
    public ProdutoComestivel(String nome, String id, String marca, double preco_compra, String tipo, String validade) {
        super(nome, id, marca, preco_compra, tipo);
        this.quantidade = 0; //setei como 0 porque so vamos controlar a quantidade quando for adicionar no estoque
        this.validade = validade;
        this.taxaLucro = 0.0;
        this.precoVenda = 0.0;
    }

    public String CustomtoString() {
        return "Produto{" + "nome=" + nome + ", id=" + id + ", marca=" + marca +
                ", preco=" + preco_compra + ", tipo=" + tipo +
                ", quantidade=" + quantidade + ", validade=" + validade + '}';
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    
}
