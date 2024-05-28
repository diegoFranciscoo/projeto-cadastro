package Testando.main.cadastros;

public class Formulario {
    protected String pergunta;

    public Formulario(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
}
