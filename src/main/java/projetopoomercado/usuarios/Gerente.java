
package projetopoomercado.usuarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import projetopoomercado.estoques.IEstoque;
import projetopoomercado.produtos.Produto;
import projetopoomercado.produtos.ProdutoHistorico;


public class Gerente extends Funcionario {
    
    //cria o vetor onde vai ta o historico de vendas e compras do mercado
   public static Vector<ProdutoHistorico> produtoHist;
    
    //construtor
    public Gerente(IEstoque estoque, String nome, String login, String senha) {
        super(estoque, nome, login, senha);
        Gerente.produtoHist = new Vector<ProdutoHistorico>();
    }
    
    //metodo para cadastrar um produto no estoque, checa se o produto ja existe no estoque, se não existir
    //ele cadastra
     public void cadastrar(Produto produto, int quantidade, double taxalucro){
         if(produto != null){ 
             if(!this.estoque.existe(produto.getId())){
              double valorTotal = (quantidade * produto.getPreco_compra());  //calcula o valor total da compra
            if(this.estoque.verSaldo() >= valorTotal){ //checa se o saldo do mercado é maior que o preço da compra
                    produto.setTaxaLucro(taxalucro);  //seta a taxa de lucro que esse produto vai ter
                    produto.setprecoVenda(produto.getPreco_compra() * produto.getTaxaLucro()); //aqui ele seta o preço de venda, sendo a multiplicação do preço de compra pela taxa de lucro
                    this.estoque.inserir(produto, quantidade); //ele chama o metodo inserir da interface de estoque, onde ele insere o produto e a quantidade no estoque
                    this.estoque.definirSaldo(this.estoque.verSaldo() - valorTotal); //atualiza o saldo do mercado
                    ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade); //cria um objeto de produto historico, onde os atributos dele vão ser os mesmos do que o produto que foi vendido
                 this.registrarCompra(produtoHistorico); //registra a compra, colocando-a no vetor do historico
            }
        }
         }
    }

    //metodo para adicionar mais produtos no estoque, caso ele ja esteja cadastrado
    //se nao tiver cadastrado, nao vai adicionar
      public void adicionar(Produto produto, int quantidade){
        if(produto != null){
            double valorTotal = (quantidade * produto.getPreco_compra());  //valor da compra
            if(this.estoque.existe(produto.getId())){
               if(this.estoque.verSaldo() >= valorTotal){    //checa o saldo
                 this.estoque.inserir(produto, quantidade);  //insere no estoque
                this.estoque.definirSaldo(this.estoque.verSaldo() - valorTotal); //atualiza o saldo
                 ProdutoHistorico produtoHistorico = new ProdutoHistorico(produto.getId(), valorTotal, quantidade);
                 this.registrarCompra(produtoHistorico); //registra a compra
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

    //metodo pro gerente ver o estoque, ele somente chama o metodo de mostrar o estoque da interface estoque
      public void verEstoque(String tipo){
          this.estoque.mostrarEstoque(tipo);
      }

    //metodo para registrar a compra, ele recebe um objeto de produto historico, adiciona no vetor e seleciona a forma como "compra"
public void registrarCompra(ProdutoHistorico produto){
          if(produto != null){
              Gerente.produtoHist.add(produto);
              produto.setForma("Compra");
          }
}
   //ver o balanço financeiro pela data, escreve uma data e mostra todos os produtos vendidos nesse dia, quanto entrou, quanto saiu 
    public void verBalancoData(String data){
          double ganho = 0.0; 
          double perda = 0.0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDate localDate = LocalDate.parse(data, formatter); //transformando a data em forma de string para data em forma de LocalDate
         for(ProdutoHistorico produto : Gerente.produtoHist){ // percorre todo o vetor de historico
            if(localDate.equals(produto.getData())){  //pega todos os produtos que foram vendidos/comprados na data escrita
             System.out.println(produto);  //printa todos eles
             if(produto.getForma() == "Venda"){
             ganho += produto.getPreco();  //calcula quanto ganhou
             }
             else{
                 perda += produto.getPreco();  //calcula quanto perdeu
             }
            }
         }
         double balanco = ganho - perda;
         System.out.println("Saiu: " + perda + " " + "Entrou: " + ganho);  //mpstra os ganhos e perdas
         System.out.printf("Balanço final: $%.2f\n", balanco); //mostra o balanço do dia (sem contar o saldo setado inicialmente, so o quanto foi comprado e vendido)
      }

    //mostra todos os produtos vendidos e comprados, mesmo funcionamento do anterior
    public void verBalancoTotal(){
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
         System.out.println("Saldo do mercado: " + this.estoque.verSaldo());
         
      }

    //metodo para setar o saldo inicial do mercado
    public void iniciarSaldo(double valor){
        this.estoque.definirSaldo(valor);
    }

}
      
