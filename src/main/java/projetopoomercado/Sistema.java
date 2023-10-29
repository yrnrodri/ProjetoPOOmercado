
package projetopoomercado;

import java.util.Vector;

public class Sistema {
    private Vector<Produto> produtos_sistema; //onde vai ficar guardado todos os produtos do sistema
    private Vector<Produto> estoque;//onde vai ficar guardado todos os produtos do estoque
    private int quantidade_add;

    public Sistema() {
        produtos_sistema = new Vector<Produto>();
        estoque = new Vector<Produto>();
    }
    
    //metodo para checar se esse produto está no cadastrado no sistema
    //ele percorre todo o vetor do sistema e ve se o ID digitado está dentro
    public Produto procurar_sistema(String id){
        for(Produto produto : produtos_sistema){
            if(produto.getId().equals(id)){
                return produto;
            }            
        }
         return null;
    }
    
    //metodo para checar se esse produto está dentro do estoque
    //ele percorre todo o vetor do estoque e ve se o ID digitado está dentro
    public boolean existe_estoque(String id){
        for(Produto produto : estoque){
            if(produto.getId().equals(id)){
                return true;
            }
                
        }
        return false;
    }
    
    //metodo para cadastrar um produto no sistema
    public void cadastrar(Produto produto){
        this.produtos_sistema.add(produto);
    }
    
    //metodo para adicionar um produto do sistema no estoque
    //ele checa se o produto está no sistema e no estoque
    //se o produto nao estiver no estoque, vai adiciona-lo e a quantidade que o usuario desejar
    //se o produto ja estiver no estoque, ele so vai adicionar a quantidade
    public void adicionar_estoque(String id, int quantidade_add){
        Produto produto = procurar_sistema(id);
            if(produto != null && !this.existe_estoque(produto.getId())){
                this.estoque.add(produto);
                for(int i = 0; i < quantidade_add; i++){
                produto.setQuantidade(produto.getQuantidade() + 1);
                }
            }
            else if(produto != null && this.existe_estoque(produto.getId())){
                for(int i = 0; i < quantidade_add; i++){
                produto.setQuantidade(produto.getQuantidade() + 1);
                }
            }
        
    }

    @Override
    public String toString() {
        return "Sistema{" + "estoque=" + estoque + '}';
    }

    
    

    
    
    
}
