/*
 * Demonstração de estruturas de repetição em Java
 * Curso Java 360 - For, While, Do-While, For-Each, Break, Continue e Labeled Loops
 *
 * Aborda:
 *  - For: quando sabemos quantas vezes vamos repetir
 *  - While: quando repetimos enquanto uma condição for verdadeira
 *  - Do-While: garante execução pelo menos uma vez
 *  - For-Each: iteração simplificada sobre arrays ou coleções
 *  - Break: sai do loop imediatamente
 *  - Continue: pula a iteração atual
 *  - Labeled Loops: controlar loops aninhados de forma mais precisa
 */
package com.ericfr1tzenvalle.java.course.JavaCORE;

import java.util.Scanner;

public class EstruturasRepeticao {
    public static void main(String[] args) {

        System.out.println("--- For Loop ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("\n--- While Loop ---");
        int j = 1;
        while (j <= 5) {
            System.out.println("j = " + j);
            j++;
        }

        System.out.println("\n--- Do-While Loop ---");
        int k = 1;
        do {
            System.out.println("k = " + k);
            k++;
        } while (k <= 5);

        System.out.println("\n--- For-Each Loop ---");
        int[] numeros = {1, 2, 3, 4, 5};
        for (int num : numeros) {
            System.out.println("num = " + num);
        }

        System.out.println("\n--- Break e Continue ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 4) {
                System.out.println("Pulando o número 4");
                continue;
            }
            if (i == 8) {
                System.out.println("Parando o loop no número 8");
                break;
            }
            System.out.println("i = " + i);
        }

        System.out.println("\n--- Labeled Loops ---");
        outer: // este é o label do loop externo // ou seja podemos nomear loops
        for (int linha = 1; linha <= 3; linha++) {
            for (int coluna = 1; coluna <= 3; coluna++) {
                System.out.print("(" + linha + "," + coluna + ") ");
                if (linha == 2 && coluna == 2) {
                    System.out.println("\nEncontramos o alvo, saindo do loop externo!");
                    break outer; // sai diretamente do loop com label 'outer'
                }
            }
            System.out.println(); 
        }

        System.out.println("\nFim da demonstração de loops.");

        // OBSERVAÇÕES
        // - For é ótimo quando sabemos quantas vezes repetir algo.
        // - While é melhor quando não sabemos o total de repetições.
        // - Do-While garante que o loop execute pelo menos uma vez.
        // - For-Each deixa o código mais limpo ao percorrer arrays/coleções.
        // - Break e Continue dão mais controle, mas use com moderação.
        // - Labeled loops ajudam a sair de loops aninhados quando necessário.

        // ---------------- EXERCÍCIOS ----------------

        // EXERCÍCIO 1 - Somar números pares de 0 até 100
        int soma = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                soma += i;
            }
        }
        System.out.println("\nExercício 1 - Soma dos pares de 0 a 100: " + soma);

        // EXERCÍCIO 2 - Calcular média de notas até usuário encerrar
        Scanner sc = new Scanner(System.in);
        int somaNotas = 0;
        int qtdNotas = 0;

        System.out.println("\nExercício 2 - Cálculo da média das notas");
        while (true) {
            System.out.print("Digite a nota " + (qtdNotas + 1) + " (ENTER para sair): ");
            String aux = sc.nextLine();

            if (!aux.isEmpty()) {
                somaNotas += Integer.parseInt(aux);
                qtdNotas++;
                continue;
            }
            break;
        }

        if (qtdNotas > 0) {
            double media = (double) somaNotas / qtdNotas;
            System.out.println("Média das notas: " + media);
        } else {
            System.out.println("Nenhuma nota informada.");
        }

        // EXERCÍCIO 3 - Tabuada de um número
        System.out.println("\nExercício 3 - Tabuada");
        System.out.print("Digite um número: ");
        int num = sc.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

        sc.close(); 
    }
}
