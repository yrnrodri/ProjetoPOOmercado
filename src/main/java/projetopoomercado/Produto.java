
package projetopoomercado;


public class Produto {
    //atributos
     private String nome;
    private String id;
    private String marca;
    private double preco;
    private String tipo;
    private String validade;
    private int quantidade;

    //construtor
    public Produto(String nome, String id, String marca, double preco, String tipo, String validade) {
        this.nome = nome;
        this.id = id;
        this.marca = marca;
        this.preco = preco;
        this.tipo = tipo;
        this.validade = validade;
        this.quantidade = 0; //setei como 0 porque so vamos controlar a quantidade quando for adicionar no estoque
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", id=" + id + ", marca=" + marca +
                ", preco=" + preco + 
                ", tipo=" + tipo + 
                ", validade=" + validade + ", quantidade=" + quantidade + '}';
    }
        
   

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
