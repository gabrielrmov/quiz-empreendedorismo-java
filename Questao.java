import java.util.List;


public class Questao {

    private String enunciado;
    private List<String> alternativas;
    private char respostaCorreta; 

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

    public boolean isRespostaCorreta(char respostaUsuario) {
        return Character.toUpperCase(respostaUsuario) == respostaCorreta;
    }

    public void exibirQuestao(int numero) {
        System.out.println("Questão " + numero + ": " + enunciado);
        char letra = 'A';
        for (String alternativa : alternativas) {
            System.out.println("   " + letra + ") " + alternativa);
            letra++;
        }
    }
}
