

package projetopoomercado;

public class Projetopoomercado {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Produto produto1 = new Produto("refrigerante", "9888", "coca cola", 20.0, "bebida", "20/02/2020");
        sistema.cadastrar(produto1);
        Produto produto2 = new Produto("bolacha de flocos", "9889", "richester", 15.0, "comida", "20/02/2020");
        sistema.cadastrar(produto2);
        
        sistema.adicionar_estoque("9888", 5);
        sistema.adicionar_estoque("9888", 4);
        sistema.adicionar_estoque("9889", 2);
        
        System.out.println(sistema.toString());
    }
}
