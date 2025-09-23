/*
 * Demonstração de Tratamento de Exceções em Java
 * Curso Java 360 - Blocos try-catch, multi-catch, finally e try-with-resources
 *
 * Aborda:
 * - Captura e tratamento de exceções com try-catch
 * - Multi-catch: captura múltiplas exceções em um único bloco
 * - Ordem de catch: sempre tratar exceções específicas antes das genéricas
 * - Bloco finally: garante execução de código independentemente da exceção
 * - Try-with-resources: gerenciamento automático de recursos que implementam AutoCloseable
 * - Transformação de exceções: capturar uma exceção e lançar outra mais adequada
 * - Boas práticas no tratamento de erros
 */
package com.ericfr1tzenvalle.java.course.javaOO;

import java.util.Scanner;

public class TratandoExcecoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int number1 = lerNumero(sc);
        int number2 = lerNumero(sc);
        
        System.out.println("Resposta: " + (number1 + number2));
    }

    public static int lerNumero(Scanner sc) {
        int number;
        try {
            return number = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            // Retorna um valor padrão caso o usuário digite algo inválido
            return 10;
        }
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Blocos try-catch permitem capturar e tratar exceções, evitando que o programa
 *   quebre inesperadamente.
 *
 * - Podemos ter múltiplos catch em um mesmo try, mas apenas o primeiro catch que
 *   corresponder à exceção lançada será executado.
 *
 * - Multi-catch: é possível capturar múltiplas exceções no mesmo bloco catch usando '|'.
 *
 * - Ordem de catch: sempre tratar primeiro as exceções mais específicas e deixar as
 *   mais genéricas por último, para evitar que uma exceção específica seja "engolida".
 *
 * - Bloco finally: garante que um trecho de código será executado independentemente
 *   de exceções, útil para liberar recursos (como arquivos ou conexões).
 *
 * - Try-with-resources: facilita o gerenciamento automático de recursos que implementam
 *   AutoCloseable (como Scanner, FileReader), evitando vazamentos de recursos.
 *
 * - Transformar exceções: às vezes é vantajoso capturar uma exceção e lançar uma
 *   outra (mais genérica ou específica do serviço) para esconder detalhes de implementação
 *   e padronizar o tratamento de erros.
 *
 * - Boas práticas:
 *     - Sempre capturar exceções que você consegue tratar ou que fazem sentido
 *       repassar.
 *     - Evitar catch genérico sem ação, pois pode mascarar erros importantes.
 *     - Utilizar mensagens claras nas exceptions customizadas para facilitar debugging.
 *
 * - No exemplo:
 *     - O método `lerNumero` usa try-catch para capturar `NumberFormatException`.
 *     - Quando o usuário digita um valor inválido, o método retorna 10 por padrão.
 */
