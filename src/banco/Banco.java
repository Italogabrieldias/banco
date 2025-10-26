package banco;

import exceptions.ContaInvalidaExeption;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarConta(Conta conta) {
        conta.add(conta);
        Cliente titular = conta.getTitular();
        if (!clientes.contains(titular)) {
            clientes.add(titular);
        }

        System.out.println("Conta Criada com sucesso!");
        System.out.println("Número da conta: " + conta.getNumero());
    }

    public Conta buscarConta(int numeroConta) throws ContaInvalidaExeption {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }

        }
        throw new ContaInvalidaExeption(numeroConta);
    }

    public List<Conta> buscarContasPorCliente(String cpf) {
        List<Conta> contasCliente = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.getTitular().getCpf().equals(cpf)) {
                contasCliente.add(conta);
            }
        }
        return contasCliente;
    }

    public Cliente buscCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void listarTodasContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta Cadastrada.");
            return;
        }
        System.out.println("\n===============  CONTAS CADASTRADAS ===============");
        for (Conta conta : contas) {
            System.out.println(conta);

        }

        System.out.println("=============================================\n");
    }

    public void listarTodosClientes() {
        if (clientes.isEmpty()) {
            System.out.println("nenhum clientes cadastrado.");
            return;
        }
        System.out.println("=============================================\n");
    }

    public int getTotalContas() {
        return contas.size();
    }

    public int getTotalClientes() {
        return clientes.size();
    }

    public void exibirRelatorio() {
        System.out.println("\n========== RELATÓRIO DO BANCO ==========");
        System.out.println("Banco: " + nome);
        System.out.println("Total de Clientes: " + clientes.size());
        System.out.println("Total de Contas: " + contas.size());

        int contasCorrente = 0;
        int contasPoupanca = 0;
        double saldoTotal = 0;

        for (Conta conta : contas) {
            if (conta instanceof ContaCorrente) {
                contasCorrente++;
            } else if (conta instanceof ContaPoupanca) {
                contasPoupanca++;
            }
            saldoTotal += conta.getSaldo();
        }

        System.out.println("Contas Corrente: " + contasCorrente);
        System.out.println("Contas Poupança: " + contasPoupanca);
        System.out.printf("Saldo Total: R$ %.2f\n", saldoTotal);
        System.out.println("========================================\n");
    }
}
