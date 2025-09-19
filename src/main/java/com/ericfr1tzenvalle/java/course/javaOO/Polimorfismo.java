/*
 * Demonstração de Polimorfismo em Java
 * Curso Java 360 - Polimorfismo, interfaces e generalização de tipos
 *
 * Aborda:
 * - Conceito de polimorfismo: trabalhar com referências genéricas (ex: Shape) para lidar com múltiplos tipos concretos
 * - Como isso facilita a criação de métodos genéricos e evita repetição de código
 * - Uso do operador `instanceof` para checagem de tipos em tempo de execução
 * - Cuidados com casting explícito e risco de `ClassCastException`
 * - Casting automático quando utilizado junto do `instanceof`
 * - Vantagens: flexibilidade, extensibilidade e código mais limpo
 * - Desvantagens: pode limitar acesso a comportamentos específicos da subclasse
 */
package com.ericfr1tzenvalle.java.course.javaOO;

public class Polimorfismo {
    public static void main(String[] args) {
        // Exemplo prático: calculadora de áreas usando polimorfismo
        Calculator c = new Calculator();
        c.sumSurfaceArea(new Circle(4));
        c.sumSurfaceArea(new Rectangle(2, 3));
        c.sumSurfaceArea(new Square(2));

        System.out.println("Total das Áreas: " + c.getTotal());
    }

    // Interface genérica para formas geométricas
    private interface Shape {
        double surfaceArea();
    }

    // Classe que usa polimorfismo para somar áreas de qualquer Shape
    private static class Calculator {
        private double total;
        public void sumSurfaceArea(Shape s) {
            total += s.surfaceArea();
        }
        public double getTotal() {
            return total;
        }
    }


    private static class Circle implements Shape {
        private final double raio;

        public Circle(double raio) {
            this.raio = raio;
        }

        @Override
        public double surfaceArea() {
            return Math.PI * raio * raio; 
        }
    }


    private static class Rectangle implements Shape {
        private final double base;
        private final double altura;

        public Rectangle(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double surfaceArea() {
            return base * altura;
        }
    }


    private static class Square implements Shape {
        private final double lado;

        public Square(double lado) {
            this.lado = lado;
        }

        @Override
        public double surfaceArea() {
            return lado * lado;
        }
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Polimorfismo permite trabalhar com referências mais genéricas (ex: Shape),
 *   reduzindo duplicação de código e tornando o sistema extensível.
 *
 * - A interface Shape define o "contrato" que todas as formas devem seguir:
 *   implementar surfaceArea().
 *
 * - O polimorfismo possibilita que a classe Calculator trabalhe com
 *   qualquer forma sem precisar conhecer sua implementação concreta.
 *
 * - `instanceof` pode ser usado para verificar o tipo real de um objeto,
 *   mas seu uso excessivo pode indicar má modelagem.
 *
 * - Casting explícito deve ser feito com cuidado, pois pode lançar
 *   `ClassCastException`. Quando combinado com `instanceof`, o compilador
 *   permite cast seguro (casting automático).
 *
 * - Pontos fortes: flexibilidade, reutilização de código e fácil extensão.
 * - Pontos fracos: pode esconder comportamentos específicos das subclasses,
 *   exigindo verificações adicionais quando necessário.
 */
