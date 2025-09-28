/*
 * Demonstração de BigInteger e BigDecimal em Java
 * Curso Java 360 - Big Numbers
 *
 * Aborda:
 * - BigInteger para inteiros arbitrariamente grandes
 * - BigDecimal para cálculos de alta precisão, ideal em contextos financeiros
 * - Operações matemáticas (add, subtract, multiply, divide)
 * - Conversão entre BigDecimal/BigInteger e tipos primitivos
 * - Comparação correta usando compareTo em vez de equals
 * - Arredondamento com Math (ceil, floor, round) para doubles
 * - Arredondamento em BigDecimal usando setScale e RoundingMode
 */

package com.ericfr1tzenvalle.java.course.javaTextosNumeros;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigNumbers {
    public static void main(String[] args) {

        // Exemplo 1: BigInteger (inteiros muito grandes)
        BigInteger bigInt1 = new BigInteger("9999999999999999999999999999");
        BigInteger bigInt2 = new BigInteger("1234567890123456789012345678");
        BigInteger soma = bigInt1.add(bigInt2);
        BigInteger mult = bigInt1.multiply(bigInt2);
        System.out.println("Soma BigInteger: " + soma);
        System.out.println("Multiplicação BigInteger: " + mult);

        // Exemplo 2: BigDecimal (precisão para valores monetários)
        BigDecimal preco = new BigDecimal("19.99");
        BigDecimal qtd = new BigDecimal("3");
        BigDecimal total = preco.multiply(qtd);
        System.out.println("\nTotal com BigDecimal: " + total);

        // Comparação correta
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.00");
        System.out.println("Equals: " + a.equals(b)); // false (leva escala em conta)
        System.out.println("CompareTo: " + a.compareTo(b)); // 0 (mesmo valor)

        // Exemplo 3: Conversão para primitivos
        double valorDouble = total.doubleValue();
        int valorInt = total.intValue();
        System.out.println("\nConversões: double=" + valorDouble + " int=" + valorInt);

        // Exemplo 4: Arredondamentos com Math (doubles)
        double x = 5.67;
        System.out.println("\nArredondamentos com Math:");
        System.out.println("Math.ceil(5.67)  -> " + Math.ceil(x));
        System.out.println("Math.floor(5.67) -> " + Math.floor(x));
        System.out.println("Math.round(5.67) -> " + Math.round(x));

        // Exemplo 5: Arredondamento com BigDecimal
        BigDecimal valor = new BigDecimal("123.456789");
        System.out.println("\nArredondamentos com BigDecimal:");
        System.out.println("Duas casas (HALF_UP): " + valor.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Duas casas (DOWN): " + valor.setScale(2, RoundingMode.DOWN));
        System.out.println("Duas casas (UP): " + valor.setScale(2, RoundingMode.UP));
        System.out.println("Duas casas (HALF_EVEN): " + valor.setScale(2, RoundingMode.HALF_EVEN));
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - BigInteger resolve limites de int/long, permitindo operações com inteiros enormes.
 * - BigDecimal é a escolha certa para cálculos monetários, evitando erros de ponto flutuante do double.
 * - Comparar BigDecimal com equals() pode ser enganoso (leva escala em conta); prefira compareTo().
 * - Métodos de arredondamento:
 *   • Math.ceil → arredonda sempre para cima
 *   • Math.floor → arredonda sempre para baixo
 *   • Math.round → arredonda para o inteiro mais próximo
 *   • BigDecimal.setScale → permite controlar casas decimais com vários RoundingModes (UP, DOWN, HALF_UP, HALF_EVEN, etc.)
 * - Conversões para primitivos devem ser usadas com cautela (podem perder precisão).
 */
