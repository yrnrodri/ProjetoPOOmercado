
package projetopoomercado.estoques;

import projetopoomercado.excecao.SNException;
import projetopoomercado.excecao.SIException;
import projetopoomercado.excecao.VNException;
import projetopoomercado.excecao.PIException;
import projetopoomercado.produtos.Produto;


public interface IEstoque {
    
    
    public void inserir(Produto produto, int quantidade);
    
    public Produto procurar(String id);
    
    public boolean existe(String id);
    
    public void reduzir(Produto produto, int quantidade) throws PIException;
    
    public void mostrarEstoque(String tipo);
    
    public double verSaldo();
    
    public void definirSaldo(double valor) throws SNException;
    
    
    // **teste**
    public void venderEstoque(double valor) throws VNException;

    public void adquirirEstoque(String Id, double valor) throws SIException;

    public void venderCartaoEstoque(double valor);
}
