/*
 * Demonstração de Classes Wrappers em Java
 * Curso Java 360 - Wrappers, Autoboxing, Parsing e Boas Práticas
 *
 * Aborda:
 * - O que são classes wrappers (Byte, Short, Integer, Long, Float, Double, Boolean, Character)
 * - Diferença entre tipos primitivos e wrappers (objetos imutáveis)
 * - Por que não devemos instanciar wrappers com construtor (deprecated, uso de valueOf())
 * - Diferença entre valueOf() e parseXxx()
 * - Autoboxing e unboxing: conversão automática entre primitivo e wrapper
 * - Integer cache (range -128 a 127 reaproveitado no valueOf())
 * - Comparação correta usando equals() (== só compara referências)
 * - Vantagens e desvantagens do uso de wrappers
 * - Exercícios práticos:
 *   1. Interface Operation com exemplo de soma usando Integer
 *   2. Conversão de número decimal para binário, hexadecimal e octal
 */
package com.ericfr1tzenvalle.java.course.javaTiposEspeciais;

import java.util.Scanner;

public class Wrapper {
    public static void main(String[] args) {
        // Exercicio 1: Uso de interface com Integer (autoboxing/unboxing)
        Operation op = new OperationSum();
        System.out.println("Resultado de 10 + 12 = " + op.execute(10, 12));

        // Exercicio 2: Conversões de String para int com parse
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numeroEscolhido = Integer.parseInt(sc.nextLine()); // parse converte direto para primitivo

        System.out.println("Binário: " + Integer.toBinaryString(numeroEscolhido));
        System.out.println("Hexadecimal: " + Integer.toHexString(numeroEscolhido));
        System.out.println("Octal: " + Integer.toOctalString(numeroEscolhido));

        // Ex 1: valueOf vs parse
        Integer n1 = Integer.valueOf("127");  // retorna objeto Integer (pode usar cache interno)
        int n2 = Integer.parseInt("127");     // retorna primitivo int
        System.out.println("valueOf retorna wrapper: " + n1.getClass().getSimpleName());
        System.out.println("parseInt retorna primitivo: " + n2);

        // Ex 2: Integer cache
        Integer a = Integer.valueOf(127);
        Integer b = Integer.valueOf(127);
        System.out.println("Comparando cache (-128 a 127): " + (a == b)); // true (mesmo objeto)

        Integer x = Integer.valueOf(128);
        Integer y = Integer.valueOf(128);
        System.out.println("Fora do cache (>127): " + (x == y)); // false (objetos diferentes)

        // Ex 3: comparação correta
        System.out.println("Comparação correta com equals: " + x.equals(y));
    }


    private interface Operation {
        int execute(Integer n1, Integer n2);
    }


    private static class OperationSum implements Operation {
        @Override
        public int execute(Integer n1, Integer n2) {
            // Tratamento de null (evita NullPointerException)
            return (n1 == null ? 0 : n1) + (n2 == null ? 0 : n2);
        }
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Classes wrappers encapsulam tipos primitivos em objetos, permitindo uso em coleções genéricas e APIs que exigem objetos.
 * - Não se deve instanciar wrappers com construtor (ex: new Integer(10)), pois é obsoleto e cria objetos desnecessários.
 * - valueOf(): retorna objeto wrapper, aproveitando cache interno para valores entre -128 e 127.
 * - parseXxx(): converte String diretamente para tipo primitivo (int, double, etc).
 * - Autoboxing: conversão automática de primitivo para wrapper (int → Integer).
 * - Unboxing: conversão automática de wrapper para primitivo (Integer → int).
 * - Integer cache: valores -128 a 127 usam a mesma referência em valueOf, otimizando memória.
 * - Comparações: usar equals() para comparar valores. O operador == só compara referências de objetos.
 * - Vantagens: interoperabilidade com coleções genéricas, métodos utilitários, nullabilidade.
 * - Desvantagens: maior consumo de memória e performance inferior comparado a tipos primitivos.
 *
 * Exercícios demonstrados:
 * 1. Implementação de interface Operation usando autoboxing com Integer.
 * 2. Conversão de número decimal para binário, octal e hexadecimal com métodos da classe Integer.
 * 3. Demonstração de valueOf vs parseInt.
 * 4. Exploração do Integer cache e impacto em comparações.
 */
