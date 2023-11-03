package projetopoomercado.application;

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
        Produto produto2 = new ProdutoComestivel("bolacha de flocos", "9889", "richester", 15.0, "comida", "07/02/2025");
   
        gerente.cadastrar(produto1, 5, 1.2);
        
        Vendedor vendedor = new Vendedor(estoque, "joao", "joaozin", "susu");
        
        vendedor.vender_debito("9888", 3);
        gerente.adicionar(produto1, 3);
        vendedor.vender_dinheiro("9888", 120.0, 5);
        gerente.cadastrar(produto2, 3, 1.1);
        vendedor.vender_credito("9889", 3, 2);


        gerente.verBalanco();
        gerente.verEstoque("comida");
        System.out.println("hello");
        
    
        
       
        
        
        
    }
}
