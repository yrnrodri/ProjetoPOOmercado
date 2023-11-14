package projetopoomercado.application;

//import java.time.LocalDate;
import projetopoomercado.estoques.Estoque;
import projetopoomercado.estoques.IEstoque;
import projetopoomercado.excecao.PEException;
import projetopoomercado.excecao.SIException;
import projetopoomercado.excecao.PIException;
import projetopoomercado.excecao.QIException;
import projetopoomercado.excecao.QNException;
import projetopoomercado.excecao.QNUException;
import projetopoomercado.produtos.Produto;
import projetopoomercado.produtos.ProdutoComestivel;
import projetopoomercado.usuarios.Gerente;
import projetopoomercado.usuarios.Vendedor;


public class Projetopoomercado {

    public static void main(String[] args) {
        
        IEstoque estoque = new Estoque();
        Gerente gerente = new Gerente(estoque, "rodrigo", "jrodri", "hahaha");
        gerente.iniciarSaldo(100.0);
        
        Produto produto1 = new ProdutoComestivel("refrigerante", "9888", "coca cola", 20.0, "bebida", "20/07/2023");
        //Produto produto2 = new ProdutoComestivel("bolacha de flocos", "9889", "richester", 15.0, "comida", "07/02/2025");
   
        try{
            gerente.cadastrar(produto1, -5, 1.2);
        }catch(PEException e){
            System.out.print(e.getMessage());
            System.out.print(" Id: ");
            System.out.print(e.getId());
        }catch(SIException e){
            System.out.print(e.getMessage());
            System.out.print(" Id/Saldo/Valor: ");
            System.out.print(e.getId()+"/"+ e.getSaldo()+"/"+e.getValor());
        }catch(QNException e){
            System.out.print(e.getMessage());
            System.out.print(" Quantidade: ");
            System.out.print(e.getQuantidadeRequerida());
        }catch(QNUException e){
            System.out.print(e.getMessage());
        }
        
        Vendedor vendedor = new Vendedor(estoque, "joao", "joaozin", "susu");
        
        try{
            vendedor.venderDebito("9888", 3);
        }catch(QNException e){
            System.out.print(e.getMessage());
            System.out.print(" Quantidade: ");
            System.out.print(e.getQuantidadeRequerida());
        }catch(QNUException e){
            System.out.print(e.getMessage());
        }catch(QIException e){
            System.out.print(e.getMessage());
            System.out.print(" Id/Quantidade em Estoque/Quantidade requerida: ");
            System.out.print(e.getId()+"/"+ e.getQuantidadeEstoque()+"/"+e.getQuantidadeRequerida());
        }catch(PIException e){
            System.out.print(e.getMessage());
            System.out.print(" Id: ");
            System.out.print(e.getId());
        }    
        gerente.verBalancoData("2023-11-05");
 
        
    

    }
}
