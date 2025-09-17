/*
 * Demonstração sobre Pacotes em Java
 * Curso Java 360 - Organização de código, imports, visibilidade e convenções
 */
package com.ericfr1tzenvalle.java.course.javaOO;

public class Pacotes {
    public static void main(String[] args) {
        /*
         * Pacotes servem para organizar classes em agrupamentos lógicos.
         * A declaração "package ..." é OBRIGATÓRIA, e deve aparecer na primeira
         * linha do arquivo .java (antes de qualquer import ou definição de classe).
         *
         * Convenção de nomenclatura:
         *   - Sempre em letras minúsculas.
         *   - Para evitar conflitos entre projetos, usa-se o domínio da empresa
         *     escrito ao contrário, seguido do nome do projeto/módulo.
         *     Ex: com.google.maps, org.apache.commons, br.com.minhaempresa.sistema
         *
         * Fully Qualified Name (FQN):
         *   - O nome completo da classe incluindo seu pacote.
         *   - Ex: java.util.Date e java.sql.Date são classes diferentes,
         *     mesmo que tenham o mesmo nome, pois estão em pacotes diferentes.
         *
         * Imports:
         *   - Para usar classes de outros pacotes, fazemos:
         *       import java.util.Date;
         *   - Caso haja ambiguidade (duas classes com o mesmo nome),
         *     devemos usar o nome totalmente qualificado (FQN) para distinguir:
         *       java.util.Date data1 = new java.util.Date();
         *       java.sql.Date data2 = new java.sql.Date(System.currentTimeMillis());
         *
         * Imports automáticos:
         *   - O pacote java.lang é importado automaticamente
         *     (ex: String, System, Math, Object, etc).
         *
         * Import estático:
         *   - Podemos importar métodos ou constantes estáticas diretamente:
         *       import static java.lang.Math.PI;
         *       import static java.lang.Math.sqrt;
         *   - Assim podemos usar PI e sqrt() sem precisar de Math. na frente.
         *
         * Visibilidade baseada em pacotes:
         *   - "default" (quando não se usa public/protected/private) significa
         *     que a classe, atributo ou método só é visível dentro do mesmo pacote.
         *   - É uma forma de encapsulamento em nível de pacote.
         *
         * Resumindo:
         * - Pacotes evitam conflitos de nomes.
         * - Organizam melhor o código.
         * - Controlam visibilidade (default/package-private).
         * - Facilitam manutenção e legibilidade em projetos grandes.
         */
    }
}
