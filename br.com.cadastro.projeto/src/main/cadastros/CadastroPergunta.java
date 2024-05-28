package Testando.main.cadastros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroPergunta {
    private Scanner scanner;
    private List<Formulario> perguntas;


    public CadastroPergunta() {
        this.scanner = new Scanner(System.in);
        this.perguntas = new ArrayList<>();

    }

    public void cadastrarPergunta() {
        System.out.println("Escreva sua pergunta");
        String perguntaUsuario = scanner.nextLine();
        Formulario formulario = new Formulario(perguntaUsuario);
        perguntas.add(formulario);
    }

    public void deletarPergunta() {
        if(perguntas.isEmpty()){
            throw new IllegalArgumentException("A Lista está vazia");
        }
        System.out.println("Qual o numero da pergunta que voce quer deletar?");
        int t = 1;
        for (Formulario formulario : perguntas) {
            System.out.println(t + "- " + formulario.getPergunta());
            t++;
        }

        int delete = scanner.nextInt();
        if(delete < 5) {
            System.out.println("Você so pode apagar da 4 pergunta em diante");
            return;
        };
        perguntas.remove(delete - 1);
    }

}
