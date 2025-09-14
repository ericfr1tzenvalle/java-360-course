/*
 * Demonstração de tipos de dados em Java
 * Curso Java 360 - Tipos Primitivos, Casting, String, Text Block e Scanner
 */
package com.ericfr1tzenvalle.java.course.JavaCORE;

import java.util.Scanner;

public class VariaveisTipoDeDados {
    public static void main(String[] args) {
        
        // --- VAR ---
        var caractere = 'J'; // inferência de tipo -> char
        System.out.println("Caractere (var -> char): " + caractere);

        // --- TIPOS INTEIROS ---
        byte numeroByte = 120;           // -128 até 127
        short numeroShort = 32000;       // -32768 até 32767
        int numeroInt = 2_000_000_000;   // -2 bilhões até 2 bilhões
        long numeroLong = 9_000_000_000L;// precisa do 'L' se passar do limite do int

        System.out.println("Byte: " + numeroByte);
        System.out.println("Short: " + numeroShort);
        System.out.println("Int: " + numeroInt);
        System.out.println("Long: " + numeroLong);

        // --- PONTO FLUTUANTE ---
        float numeroFloat = 3.1415f;   // precisão simples
        double numeroDouble = 2.71828; // precisão dupla

        System.out.println("Float: " + numeroFloat);
        System.out.println("Double: " + numeroDouble);

        // --- BOOLEAN ---
        boolean estaChovendo = true;
        boolean temSol = false;
        System.out.println("Está chovendo? " + estaChovendo);
        System.out.println("Tem sol? " + temSol);

        // --- BINÁRIO, HEXADECIMAL E OCTAL ---
        int numeroBinario = 0b1010; // 10 em decimal
        int numeroHexa = 0xFF;      // 255 em decimal
        int numeroOctal = 07;       // 7 em decimal

        System.out.println("Binário 0b1010 = " + numeroBinario);
        System.out.println("Hexadecimal 0xFF = " + numeroHexa);
        System.out.println("Octal 07 = " + numeroOctal);

        // --- "PROMOÇÃO" DE TIPOS ---
        int inteiro = 100;
        long convertidoParaLong = inteiro; // automático (int -> long)
        double convertidoParaDouble = convertidoParaLong; // automático (long -> double)
        System.out.println("Promoção automática (int -> long -> double): " + convertidoParaDouble);

        // --- CASTING EXPLÍCITO ---
        int numeroGrande = 130;
        byte convertidoParaByte = (byte) numeroGrande; // perde informação
        System.out.println("Casting explícito (int 130 -> byte): " + convertidoParaByte);

        double numeroComCasas = 9.99;
        int convertidoParaInt = (int) numeroComCasas;
        System.out.println("Casting explícito (double 9.99 -> int): " + convertidoParaInt);

        // --- TESTANDO LIMITES ---
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        System.out.println("Valor máximo de int: " + maxInt);
        System.out.println("Valor mínimo de int: " + minInt);
        System.out.println("Overflow (maxInt + 1): " + (maxInt + 1));
        System.out.println("Underflow (minInt - 1): " + (minInt - 1));
        
        // --- TIPO CHAR ---
        char c1 = 'A'; // internamente isso é um número (código Unicode)
        int valorUnicode = (int) c1;
        System.out.println("Char 'A' em Unicode/ASCII = " + valorUnicode); // 65
        
        char c2 = (char) (c1 + 2); // podemos manipular char como número
        System.out.println("Char 'A' + 2 = " + c2); // deve imprimir 'C'
        
        char c3 = (char) -10; // exemplo estranho, compila mas gera símbolos
        System.out.println("Char negativo: " + c3);

        // --- STRING ---
        String palavra1 = "Java";
        String palavra2 = " é incrível!";
        String frase = palavra1 + palavra2; // concatenação
        System.out.println("Concatenação: " + frase);

        // --- MÉTODOS ÚTEIS DE STRING ---
        System.out.println("Tamanho da frase: " + frase.length());
        System.out.println("Maiúsculas: " + frase.toUpperCase());
        System.out.println("Minúsculas: " + frase.toLowerCase());
        System.out.println("Caractere na posição 0: " + frase.charAt(0));
        System.out.println("Substring (0 a 4): " + frase.substring(0, 4));
        System.out.println("Contém 'Java'? " + frase.contains("Java"));
        System.out.println("Trocar 'Java' por 'C#': " + frase.replace("Java", "C#"));
        System.out.println("É igual a 'Java é incrível!'? " + frase.equals("Java é incrível!"));
        System.out.println("É igual (ignorando maiúsculas/minúsculas)? " + frase.equalsIgnoreCase("java É incrível!"));

        // --- DIFERENÇA ENTRE == e equals ---
        String texto1 = "abc";
        String texto2 = "abc";
        String texto3 = new String("abc");
        System.out.println("Comparação com == (pool de Strings): " + (texto1 == texto2)); // true
        System.out.println("Comparação com == (objeto novo): " + (texto1 == texto3));     // false
        System.out.println("Comparação com equals (conteúdo): " + texto1.equals(texto3)); // true

        // --- TEXT BLOCK
        // Usado para escrever Strings multilinha de forma mais limpa
        // Ele preserva a formatação, ou seja, da forma que está vai ser a forma
        // Que vai ser imprimida
        String textoMultilinha = """
                Esse é um Text Block em Java.
                Ele preserva quebras de linha,
                e é ótimo para JSON, XML, HTML ou mensagens longas.
                """;
        System.out.println("Exemplo de Text Block:");
        System.out.println(textoMultilinha);

        // --- SCANNER (entrada de dados pelo teclado) ---
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine(); // lê uma linha inteira

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt(); // lê um número inteiro

        System.out.println("Olá, " + nome + "! Você tem " + idade + " anos.");

        
    }
}
