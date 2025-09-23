/*
 * Demonstração de Exceções em Java
 * Curso Java 360 - Exceptions (Checked e Unchecked)
 *
 * Aborda:
 * - Diferença entre usar códigos de erro/booleans vs. exceptions
 * - Checked Exceptions: exigem tratamento explícito (try/catch ou throws)
 * - Unchecked Exceptions (Runtime): não obrigam tratamento, geralmente bugs ou erros inesperados
 * - Estratégias: propagar exceções (throws) ou tratar localmente (try/catch)
 * - Boas práticas: usar checked para situações esperadas/recuperáveis, unchecked para falhas inesperadas
 * - Exceções customizadas: criar classes que estendem Exception ou RuntimeException
 */
package com.ericfr1tzenvalle.java.course.javaOO;

public class Excecoes {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(50);
        System.out.println("Acelerando: " + v1.accelerate());
        System.out.println("Acelerando: " + v1.accelerate());
        //Proxima chamada vai lançar a exception.
        System.out.println("Acelerando? " + v1.accelerate());
    }

    private static class Vehicle {
        private double velocidadeAtual;

        public Vehicle(double velocidadeAtual) {
            this.velocidadeAtual = velocidadeAtual;
        }

        public double accelerate() {
            if (this.velocidadeAtual * 2 > 200) {
                throw new VelocidadeMaximaException("Velocidade máxima atingida");
            }
            this.velocidadeAtual *= 2;
            return velocidadeAtual;
        }
    }

    // Podemos criar uma exception customizada
    private static class VelocidadeMaximaException extends RuntimeException {
        public VelocidadeMaximaException(String message) {
            super(message);
        }
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Exceptions substituem códigos de erro e tornam o tratamento mais claro.
 * - Checked obrigam o desenvolvedor a decidir entre tratar ou propagar.
 * - Unchecked não exigem tratamento, sendo usadas para bugs ou condições inesperadas.
 * - Podemos criar exceções customizadas que representam regras de negócio específicas.
 * - O exemplo mostra uma exceção lançada ao tentar acelerar além do limite de velocidade.
 */
