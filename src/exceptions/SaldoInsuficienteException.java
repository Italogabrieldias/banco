package exceptions;

public class SaldoInsuficienteException extends Exception{
    private double saldoAtual;
    private double valorSolicitado;

    public SaldoInsuficienteException (double saldoAtual, double valorSolicitado) {
        super(String.format("Saldo Insuficiente! Saldo Atual: R$ %.2f, Valor solicitado: R$ %.2f",
                saldoAtual, valorSolicitado));
        this.saldoAtual = saldoAtual;
        this.valorSolicitado = valorSolicitado;
    }

    public double getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(double valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }
}
