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
    public void depositar(Double valor) {
        super.depositar(valor);
    }

    @Override
    public void investir(Double valor) {
        super.investir(valor);
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
    }

    @Override
    public void transferencia(Conta destino, Double valor) {
        super.transferencia(destino, valor);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
