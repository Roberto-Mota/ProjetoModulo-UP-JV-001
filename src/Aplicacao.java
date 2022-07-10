import java.util.Scanner;

import cliente.Cliente;
import cliente.ClientePessoaFisica;
import cliente.ClientePessoaJuridica;
import conta.Conta;
import conta.ContaCorrente;
import conta.TipoConta;

public class Aplicacao {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Boolean criandoContaCliente = true;

        Cliente cliente = null;
        Conta contaUser = null;
        // Gerar um número aleatório para agência e Número de Conta
        Integer agencia = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
        Integer numeroConta = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
        // Criação de uma conta dummy para realização de transferência
        Cliente clienteDummy = new ClientePessoaFisica("Nuno Passos", "000111222333");
        ContaCorrente contaDummy = (ContaCorrente) Conta.abrirConta(agencia, numeroConta, clienteDummy,
                TipoConta.CORRENTE);

        while (criandoContaCliente) {
            Boolean cadastrandoCliente = true;
            while (cadastrandoCliente) {
                int tipoPessoa = 0;
                String nome;
                String cadastro;
                System.out.println("Cadastrar novo cliente: ");
                Thread.sleep(1000);

                Boolean hasChosenTipoCliente = false;
                System.out.println("Escolha o tipo de cliente: ");
                while (!hasChosenTipoCliente) {
                    System.out.println("Digite o número para selecionar o tipo de cliente: ");
                    System.out.println("1 -> para Pessoa Jurídica");
                    System.out.println("2 -> para Pessoa Física");
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
                Boolean hasChosenAccountType = false;
                while (!hasChosenAccountType) {
                    System.out.println("Digite o número para selecionar o tipo de conta desejada:");
                    System.out.println("1 -> Corrente\n2 -> Poupança (Apenas para pessoas físicas)\n3 -> Investimento");
                    String opcao = scan.next();
                    Integer opcaoInteger = 0;
                    try {
                        opcaoInteger = Integer.parseInt(opcao);
                        if (opcaoInteger == 2 && cliente instanceof ClientePessoaJuridica) {
                            System.out.println("Pessoas Jurídicas não podem abrir conta do tipo poupança");
                        } else if (opcaoInteger == 1) {
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
                contaUser = Conta.abrirConta(agencia, numeroConta, cliente, tipoConta);
                System.out.println(contaUser);
                cadastrandoConta = false;
                criandoContaCliente = false;
            } // Término do cadastro da conta

        }
        // Inicio das operações com a conta

        Boolean operando = true;
        while (operando) {

            // Qual operação deseja fazer?
            System.out.println("Qual operação deseja fazer?");
            System.out.println(
                    "1 -> Sacar\n2 -> Depositar\n3 -> Transferencia\n4 -> Investir\n5 -> Encerrar atendimento");

            
            // Demonstra ser importante o tratamento do Input do usuário.
            String opcao = scan.next();
            Integer opcaoInteger = Integer.parseInt(opcao);

            Double valor;
            Boolean isSuccessful = false;
            String input;

            switch (opcaoInteger) {
                case 1: // Sacar
                    System.out.println("Opção de saque selecionada");
                    System.out.println("Digite o valor desejado para saque:");
                    while (!isSuccessful) {
                        input = scan.next();
                        try {
                            valor = Double.valueOf(input);
                            if (contaUser.sacar(valor)) {
                                isSuccessful = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor inválido, por favor tente novamente");
                            // scan = scan.reset();
                        }
                    }
                    break;

                case 2: // Depositar
                    System.out.println("Opção de depósito selecionada");
                    System.out.println("Digite o valor desejado para depósito:");
                    while (!isSuccessful) {
                        input = scan.next();
                        try {
                            valor = Double.valueOf(input);
                            if (contaUser.depositar(valor)) {
                                isSuccessful = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor inválido");
                        }
                    }
                    break;

                case 3: // Transferência
                    System.out.println("Opção de transferencia selecionada");
                    System.out.println("Digite o valor desejado para transferencia:");
                    System.out
                            .println("(Há apenas uma conta destino para exemplo e o valor será transferido para ela)");
                    while (!isSuccessful) {
                        input = scan.next();
                        try {
                            valor = Double.valueOf(input);
                            if (contaUser.transferencia(contaDummy, valor)) {
                                isSuccessful = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor inválido");
                        }
                    }
                    break;

                case 4: // Investir
                    System.out.println("Opção de investimento selecionada");
                    System.out.println("Digite o valor desejado para investir:");
                    while (!isSuccessful) {
                        input = scan.next();
                        try {
                            valor = Double.valueOf(input);
                            if (contaUser.investir(valor)) {
                                isSuccessful = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor inválido");
                        }
                    }

                    break;
                case 5: // Encerrar Atendimento
                    System.out.println("Opção de encerrar atendimento selecionada, tenha um bom dia");
                    operando = false;
                    break;

                default:
                    System.out.println("Opcao inválida, por favor tente novamente");
                    break;
            }
        }
        scan.close();
    }
}
