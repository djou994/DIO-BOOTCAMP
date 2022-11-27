package br.com.java.services;

import br.com.java.entities.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Operacoes {

    Banco banco = new Banco();

    public static void depositoInicial(Conta cc, Conta poupanca) {
        System.out.println("Deseja realizar um deposito? (S/N)");
        String isDeposito = new Scanner(System.in).nextLine();
        if (isDeposito.equalsIgnoreCase("S")) {
            System.out.println("Qual o tipo da conta? (C/P)");
            String tipoConta = new Scanner(System.in).nextLine();
            if (tipoConta.equalsIgnoreCase("C")) {
                System.out.println("Informe o valor do deposito: ");
                double valor = Double.parseDouble(new Scanner(System.in).nextLine());
                cc.depositar(valor);
            } else {
                double valor = Double.parseDouble(new Scanner(System.in).nextLine());
                poupanca.depositar(valor);
            }
        }
    }

    private static void addConta(Banco banco, Conta cc, Conta poupanca) {
        if (banco.getContas() == null)
            banco.setContas(new ArrayList<>());
        banco.getContas().add(cc);
        banco.getContas().add(poupanca);
    }

    public void criarConta() {
        Cliente cliente = new Cliente();
        System.out.println("Informe o nome do cliente: ");
        String nome = new Scanner(System.in).nextLine();
        cliente.setNome(nome);

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);
        addConta(banco, cc, poupanca);

        Operacoes.depositoInicial(cc, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }

    public void verSaldo() {
        System.out.println("Informe o Nº da conta: ");
        int nrConta = Integer.parseInt(new Scanner(System.in).nextLine());
        Optional<Conta> c = banco.getContas().stream().filter(conta -> conta.getNrConta() == nrConta).findAny();
        c.ifPresent(IConta::imprimirExtrato);
    }

    public void depositar() {
        System.out.println("Informe o Nº da conta: ");
        int nrConta = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Informe o valor do deposito: ");
        double valor = Double.parseDouble(new Scanner(System.in).nextLine());
        Optional<Conta> c = banco.getContas().stream().filter(conta -> conta.getNrConta() == nrConta).findAny();
        c.ifPresent(conta -> {
            conta.depositar(valor);
        });
    }

    public void listarContas() {
        banco.listaContas();
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
