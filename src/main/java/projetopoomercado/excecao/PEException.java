package projetopoomercado.excecao;

public class PEException extends Exception{
    
    private String Id;


    public PEException(String Id){

        super("\nProduto já existente ");
        this.Id = Id;
      }
    
      public String getId(){
        return Id;
      }
}
