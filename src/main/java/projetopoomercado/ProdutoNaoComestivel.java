
package projetopoomercado;


public class ProdutoNaoComestivel extends Produto {
    
    public ProdutoNaoComestivel(String nome, String id, String marca, double preco_compra, String tipo) {
        super(nome, id, marca, preco_compra, tipo);
        this.quantidade = 0;
        this.taxaLucro = 0.0;
        this.precoVenda = 0.0;
    }
    
}
