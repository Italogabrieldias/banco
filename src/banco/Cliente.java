package banco;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public void Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = "";
        this.telefone = "";
    }

    public void Banco(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
    public String exibirDetalhes () {
        return String.format( "Nome: %s\nCPF: %s\nEndereço: %s\nTelefone: %s",
                nome, cpf,
                endereco.isEmpty() ? "Não informado" : endereco,
                telefone.isEmpty() ? "Não informado" : telefone
        );
    }
}

