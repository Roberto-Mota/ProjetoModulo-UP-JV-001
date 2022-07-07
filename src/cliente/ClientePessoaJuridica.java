package cliente;

public class ClientePessoaJuridica extends Cliente {
    
    String cnpj;

    public ClientePessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

}
