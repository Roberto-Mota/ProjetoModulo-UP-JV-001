package conta;

import java.math.BigDecimal;

import cliente.Cliente;

public class ContaCorrente extends Conta {

    private ContaCorrente(int agencia, int numero, Cliente cliente) {
        super(agencia, numero, cliente);
    }

    @Override
    public Conta abrirConta(int agencia, int numero, Cliente cliente) {
        return new ContaCorrente(agencia, numero, cliente);
    }

    @Override
    public void depositar(BigDecimal valor) {
        super.depositar(valor);
    }

    @Override
    public void investir(BigDecimal valor) {
        super.investir(valor);
    }

    @Override
    public void sacar(BigDecimal valor) {
        super.sacar(valor);
    }

    @Override
    public void transferencia(Conta destino, BigDecimal valor) {
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
