package com.ericfr1tzenvalle.java.course.javaOO;

/*
 * Demonstração de Interfaces em Java
 * Curso Java 360 - Conceitos de interfaces, contratos, métodos default, static e private
 *
 * Aborda:
 * - Conceito de interface: contrato que define métodos que a classe deve implementar
 * - Ocultação de implementação: não importa como, apenas que sabe executar
 * - Visibilidade implícita: métodos sempre públicos e abstratos
 * - Regras de sobrescrita: não se pode reduzir a visibilidade
 * - Atributos em interfaces viram constantes (public static final)
 * - Impossibilidade de instanciar interfaces diretamente
 * - Default methods, static methods e private methods em interfaces
 * - Diamond Problem e como resolver sobrescrevendo métodos
 */
public class Interfaces {

    public static void main(String[] args) {
        // Exercicio
        // login estático com credenciais fixas
        StaticLoginMethods sl = new StaticLoginMethods("Eric", "123");
        System.out.println("Login efetuado: " + sl.login("Eric", "123"));

        // login baseado em regra customizada (username == password)
        SameCredentialsLoginMethod scl = new SameCredentialsLoginMethod();
        System.out.println("Login efetuado: " + scl.login("Eric", "Eric"));

        // usando construtor para definir credenciais diferentes
        StaticLoginMethods s12 = new StaticLoginMethods("Jario", "123");
        System.out.println("Login efetuado: " + s12.login("Jario", "123"));
    }

    // Interface define o contrato de login
    private interface LoginMethod {
        boolean login(String username, String password);
    }

    // Implementação com credenciais privadas
    private static class StaticLoginMethods implements LoginMethod {
        private final String username;
        private final String password;

        public StaticLoginMethods() {
            this.username = "";
            this.password = "";
        }

        public StaticLoginMethods(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public boolean login(String username, String password) {
            return username.equals(this.username) && password.equals(this.password);
        }
    }

    // Implementação baseada em regra simples (username == password)
    private static class SameCredentialsLoginMethod implements LoginMethod {
        @Override
        public boolean login(String username, String password) {
            return username.equals(password);
        }
    }
}
