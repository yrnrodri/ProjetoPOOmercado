
package projetopoomercado.usuarios;

import projetopoomercado.estoques.IEstoque;
import projetopoomercado.produtos.Produto;
import projetopoomercado.produtos.ProdutoHistorico;

import projetopoomercado.excecao.PIException;
import projetopoomercado.excecao.QIException;
import projetopoomercado.excecao.QNException;
import projetopoomercado.excecao.QNUException;
import projetopoomercado.excecao.VNUException;
import projetopoomercado.excecao.VNException;
import projetopoomercado.excecao.VIException;
import projetopoomercado.excecao.PANException;
import projetopoomercado.excecao.PANUException;

public class Vendedor extends Funcionario {
    //atributos
    private double taxaCredito;

    //construtor
    public Vendedor(IEstoque estoque, String nome, String login, String senha) {
        super(estoque, nome, login, senha);
        this.taxaCredito = 1.2;
    }

    //metodo para vender o produto em dinheiro, recebe o id, o valor dado pelo cliente e a quantidade desejada
    /*  public void venderDinheiro(String id, double valor, int quantidade){
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
      
    } */

    // **minha gambiarra abaixo** //

    public void venderDinheiro(String id, double valor, int quantidade) throws QIException, QNException, QNUException, VNException, VNUException, VIException,  PIException{
        
        if(valor>0){
            if(quantidade > 0){
        
        Produto produto = this.estoque.procurar(id); //checa se tem o produto no estoque
        if(produto != null){
            double valorTotal = quantidade * produto.getPrecoVenda(); //calcula o valor da venda
            if(quantidade <= produto.getQuantidade()){ //checa se a quantidade desejada pelo cliente tem o suficiente no estoque
            if(valor > valorTotal ){ // caso o valor dado pelo cliente seja maior que o valor da venda, será retornado um troco
                this.estoque.venderEstoque(valorTotal); //atualiza o saldo
                this.troco(valor - valorTotal); //mostra o troco
                this.estoque.reduzir(produto, quantidade); //chama o metodo reduzir da interface estoque, onde tira a quantidade vendida do estoque
                ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade); //cria um objeto produto historico, onde os atributos são os do produto vendido
                this.registrarVenda(produtoHistorico); //registra a venda
                this.notaFiscal(produtoHistorico); //imprime a nota fiscal
            }
            else if(valor == valorTotal){ //caso o valor dado pelo cliente seja igual ao valor da venda, não retornará troco
                this.estoque.venderEstoque(valorTotal); //atualiza o saldo
                this.estoque.reduzir(produto, quantidade); //reduz a quantidade do estoque
                ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valor, quantidade);
                this.registrarVenda(produtoHistorico); //registra a venda
                this.notaFiscal(produtoHistorico); //imprime a nota fiscal
            }
            else{
                throw new VIException(valorTotal, valor);
            }
            }
            else{
                throw new QIException(id, produto.getQuantidade(), quantidade);
            }
        }
        else
            throw new PIException(id);
        }
        else if(quantidade == 0)
            throw new QNUException();
        else if(quantidade < 0)
            throw new QNException(quantidade);
        }
        else if(valor == 0)
            throw new VNUException(valor);
        else if(valor < 0)
            throw new VNException(valor);    
      
    }


    /* 
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
    }*/

    //metodo para vender por cartão de crédito(**teste**)
     public void venderCredito(String id, int quantidade, int parcelas) throws PANUException, PANException, PIException, QIException, QNUException, QNException{
        
        if(parcelas>0){
        
        if(quantidade>0){

        Produto produto = this.estoque.procurar(id); //procura no vetor estoque
        if(produto != null){
            if(quantidade <= produto.getQuantidade()){ //checa a quantidade
            double valorTotal = quantidade * produto.getPrecoVenda() * taxaCredito; //calcula o valor da venda, dessa vez adicionando a taxa de crédito
            this.estoque.venderCartaoEstoque(valorTotal); //atualiza o saldo
            this.estoque.reduzir(produto, quantidade); //reduz a quantidade do estoque 
            ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
            this.registrarVenda(produtoHistorico); //registra a venda
            this.notaFiscal(produtoHistorico); //imprime a nota fiscal
            }
            else{
                throw new QIException(id,produto.getQuantidade(),quantidade);
            }
        }else
            throw new PIException(id); //produto ja existente
        }else if(quantidade < 0)
            throw new QNException(quantidade); // quantidade negativa
         else if(quantidade == 0)
            throw new QNUException(); // quantidade nula
        }else if(parcelas<0)
            throw new PANException(parcelas); // parcelas negativas
         else
            throw new PANUException(parcelas); // parcelas nula
    }



     /*//metodo para vender no debito
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
    }*/


    //metodo para vender no debito(**teste**)
      public void venderDebito(String id, int quantidade) throws QNException, QNUException, QIException, PIException{
        if(quantidade>0){
        Produto produto = this.estoque.procurar(id); //procura no vetor estoque
        if(produto != null){
            if(quantidade <= produto.getQuantidade()){ //checa a quantidade
            double valorTotal = quantidade * produto.getPrecoVenda(); //calcula o valor da venda
            this.estoque.venderCartaoEstoque(valorTotal); //atualiza o saldo
            this.estoque.reduzir(produto, quantidade); //reduz a quantidade
            ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
            this.registrarVenda(produtoHistorico); //registra a venda     
            this.notaFiscal(produtoHistorico); //imprime a nota fiscal
            }
            else{
                throw new QIException(id, produto.getQuantidade(), quantidade);
            }
        }else
            throw new PIException(id); //produto ja existente
        }else if(quantidade < 0)
            throw new QNException(quantidade); //quantidade negativa
         else if(quantidade == 0)
            throw new QNUException(); // quantidade nula
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
