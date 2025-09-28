/*
 * Demonstração de Random e geração de números aleatórios em Java
 * Curso Java 360 - Random, seed, UUID e simulação de dados de RPG
 *
 * Aborda:
 * - Classe Random para gerar números pseudoaleatórios
 * - Diferença entre nextInt(n) e nextInt(origin, bound) (Java 17+)
 * - Simulação de rolagem de dados de RPG: D4, D6, D8, D10, D12, D20
 * - Geração de múltiplos valores aleatórios (vários dados ao mesmo tempo)
 * - Uso de UUID para gerar identificadores únicos
 */
package com.ericfr1tzenvalle.java.course.javaTextosNumeros;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RandomNumbers {

    public static void main(String[] args) {
        // Exercicio 1: rolando um D6
        System.out.println("Rolando um dado D6: " + Dados.rolld6());

        // Exercicio 2: rolando múltiplos D6
        System.out.println("Rolando 2 D6: " + Dados.rollMultDice(6, 2));

        // Exercicio 3: rolando todos os tipos de dados comuns de RPG
        System.out.println("D4: " + Dados.rolld4());
        System.out.println("D6: " + Dados.rolld6());
        System.out.println("D8: " + Dados.rolld8());
        System.out.println("D10: " + Dados.rolld10());
        System.out.println("D12: " + Dados.rolld12());
        System.out.println("D20: " + Dados.rolld20());

        // Exercicio 4: rolando múltiplos dados de tipos diferentes
        System.out.println("Rolando 3 D8: " + Dados.rollMultDice(8, 3));
        System.out.println("Rolando 4 D12: " + Dados.rollMultDice(12, 4));

        // Exercicio 5: gerando UUID
        System.out.println("UUID gerado: " + UUID.randomUUID());
    }

    private static class Dados {

        private static final Random rand = new Random(); // objeto Random compartilhado

        // Rola um dado de 1 até range
        public static int rollDice(int range){
            return rand.nextInt(range) + 1;
        }

        // Rola múltiplos dados de mesmo range
        public static List<String> rollMultDice(int range, int qtd){
            List<String> valores = new ArrayList<>();
            for(int i = 0; i < qtd; i++){
               valores.add(String.valueOf(rand.nextInt(range) + 1));
            }
            return valores;
        }

        // Métodos simulando dados de RPG
        public static int rolld4()  { return rand.nextInt(1, 5); }
        public static int rolld6()  { return rand.nextInt(1, 7); }
        public static int rolld8()  { return rand.nextInt(1, 9); }
        public static int rolld10() { return rand.nextInt(1, 11); }
        public static int rolld12() { return rand.nextInt(1, 13); }
        public static int rolld20() { return rand.nextInt(1, 21); }
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Random permite gerar números pseudoaleatórios. Para RPG, usamos nextInt(range) + 1.
 * - rollMultDice mostra como gerar várias jogadas de um dado ao mesmo tempo.
 * - Métodos rolld4, rolld6, rolld8, rolld10, rolld12, rolld20 simulam dados clássicos de RPG.
 * - Exemplo de múltiplos dados de tipos diferentes ajuda a visualizar combinações.
 * - UUID.randomUUID() gera identificadores universais únicos.
 * - Utilizar um único objeto Random é mais eficiente e evita repetições inesperadas.
 * - É possível usar seed para reprodutibilidade de sequências aleatórias.
 */
