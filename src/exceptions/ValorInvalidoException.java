package exceptions;

public class ValorInvalidoException extends Exception {
    public ValorInvalidoException (String mensagem){
        super(mensagem);
    }
    public ValorInvalidoException(){
        super("Valor inválido! O valor deve ser mario que zero.");
    }
}
