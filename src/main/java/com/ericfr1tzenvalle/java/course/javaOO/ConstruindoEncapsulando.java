/*
 * Demonstração de encapsulamento em Java
 * Curso Java 360 - Encapsulamento, Construtores, Getters/Setters e Modificador final
 *
 * Aborda:
 * - Encapsulamento: ocultar atributos do acesso direto externo
 * - Modificadores de acesso: public, private
 * - Getters e Setters: métodos de acesso/controlados
 * - Construtores e construtores que chamam outros construtores
 * - Uso do modificador final em atributos e variáveis
 * - Diferença entre imutabilidade de variáveis e mutabilidade da referência
 */
package com.ericfr1tzenvalle.java.course.javaOO;

/**
 * Classe de exemplo para encapsulamento e construtores.
 */
public class ConstruindoEncapsulando {

    public static void main(String[] args) {
        // ===== Exercício 1: Lâmpada com encapsulamento =====
        Lamp l1 = new Lamp(true); // inicia ligada
        l1.showState();
        l1.setOff();
        l1.showState();
        l1.setOn();
        l1.showState();
        //l1.on = false; Não pode
        //So mudamos o estado da lampada atraves de metodos

        System.out.println("==============================");

        // ===== Exercício 2: Retângulo com construtores =====
        Retangulo r1 = new Retangulo(2); // quadrado de lado 2
        System.out.println("Área r1 (quadrado): " + r1.getSquare());

        Retangulo r2 = new Retangulo(2, 3); // retângulo 2x3
        System.out.println("Área r2 (retângulo): " + r2.getSquare());
    }

    /**
     * Classe que representa uma lâmpada, usando encapsulamento.
     */
    static class Lamp {
        private boolean on; // atributo privado, acessado apenas via métodos

        public Lamp(boolean isLigada) {
            this.on = isLigada;
        }

        public void setOff() {
            this.on = false;
        }

        public void setOn() {
            this.on = true;
        }

        public void showState() {
            if (this.on) {
                System.out.println("Lâmpada ligada");
            } else {
                System.out.println("Lâmpada desligada");
            }
        }
    }

    /**
     * Classe que representa um retângulo, usando construtores sobrecarregados.
     */
    static class Retangulo {
        private final double width;  // atributos finais -> imutáveis após inicialização
        private final double height;
        private final double square;

        // Construtor principal
        public Retangulo(double width, double height) {
            this.width = width;
            this.height = height;
            this.square = width * height;
        }

        // Construtor que chama outro (quadrado)
        public Retangulo(int lado) {
            this(lado, lado);
        }

        public double getSquare() {
            return square;
        }
    }
}
