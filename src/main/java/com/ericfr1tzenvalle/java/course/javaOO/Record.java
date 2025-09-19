/*
 * Demonstração de Records em Java
 * Curso Java 360 - Records, imutabilidade e construtores
 *
 * Aborda:
 * - Records: classes imutáveis e concisas para transportar dados
 * - Criação de registros com atributos finais automaticamente
 * - Imutabilidade: campos não podem ser alterados depois da criação
 * - Possibilidade de construtores adicionais para validações
 * - Uso de Objects.requireNonNull para garantir que valores não sejam nulos
 */
package com.ericfr1tzenvalle.java.course.javaOO;

import java.util.Objects;

public class Record {

    public static void main(String[] args) {
        // Exemplo simples de record
        Person p1 = new Person("Eric", 25);
        System.out.println(p1);

        // Criando com construtor adicional
        Person p2 = new Person("Luísa", 30);
        System.out.println(p2);
    }

    private record Person(String name, int age) {
          private static int DEFAULT_AGE = 0; //metodos static sim    
        //private String date; atributos de instancia não podem
        //Construtor caso queira adicionar alguma inicialização
        public Person {
            Objects.requireNonNull(name, "Name não pode ser nulo");
            if (age < 0) throw new IllegalArgumentException("Idade não pode ser negativa");
        }

        // Possibilidade de adicionar métodos adicionais/ de instancia e static
        public String greet() {
            return "Olá, meu nome é " + name;
        }
        // Possibilidade também de adicionar construtores
        public Person(String name){
            this(name, DEFAULT_AGE);
        }
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Records oferecem forma concisa de criar classes para transportar dados, 
 *   garantindo imutabilidade e simplicidade.
 *
 * - Todos os campos de um record são finais e públicos por padrão (com getters automáticos).
 *
 * - Construtores adicionais permitem validar os dados ao criar o objeto, usando
 *   Objects.requireNonNull ou validações customizadas.
 *
 * - É possível adicionar métodos, mas não alterar os campos diretamente.
 *
 * - Records são ideais para DTOs, value objects e situações onde não é necessário
 *   comportamento complexo de classes normais.
 */
