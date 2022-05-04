package com.dio.bancodigital;

public class Main {

    public static void main(String[] args) {
        Cliente venilton = new Cliente("Venilton", "11133344455");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.depositar(100);
        cc.transferir(100, poupanca);
        System.out.println();

        cc.imprimirExtrato();
        System.out.println();

        poupanca.imprimirExtrato();
        System.out.println();

        Endereco endereco = new Endereco("Pernambuco", "Paulista", "Janga", "Rua tal", 12);
        Endereco endereco2 = new Endereco("Pernambuco", "Recife", "Várzea", "Rua tal", 13);

        Cliente nelson = new Cliente("Nelson", "22233344455", "nelson@teste.com", "81900000000", endereco);
        Cliente simone = new Cliente("Simone", "44455566677", "simone@teste.com", "81900000001", endereco2);

        Conta nelsonContaCorrente = new ContaCorrente(nelson, 50d, 439);
        Conta nelsonContaPoupanca = new ContaPoupanca(nelson, 250.0);

        nelsonContaCorrente.imprimirExtrato();
        System.out.println();

        // valor maior que o saldo:
        nelsonContaCorrente.transferir(80.0, nelsonContaPoupanca);

        nelsonContaCorrente.transferir(20.0, nelsonContaPoupanca);
        System.out.println();

        nelsonContaCorrente.imprimirExtrato();
        System.out.println();

        Conta simoneContaCorrente = new ContaCorrente(simone);
        Conta simoneContaPoupanca = new ContaPoupanca(simone, 500.0, 228);

        simoneContaCorrente.imprimirExtrato();
        System.out.println();

        // depositando valor invalido:
        simoneContaCorrente.depositar(-20.0);
        System.out.println();
        
        simoneContaCorrente.depositar(200.0);
        
        simoneContaCorrente.imprimirExtrato();
        System.out.println();
        
        simoneContaCorrente.sacar(0d);
        System.out.println();
        
        simoneContaPoupanca.imprimirExtrato();
        System.out.println();
        
        simoneContaPoupanca.transferir(500d, simoneContaCorrente);
        
        simoneContaPoupanca.imprimirExtrato();
        System.out.println();
        
        simoneContaCorrente.imprimirExtrato();
        System.out.println();
    }
}