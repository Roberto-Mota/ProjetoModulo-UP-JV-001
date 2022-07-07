import cliente.Cliente;
import cliente.ClientePessoaJuridica;
import conta.Conta;
import conta.TipoConta;

public class Aplicacao {
    public static void main(String[] args) throws Exception {
        
        Cliente clienteCliente = new ClientePessoaJuridica("teste", "cnpj");

        Conta conta = Conta.abrirConta(00000, 00000, clienteCliente, TipoConta.CORRENTE);

        conta.investir(100.00);
    }
}
