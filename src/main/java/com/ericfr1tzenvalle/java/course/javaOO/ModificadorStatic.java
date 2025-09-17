/*
 * Demonstração do modificador static em Java
 * Curso Java 360 - Atributos estáticos, métodos estáticos, blocos estáticos e constantes
 *
 * Aborda:
 * - static: atributos e métodos compartilhados entre todas as instâncias
 * - Métodos estáticos: só podem acessar atributos estáticos diretamente
 * - Blocos estáticos: usados para inicialização
 * - Exemplos na API Java: Math, Collections, Arrays (métodos utilitários estáticos)
 * - Boas práticas: uso de static final para constantes
 */
package com.ericfr1tzenvalle.java.course.javaOO;

public class ModificadorStatic {
    public static void main(String[] args) {
        // Exercícios 1 e 2:
        // contagem de objetos criados
        Number n1 = new Number(10);
        System.out.println("n1 = " + n1.getNumber());
        System.out.println("Objetos criados: " + Number.objetosCriados);

        Number n2 = new Number(20);
        System.out.println("n2 = " + n2.getNumber());
        System.out.println("Objetos criados: " + Number.objetosCriados);

        // método estático somando dois Numbers
        Number n3 = Number.add(n2, n1);
        System.out.println("n3 = " + n3.getNumber());
        System.out.println("Objetos criados: " + Number.objetosCriados);

        // criando objetos via método de fábrica estático
        Number n4 = Number.newNumber(50);
        System.out.println("n4 = " + n4.getNumber());
        System.out.println("Objetos criados: " + Number.objetosCriados);

        
        System.out.println("Valor de PI da classe Math: " + Math.PI);
    }

    private static class Number {
        private int number;
        protected static int objetosCriados;

        // Bloco estático: executa apenas uma vez, na carga da classe, é util 
        // quando queremos inicializar statics  
        static {
            objetosCriados = 0;
            System.out.println("Classe Number carregada! Contador inicializado.");
        }

        private Number(int number) {
            this.number = number;
            objetosCriados++;
        }

        public void incrementa() {
            number++;
        }

        public int getNumber() {
            return number;
        }

        public static Number add(Number x, Number y) {
            return new Number(x.getNumber() + y.getNumber());
        }

        public int getObjetosCriados() {
            return objetosCriados;
        }

        // Método de fábrica estático, ele que decide como que é criado.
        public static Number newNumber(int n) {
            return new Number(n);
        }
    }
}
     /*
         * Resumo do que foi abordado neste exemplo:
         *
         * - Atributos estáticos pertencem à classe, e não à instância.
         *   Isso significa que todos os objetos compartilham o mesmo valor
         *   do atributo estático. No caso, "objetosCriados" é atualizado
         *   sempre que um novo Number é construído.
         *
         * - Métodos estáticos só podem acessar membros estáticos, pois não
         *   dependem de uma instância para serem chamados. Exemplo: add().
         *
         * - Blocos estáticos são executados apenas uma vez, na carga da
         *   classe em memória (quando o ClassLoader carrega a classe).
         *   Aqui usamos o bloco para inicializar "objetosCriados = 0".
         *
         * - Construtores privados controlam a criação de instâncias. Isso
         *   dá mais flexibilidade e segurança: a própria classe decide
         *   como os objetos devem ser instanciados, evitando usos
         *   incorretos. Foi usado também o método fábrica "newNumber()".
         *
         * - Boas práticas: 
         *   1. Constantes devem ser declaradas como static final, 
         *      geralmente com nomes em caixa alta (ex: MAX_VALUE).
         *   2. Evitar uso abusivo de atributos/métodos estáticos, pois
         *      quebra encapsulamento e orientações de OOP se usado em excesso.
         *   3. Static é útil para utilitários (ex: Math, Collections) e 
         *      para valores globais que devem ser compartilhados.
         *
         * - Conceito geral: static permite comportamento associado à classe
         *   em si, e não a cada objeto isolado. É uma forma de otimizar
         *   memória e centralizar comportamentos/atributos que não fazem
         *   sentido existir em cada instância separadamente.
         */