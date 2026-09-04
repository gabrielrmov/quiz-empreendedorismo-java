import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Sistema de Quiz (Perguntas e Respostas) - Tema: Empreendedorismo e Negócios
 *
 * Disciplina: Algoritmos e Linguagem de Programação II
 * Trabalho: Sistema de Quiz em Java (Console)
 */
public class Main {

    // TODO: ajuste estes dados antes de entregar o trabalho
    private static final String NOME_ALUNO = "Gabriel Rodrigues Cabral";
    private static final String NOME_PROFESSOR = "Nome do Professor";
    private static final String NOME_FACULDADE = "Nome da Faculdade";

    public static void main(String[] args) {
        // Garante acentuação correta no console, independente do sistema operacional
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        exibirCabecalho();

        List<Questao> questoes = criarQuestoes();

        int acertos = 0;

        for (int i = 0; i < questoes.size(); i++) {
            Questao questaoAtual = questoes.get(i);
            questaoAtual.exibirQuestao(i + 1);

            char respostaUsuario = lerResposta(scanner, questaoAtual.getAlternativas().size());

            if (questaoAtual.isRespostaCorreta(respostaUsuario)) {
                System.out.println("Resposta correta!\n");
                acertos++;
            } else {
                System.out.println("Resposta incorreta. A alternativa correta era a letra "
                        + questaoAtual.getRespostaCorreta() + ".\n");
            }
        }

        exibirResultado(acertos, questoes.size());

        scanner.close();
    }

    /**
     * Exibe o cabeçalho inicial do sistema com nome do aluno,
     * do professor e da faculdade.
     */
    private static void exibirCabecalho() {
        System.out.println("========================================================");
        System.out.println(" SISTEMA DE QUIZ - PERGUNTAS E RESPOSTAS");
        System.out.println(" Tema: Empreendedorismo e Negócios");
        System.out.println("========================================================");
        System.out.println(" Aluno(a): " + NOME_ALUNO);
        System.out.println(" Professor(a): " + NOME_PROFESSOR);
        System.out.println(" Faculdade: " + NOME_FACULDADE);
        System.out.println("========================================================\n");
    }

    /**
     * Lê e valida a resposta digitada pelo usuário, garantindo que
     * corresponda a uma das letras disponíveis para a questão atual.
     */
    private static char lerResposta(Scanner scanner, int quantidadeAlternativas) {
        char letraMaxima = (char) ('A' + quantidadeAlternativas - 1);
        String entrada;
        char resposta;

        while (true) {
            System.out.print("Digite a letra da alternativa escolhida (A a "
                    + letraMaxima + "): ");
            entrada = scanner.nextLine().trim().toUpperCase();

            if (entrada.length() == 1) {
                resposta = entrada.charAt(0);
                if (resposta >= 'A' && resposta <= letraMaxima) {
                    return resposta;
                }
            }

            System.out.println("Opção inválida! Tente novamente.");
        }
    }

    /**
     * Exibe o total de acertos, a porcentagem de aproveitamento e a
     * mensagem de agradecimento final.
     */
    private static void exibirResultado(int acertos, int totalQuestoes) {
        double porcentagem = (acertos / (double) totalQuestoes) * 100;

        System.out.println("========================================================");
        System.out.println(" RESULTADO FINAL");
        System.out.println("========================================================");
        System.out.println(" Total de questões: " + totalQuestoes);
        System.out.println(" Acertos: " + acertos);
        System.out.println(" Erros: " + (totalQuestoes - acertos));
        System.out.printf(Locale.US, " Aproveitamento: %.2f%%%n", porcentagem);
        System.out.println("========================================================");
        System.out.println("\nObrigado por participar do Quiz! Esperamos que você tenha");
        System.out.println("aprendido um pouco mais sobre Empreendedorismo e Negócios.");
    }

