/*
 * Demonstração de Sealed Classes em Java
 * Curso Java 360 - Sealed, Non-Sealed e vantagens/desvantagens
 *
 * Aborda:
 * - Motivação de sealed classes: controlar quais classes podem estender uma superclasse
 * - Uso da palavra-chave `sealed` para restringir herança
 * - `permits` define explicitamente quais subclasses são permitidas
 * - Non-sealed: permite que uma subclasse quebre a restrição de sealed
 * - Evita alterações indesejadas na hierarquia, aumentando segurança e manutenção
 */
package com.ericfr1tzenvalle.java.course.javaOO;

public class SealedClass {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        System.out.println(circle.getType());
        System.out.println(rectangle.getType());
    }

    // Superclasse selada
    private sealed interface Shape permits Circle, Rectangle {
        String getType();
    }

    // Subclasse permitida
    private static final class Circle implements Shape {
        @Override
        public String getType() {
            return "Círculo";
        }
    }

    // Subclasse permitida
    private static final class Rectangle implements Shape {
        @Override
        public String getType() {
            return "Retângulo";
        }
    }

    // Subclasse que poderia ser non-sealed
    // Exemplo de Non-Sealed: permitir novas subclasses além das originais
    // private non-sealed class Square extends Shape { ... }
}
/*
 * Resumo do que foi abordado:
 *
 * - Sealed classes/interfaces permitem controlar quais classes podem estender
 *   ou implementar uma superclasse ou interface, aumentando o controle sobre a
 *   hierarquia de classes.
 *
 * - A palavra-chave `sealed` é usada na superclasse/interface e precisa indicar
 *   explicitamente, via `permits`, quais subclasses são permitidas.
 *
 * - Subclasses permitidas podem ser:
 *     - `final`: não podem ser estendidas (mais restritivo)
 *     - `non-sealed`: podem ser estendidas livremente, quebrando a restrição
 *       da sealed superclasse
 *     - `sealed`: podem restringir suas próprias subclasses, mantendo controle
 *
 * - Vantagens:
 *     - Maior segurança e previsibilidade da hierarquia
 *     - Facilita manutenção e evolução da API, pois você sabe exatamente
 *       quais subclasses existem
 *     - Combina bem com pattern matching e switch expressions em Java moderno
 *
 * - Desvantagens:
 *     - Menos flexível, pois novas subclasses fora das permitidas exigem
 *       alteração na superclasse
 *     - Pode aumentar a complexidade se usado em excesso em projetos grandes
 *
 * - Conceito geral: sealed classes/interfaces equilibram encapsulamento e
 *   flexibilidade, permitindo um design controlado da herança sem abrir mão
 *   da extensibilidade quando necessário (via non-sealed).
 */
