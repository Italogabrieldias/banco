package banco;

import exceptions.ValorInvalidoException;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;
    private static final double TAXA_MANUTENCAO = 15.0;

    public ContaCorrente(Cliente titular, double depositoInicial) {
        super(titular);
        this.limiteChequeEspecial = 500.0;
    }

    public ContaCorrente(Cliente titular, double depositoInicial, double limiteChequeEspecial) throws ValorInvalidoException {
        super(titular, depositoInicial);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        if (limiteChequeEspecial >= 0) {
            this.limiteChequeEspecial = limiteChequeEspecial;
        }

    }

    @Override
    protected boolean podeSacar(double valor) {
        return (getSaldo() + limiteChequeEspecial) >= valor;
    }

    @Override
    public String getTipoConta() {
        return "Conta Corrente";
    }

    public void cobrareTaxaManutencao() {
        try {
            setSaldo(getSaldo() - TAXA_MANUTENCAO);
            System.out.printf("Taxa de manutenção de R$ %.2f cobrada. \n", TAXA_MANUTENCAO);

        } catch (Exception e) {
            System.out.println("Erro ao cobrar taxa de manutenção.");
        }
    }

    @Override
    protected void exibirInformacoesEspecificas() {
        System.out.printf("Limite Cheque Especial: R$ %.2f\n", limiteChequeEspecial);
        System.out.printf("Saldo Disponível Total: R$ %.2f\n", getSaldo() + limiteChequeEspecial);
    }

    public void cobrarTaxaManutencao() {
    }
}
