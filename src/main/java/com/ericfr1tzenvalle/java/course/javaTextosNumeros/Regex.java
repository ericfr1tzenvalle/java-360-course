/*
 * Demonstração de Expressões Regulares (Regex) em Java
 * Curso Java 360 - Pattern, Matcher e manipulação de strings
 *
 * Aborda:
 * - Expressões regulares: padrão de caracteres para validação e extração de dados
 * - Metacaracteres (\d, \D, ^, $, etc.) e quantificadores ({n}, +, ?, *)
 * - Classe Pattern: representa a regex compilada
 * - Classe Matcher: encontra correspondências em uma string
 * - Métodos matches(), replaceAll() e split() para validação, limpeza e tokenização
 */
package com.ericfr1tzenvalle.java.course.javaTextosNumeros;

import java.util.*;
import java.util.regex.*;

public class Regex {

    public static void main(String[] args) {
        // Exercicio 1: Validar CPF
        System.out.println("Teste REGEX CPF");
        Pattern p = Pattern.compile("^(?:\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$");
        List<String> cpfs = Arrays.asList("047.214.650-50", "24215295068", "3212213123142");
        for (String cpf : cpfs) {
            System.out.println("CPF: " + cpf + " -> " + cpf.matches(p.toString()));
        }

        // Exercicio 2: Limpar ou extrair dígitos de uma mensagem
        System.out.println("\nLimpando mensagem com REGEX");
        String mensagem = "O1i t345ud0o b4321e342m?";
        System.out.println("Mensagem original: " + mensagem);
        System.out.println("Sem os dígitos: " + mensagem.replaceAll("\\d", ""));
        System.out.println("Só os dígitos: " + mensagem.replaceAll("\\D", ""));

        // Exercicio 3: Extrair informações de nomes de arquivos
        System.out.println("\nMáquina Fotográfica");
        String nomeArquivo = "IMG_001-1999-Tramandai.jpg";
        Photo p1 = Photo.criaInstancia(nomeArquivo);
        System.out.println(p1);
    }

    private static class Photo {

        private final String numeroSequencial;
        private final String ano;
        private final String cidade;

        public Photo(String numeroSequencial, String ano, String cidade) {
            this.numeroSequencial = numeroSequencial;
            this.ano = ano;
            this.cidade = cidade;
        }

        public static Photo criaInstancia(String nomeArquivo) {
            Pattern formato = Pattern.compile("^IMG_(\\d+)-(\\d{4})-([a-zA-Z_]+)\\.jpg$");
            Matcher matcher = formato.matcher(nomeArquivo);

            if (matcher.matches()) {
                return new Photo(matcher.group(1), matcher.group(2), matcher.group(3));
            }

            return null; 
        }

        @Override
        public String toString() {
            return "Photo: " + numeroSequencial + " Ano: " + ano + " Em: " + cidade;
        }
    }
}

/*
 * Resumo aprofundado sobre Expressões Regulares (Regex) em Java
 *
 * 1. Conceito
 * - Regex é uma linguagem de padrões para descrever sequências de caracteres.
 * - Permite validar, buscar, substituir ou extrair partes de strings de forma eficiente.
 * - Útil para validação de dados (CPF, email, telefone), parsing de logs, processamento de textos, etc.
 *
 * 2. Classes principais
 * - Pattern: representa a regex compilada em Java.
 *      Exemplo: Pattern p = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
 * - Matcher: aplica o Pattern a uma string para encontrar correspondências.
 *      Exemplo: Matcher m = p.matcher("123-45-6789"); m.matches();
 *
 * 3. Métodos mais utilizados
 * - matches(): retorna true se a string inteira casar com o padrão.
 * - find(): verifica se há correspondência parcial na string.
 * - replaceAll(String replacement): substitui todas as ocorrências que casam com o padrão.
 * - split(String regex): divide a string em partes com base no padrão.
 *
 * 4. Metacaracteres e quantificadores comuns
 * ------------------------------------------------------------------
 * Símbolo       | Significado                     | Exemplo
 * ------------------------------------------------------------------
 * .             | Qualquer caractere              | a.c → "abc", "a3c"
 * \d            | Dígito (0-9)                    | \d\d → "12", "34"
 * \D            | Não dígito                      | \D+ → "abc"
 * \w            | Caractere de palavra [a-zA-Z0-9_] | \w+ → "teste1"
 * \W            | Não caractere de palavra        | \W → "@", "!"
 * \s            | Espaço em branco                | \s → " ", "\t"
 * \S            | Não espaço                      | \S → "a", "1"
 * ^             | Início da string                | ^abc → casa "abc..." no início
 * $             | Fim da string                   | xyz$ → casa "...xyz" no final
 * []            | Conjunto de caracteres          | [aeiou] → "a", "e", ...
 * [^...]        | Negação do conjunto             | [^0-9] → não dígitos
 * ()            | Grupo de captura                | (\d{3})-(\d{2}) → captura "123-45"
 * |             | OU                              | abc|def → "abc" ou "def"
 * ?             | Zero ou um                      | colou?r → "color" ou "colour"
 * *             | Zero ou mais                    | a* → "", "a", "aa"
 * +             | Um ou mais                      | a+ → "a", "aa"
 * {n}           | Quantidade exata                | \d{3} → "123"
 * {n,m}         | Entre n e m                     | \d{2,4} → "12", "123", "1234"
 * ------------------------------------------------------------------
 *
 * 5. Boas práticas
 * - Usar Pattern.compile() uma vez e reutilizar o Pattern, em vez de criar muitas vezes.
 * - Validar inputs críticos com regex antes de processar.
 * - Testar padrões com ferramentas online (regex101.com, regexr.com) para garantir corretude.
 * - Evitar regex muito complexas ou que impactem performance (ex: backtracking excessivo).
 *
 * 6. Exemplos práticos
 * - Validação de CPF: "123.456.789-09" ou "12345678909" usando ^(?:\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$
 * - Limpeza de mensagem: remover todos os dígitos com replaceAll("\\d", "")
 * - Extração de dados de arquivo de fotos: IMG_001-1999-Cidade.jpg
 *   Pattern: ^IMG_(\\d+)-(\\d{4})-([a-zA-Z_]+)\\.jpg$
 *
 * 7. Observações
 * - Matcher.group(n) retorna o conteúdo do n-ésimo grupo capturado.
 * - Regex é case-sensitive por padrão; Pattern.CASE_INSENSITIVE permite ignorar maiúsculas/minúsculas.
 * - Para incluir caracteres especiais literais (\., *, ?, +, [, etc.) usar escape \\.
 *
 * 8. Vantagens
 * - Compacto e poderoso para manipulação de texto.
 * - Substitui muitas operações manuais com loops e condicionais.
 *
 * 9. Limitações
 * - Regex complexas podem ser difíceis de ler e manter.
 * - Performance pode ser ruim em padrões muito ambíguos ou grandes volumes de texto.
 *
 * Conclusão: Regex é uma ferramenta essencial para qualquer desenvolvedor Java que trabalhe com strings, validação de dados e extração de informações.
 */

