package exceptions;

public class ContaInvalidaException extends Exception {
    public ContaInvalidaException(String mensagem){
        super(mensagem);
    }
    public ContaInvalidaException(int numeroConta){
        super("Conta númereo "+ numeroConta + "não encontrada!");
    }

}
