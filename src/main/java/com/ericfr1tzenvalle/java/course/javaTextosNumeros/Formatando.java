/*
 * Demonstração de formatação de Strings e números em Java
 * Curso Java 360 - Texto e Números
 *
 * Aborda:
 * - String.format(), System.out.format() e System.out.printf()
 *   → Diferentes formas de interpolar e alinhar valores em strings
 * - Placeholders (%s, %d, %f etc.) e formatação com largura e alinhamento
 * - Formatação de números com NumberFormat
 * - Uso de Locale e Currency para exibir valores monetários corretamente
 * - Exemplo prático com classe Item (nome, descrição, preço e moeda)
 */
package com.ericfr1tzenvalle.java.course.javaTextosNumeros;

import java.text.NumberFormat;
import java.util.Currency;

public class Formatando {
    public static void main(String[] args) {
        
        Item i = new Item("Cigarro eletrônico", "É como um cigarro porém eletronico", 20, "BRL");
        System.out.println(i);

        System.out.printf("Produto: %-20s | Preço: %10.2f%n", i.getNome(), i.getPreco());


        String msg = String.format("Descrição: %-30s | Valor: %s", i.getDescricao(), i.getPreco());
        System.out.println(msg);
    }

    private static class Item {
        private final String nome;
        private final String descricao;
        private final double preco;
        private final NumberFormat numberFormat;

        public Item(String nome, String descricao, double preco, String moeda) {
            this.nome = nome;
            this.descricao = descricao;
            this.preco = preco;            
            numberFormat = NumberFormat.getCurrencyInstance();
            numberFormat.setCurrency(Currency.getInstance(moeda));
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public String getDescricao() {
            return descricao;
        }
        
        @Override
        public String toString() {
            return String.format("%-20s | %-25s | %15s", 
                    nome, descricao, numberFormat.format(preco));
        }
    }
}
/*
 * Resumo do que foi abordado:
 *
 * - Formatação de strings em Java pode ser feita de diferentes formas:
 *   • String.format() → retorna uma nova String formatada.
 *   • System.out.format() e System.out.printf() → imprimem diretamente no console.
 *
 * - Placeholders controlam a forma como os valores são exibidos:
 *   %s → string
 *   %d → inteiros
 *   %f → números decimais (permite definir casas decimais: %.2f → duas casas)
 *   %n → quebra de linha independente de SO
 *   %10s / %-10s → define largura e alinhamento (direita/esquerda).
 *
 * - É possível combinar placeholders para gerar relatórios alinhados,
 *   tabelas e saídas mais legíveis.
 *
 * - Para valores monetários, o uso de NumberFormat é preferível,
 *   pois ele:
 *     • Considera o Locale (país/idioma) para aplicar separadores corretos
 *       (vírgula, ponto, espaço etc.).
 *     • Usa Currency para exibir o símbolo monetário correto (R$, $, €, ¥...).
 *     • Facilita a conversão de valores numéricos em formatos prontos
 *       sem precisar manipular manualmente.
 *
 * - Exemplo prático:
 *   A classe Item demonstra:
 *     • Uso de String.format() para alinhar nome, descrição e preço.
 *     • Uso de NumberFormat com Currency.getInstance("BRL") para exibir
 *       o preço no formato monetário brasileiro.
 *
 * - Em resumo, a formatação é uma ferramenta essencial para:
 *   • Tornar a saída mais legível e organizada.
 *   • Adaptar valores a diferentes contextos (relatórios, logs, tabelas).
 *   • Internacionalizar sistemas (i18n), exibindo números e moedas de acordo
 *     com o país do usuário.
 */
