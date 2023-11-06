
package projetopoomercado.usuarios;

import projetopoomercado.estoques.IEstoque;
import projetopoomercado.produtos.Produto;
import projetopoomercado.produtos.ProdutoHistorico;

public class Vendedor extends Funcionario {
    
    private double taxaCredito;
    
    public Vendedor(IEstoque estoque, String nome, String login, String senha) {
        super(estoque, nome, login, senha);
        this.taxaCredito = 1.2;
    }
    
     public void venderDinheiro(String id, double valor, int quantidade){
        Produto produto = this.estoque.procurar(id);
        if(produto != null){
            double valorTotal = quantidade * produto.getPrecoVenda();
            if(quantidade <= produto.getQuantidade()){
            if(valor > valorTotal ){
                this.estoque.definirSaldo(this.estoque.verSaldo() + valorTotal);
                this.troco(valor - valorTotal);
                this.estoque.reduzir(produto, quantidade);
                ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
                this.registrarVenda(produtoHistorico);
                
            }
            else if(valor == valorTotal){
                this.estoque.definirSaldo(this.estoque.verSaldo() + valor);
                this.estoque.reduzir(produto, quantidade);
                ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valor, quantidade);
                this.registrarVenda(produtoHistorico);
            }
            else{
                System.out.println("Valor insuficiente!");
            }
            }
            else{
                System.out.println("Sem produtos o suficiente no estoque.");
            }
        }
      
    }
     
     public void venderCredito(String id, int quantidade, int parcelas){
        Produto produto = this.estoque.procurar(id);
        if(produto != null){
            if(quantidade <= produto.getQuantidade()){
            double valorTotal = quantidade * produto.getPrecoVenda() * taxaCredito;
            this.estoque.definirSaldo(this.estoque.verSaldo() + valorTotal);
            this.estoque.reduzir(produto, quantidade);
            ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
            this.registrarVenda(produtoHistorico);
            }
            else{
                System.out.println("Sem produtos o suficiente no estoque.");
            }
        }
    }
     
      public void venderDebito(String id, int quantidade){
        Produto produto = this.estoque.procurar(id);
        if(produto != null){
            if(quantidade <= produto.getQuantidade()){
            double valorTotal = quantidade * produto.getPrecoVenda();
            this.estoque.definirSaldo(this.estoque.verSaldo() + valorTotal);
            this.estoque.reduzir(produto, quantidade);
            ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
            this.registrarVenda(produtoHistorico);      
            this.notaFiscal(produtoHistorico);
            }
            else{
                System.out.println("Sem produtos o suficiente no estoque.");
            }
        }
    }
      
      public void troco(double valor){
            System.out.println("Seu troco é: " + valor);
      }
      
      public void registrarVenda(ProdutoHistorico produto){
          if(produto != null){
              Gerente.produtoHist.add(produto);
              produto.setForma("Venda");
          }
      }
      
      public void notaFiscal(ProdutoHistorico produto){
            System.out.println("Nota fiscal: " + produto);

      }
      

}
