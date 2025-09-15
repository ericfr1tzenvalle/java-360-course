/*
 * Demonstração de estruturas de seleção em Java
 * Curso Java 360 - If, If-Else, Switch, Switch Expressions e Operador Ternário
 *
 * Aborda:
 *  - If e If-Else: testes condicionais simples e aninhados
 *  - Switch tradicional: somente para valores discretos (int, char, String, enums)
 *      * Não é possível usar intervalos ou tipos double/long
 *  - Switch Expression: permite atribuição de valor diretamente
 *  - Operador ternário: forma compacta de if-else para atribuições simples
 */
package com.ericfr1tzenvalle.java.course.JavaCORE;

import java.util.Scanner;

public class EstruturasSelecao {
    public static void main(String[] args) {

        // -------------------------
        // EXEMPLO 1: IF / IF-ELSE
        // -------------------------
        // Estrutura condicional para classificar idade
        int idade = 18;
        if (idade < 18) {
            System.out.println("Menor de idade");
        } else if (idade >= 18 && idade < 65) {
            System.out.println("Adulto");
        } else {
            System.out.println("Idoso");
        }

        // -------------------------
        // EXERCÍCIO 1: Teste de paridade
        // -------------------------
        // Verifica se um número é par ou ímpar e altera seu valor
        Scanner sc = new Scanner(System.in);
        int x = 10;
        if (x % 2 == 0) { // % é o operador módulo, retorna o resto da divisão
            x += 5;        // se for par, soma 5
        } else {
            x *= 2;        // se for ímpar, multiplica por 2
        }
        System.out.println("O valor de x: " + x);

        // -------------------------
        // EXERCÍCIO 2: Cálculo de multa
        // -------------------------
        // Simula um cálculo de multa baseado na velocidade
        int permitida = 80;   // velocidade permitida
        int atual = 90;       // velocidade atual
        int considerada;      // velocidade considerada para multa
        int multa;            // valor da multa

        if (permitida < atual) { // se ultrapassou a velocidade
            if (permitida < 100) { 
                considerada = atual + 7; // acrescente 7 km/h se limite < 100
            } else {
                considerada = atual + (int) (atual * 0.1); // 10% a mais se limite >= 100
            }

            int diff = considerada - permitida; // diferença entre considerada e limite
            multa = diff * 10;                  // cada km acima = R$10

        } else {
            multa = 0; // sem excesso, sem multa
        }
        System.out.println("Valor multa: R$" + multa);

        // -------------------------
        // EXERCÍCIO 3: SWITCH TRADICIONAL
        // -------------------------
        // Avalia o dia da semana pelo número (1=domingo, 7=sábado)
        int diaSemana = 3;
        switch (diaSemana) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda-feira");
                break;
            case 3:
                System.out.println("Terça-feira");
                break;
            case 4:
                System.out.println("Quarta-feira");
                break;
            case 5:
                System.out.println("Quinta-feira");
                break;
            case 6:
                System.out.println("Sexta-feira");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Dia inválido");
                break;
        }

        // -------------------------
        // SWITCH EXPRESSION (Java 14+)
        // -------------------------
        // Permite atribuir o resultado diretamente a uma variável
        String tipoDia = switch (diaSemana) {
            case 1, 7 -> "Fim de semana";     // caso 1 ou 7
            case 2, 3, 4, 5, 6 -> "Dia útil"; // caso 2-6
            default -> "Inválido";            // caso padrão
        };
        System.out.println("Tipo de dia: " + tipoDia);

        // -------------------------
        // OPERADOR TERNÁRIO
        // -------------------------
        // Forma compacta de if-else basicamente
        int age = 18;
        String maior = age >= 18 ? "Maior de idade" : "Menor de idade";
        // condição ? verdadeiro : falso
        System.out.println(maior);

        // -------------------------
        // OBSERVAÇÕES FINAIS
        // -------------------------
        // - If-Else é útil para condições complexas e intervalos
        // - Switch é melhor para múltiplos valores discretos
        // - Switch Expression permite atribuição direta e casos combinados
        // - Operador ternário reduz linhas quando a decisão é simples
    }
}
