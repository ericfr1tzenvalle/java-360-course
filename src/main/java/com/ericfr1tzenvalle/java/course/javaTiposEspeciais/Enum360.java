/*
 * Demonstração de Enums em Java
 * Curso Java 360 - Enumerações, Métodos e Construtores
 *
 * Aborda:
 * - Enums como listas fixas de constantes (public static final implícitos)
 * - Garantia de segurança em tempo de compilação
 * - Enums são classes especiais: não podem ser instanciados diretamente nem estendidos (final)
 * - Possibilidade de adicionar métodos, atributos e construtores privados
 * - Implementação de interfaces por enums
 * - Uso em switch expressions
 * - Import estático para facilitar legibilidade
 * - Métodos utilitários como values() e valueOf()
 */

package com.ericfr1tzenvalle.java.course.javaTiposEspeciais;
import static com.ericfr1tzenvalle.java.course.javaTiposEspeciais.Enum360.DiasDaSemana.*;

public class Enum360 {
    public static void main(String[] args) {
        // Exemplo 1:
        DiasDaSemana d1 = SEGUNDA; //Possivel com import static
        System.out.println("Dia: " + d1);
        for (int i = 0; i < 7; i++) {
            d1 = d1.getNext();
            System.out.println("Dia: " + d1);
        }

        // Exemplo 2: Operações matemáticas 
        Operacoes op = Operacoes.MULTIPLICACAO;
        System.out.println("\nCálculos:");
        System.out.println("2 " + op + " 5 = " + op.calculate(2, 5));
    }


    private static enum Operacoes {
        SOMA('+'), 
        SUBTRACAO('-'),
        DIVISAO('/'), 
        MULTIPLICACAO('x');

        private final char simbolo;

        private Operacoes(char simbolo) {
            this.simbolo = simbolo;
        }

        @Override
        public String toString() {
            return String.valueOf(simbolo);
        }

        public double calculate(double v1, double v2) {
            return switch (this) {
                case SOMA -> v1 + v2;
                case SUBTRACAO -> v1 - v2;
                case DIVISAO -> v1 / v2;
                case MULTIPLICACAO -> v1 * v2;
            };
        }
    }

    
    
    public static enum DiasDaSemana {
        SEGUNDA("TERÇA"),
        TERCA("QUARTA"),
        QUARTA("QUINTA"),
        QUINTA("SEXTA"),
        SEXTA("SABADO"),
        SABADO("DOMINGO"),
        DOMINGO("SEGUNDA");

        private final String next;

        DiasDaSemana(String next) {
            this.next = next;
        }

        public DiasDaSemana getNext() {
            for (DiasDaSemana d : DiasDaSemana.values()) {
                if (this.next.equals(d.name())) {
                    return d;
                }
            }
            return null;
        }
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Enums em Java são tipos especiais usados para representar conjuntos fixos de constantes.
 * - Cada constante é public static final implicitamente, garantindo imutabilidade e segurança.
 * - Enums podem ter atributos, métodos e construtores privados, permitindo comportamentos associados.
 * - É possível sobrescrever métodos como toString() e criar lógicas customizadas em cada constante.
 * - São muito úteis em expressões switch, validações e regras de negócio bem definidas.
 * - Exemplo: enum Operacoes implementa cálculos matemáticos; enum DiasDaSemana percorre dias sequenciais.
 */