    /**
     * Cria e retorna a lista com as 15 questões do Quiz.
     */
    private static List<Questao> criarQuestoes() {
        List<Questao> questoes = new ArrayList<>();

        questoes.add(new Questao(
                "O que é um empreendedor?",
                List.of(
                        "Uma pessoa que identifica oportunidades e assume riscos para criar ou expandir um negócio",
                        "Um funcionário que segue ordens sem tomar decisões",
                        "Um investidor que nunca assume riscos",
                        "Um consumidor que compra produtos inovadores"
                ),
                'A'));

        questoes.add(new Questao(
                "O que é um MVP (Minimum Viable Product)?",
                List.of(
                        "O produto final, com todas as funcionalidades possíveis",
                        "A versão mais simples de um produto que já entrega valor ao cliente e permite testar hipóteses",
                        "Um plano de marketing completo",
                        "Um tipo de financiamento coletivo"
                ),
                'B'));

        questoes.add(new Questao(
                "O que significa a sigla SWOT (ou FOFA, em português)?",
                List.of(
                        "Forças, Oportunidades, Fraquezas e Ameaças",
                        "Faturamento, Objetivos, Finanças e Ativos",
                        "Fornecedores, Ofertas, Funcionários e Ativos",
                        "Foco, Organização, Flexibilidade e Autonomia"
                ),
                'A'));

        questoes.add(new Questao(
                "O que é um plano de negócios (business plan)?",
                List.of(
                        "Um documento útil apenas para captar investidores, sem uso interno",
                        "Um documento que descreve os objetivos do negócio e os passos para alcançá-los",
                        "Um contrato entre sócios",
                        "Um relatório fiscal obrigatório"
                ),
                'B'));

        questoes.add(new Questao(
                "O que é 'público-alvo'?",
                List.of(
                        "O grupo de concorrentes diretos da empresa",
                        "O conjunto de fornecedores da empresa",
                        "O grupo de consumidores com maior probabilidade de comprar o produto/serviço",
                        "O quadro de funcionários da empresa"
                ),
                'C'));

        questoes.add(new Questao(
                "O que é ponto de equilíbrio (break-even point)?",
                List.of(
                        "O momento em que a empresa quebra e encerra as atividades",
                        "O momento em que a receita se iguala aos custos, sem lucro ou prejuízo",
                        "O lucro máximo que uma empresa pode alcançar",
                        "O valor investido inicialmente pelo empreendedor"
                ),
                'B'));

        questoes.add(new Questao(
                "O que é fluxo de caixa?",
                List.of(
                        "O registro de todas as entradas e saídas de dinheiro da empresa em um período",
                        "O valor total do patrimônio da empresa",
                        "Um tipo de empréstimo bancário",
                        "O lucro líquido anual"
                ),
                'A'));

        questoes.add(new Questao(
                "O que é uma startup?",
                List.of(
                        "Uma empresa familiar tradicional, sem uso de tecnologia",
                        "Um negócio inovador, geralmente com modelo escalável e alto grau de incerteza",
                        "Uma filial de uma grande corporação",
                        "Um tipo de ONG"
                ),
                'B'));

        questoes.add(new Questao(
                "O que caracteriza um negócio 'escalável'?",
                List.of(
                        "Aumentar a receita sem um aumento proporcional nos custos",
                        "Precisar contratar um novo funcionário para cada novo cliente",
                        "Depender exclusivamente de vendas presenciais",
                        "Ter faturamento fixo todos os meses"
                ),
                'A'));

        questoes.add(new Questao(
                "O que é um elevator pitch?",
                List.of(
                        "Um contrato de investimento",
                        "Uma apresentação rápida e persuasiva de uma ideia de negócio",
                        "Um tipo de financiamento bancário",
                        "Um relatório financeiro trimestral"
                ),
                'B'));

        questoes.add(new Questao(
                "No Brasil, o que é o MEI?",
                List.of(
                        "Microempreendedor Individual, categoria simplificada de formalização",
                        "Um tipo de imposto sobre grandes empresas",
                        "Um fundo de investimento em startups",
                        "Um órgão fiscalizador do comércio"
                ),
                'A'));

        questoes.add(new Questao(
                "O que é ROI (Retorno sobre Investimento)?",
                List.of(
                        "O valor total gasto em marketing",
                        "Uma métrica que mede o ganho ou perda gerado por um investimento em relação ao seu custo",
                        "O número de clientes conquistados em um mês",
                        "O capital social de uma empresa"
                ),
                'B'));

        questoes.add(new Questao(
                "O que é branding?",
                List.of(
                        "O processo de construção e gestão da marca de uma empresa",
                        "O cálculo de impostos sobre vendas",
                        "A elaboração do contrato social",
                        "O processo de contratação de funcionários"
                ),
                'A'));

        questoes.add(new Questao(
                "O que diferencia uma franquia de um negócio próprio independente?",
                List.of(
                        "Não há diferença; ambos operam exatamente do mesmo modo",
                        "Na franquia, o franqueado utiliza a marca e o modelo de negócio de um franqueador mediante contrato",
                        "A franquia não permite ao empreendedor ter autonomia nenhuma",
                        "O negócio independente sempre exige mais capital do que uma franquia"
                ),
                'B'));

        questoes.add(new Questao(
                "Por que a análise da concorrência é importante para um empreendedor?",
                List.of(
                        "Porque permite copiar exatamente o que os concorrentes fazem",
                        "Porque é obrigatória por lei antes de abrir uma empresa",
                        "Porque ajuda a identificar diferenciais, oportunidades e ameaças no mercado",
                        "Porque elimina a necessidade de um plano de negócios"
                ),
                'C'));

        return questoes;
    }
}
