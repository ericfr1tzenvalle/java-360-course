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
 * - Exceptions são mecanismos para sinalizar e lidar com erros ou condições
 *   inesperadas, substituindo o uso de códigos de retorno ou flags booleanas, o que
 *   torna o código mais legível e expressivo.
 *
 * - Checked Exceptions:
 *     - São verificadas em tempo de compilação.
 *     - O compilador obriga que sejam tratadas com `try/catch` ou propagadas com `throws`.
 *     - Indicadas para situações que podem ocorrer normalmente durante a execução, 
 *       como falhas de I/O, conexões de rede ou validações externas.
 *
 * - Unchecked Exceptions (RuntimeException e subclasses):
 *     - Não são verificadas em tempo de compilação.
 *     - Normalmente representam erros de lógica, como NullPointerException, 
 *       ArrayIndexOutOfBoundsException ou violação de regras internas.
 *     - Não obrigam tratamento, mas é importante entender o risco de falhas inesperadas.
 *
 * - Estratégias de tratamento:
 *     - Propagar a exceção (`throws`) quando não faz sentido tratar localmente.
 *     - Tratar localmente (`try/catch`) quando é possível recuperar ou fornecer
 *       uma resposta adequada ao usuário.
 *
 * - Boas práticas:
 *     - Usar checked exceptions para condições recuperáveis e esperadas.
 *     - Usar unchecked exceptions para erros inesperados ou falhas de programação.
 *     - Evitar misturar lógica de negócios com lógica de tratamento de exceções.
 *     - Criar exceptions customizadas para regras específicas de negócio, 
 *       aumentando a clareza e o significado do erro.
 *
 * - No exemplo:
 *     - A classe `Vehicle` lança uma `VelocidadeMaximaException` se tentar acelerar 
 *       além do limite.
 *     - Demonstra o uso de uma exception customizada para modelar uma regra específica 
 *       de negócio.
 */

