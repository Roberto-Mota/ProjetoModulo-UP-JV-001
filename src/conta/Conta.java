package conta;
// conta, sacar, depositar, transferência, investir

import java.math.BigDecimal;

import cliente.Cliente;
import cliente.ClientePessoaJuridica;

public class Conta {
    protected BigDecimal saldo;
    private int agencia;
    private int numero;
    private Cliente cliente;
    private static int total = 0;
    private static BigDecimal juros;

   
    protected Conta(int agencia, int numero, Cliente cliente){
        Conta.total++;
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
    }

    public Conta abrirConta(int agencia, int numero, Cliente cliente) {
       return new Conta(agencia, numero, cliente);
    }

    public Boolean validarConta(Integer agencia, int numero, Cliente cliente) {
        if (agencia > 0 && numero > 0 && cliente != null) {
            return true;
        } else {
            return false;
        }
    }

    public void sacar(BigDecimal valor) {
        this.saldo.subtract(valor);
    }
    
    public void depositar(BigDecimal valor) {
        this.saldo.add(valor);
    }

    public void transferencia(Conta destino, BigDecimal valor) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void investir(BigDecimal valor) {
        if (this.cliente instanceof ClientePessoaJuridica) {
            Double valorDouble = valor.doubleValue();
            //this.saldo += (valor (juros + 0.02))
        } //else
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Conta.total = total;
    }

    public static BigDecimal getJuros() {
        return juros;
    }

    public static void setJuros(BigDecimal juros) {
        Conta.juros = juros;
    }

}