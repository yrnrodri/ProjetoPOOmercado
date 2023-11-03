
package projetopoomercado.usuarios;

import java.util.Vector;
import projetopoomercado.estoques.IEstoque;
import projetopoomercado.produtos.Produto;
import projetopoomercado.produtos.ProdutoHistorico;


public class Gerente extends Funcionario {
    
    
   public static Vector<ProdutoHistorico> produtoHist;
    
    
    public Gerente(IEstoque estoque, String nome, String login, String senha) {
        super(estoque, nome, login, senha);
        Gerente.produtoHist = new Vector<ProdutoHistorico>();
    }
    
     public void cadastrar(Produto produto, int quantidade, double taxalucro){
         if(produto != null){
             if(!this.estoque.existe(produto.getId())){
              double valorTotal = (quantidade * produto.getPreco_compra());
            if(this.estoque.verSaldo() >= valorTotal){
                    produto.setTaxaLucro(taxalucro);
                    produto.setprecoVenda(produto.getPreco_compra() * produto.getTaxaLucro());
                    this.estoque.inserir(produto, quantidade);
                    this.estoque.definirSaldo(this.estoque.verSaldo() - valorTotal);
                    ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
                 this.registrarCompra(produtoHistorico);
            }
        }
         }
    }
     
      public void adicionar(Produto produto, int quantidade){
        if(produto != null){
            double valorTotal = (quantidade * produto.getPreco_compra());
            if(this.estoque.existe(produto.getId())){
               if(this.estoque.verSaldo() >= valorTotal){    
                 this.estoque.inserir(produto, quantidade);
                this.estoque.definirSaldo(this.estoque.verSaldo() - valorTotal);
                 ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
                 this.registrarCompra(produtoHistorico);
            }
               else{
                   System.out.println("Saldo insuficiente!");
               }
            }
            else{
                System.out.println("Produto não cadastrado.");
            }
        }
            
    }
      
      public void verEstoque(String tipo){
          this.estoque.mostrarEstoque(tipo);
      }
          
public void registrarCompra(ProdutoHistorico produto){
          if(produto != null){
              Gerente.produtoHist.add(produto);
              produto.setForma("Compra");
          }
}
    
    public void verBalanco(){
          double ganho = 0.0;
          double perda = 0.0;
         for(ProdutoHistorico produto : Gerente.produtoHist){
             System.out.println(produto);
             if(produto.getForma() == "Venda"){
             ganho += produto.getPreco();
             }
             else{
                 perda += produto.getPreco();
             }
         }
         double balanco = ganho - perda;
         System.out.println("Saiu: " + perda + " " + "Entrou: " + ganho);
         System.out.printf("Balanço final: $%.2f\n", balanco);
      }
    
    public void iniciarSaldo(double valor){
        this.estoque.definirSaldo(valor);
    }

}
      
