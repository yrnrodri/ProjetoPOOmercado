
package projetopoomercado;

import java.util.Vector;


public abstract class Funcionario {
    
    protected String login;
    protected String senha;
    protected String nome;
    protected IEstoque estoque;
   
    
    public Funcionario(IEstoque estoque, String nome, String login, String senha){
        this.estoque = estoque;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
       
    }


    
   
    
}
