# Sistema Bancário em Java - Estudo de POO

Um sistema bancário completo desenvolvido em Java para demonstrar os quatro pilares fundamentais da Programação Orientada a Objetos (POO).

## 🎯 Objetivo

Este projeto foi criado com fins educacionais para demonstrar na prática os conceitos de:
- **Encapsulamento**
- **Herança**
- **Polimorfismo**
- **Abstração**

## 🏗️ Estrutura do Projeto

```
src/
├── Main.java                    # Classe principal com interface CLI
├── banco/
│   ├── Cliente.java            # Representa um cliente do banco
│   ├── Conta.java              # Classe abstrata (base para contas)
│   ├── ContaCorrente.java      # Herda de Conta
│   ├── ContaPoupanca.java      # Herda de Conta
│   └── Banco.java              # Gerencia contas e clientes
└── exceptions/
    ├── SaldoInsuficienteException.java
    ├── ContaInvalidaException.java
    └── ValorInvalidoException.java
```

## 📚 Conceitos de POO Aplicados

### 1. Encapsulamento

**Onde está aplicado:**
- Classe `Cliente`: atributos privados (nome, cpf, endereço, telefone) com getters e setters
- Classe `Conta`: atributo `saldo` é privado, só pode ser modificado através de métodos públicos
- Classe `Banco`: listas de contas e clientes são privadas

**Exemplo:**
```java
public class Cliente {
    private String nome;     // Encapsulado
    private String cpf;      // Encapsulado
    
    public String getNome() {  // Acesso controlado
        return nome;
    }
}
```

**Por que é importante:** Protege os dados internos da classe e garante que sejam modificados apenas de forma controlada.

### 2. Herança

**Onde está aplicado:**
- `ContaCorrente` e `ContaPoupanca` herdam de `Conta`
- Ambas reutilizam código da classe pai (depositar, transferir, etc.)
- Cada uma adiciona características específicas

**Exemplo:**
```java
public abstract class Conta {
    // Métodos e atributos comuns
}

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;  // Atributo específico
}

public class ContaPoupanca extends Conta {
    private double taxaRendimento;  // Atributo específico
}
```

**Por que é importante:** Evita duplicação de código e cria uma hierarquia lógica entre as classes.

### 3. Polimorfismo

**Onde está aplicado:**
- Método `podeSacar()`: comportamento diferente em cada tipo de conta
- Método `getTipoConta()`: retorna descrições diferentes
- Método `exibirInformacoesEspecificas()`: cada conta exibe suas informações únicas
- Lista `List<Conta>` no Banco pode armazenar qualquer tipo de conta

**Exemplo:**
```java
// Na classe Conta (abstrato)
protected abstract boolean podeSacar(double valor);

// Na ContaCorrente
@Override
protected boolean podeSacar(double valor) {
    return (getSaldo() + limiteChequeEspecial) >= valor;
}

// Na ContaPoupanca
@Override
protected boolean podeSacar(double valor) {
    return getSaldo() >= valor;
}
```

**Por que é importante:** Permite que objetos de diferentes classes sejam tratados de forma uniforme, com comportamentos específicos.

### 4. Abstração

**Onde está aplicado:**
- Classe `Conta` é abstrata - não pode ser instanciada diretamente
- Métodos abstratos `podeSacar()` e `getTipoConta()` devem ser implementados pelas subclasses
- Esconde detalhes de implementação, expondo apenas o necessário

**Exemplo:**
```java
public abstract class Conta {
    protected abstract boolean podeSacar(double valor);
    
    public void sacar(double valor) throws ... {
        if (!podeSacar(valor)) {  // Usa o método abstrato
            throw new SaldoInsuficienteException(...);
        }
        // ...
    }
}
```

**Por que é importante:** Define um contrato que as subclasses devem seguir, garantindo consistência.

## 🚀 Como Executar

1. Compile o projeto:
```bash
javac -d . src/Main.java src/banco/*.java src/exceptions/*.java
```

2. Execute o programa:
```bash
java Main
```

## 💡 Funcionalidades

- ✅ Criar contas (Corrente ou Poupança)
- ✅ Depositar valores
- ✅ Sacar valores (com validações)
- ✅ Transferir entre contas
- ✅ Consultar extratos
- ✅ Listar todas as contas
- ✅ Aplicar rendimento (Poupança)
- ✅ Cobrar taxa de manutenção (Corrente)
- ✅ Relatório geral do banco

## 🎓 Recursos Adicionais Demonstrados

### Tratamento de Exceções Customizadas
- `SaldoInsuficienteException`: quando não há saldo para operação
- `ContaInvalidaException`: quando conta não existe
- `ValorInvalidoException`: quando valor é inválido (negativo ou zero)

### Boas Práticas
- Uso de constantes (`TAXA_MANUTENCAO`, `TAXA_RENDIMENTO_PADRAO`)
- Métodos privados e protected quando apropriado
- Sobrescrita de `toString()` para representação textual
- Validações em construtores e métodos
- Uso de listas genéricas (`List<Conta>`, `List<Cliente>`)

## 📖 Conceitos Extras

### Instanceof e Casting
```java
if (conta instanceof ContaPoupanca) {
    ContaPoupanca poupanca = (ContaPoupanca) conta;
    poupanca.aplicarRendimento();
}
```

### Sobrecarga de Construtores
Várias formas de criar objetos da mesma classe:
```java
new ContaCorrente(cliente);
new ContaCorrente(cliente, depositoInicial);
new ContaCorrente(cliente, depositoInicial, limite);
```

## 🎯 Exercícios Sugeridos

1. Adicionar um novo tipo de conta (ex: ContaSalario)
2. Implementar histórico de transações
3. Adicionar autenticação com senha
4. Criar relatórios mais detalhados
5. Implementar persistência de dados em arquivos
6. Adicionar limites diários de saque
7. Implementar taxas diferenciadas por tipo de operação

## 📝 Licença

Projeto educacional - livre para uso e modificação.
