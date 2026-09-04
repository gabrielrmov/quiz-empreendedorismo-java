import java.util.List;

/**
 * Representa uma questão do Quiz, contendo o enunciado, a lista de
 * alternativas e a letra correspondente à alternativa correta.
 */
public class Questao {

    private String enunciado;
    private List<String> alternativas;
    private char respostaCorreta; // 'A', 'B', 'C' ou 'D'

    public Questao(String enunciado, List<String> alternativas, char respostaCorreta) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respostaCorreta = Character.toUpperCase(respostaCorreta);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public char getRespostaCorreta() {
        return respostaCorreta;
    }

    /**
     * Verifica se a resposta informada pelo usuário está correta.
     *
     * @param respostaUsuario letra escolhida pelo usuário
     * @return true se a resposta estiver correta, false caso contrário
     */
    public boolean isRespostaCorreta(char respostaUsuario) {
        return Character.toUpperCase(respostaUsuario) == respostaCorreta;
    }

    /**
     * Exibe o enunciado da questão e suas alternativas numeradas com
     * letras (A, B, C, D...) no console.
     */
    public void exibirQuestao(int numero) {
        System.out.println("Questão " + numero + ": " + enunciado);
        char letra = 'A';
        for (String alternativa : alternativas) {
            System.out.println("   " + letra + ") " + alternativa);
            letra++;
        }
    }
}
