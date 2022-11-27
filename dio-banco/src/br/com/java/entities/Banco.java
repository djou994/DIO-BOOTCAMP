package br.com.java.entities;

import java.util.List;

public class Banco {

    private String nome;

    private List<Conta> contas;

    public void listaContas() {
        contas.forEach(conta -> {
            System.out.println("=== Contas ===");
            System.out.printf("Conta: %d%n", conta.nrConta);
            System.out.printf("Cliente: %s%n", conta.cliente.getNome());
        });
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
