package conta;

import cliente.Cliente;

public class ContaCorrente extends Conta {

    private ContaCorrente(Integer agencia, Integer numero, Cliente cliente) {
        super(agencia, numero, cliente);
        this.setTipoConta(TipoConta.CORRENTE);
    }

    public static ContaCorrente abrirContaCorrente(Integer agencia, Integer numero, Cliente cliente) {
        return new ContaCorrente(agencia, numero, cliente);
    }

    @Override
    public Boolean depositar(Double valor) {
        return super.depositar(valor);
    }

    @Override
    public Boolean investir(Double valor) {
        return super.investir(valor);
    }

    @Override
    public Boolean sacar(Double valor) {
        return super.sacar(valor);
    }

    @Override
    public Boolean transferencia(Conta destino, Double valor) {
        return super.transferencia(destino, valor);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
