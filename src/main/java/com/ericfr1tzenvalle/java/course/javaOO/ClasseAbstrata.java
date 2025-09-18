/*
 * Demonstração de Classes Abstratas em Java
 * Curso Java 360 - Classes e Métodos Abstratos
 *
 * Aborda:
 * - Classes abstratas como "DNA" para subclasses
 * - Métodos abstratos obrigam implementação pelas subclasses
 * - Métodos concretos podem ser reutilizados em subclasses
 * - Subclasses podem ter comportamentos específicos
 */
package com.ericfr1tzenvalle.java.course.javaOO;

public class ClasseAbstrata {

    public static void main(String[] args) {
        // Exercício 1: Conta Corrente
        Account c1 = new CheckingAccount(0.05);
        System.out.println("Saldo inicial Conta Corrente: " + c1.getBalance());
        c1.updateBalance();
        System.out.println("Saldo após atualização: " + c1.getBalance());
        System.out.println();

        // Exercício 2: Conta Poupança
        Account s1 = new SavingsAccount(2000);
        System.out.println("Saldo inicial Conta Poupança: " + s1.getBalance());
        s1.updateBalance();
        System.out.println("Saldo após atualização: " + s1.getBalance());
    }

    // Classe abstrata base
    private abstract static class Account {
        private double balance;

        public Account(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void updateBalance() {
            balance *= rate();
        }

        public abstract double rate();
    }

    // Subclasse concreta: Conta Corrente
    private static class CheckingAccount extends Account {
        private double rate;

        public CheckingAccount(double rate) {
            super(100); 
            this.rate = rate;
        }

        @Override
        public double rate() {
            return rate;
        }
    }

    // Subclasse concreta: Conta Poupança
    private static class SavingsAccount extends Account {

        public SavingsAccount(double balance) {
            super(balance);
        }

        @Override
        public double rate() {
            return 0.5;
        }
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Classes abstratas servem como modelos ou "DNA" para suas subclasses,
 *   definindo atributos e métodos que todas as subclasses devem possuir.
 *
 * - Uma classe abstrata **não pode ser instanciada diretamente**. 
 *   Ela existe para ser estendida, garantindo que a hierarquia de classes siga certas regras.
 *
 * - Métodos abstratos (declarados com `abstract`) **não possuem implementação** na superclasse. 
 *   Isso força as subclasses a fornecerem a lógica concreta desses métodos.
 *
 * - Métodos concretos dentro de classes abstratas podem ser reutilizados pelas subclasses,
 *   promovendo **reaproveitamento de código** e centralizando a lógica comum.
 *
 * - Polimorfismo: referências do tipo da superclasse abstrata podem apontar
 *   para objetos das subclasses. A JVM chamará o método correto em tempo de execução
 *   (ex.: `Account conta = new CheckingAccount(...)`).
 *
 * - Construtores: mesmo classes abstratas podem ter construtores. Eles são chamados
 *   quando a subclasse é instanciada, garantindo que os atributos da superclasse sejam inicializados.
 *
 * - Boas práticas:
 *   1. Use classes abstratas quando houver **comportamentos comuns**, mas algumas implementações
 *      só façam sentido em subclasses específicas.
 *   2. Evite colocar lógica complexa que dependa de detalhes da subclasse diretamente na superclasse.
 *   3. Combine classes abstratas com interfaces quando precisar definir contratos adicionais,
 *      permitindo múltipla "implementação" de comportamentos sem herança múltipla.
*/
