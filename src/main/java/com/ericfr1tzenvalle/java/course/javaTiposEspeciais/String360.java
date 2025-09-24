/*
 * Curso Java 360 - Strings, Imutabilidade e Performance
 *
 * Aborda:
 * - Strings em Java são imutáveis
 * - Pool de Strings: sub-área do heap que reaproveita objetos
 * - Não usar new String("..."), pois cria objetos fora do pool
 * - Comparação: sempre usar equals() ao invés de ==
 * - Método intern(): força inclusão da String no pool
 * - Problemas de performance em concatenação (uso de StringBuilder é recomendado)
 * - Operações úteis: substring, indexOf, replace, toUpperCase, etc.
 */
package com.ericfr1tzenvalle.java.course.javaTiposEspeciais;

import java.util.Scanner;

public class String360 {
    public static void main(String[] args) {
        // Pool de Strings
        String a = "java";
        String b = "java";
        String c = new String("java");

        System.out.println("a == b? " + (a == b)); // true (mesma referência do pool)
        System.out.println("a == c? " + (a == c)); // false (novo objeto fora do pool)
        System.out.println("a.equals(c)? " + a.equals(c)); // true (mesmo conteúdo)

        // Método intern()
        String d = c.intern(); 
        System.out.println("a == d? " + (a == d)); // true (agora aponta para o pool)

        // Exemplo de concatenação ruim (cria vários objetos intermediários)
        String concat = "";
        for (int i = 0; i < 5; i++) {
            concat += i; 
        }
        System.out.println("Concatenação ruim: " + concat);

        // Solução com StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(i);
        }
        System.out.println("Concatenação eficiente: " + sb.toString());

        // Exercicio 1 - Inversão de palavras
        System.out.println("\nInversão de palavras");
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a palavra: ");
        String entrada = sc.nextLine();
        System.out.println("Resultado: " + new StringBuilder(entrada).reverse());

        // Exercicio 2 - Colocar parte da frase em maiúsculo
        String s = "voce é incrivel";
        System.out.println("\nFrase transformada: " + upperCase(s, "incrivel"));
    }

    private static String upperCase(String s, String piece) {
        int pos = s.indexOf(piece);
        if (pos < 0) {
            return s;
        }
        String extracted = s.substring(pos, pos + piece.length());
        String transformed = extracted.toUpperCase();
        return s.replace(piece, transformed);
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Strings em Java são imutáveis, garantindo segurança e consistência.
 * - O pool de Strings evita criar múltiplas instâncias desnecessárias.
 * - Comparar Strings deve ser feito com equals(), não com ==.
 * - O método intern() pode alinhar Strings criadas fora do pool.
 * - Concatenações em laços devem usar StringBuilder para eficiência.
 * - Exemplo prático de manipulação: inversão e transformação parcial de texto.
 */
