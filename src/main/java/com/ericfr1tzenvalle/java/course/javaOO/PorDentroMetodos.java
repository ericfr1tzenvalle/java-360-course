package com.ericfr1tzenvalle.java.course.javaOO;

/**
 * Curso Java 360: Trabalhando por dentro dos Métodos em Java.
 *
 * - Métodos: bloco de código que executa uma ação. Podem receber parâmetros e/ou retornar valores.
 * - Parâmetros: dados que passamos para o método. Eles podem ser tipos primitivos (cópia do valor) ou objetos (referência).
 * - Retorno: quando o método não é void, precisa devolver um valor usando "return".
 * - Sobrecarga de métodos: quando temos vários métodos com o mesmo nome, mas assinaturas diferentes (Java escolhe pela lista de parâmetros).
 * - Memória: tipos primitivos (int, double, boolean) guardam o valor direto; objetos guardam referências na Stack que apontam para instâncias na Heap.
 * - Inicialização: tipos primitivos começam com 0 (ou equivalente), objetos começam como null se não inicializados.
 * - NullPointerException: erro comum ao tentar acessar atributos/métodos de referências nulas.
 */
public class PorDentroMetodos {

    public static void main(String[] args) {
        // ===== FRACTION =====
        System.out.println("=== Exemplo com Frações ===");
        Fraction f1 = new Fraction(2, 3);  // 2/3
        Fraction f2 = new Fraction(4, 5);  // 4/5

        System.out.print("f1 = ");
        f1.mostraFraction();

        System.out.print("\nf2 = ");
        f2.mostraFraction();

        // multiplicação com retorno
        Fraction resultado = f1.multiplicaFracao(f2);
        System.out.print("\nResultado f1 * f2 = ");
        resultado.mostraFraction();

        // sobrecarga de métodos
        Fraction f3 = f1.multiplicaFracao(2); // multiplicando por inteiro
        System.out.print("\nResultado f1 * 2 = ");
        f3.mostraFraction();

        System.out.println("\n==============");

        // ===== WATCH =====
        System.out.println("=== Exemplo com Relógio ===");
        Watch w1 = new Watch();
        w1.setTime(2, 30, 20);
        System.out.println("Horário formatado: " + w1.readHour() + ":" + w1.readMinute() + ":" + w1.readSecond());

        // Mostrando acesso interno (pouco recomendado)
        System.out.println("Ponteiro hora (interno): " + w1.hour.number);
        System.out.println("Ponteiro minuto (interno): " + w1.minute.number);
        System.out.println("Ponteiro segundo (interno): " + w1.second.number);

        System.out.println("\n==============");

        // ===== PASSAGEM DE OBJETOS COMO PARÂMETROS =====
        System.out.println("=== Exemplo de Passagem de Objetos ===");
        alteraHora(w1); // método recebe objeto e altera
        System.out.println("Horário após alteração externa: " + w1.readHour() + ":" + w1.readMinute() + ":" + w1.readSecond());

        System.out.println("\n==============");

        // ===== INICIALIZAÇÃO PADRÃO =====
        System.out.println("=== Inicialização Padrão ===");
        Pointer ponteiro = new Pointer();
        System.out.println("Valor padrão de int: " + ponteiro.number); // começa em 0
        String texto = null;
        System.out.println("String não inicializada: " + texto);

        System.out.println("\n==============");

        // ===== NULLPOINTEREXCEPTION =====
        System.out.println("=== NullPointerException (exemplo) ===");
        Watch w2 = null;
        try {
            w2.setTime(10, 20, 30); // vai dar erro porque w2 é null
        } catch (NullPointerException e) {
            System.out.println("Tentou acessar método em referência null! -> " + e);
        }
    }

    // Método que recebe objeto como parâmetro (passagem de referência)
    public static void alteraHora(Watch relogio) {
        relogio.setTime(5, 0, 0);
    }

    // ===== CLASSE FRACTION =====
    static class Fraction {
        private int numerador;
        private int denominador;

        public Fraction(int numerador, int denominador) {
            this.numerador = numerador;
            this.denominador = denominador;
        }

        // método que recebe outro objeto Fraction
        public Fraction multiplicaFracao(Fraction x) {
            return new Fraction(this.numerador * x.numerador, this.denominador * x.denominador);
        }

        // sobrecarga: método com mesmo nome mas parâmetro diferente
        public Fraction multiplicaFracao(int numero) {
            return new Fraction(this.numerador * numero, this.denominador);
        }

        public void mostraFraction() {
            System.out.printf("%d\n--\n%d", numerador, denominador);
        }
    }

    // ===== CLASSE POINTER =====
    static class Pointer {
        int number; // se não inicializado, padrão = 0
    }

    // ===== CLASSE WATCH =====
    static class Watch {
        Pointer hour;
        Pointer minute;
        Pointer second;

        public Watch() {
            this.hour = new Pointer();
            this.minute = new Pointer();
            this.second = new Pointer();
        }

        // método com parâmetros
        public void setTime(int horas, int minutos, int segundos) {
            this.hour.number = horas;
            this.minute.number = minutos / 5;  // escala de ponteiro
            this.second.number = segundos / 5;
        }

        // métodos com retorno
        public int readHour() {
            return hour.number;
        }

        public int readMinute() {
            return minute.number * 5;
        }

        public int readSecond() {
            return second.number * 5;
        }
    }
}
