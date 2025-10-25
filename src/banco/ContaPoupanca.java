package banco;

import exceptions.ValorInvalidoException;

public class ContaPoupanca extends Conta {
    private double taxaRendimento;
    private static final double TAXA_RENDIMENTO_PADRAO = 0.005;

    public ContaPoupanca(Cliente titular) {
        super(titular);
        this.taxaRendimento = TAXA_RENDIMENTO_PADRAO;
    }

    public ContaPoupanca(Cliente titular, double depositoInicial) throws ValorInvalidoException {
        super(titular, depositoInicial);
        this.taxaRendimento = TAXA_RENDIMENTO_PADRAO;
    }

    public ContaPoupanca(Cliente titular, double depositoInicial, double taxaRendimento)
            throws ValorInvalidoException {
        super(titular, depositoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        if (taxaRendimento >= 0) {
            this.taxaRendimento = taxaRendimento;
        }
    }

    @Override
    protected boolean podeSacar(double valor) {
        return getSaldo() >= valor;
    }

    @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * taxaRendimento;
        setSaldo(getSaldo() + rendimento);
        System.out.printf("Rendimento de R$ %.2f aplicado (%.2f%%).\n",
                rendimento, taxaRendimento * 100);
    }

    @Override
    protected void exibirInformacoesEspecificas() {
        System.out.printf("Taxa de Rendimento: %.2f%% ao mês\n", taxaRendimento * 100);
    }
}
