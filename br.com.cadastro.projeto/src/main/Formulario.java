package Testando.main;

public class Formulario {
    private String pergunta;

    public Formulario(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    @Override
    public String toString() {
        return "Pergunta: " + pergunta;
    }
}
