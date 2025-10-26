import banco.*;
import exceptions.ContaInvalidaExeption;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorInvalidoException;

import java.util.Scanner;

public class Main {
    private static Banco banco;
    private static Scanner scanner;

    public static void main(String[] args) {
        banco = new Banco("Banco POO Digital");
        scanner = new Scanner(System.in);

        exibirBoasVindas();

        boolean continuar = true;
        while (continuar) {
            try {
                exibirMenuPrincipal();
                int opcao = lerOpcao();

                switch (opcao) {
                    case 1:
                        criarConta();
                        break;
                    case 2:
                        realizarDeposito();
                        break;
                    case 3:
                        realizarSaque();
                        break;
                    case 4:
                        realizarTransferencia();
                        break;
                    case 5:
                        consultarExtrato();
                        break;
                    case 6:
                        listarContas();
                        break;
                    case 7:
                        aplicarRendimento();
                        break;
                    case 8:
                        cobrarTaxaManutencao();
                        break;
                    case 9:
                       exibirRelatorio();
                        break;
                    case 0:
                        continuar = false;
                        System.out.println("\nObrigado por usar o " + banco.getNome() + "!");
                        break;
                    default:
                        System.out.println("\nOpção inválida! Tente novamente.");
                }
                if (continuar && opcao != 0) {
                    pausar();
                }
            } catch (Exception e) {
                System.out.println("\nErro: " + e.getMessage());
                pausar();
            }
        }
        scanner.close();
    }

    private static void exibirBoasVindas() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   BEM-VINDO AO BANCO POO DIGITAL          ║");
        System.out.println("║   Sistema Bancário em Java                ║");
        System.out.println("║   Demonstração de POO                     ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n========== MENU PRINCIPAL ==========");
        System.out.println("1. Criar Nova Conta");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Transferir");
        System.out.println("5. Consultar Extrato");
        System.out.println("6. Listar Todas as Contas");
        System.out.println("7. Aplicar Rendimento (Poupança)");
        System.out.println("8. Cobrar Taxa de Manutenção (Corrente)");
        System.out.println("9. Relatório do Banco");
        System.out.println("0. Sair");
        System.out.println("====================================");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
        private static void criarConta () {
            try {
                System.out.println("\n--- CRIAR NOVA CONTA ---");

                System.out.println("Nome do titular: ");
                String nome = scanner.nextLine();

                System.out.println("CPF do Titular: ");
                String cpf = scanner.nextLine();

                System.out.println("Endereço (Opcional): ");
                String endereco = scanner.nextLine();

                System.out.println("Telefone (opcional): ");
                String telefone = scanner.nextLine();

                Cliente cliente = new Cliente(nome, cpf, endereco, telefone);
                System.out.println("\nTipo de Conta:");
                System.out.println("1. Conta Corrente");
                System.out.println("2. Conta Poupança");
                System.out.print("Escolha o tipo: ");
                int tipo = lerOpcao();

                System.out.println("Valor do depósito inicial (ou 0): R$ ");
                double depositoInicial = Double.parseDouble(scanner.nextLine());

                Conta novaConta;

                if (tipo == 1) {
                    if (depositoInicial > 0) {
                        novaConta = new ContaCorrente(cliente, depositoInicial);
                    } else {
                        novaConta = new ContaCorrente(Cliente);
                    }else if (tipo == 2) {
                        if (depositoInicial > 0) {
                            novaConta = new ContaPoupanca(cliente, depositoInicial);
                        } else {
                            novaConta = new ContaPoupanca(cliente);
                        }
                    } else {
                        System.out.println("Tipo de conta inválido!");
                        return;
                    }
                    banco.adicionarConta(novaConta);

                } catch(ValorInvalidoException e){
                    System.out.println("Erro: " + e.getMessage());
                } catch(NumberFormatException e){
                    System.out.println("Erro: Valor inválido!");
                }

            }
            private static void realizarDeposito () {
                try {
                    System.out.println("\n--- DEPOSITAR ---");
                    System.out.println("Número da conta: ");
                    int numeroConta = Integer.parseInt(scanner.nextLine());

                    Conta conta = banco.buscarConta(numeroConta);

                    System.out.print("Valor a depositar: R$ ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    conta.depositar(valor);

                } catch (ContaInvalidaExeption | ValorInvalidoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor inválido!");
                }
            }
            private static void realizarSaque () {
                try {
                    System.out.println("\n--- SACAR ---");
                    System.out.println("Número da Conta: ");
                    int numeroConta = Integer.parseInt(scanner.nextLine());

                    Conta conta = banco.buscarConta(numeroConta);
                    System.out.println("Valor a sacar: R$ ");
                    double valor = Double.parseDouble(scanner.nextLine());

                    conta.sacar(valor);
                } catch (ContaInvalidaExeption | ValorInvalidoException | SaldoInsuficienteException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor inválido!");
                }
            }
            private static void realiazarTransferencia () {
                try {
                    System.out.println("\n--- TRANSFERIR ---");
                    System.out.print("Número da conta de origem: ");
                    int numeroOrigem = Integer.parseInt(scanner.nextLine());

                    Conta contaOrigem = banco.buscarConta(numeroOrigem);

                    System.out.print("Número da conta de destino: ");
                    int numeroDestino = Integer.parseInt(scanner.nextLine());

                    Conta contaDestino = banco.buscarConta(numeroDestino);

                    System.out.print("Valor a transferir: R$ ");
                    double valor = Double.parseDouble(scanner.nextLine());

                    contaOrigem.transferir(valor, contaDestino);

                } catch (ContaInvalidaException | ValorInvalidoException | SaldoInsuficienteException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Valor inválido!");
                }
            }

            private static void cobrarTaxaManutencao () {
                try {
                    System.out.println("\n--- COBRAR TAXA DE MANUTENÇÃO ---");
                    System.out.print("Número da conta corrente: ");
                    int numeroConta = Integer.parseInt(scanner.nextLine());

                    Conta conta = banco.buscarConta(numeroConta);

                    if (conta instanceof ContaCorrente) {
                        ContaCorrente corrente = (ContaCorrente) conta;
                        corrente.cobrarTaxaManutencao();
                    } else {
                        System.out.println("Erro: Esta operação é válida apenas para Contas Corrente!");
                    }

                } catch (ContaInvalidaException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Número de conta inválido!");
                }
            }

            private static void exibirRelatorio() {
                banco.exibirRelatorio();
            }

            private static void pausar() {
                System.out.print("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }
}