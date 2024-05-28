package Testando.main;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    Scanner scanner;
    List<Pessoa> pessoas;
    List<Formulario> perguntas;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.pessoas = new ArrayList<>();
        this.perguntas = new ArrayList<>();
    }

    public void menuPrincipal() {
        File file = new File("C:\\ProjetoCadastro\\br.com.cadastro.projeto\\src\\MenuPrincipal.txt");
        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("1 - Cadastrar o usuário");
            bw.newLine();
            bw.write("2 - Listar todos usuários cadastrados");
            bw.newLine();
            bw.write("3 - Cadastrar nova pergunta no formulário");
            bw.newLine();
            bw.write("4 - Deletar pergunta do formulário");
            bw.newLine();
            bw.write("5 - Pesquisar usuário por nome ou idade ou email");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                lerMenu();
                break;
            case 2:
                int i = 1;
                for (Pessoa pessoa : pessoas) {
                    System.out.println(i + "- " + pessoa.getNome());
                    i++;
                }
                menuPrincipal();
                break;
            case 3:
                cadastraPergunta();
                break;
            case 4:
                deletarPergunta();
                break;
            case 5:
                pesquisarPorNomeEmailOuIdade();
                break;
            default:
                System.out.println("Opção invalida");
                menuPrincipal();
        }

    }

    private void lerMenu() {
        File file = new File("C:\\ProjetoCadastro\\br.com.cadastro.projeto\\src\\formulario.txt");
        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("1 - Qual seu nome completo?");
            bw.newLine();
            bw.write("2 - Qual seu email de contato?");
            bw.newLine();
            bw.write("3 - Qual sua idade?");
            bw.newLine();
            bw.write("4 - Qual sua altura?");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cadastraPessoa();
    }

    private void cadastraPessoa() {
        scanner.nextLine();
        String nome = scanner.nextLine();
        String email = scanner.nextLine();
        int idade = scanner.nextInt();
        scanner.nextLine();
        String alturaString = scanner.nextLine();

        validaPessoa(nome, email, idade);
        double altura = Double.parseDouble(alturaString.replace(",", "."));

        Pessoa pessoa = new Pessoa(nome, email, idade, altura);
        pessoas.add(pessoa);
        System.out.println(pessoa);

        String nomeFile = pessoas.size() + "-" + pessoa.getNome().toUpperCase();
        String diretorio = "C:\\ProjetoCadastro\\br.com.cadastro.projeto\\src\\Cadastros";
        File file = new File(diretorio, nomeFile);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
            bw.write(pessoa.getNome());
            bw.newLine();
            bw.write(pessoa.getEmail());
            bw.newLine();
            bw.write(String.valueOf(pessoa.getIdade()));
            bw.newLine();
            bw.write(String.valueOf(pessoa.getAltura()));
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        menuPrincipal();
    }

    private void validaPessoa(String nome, String email, int idade) {
        if (nome.length() < 10) {
            throw new IllegalArgumentException("O nome deve possuir no minimo 10 letras");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("O email deve conter @"); // fazer com regex
        }
        if (idade < 18) {
            throw new IllegalArgumentException("Você deve ser maior que 18 anos");
        }
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getEmail().equals(email)) {
                throw new IllegalArgumentException("O email já foi registrado");
            }
        }
    }

    private void cadastraPergunta() {
        System.out.println("Escreva sua pergunta");
        scanner.nextLine();
        String pergunta = scanner.nextLine();
        Formulario formulario = new Formulario(pergunta);
        perguntas.add(formulario);
        menuPrincipal();
    }

    private void deletarPergunta() {
        System.out.println("Qual o numero da pergunta que voce quer deletar?");
        int t = 1;
        for (Formulario formulario : perguntas) {
            System.out.println(t + "- " + formulario.getPergunta());
            t++;
        }
        int delete = scanner.nextInt();
        perguntas.remove(delete - 1);
        menuPrincipal();
    }

    public void pesquisarPorNomeEmailOuIdade() {
        if (pessoas.isEmpty()) {
            throw new RuntimeException("Sem pessoas cadastradas");
        }
        System.out.println("Você quer pesquisar por: ");
        System.out.println("1- Nome");
        System.out.println("2- Email");
        System.out.println("3- Idade");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome para pesquisar:");
                scanner.nextLine();
                String nomePesquisa = scanner.nextLine();
                List<Pessoa> listNome = pessoas.stream().filter(n -> n.getNome().contains(nomePesquisa)).toList();
                System.out.println(listNome);
                break;
            case 2:
                System.out.println("Digite o email para pesquisar:");
                scanner.next();
                String emailPesquisa = scanner.nextLine();
                List<Pessoa> listEmail = pessoas.stream().filter(n -> n.getEmail().contains(emailPesquisa)).toList();
                System.out.println(listEmail);
                break;
            case 3:
                System.out.println("Digite o idade para pesquisar:");
                int idadePesquisa = scanner.nextInt();
                List<Pessoa> listIdade = pessoas.stream().filter(n -> n.getIdade() == idadePesquisa).toList();
                System.out.println(listIdade);
                break;
        }
        menuPrincipal();

    }
}
