/*
 * Demonstração de operadores em Java
 * Curso Java 360 - Operadores Aritméticos, Relacionais, Lógicos, Atribuição,
 * Precedência, Expressões complexas, Casting e uso de Scanner em exemplos práticos.
 */
package com.ericfr1tzenvalle.java.course.JavaCORE;

import java.util.Scanner;

public class OperadoresJava {
    public static void main(String[] args) {
        // OPERADORES ARITMÉTICOS
        int resultado1 = (1 + 2 * (3 + 1)) / 2; // segue a ordem de precedência
        System.out.println("Resultado1 = " + resultado1);

        int x = 4;
        int y = 8;
        int divisaoInteira = x / y; 
        System.out.println("Divisão inteira 4/8 = " + divisaoInteira); // 0, pois ignora o decimal

        double divisaoCorreta = (double) x / y; 
        System.out.println("Divisão com double 4/8 = " + divisaoCorreta); // 0.5

        
        // OPERADORES RELACIONAIS
        System.out.println("\n--- Operadores Relacionais ---");
        System.out.println("10 == 10 ? " + (10 == 10)); 
        System.out.println("10 != 5 ? " + (10 != 5));   
        System.out.println("7 > 3 ? " + (7 > 3));       
        System.out.println("7 < 3 ? " + (7 < 3));       
        System.out.println("7 >= 7 ? " + (7 >= 7));     
        System.out.println("5 <= 9 ? " + (5 <= 9));     

        
        // OPERADORES LÓGICOS
        System.out.println("\n--- Operadores Lógicos ---");
        boolean cond1 = (5 > 2) && (10 < 20); // true && true = true
        boolean cond2 = (5 > 10) || (10 < 20); // false || true = true
        boolean cond3 = !(5 == 5); // !(true) = false
        System.out.println("cond1 = " + cond1);
        System.out.println("cond2 = " + cond2);
        System.out.println("cond3 = " + cond3);

        // EXERCICIO 1
        boolean expressao = 15 - 5 * 2 > (3 - 1) / 2 && 4 <= 2 * 2 || !(2 != 4);
        System.out.println("\nResultado da expressão complexa: " + expressao);

        // -------------------------
        // OPERADORES DE ATRIBUIÇÃO
        // -------------------------
        System.out.println("\n--- Operadores de Atribuição ---");
        int numero = 10;
        numero += 5; // equivale a numero = numero + 5
        System.out.println("numero += 5 => " + numero);

        numero -= 3; // numero = numero - 3
        System.out.println("numero -= 3 => " + numero);

        numero *= 2; // numero = numero * 2
        System.out.println("numero *= 2 => " + numero);

        numero /= 4; // numero = numero / 4
        System.out.println("numero /= 4 => " + numero);

        numero %= 3; // numero = numero % 3
        System.out.println("numero %= 3 => " + numero);

        // -------------------------
        // EXERCICIO 2
        // -------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Cálculo da Média ---");
        System.out.print("Digite a primeira nota: ");
        double nota1 = Double.parseDouble(sc.nextLine());

        System.out.print("Digite a segunda nota: ");
        double nota2 = Double.parseDouble(sc.nextLine());

        double media = (nota1 + nota2) / 2;
        System.out.println("Média final = " + media);
        // -------------------------
        // EXERCICIO 3
        // -------------------------
        System.out.println("\n--- Conversão Celsius para Fahrenheit ---");
        System.out.print("Digite a temperatura em Celsius: ");
        double celsius = Double.parseDouble(sc.nextLine());

        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println(celsius + "°C = " + fahrenheit + "°F");

        sc.close();
    }
}
