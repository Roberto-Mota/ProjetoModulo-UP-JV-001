import java.util.Scanner;

import cliente.Cliente;
import cliente.ClientePessoaFisica;
import cliente.ClientePessoaJuridica;
import conta.Conta;
import conta.TipoConta;

public class Aplicacao {
    public static void main(String[] args) throws Exception {
        Boolean operando = true;
        while (operando) {
            Boolean cadastrandoCliente = true;
            Scanner scan = new Scanner(System.in);
            Cliente cliente = null;

            while (cadastrandoCliente) {
                int tipoPessoa = 0;
                String nome;
                String cadastro;
                System.out.println("Cadastrar novo cliente: ");
                Thread.sleep(1000);

                Boolean hasChosenTipoCliente = false;
                System.out.println("Escolha o tipo de cliente: ");
                while (!hasChosenTipoCliente) {
                    System.out.println("Digite 1 para Pessoa Jurídica");
                    System.out.println("Digite 2 para Pessoa Física");
                    String choice = scan.next();
                    if (Integer.valueOf(choice) == 1) {
                        System.out.println("Prosseguindo para cadastro de Pessoa Jurídica");
                        tipoPessoa = 1;
                        hasChosenTipoCliente = true;
                    } else if (Integer.valueOf(choice) == 2) {
                        System.out.println("Prosseguindo para cadastro de Pessoa Física");
                        tipoPessoa = 2;
                        hasChosenTipoCliente = true;
                    } else {
                        System.out.println("Opção inválida, por favor tente novamente:");
                    }
                }

                System.out.println("Digite o nome:");
                nome = scan.next();

                System.out.println("Digite o cnpj/cpf:");
                cadastro = scan.next();

                if (tipoPessoa == 1) {
                    cliente = new ClientePessoaJuridica(nome, cadastro);
                    cadastrandoCliente = false;
                } else if (tipoPessoa == 2) {
                    cliente = new ClientePessoaFisica(nome, cadastro);
                    cadastrandoCliente = false;
                }
            } // Término do cadastro do cliente.
            Boolean cadastrandoConta = true;
            while (cadastrandoConta) {
                TipoConta tipoConta = null;
   
                // Gerar um número aleatório para agência e Número de Conta
                Integer agencia = (int)Math.floor(Math.random()*(9999-1000+1)+1000);
                Integer numeroConta = (int)Math.floor(Math.random()*(9999-1000+1)+1000);

                Boolean hasChosenAccountType = false;
                while (!hasChosenAccountType) {
                    System.out.println("Digite o número para selecionar o tipo de conta desejada:");
                    System.out.println("1 -> Corrente\n2 -> Poupança (Apenas para pessoas físicas)\n3 -> Investimento");
                    String opcao = scan.next();
                    Integer opcaoInteger = 0;
                    try {
                        opcaoInteger = Integer.parseInt(opcao);
                        if(opcaoInteger == 2 && cliente instanceof ClientePessoaJuridica) {
                            System.out.println("Pessoas Jurídicas não podem abrir conta do tipo poupança");
                        }
                        else if (opcaoInteger == 1) {
                            tipoConta = TipoConta.CORRENTE;
                            hasChosenAccountType = true;
                        } else if (opcaoInteger == 2) {
                            tipoConta = TipoConta.POUPANCA;
                            hasChosenAccountType = true;
                        } else if (opcaoInteger == 3) {
                            tipoConta = TipoConta.INVESTIMENTO;
                            hasChosenAccountType = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("A opção deve ser um dígito entre 1 e 3");
                    }
                    // Gerar um número aleatório para agência e Número de Conta

                }
                Conta conta = Conta.abrirConta(agencia, numeroConta, cliente, tipoConta);
                System.out.println(conta);
            } // Término do cadastro da conta
        }
    }
}
