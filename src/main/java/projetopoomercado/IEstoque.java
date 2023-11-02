
package projetopoomercado;

        
public interface IEstoque {
    
    
    public void inserir(Produto produto, int quantidade);
    
    public Produto procurar(String id);
    
    public boolean existe(String id);
    
    public void reduzir(Produto produto, int quantidade);
    
    public void mostrarEstoque(String tipo);
    
    public double verSaldo();
    
    public void definirSaldo(double valor);
    
    
}
