import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean saida = false;
        byte opcao;

        Cliente cliente = new Cliente();
        cliente.setNome("Victor");

        Conta contaCorrente = new ContaCorrente(cliente);
        Conta contaPoupanca = new ContaPoupanca(cliente);

        contaCorrente.depositar(500);

        contaPoupanca.depositar(100);


        while (!saida){
            System.out.println("=== Banco Digital ===");
            System.out.println("1 - Saque | 2 - Depósito | 3 - Tranferência | 4 - Extrato | 0 - Sair");
            opcao = scan.nextByte();
            double valor;

            if (opcao == 1){
                System.out.println("Quantia a sacar: ");
                valor = scan.nextDouble();
                contaCorrente.sacar(valor);
            } else if (opcao == 2) {
                System.out.println("Quantia para depositar: ");
                valor = scan.nextDouble();
                contaCorrente.depositar(valor);
            } else if (opcao == 3) {
                System.out.println("Quantia a tranferir: ");
                valor = scan.nextDouble();
                contaCorrente.transferir(valor, contaPoupanca);
            } else if (opcao == 4) {
                contaCorrente.imprimirExtrato();
            } else if (opcao == 0) {
                System.out.println("Finalizando...");
                saida = true;
            } else {
                System.out.println("Opção Inválida!");
            }
        }
        contaPoupanca.imprimirExtrato();
    }
}
