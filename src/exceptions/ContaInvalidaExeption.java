package exceptions;

public class ContaInvalidaExeption extends Exception {
    public ContaInvalidaExeption(String mensagem){
        super(mensagem);
    }
    public ContaInvalidaExeption (int numeroConta){
        super("Conta númereo "+ numeroConta + "não encontrada!");
    }

}
