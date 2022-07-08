package conta;
// conta, sacar, depositar, transferência, investir

import java.math.BigDecimal;
import java.security.InvalidParameterException;

import cliente.Cliente;
import cliente.ClientePessoaJuridica;
import exceptions.InvalidClientTypeException;

public abstract class Conta {
    protected BigDecimal saldo = new BigDecimal(120);
    private Integer agencia;
    private Integer numero;
    private Cliente cliente;
    private TipoConta tipoConta;
    private static Integer total = 0;
    private static Double jurosInvestimento = 10.00; // Porcentagem

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public static void setTotal(Integer total) {
        Conta.total = total;
    }

    protected Conta(Integer agencia, Integer numero, Cliente cliente) {
        Conta.total++;
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
    }

    public static Conta abrirConta(Integer agencia, Integer numero, Cliente cliente, TipoConta TipoConta)
            throws InvalidParameterException, InvalidClientTypeException {
        switch (TipoConta) {
            case CORRENTE:
                return ContaCorrente.abrirContaCorrente(agencia, numero, cliente);

            case INVESTIMENTO:
                return ContaInvestimento.abrirContaInvestimento(agencia, numero, cliente);

            case POUPANCA:
                if (cliente instanceof ClientePessoaJuridica) {
                    throw new InvalidClientTypeException(
                            "O tipo de cliente é inválido para o tipo de conta requisitado.");
                } else {
                    return ContaPoupanca.abrirContaPoupanca(agencia, numero, cliente);
                }

            default:
                throw new InvalidParameterException();
        }
    }

    public Boolean validarConta(Integer agencia, Integer numero, Cliente cliente) {
        if (agencia > 0 && numero > 0 && cliente != null) {
            return true;
        } else {
            return false;
        }
    }

    public void sacar(Double valor) {
        Double saque = valor;
        if (this.cliente instanceof ClientePessoaJuridica) {
            valor = valor * 1.005;
        }
        if (valor > this.saldo.doubleValue()) {
            System.out.println("Valor da movimentação excede saldo disponível, por favor tente outro valor");
        } else {
            this.setSaldo(this.saldo.subtract(BigDecimal.valueOf(valor)));
            System.out.printf("R$%.2f sacado da conta, saldo atual: R$%.2f", saque, this.saldo);
        }
    }

    public void depositar(Double valor) {
        this.setSaldo(this.saldo.add(BigDecimal.valueOf(valor)));
    }

    public void transferencia(Conta destino, Double valor) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void investir(Double valorAplicado) { // Pj tem +2% nos rendimentos de conta investimento
        Double valor = valorAplicado;
        if (valorAplicado > this.saldo.doubleValue()) {
            System.out.println("Seu saldo é insuficiente para realizar esse investimento.");
        } else {
            if (this.cliente instanceof ClientePessoaJuridica && this.tipoConta == TipoConta.INVESTIMENTO) {
                jurosInvestimento += 2;
            }
            try {
                System.out.println("Valor investido...");
                Thread.sleep(2000);
                System.out.println("... 2 meses depois ...");
                Thread.sleep(2000);
                System.out.println("... 4 meses depois.");
                Thread.sleep(1000);
                valor = valor * ((jurosInvestimento) / 100);
                this.setSaldo(BigDecimal.valueOf(valor));
                System.out.printf("Parabéns pelo investimento.\nAplicação: R$%.2f\nJuros: %.2f%%\nLucro: R$%.2f",
                        valorAplicado, Conta.getJurosInvestimento(), valor);

            } catch (InterruptedException ex) {
                System.out.println("Investimento interrompido");
            }
        }

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

    public static Double getJurosInvestimento() {
        return Conta.jurosInvestimento;
    }

    public static void setJuros(Double juros) {
        Conta.jurosInvestimento = juros;
    }

}