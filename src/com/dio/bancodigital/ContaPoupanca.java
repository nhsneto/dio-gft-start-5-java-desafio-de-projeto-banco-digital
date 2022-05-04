package com.dio.bancodigital;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public ContaPoupanca(Cliente cliente, double saldo) {
        super(cliente, saldo);
    }
    
    public ContaPoupanca(Cliente cliente, double saldo, int agencia) {
        super(cliente, saldo, agencia);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupanca ===");
        super.imprimirInfosComuns();
    }
}