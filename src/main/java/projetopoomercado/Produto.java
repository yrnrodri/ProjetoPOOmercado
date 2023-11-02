
package projetopoomercado;


public class Produto {
    //atributos
    protected String nome;
    protected String id;
    protected String marca;
    protected double preco_compra;
    protected double precoVenda;
    protected String tipo;  
    protected int quantidade;
    protected double taxaLucro;
   
    //construtor
    public Produto(String nome, String id, String marca, double preco_compra, String tipo) {
        this.nome = nome;
        this.id = id;
        this.marca = marca;
        this.preco_compra = preco_compra;
        this.precoVenda = 0.0;
        this.tipo = tipo;
        this.quantidade = 0; //setei como 0 porque so vamos controlar a quantidade quando for adicionar no estoque
        this.taxaLucro = 0.0;
    }
  
    
    
    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", id=" + id + ", marca=" + marca +
                ", preco=" + preco_compra + ", tipo=" + tipo +
                ", quantidade=" + quantidade + '}';
    }
   
        
   /////getters e setters
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTaxaLucro() {
        return taxaLucro;
    }

    public void setTaxaLucro(double taxaLucro) {
        this.taxaLucro = taxaLucro;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setprecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

   
    

    
    
}
