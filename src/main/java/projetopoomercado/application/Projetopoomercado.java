package projetopoomercado.application;

//import java.time.LocalDate;
import projetopoomercado.estoques.Estoque;
import projetopoomercado.estoques.IEstoque;
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
   
        gerente.cadastrar(produto1, 5, 1.2);
        
        Vendedor vendedor = new Vendedor(estoque, "joao", "joaozin", "susu");
        
        vendedor.venderDebito("9888", 3);    
        gerente.verBalancoTotal();
 
        
    
    }
}
