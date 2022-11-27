import br.com.java.services.Operacoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes();
        boolean continua = true;
        while (continua) {
            System.out.printf("Bem vindo, %nEscolha a operação desejada: " +
                    "%n1: Criar conta " +
                    "%n2: Listar Contas " +
                    "%n3: Depositar " +
                    "%n4: Ver Saldo %n");
            int opcao = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (opcao) {
                case 1:
                    operacoes.criarConta();
                    break;
                case 2:
                    operacoes.listarContas();
                    break;
                case 3:
                    operacoes.depositar();
                    break;
                case 4:
                    operacoes.verSaldo();
            }
            System.out.println("Deseja realizar uma nova operação? (S/N)");
            String fim = new Scanner(System.in).nextLine();
            if (fim.equalsIgnoreCase("N")) {
                continua = false;
            }
        }

    }


}
