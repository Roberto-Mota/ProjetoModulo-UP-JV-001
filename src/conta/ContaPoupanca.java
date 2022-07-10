package conta;

import java.math.BigDecimal;

import cliente.Cliente;

public class ContaPoupanca extends Conta {


    private ContaPoupanca(Integer agencia, Integer numero, Cliente cliente) {
        super(agencia, numero, cliente);
        this.setTipoConta(TipoConta.POUPANCA);
    }

    public static Conta abrirContaPoupanca(Integer agencia, Integer numero, Cliente cliente) {
        return new ContaPoupanca(agencia, numero, cliente);
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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
