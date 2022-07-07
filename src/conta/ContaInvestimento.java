package conta;

import cliente.Cliente;

public class ContaInvestimento extends Conta{
    private ContaInvestimento(Integer agencia, Integer numero, Cliente cliente) {
        super(agencia, numero, cliente);
        this.setTipoConta(TipoConta.INVESTIMENTO);
    }

    public static Conta abrirContaInvestimento(Integer agencia, Integer numero, Cliente cliente) {
        return new ContaInvestimento(agencia, numero, cliente);
    }
}
