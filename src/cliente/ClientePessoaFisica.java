package cliente;

public class ClientePessoaFisica extends Cliente {

    String cpf;

    public ClientePessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

}
