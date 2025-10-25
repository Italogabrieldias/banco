package banco;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorInvalidoException;

public abstract class Conta {
    private static int contadorContas = 1000;
    private int numero;
    private double saldo;
    private Cliente titular;

    public Conta(Cliente titular) {
        this.numero = ++contadorContas;
        this.saldo = 0.0;
        this.titular = titular;
    }

    public Conta(Cliente titular, double depositoInicial) throws ValorInvalidoException {
        this(titular);
        if (depositoInicial > 0) {
            this.saldo = depositoInicial;
        } else if (depositoInicial < 0) {
            throw new ValorInvalidoException("Depósito inicial não pode ser negativo!");
        }
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException();
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso!\n", valor);
    }

    public void sacar(double valor) throws ValorInvalidoException, SaldoInsuficienteException {
        if (valor <= 0) {
            throw new ValorInvalidoException();
        }
        if (!podeSacar(valor)) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valor);
    }

    public void transferir(double valor, Conta contaDestino)
            throws ValorInvalidoException, SaldoInsuficienteException {
        if (valor <= 0) {
            throw new ValorInvalidoException();
        }
        if (!podeSacar(valor)) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
        this.saldo -= valor;
        contaDestino.saldo += valor;
        System.out.printf("Transferência de R$ %.2f realizada com sucesso para a conta %d!\n",
                valor, contaDestino.getNumero());
    }

    protected abstract boolean podeSacar(double valor);

    public abstract String getTipoConta();

    public void exibirExtrato() {
        System.out.println("\n========== EXTRATO DA CONTA ==========");
        System.out.println("Tipo: " + getTipoConta());
        System.out.println("Número da Conta: " + numero);
        System.out.println("Titular: " + titular.getNome());
        System.out.println("CPF: " + titular.getCpf());
        exibirInformacoesEspecificas();
        System.out.printf("Saldo Atual: R$ %.2f\n", saldo);
        System.out.println("======================================\n");
    }

    protected void exibirInformacoesEspecificas() {
    }

    @Override
    public String toString() {
        return String.format("Conta %d (%s) - Titular: %s - Saldo: R$ %.2f",
                numero, getTipoConta(), titular.getNome(), saldo);
    }
}
