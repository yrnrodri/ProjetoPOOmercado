
package projetopoomercado;

import java.util.Vector;


public class Estoque implements IEstoque {
    
    private Vector<Produto> estoque;
    private double saldo;
    
    public Estoque(){
        this.estoque = new Vector<Produto>();
        this.saldo = 0.0;
      
    }
   
        
    @Override
    public void inserir(Produto produto, int quantidade){
        if(produto != null){
                 if(!this.existe(produto.getId())){
                produto.setQuantidade(quantidade);
                this.estoque.add(produto);
            }
                 else if(this.existe(produto.getId())){
                     produto.setQuantidade(produto.getQuantidade() + quantidade);
                 }
            
            }
           
    }

    @Override
    public Produto procurar(String id) {
       for(Produto produto : estoque){
            if(produto.getId().equals(id)){
                return produto;
            }            
        }
         return null;
    }

    @Override
    public boolean existe(String id) {
        for(Produto produto : estoque){
            if(produto.getId().equals(id)){
                return true;
            }
                
        }
        return false;
    }

    @Override
    public void reduzir(Produto produto, int quantidade) {
            if(produto != null){
                produto.setQuantidade(produto.getQuantidade() - quantidade);
            }
    }
    
    @Override
    public void mostrarEstoque(String tipo){
        for(Produto produto : estoque){
            if(produto.getTipo().equals(tipo)){
                if(produto instanceof ProdutoComestivel){
                    System.out.println(((ProdutoComestivel) produto).CustomtoString());
                }
                else{
                    System.out.println(produto.toString());
                }
            }
        }
    }

    @Override
    public double verSaldo() {
       return saldo;
    }

    @Override
    public void definirSaldo(double valor) {
       this.saldo = valor;
    }
    
    
    

    
}
