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
        while(opcao != 0) {
            switch (opcao) {
                case 1:
                    arquivo.menuCadastroPessoa();
                    cadastroPessoa.cadastraPessoa();
                    break;
                case 2:
                    cadastroPessoa.pessoasCadastradas();
                    break;
                case 3:
                    cadastraPergunta.cadastrarPergunta();
                    break;
                case 4:
                    cadastraPergunta.deletarPergunta();
                    break;
                case 5:
                    cadastroPessoa.pesquisarPorNomeEmailOuIdade();
                    break;
                default:
                    System.out.println("Opção invalida");
            }
            arquivo.menuPrincipalTxt();
            opcao = scanner.nextInt();
        }
    }
    }


