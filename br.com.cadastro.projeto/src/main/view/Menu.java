package Testando.main.view;

import Testando.main.cadastros.CadastroPergunta;
import Testando.main.cadastros.CadastroPessoa;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Arquivo arquivo;
    private CadastroPergunta cadastraPergunta;
    private CadastroPessoa cadastroPessoa;


    public Menu() {
        this.scanner = new Scanner(System.in);
        this.cadastraPergunta = new CadastroPergunta();
        this.arquivo = new Arquivo();
        this.cadastroPessoa = new CadastroPessoa();
    }

    public void menuPrincipal() {
        arquivo.menuPrincipalTxt();
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                arquivo.menuCadastroPessoa();
                cadastroPessoa.cadastraPessoa();
                menuPrincipal();
                break;
            case 2:
                cadastroPessoa.pessoasCadastradas();
                menuPrincipal();
                break;
            case 3:
                cadastraPergunta.cadastrarPergunta();
                menuPrincipal();
                break;
            case 4:
                cadastraPergunta.deletarPergunta();
                menuPrincipal();
                break;
            case 5:
                cadastroPessoa.pesquisarPorNomeEmailOuIdade();
                menuPrincipal();
                break;
            default:
                System.out.println("Opção invalida");
                menuPrincipal();
        }

    }

}
