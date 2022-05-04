package com.dio.bancodigital;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public ContaCorrente(Cliente cliente, double saldo) {
        super(cliente, saldo);
    }
    
    public ContaCorrente(Cliente cliente, double saldo, int agencia) {
        super(cliente, saldo, agencia);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}