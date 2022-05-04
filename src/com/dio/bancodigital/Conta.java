package com.dio.bancodigital;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        agencia = Conta.AGENCIA_PADRAO;
        numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public Conta(Cliente cliente, double saldo) {
        agencia = Conta.AGENCIA_PADRAO;
        numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public Conta(Cliente cliente, double saldo, int agencia) {
        this.agencia = agencia;
        numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            valorInvalidoMensagem(valor);
        } else if (valor > saldo) {
            saldoInsuficienteMensagem(saldo);
        } else {
            saldo -= valor;
            return true;
        }

        return false;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0)
            valorInvalidoMensagem(valor);
        else
            saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (sacar(valor))
            contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format(" Numero: %d", numero));
        System.out.println(String.format("  Saldo: R$ %.2f", saldo));
    }

    private void valorInvalidoMensagem(double valor) {
        System.out.println("O valor informado " + valor + " é inválido.");
    }

    private void saldoInsuficienteMensagem(double saldo) {
        System.out.printf("Saldo insuficiente para saque. Seu saldo é R$ %.2f\n", saldo);
    }
}