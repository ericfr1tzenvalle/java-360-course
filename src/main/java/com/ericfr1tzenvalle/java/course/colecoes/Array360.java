/*
 * Demonstração de Arrays em Java
 * Curso Java 360 - Estruturas de Dados Fundamentais
 *
 * Aborda:
 * - Conceito de arrays como coleções contíguas e indexadas
 * - Tipos primitivos e objetos em arrays
 * - Inicialização: com tamanho fixo ou valores diretos
 * - Valores padrão (0, 0.0, false, null)
 * - Stack x Heap: diferenças no armazenamento e passagem de referências
 * - Arrays multidimensionais e "jagged arrays" (colunas irregulares)
 * - Iteração: for tradicional, enhanced for e Streams
 * - Métodos utilitários da classe Arrays
 * - Uso de varargs (...) em métodos
 * - Exercícios práticos:
 *   1) Elevar valores de um array ao quadrado
 *   2) Encontrar item mais caro, mais barato e preço médio
 *   3) Implementação de Bubble Sort
 */

package com.ericfr1tzenvalle.java.course.colecoes;

import java.util.Arrays;

public class Array360 {

    public static void main(String[] args) {
        // Exemplo 1: inicialização direta
        int[] elementos = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] elementosElevados = elevaArray(elementos);
        System.out.println("Elementos elevados ao quadrado: " + Arrays.toString(elementosElevados));

        // Exemplo 2: array de objetos
        Item[] itens = {
            new Item("Guitarra", 1299),
            new Item("Whey", 39.90),
            new Item("Xis", 100),
            new Item("Pré-treino", 200),
            new Item("Vodka", 12.89)
        };
        Item[] itemsOrdenados = retornaItems(itens);
        System.out.println("Resumo dos itens (max, min, médio): " + Arrays.toString(itemsOrdenados));

        // Exemplo 3: Bubble Sort
        int[] numeros = {5, 2, 9, 1, 5, 6};
        bubbleSort(numeros);
        System.out.println("Array ordenado com Bubble Sort: " + Arrays.toString(numeros));

        // Exemplo 4: Arrays multidimensionais
        int[][] matriz = {
            {1, 2, 3},
            {4, 5},       // array irregular (jagged array)
            {6, 7, 8, 9}
        };
        System.out.println("Exemplo de matriz: " + Arrays.deepToString(matriz));

        // Exemplo 5: Varargs
        System.out.println("Soma via varargs: " + soma(1, 2, 3, 4, 5));
    }

    // Exercicio 1: eleva cada elemento ao quadrado
    public static int[] elevaArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= array[i];
        }
        return array;
    }

    private static class Item {
        private String nome;
        private double price;

        public Item(String nome, double price) {
            this.nome = nome;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" + "nome='" + nome + '\'' + ", price=" + String.format("%.2f", price) + '}';
        }
    }

    // Exercicio 2: encontra item mais caro, mais barato e calcula preço médio
    public static Item[] retornaItems(Item array[]) {
        Item max = array[0];
        Item min = array[0];
        double precoMedio = 0;
        for (Item item : array) {
            if (item.price > max.price) max = item;
            if (item.price < min.price) min = item;
            precoMedio += item.price;
        }
        Item pMedio = new Item("Preço Médio", precoMedio / array.length);
        return new Item[]{max, min, pMedio};
    }

    // Exercicio 3: Bubble Sort
    public static void bubbleSort(int[] array) {
        boolean trocou;
        do {
            trocou = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    trocou = true;
                }
            }
        } while (trocou);
    }

    // Exemplo de varargs
    public static int soma(int... valores) {
        int total = 0;
        for (int v : valores) {
            total += v;
        }
        return total;
    }
}

/*
 * Resumo do que foi abordado:
 *
 * 1) O que são Arrays
 * - São coleções de dados homogêneos (mesmo tipo), armazenados de forma contígua na memória.
 * - O acesso é indexado a partir de 0, ou seja, o último elemento está em "tamanho - 1".
 * - O tamanho do array é definido na criação e não pode ser alterado depois.
 *
 * 2) Memória (Stack vs Heap)
 * - Arrays sempre são objetos, mesmo que contenham tipos primitivos.
 * - A variável que referencia o array fica no stack, mas o array em si é alocado no heap.
 * - Diferença prática: tipos primitivos guardados no stack não alteram fora do escopo;
 *   arrays (objetos) ao serem passados para métodos permitem alterar seus valores no heap.
 *
 * 3) Valores padrão
 * - int → 0
 * - double → 0.0
 * - boolean → false
 * - objetos (ex: String) → null
 * Isso garante que um array nunca começa "vazio" de fato.
 *
 * 4) Inicialização
 * - Pode ser feita com tamanho fixo (ex: new int[5]) ou já atribuindo valores ({1,2,3}).
 * - Arrays são fixos, mas podem ser "substituídos" criando um novo array.
 *
 * 5) Exceções
 * - Acessar índices fora do limite gera ArrayIndexOutOfBoundsException.
 * - Isso protege a memória e impede que você acesse áreas que não pertencem ao array.
 *
 * 6) Iteração
 * - for tradicional (usando índices)
 * - enhanced for (for-each)
 * - streams (Arrays.stream(array))
 *
 * 7) Arrays multidimensionais
 * - São arrays de arrays (ex: int[][] matriz).
 * - Não precisam ser quadrados: podem ter colunas de tamanhos diferentes (jagged arrays).
 * - Uso prático: representar tabelas, grades, matrizes matemáticas.
 *
 * 8) Varargs (...)
 * - Permitem passar múltiplos valores sem precisar criar array manualmente.
 * - São convertidos internamente em array.
 * - Sempre devem ser o último parâmetro do método.
 *
 * 9) Métodos da classe Arrays
 * - sort(array) → ordena
 * - binarySearch(array, valor) → busca binária (só funciona em arrays ordenados)
 * - copyOf(array, novoTamanho) → copia e redimensiona
 * - fill(array, valor) → preenche todo array com um valor
 * - toString(array) / deepToString(matriz) → representação em string
 * - equals(a1, a2) → compara arrays
 *
 * 10) Exercícios práticos implementados:
 * - Elevar valores de um array ao quadrado
 * - Encontrar item mais caro, mais barato e calcular preço médio
 * - Implementar algoritmo de Bubble Sort (ordenação)
 *
 * Arrays são a base para compreender coleções mais avançadas (como ArrayList, HashMap),
 * mas mesmo assim continuam úteis em situações de baixo nível ou que exigem performance.
 */
