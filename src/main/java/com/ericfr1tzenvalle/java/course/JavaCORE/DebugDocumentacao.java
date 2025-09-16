/*
 * Demonstração de documentação e debug em Java
 * Curso Java 360 - Javadoc, @Deprecated, @SuppressWarnings e Debug
 *
 * Aborda:
 *  - Javadoc: gerar documentação do seu código
 *  - @Deprecated: marcar métodos/classe como obsoletos
 *  - @SuppressWarnings: suprimir avisos do compilador
 *  - Debug: uso de breakpoints e hotkeys
 */
package com.ericfr1tzenvalle.java.course.JavaCORE;

/**
 * Classe que demonstra o uso de Javadoc e anotações
 *
 * <p>Exemplo de como documentar com Javadoc:</p>
 *
 * <pre>
 *     /** 
 *      * Soma dois números inteiros
 *      * @param a primeiro número
 *      * @param b segundo número
 *      * @return resultado da soma
 *      *\/
 *     public int soma(int a, int b) {
 *         return a + b;
 *     }
 * </pre>
 *
 * <p>Para gerar Javadoc:</p>
 * <ul>
 *   <li>No IntelliJ: <b>Tools > Generate JavaDoc</b> ou atalho <b>Alt+Shift+G</b></li>
 *   <li>No terminal: <code>javadoc -d pastaSaida NomeDaClasse.java</code></li>
 * </ul>
 */
public class DebugDocumentacao {

    /**
     * Método de exemplo marcado como obsoleto
     * @deprecated use {@link #novoMetodo()} no lugar para linkar o novo metodo
     */
    @Deprecated
    public static void metodoAntigo() {
        System.out.println("Esse método está obsoleto!");
    }

    /**
     * Novo método que substitui o antigo
     */
    public static void novoMetodo() {
        System.out.println("Esse é o método atualizado.");
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        System.out.println("Demonstração de Javadoc, @Deprecated e @SuppressWarnings");

        // Chamando o método obsoleto (gera warning)
        metodoAntigo();

        // Chamando o método novo
        novoMetodo();

        // Debug: podemos usar breakpoints para pausar a execução clicando na
        // a esquerda na linha que queremos por exemplo clique na linha 66
        int a = 10; // o codigo para aqui ai podemos f8
        int b = 20; // ir para proxima
        int soma = a + b;
        System.out.println("Soma = " + soma);

        // OBSERVAÇÕES:
        // - Breakpoint: pausa a execução em um ponto do código
        // - Step Over (F8): executa a linha atual e vai para a próxima
        // - Step Into (F7): entra dentro de métodos
        // - Step Out (Shift+F8): sai do método atual
        // - Resume (F9): continua a execução até o próximo breakpoint
        // - Usamos o debug quando queremos ver step by step a nossa aplicação
        // - Ter uma visão mais clara do que está acontecendo e onde está o ERRO
    }
}
