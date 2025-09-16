package com.ericfr1tzenvalle.java.course.javaOO;

/**
 * Curso Java 360: Conceitos fundamentais de Orientação a Objetos em Java.
 *
 * - Classe: é a definição de um tipo. Contém atributos (dados) e métodos (operações).
 * - Objeto: é uma instância concreta de uma classe, criada em tempo de execução.
 * - Instanciação: processo de criação de um objeto a partir de uma classe, usando o operador 'new'.
 * - Atributos: variáveis que descrevem o estado de um objeto.
 * - Métodos: funções que descrevem o comportamento do objeto.
 *
 * Memória:
 * - Variáveis de referência (ex.: Conta conta1) são armazenadas na Stack.
 * - Objetos criados com 'new' são armazenados na Heap.
 * - O Garbage Collector é responsável por liberar da Heap os objetos que não possuem mais referência.
 */
public class ClasseObjeto {

    public static void main(String[] args) {
        Conta conta1 = new Conta();
        conta1.numeroConta = "12345-6";
        conta1.donoConta = "Eric";
        conta1.saldo = 1000.0;

        Conta conta2 = new Conta();
        //Em um cenario real não atribuimos valores assim diretamente  
        conta2.numeroConta = "65432-1";
        conta2.donoConta = "Luísa";
        conta2.saldo = 500.0;

        conta1.depositar(200.0);
        conta1.sacar(150.0);

        System.out.println("Saldo final da conta de " + conta1.donoConta + ": " + conta1.saldo);
        System.out.println("Saldo final da conta de " + conta2.donoConta + ": " + conta2.saldo);

        // Observação:
        // - Quando o método main terminar, as referências conta1 e conta2 sairão do escopo (Stack).
        // - Se não houver mais nenhuma referência para os objetos, eles se tornam candidatos à coleta de lixo.
    }
}
/**
 * Classe que representa uma conta bancária.
 * Define atributos básicos como (número, dono, saldo) e operações (depositar, sacar).
 */
class Conta {
    //Geralmente aqui seriam privates com getter e setters  
    String numeroConta;
    String donoConta;
    double saldo;
    
    void depositar(double valor) {
        saldo += valor;
        System.out.println("Depositado R$" + valor + " na conta de " + donoConta);
    }

    void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Sacado R$" + valor + " da conta de " + donoConta);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
