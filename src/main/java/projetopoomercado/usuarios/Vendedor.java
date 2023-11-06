
package projetopoomercado.usuarios;

import projetopoomercado.estoques.IEstoque;
import projetopoomercado.produtos.Produto;
import projetopoomercado.produtos.ProdutoHistorico;

public class Vendedor extends Funcionario {
    //atributos
    private double taxaCredito;

    //construtor
    public Vendedor(IEstoque estoque, String nome, String login, String senha) {
        super(estoque, nome, login, senha);
        this.taxaCredito = 1.2;
    }

    //metodo para vender o produto em dinheiro, recebe o id, o valor dado pelo cliente e a quantidade desejada
     public void venderDinheiro(String id, double valor, int quantidade){
        Produto produto = this.estoque.procurar(id); //checa se tem o produto no estoque
        if(produto != null){
            double valorTotal = quantidade * produto.getPrecoVenda(); //calcula o valor da venda
            if(quantidade <= produto.getQuantidade()){ //checa se a quantidade desejada pelo cliente tem o suficiente no estoque
            if(valor > valorTotal ){ // caso o valor dado pelo cliente seja maior que o valor da venda, será retornado um troco
                this.estoque.definirSaldo(this.estoque.verSaldo() + valorTotal); //atualiza o saldo
                this.troco(valor - valorTotal); //mostra o troco
                this.estoque.reduzir(produto, quantidade); //chama o metodo reduzir da interface estoque, onde tira a quantidade vendida do estoque
                ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade); //cria um objeto produto historico, onde os atributos são os do produto vendido
                this.registrarVenda(produtoHistorico); //registra a venda
                this.notaFiscal(produtoHistorico); //imprime a nota fiscal
            }
            else if(valor == valorTotal){ //caso o valor dado pelo cliente seja igual ao valor da venda, não retornará troco
                this.estoque.definirSaldo(this.estoque.verSaldo() + valor); //atualiza o saldo
                this.estoque.reduzir(produto, quantidade); //reduz a quantidade do estoque
                ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valor, quantidade);
                this.registrarVenda(produtoHistorico); //registra a venda
                this.notaFiscal(produtoHistorico); //imprime a nota fiscal
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

    //metodo para vender por cartão de crédito
     public void venderCredito(String id, int quantidade, int parcelas){
        Produto produto = this.estoque.procurar(id); //procura no vetor estoque
        if(produto != null){
            if(quantidade <= produto.getQuantidade()){ //checa a quantidade
            double valorTotal = quantidade * produto.getPrecoVenda() * taxaCredito; //calcula o valor da venda, dessa vez adicionando a taxa de crédito
            this.estoque.definirSaldo(this.estoque.verSaldo() + valorTotal); //atualiza o saldo
            this.estoque.reduzir(produto, quantidade); //reduz a quantidade do estoque 
            ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
            this.registrarVenda(produtoHistorico); //registra a venda
            this.notaFiscal(produtoHistorico); //imprime a nota fiscal
            }
            else{
                System.out.println("Sem produtos o suficiente no estoque.");
            }
        }
    }
     //metodo para vender no debito
      public void venderDebito(String id, int quantidade){
        Produto produto = this.estoque.procurar(id); //procura no vetor estoque
        if(produto != null){
            if(quantidade <= produto.getQuantidade()){ //checa a quantidade
            double valorTotal = quantidade * produto.getPrecoVenda(); //calcula o valor da venda
            this.estoque.definirSaldo(this.estoque.verSaldo() + valorTotal); //atualiza o saldo
            this.estoque.reduzir(produto, quantidade); //reduz a quantidade
            ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
            this.registrarVenda(produtoHistorico); //registra a venda     
            this.notaFiscal(produtoHistorico); //imprime a nota fiscal
            }
            else{
                System.out.println("Sem produtos o suficiente no estoque.");
            }
        }
    }
      //metodo para mostrar o troco
      public void troco(double valor){
            System.out.println("Seu troco é: " + valor);
      }
      //metodo para registrar a venda, adiciona no vetor de historico e seta a forma como "venda"
      public void registrarVenda(ProdutoHistorico produto){
          if(produto != null){
              Gerente.produtoHist.add(produto);
              produto.setForma("Venda");
          }
      }
      //metodo para mostrar a nota fiscal
      public void notaFiscal(ProdutoHistorico produto){
            System.out.println("Nota fiscal: " + produto);

      }
      

}
