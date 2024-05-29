package Testando.main.cadastros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroPessoa {
    private Scanner scanner;
    private List<Pessoa> pessoas;

    public CadastroPessoa() {
        this.scanner = new Scanner(System.in);
        this.pessoas = new ArrayList<>();
    }

    public void cadastraPessoa() {

        String nome = scanner.nextLine();
        String email = scanner.nextLine();
        int idade = scanner.nextInt();
        scanner.nextLine();
        String alturaString = scanner.nextLine();


        double altura = Double.parseDouble(alturaString.replace(",", "."));
        validaPessoa(nome, email, idade);

        Pessoa pessoa = new Pessoa(nome, email, idade, altura);
        pessoas.add(pessoa);

        Path diretorio = Paths.get("br.com.cadastro.projeto/src/Cadastrados");
        try {
            if (Files.notExists(diretorio)) {
                Path diretorioCadastrados = Files.createDirectories(diretorio);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String nomeFile = pessoas.size() + "-" + pessoa.getNome().toUpperCase();
        Path fileCadastrados = Paths.get(diretorio.toString(), nomeFile);


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileCadastrados.toFile()));) {
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
    }


    public void validaPessoa(String nome, String email, int idade) {
        if (nome.length() < 10) throw new IllegalArgumentException("O nome deve possuir no minimo 10 letras");

        if (!email.contains("@")) throw new IllegalArgumentException("O email deve conter @");

        if (idade < 18) throw new IllegalArgumentException("Você deve ser maior que 18 anos");


        for (Pessoa pessoa : pessoas) {
            if (pessoa.getEmail().equals(email)) throw new IllegalArgumentException("O email já foi registrado");

        }
    }

    public void pessoasCadastradas() {
        if (pessoas.isEmpty()) throw new RuntimeException("Sem pessoas cadastradas");

        int i = 1;
        for (Pessoa pessoa : pessoas) {
            System.out.println(i + "- " + pessoa.getNome());
            i++;
        }
    }

    public void pesquisarPorNomeEmailOuIdade() {

        if (pessoas.isEmpty()) throw new RuntimeException("Sem pessoas cadastradas");


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
                List<Pessoa> listNome = pessoas.stream().filter(n -> n.getNome().startsWith(nomePesquisa)).toList();
                if (!listNome.isEmpty()) {
                    System.out.println(listNome);
                } else {
                    System.out.println("Nenhum usuario foi encontrado");
                }
                break;
            case 2:
                System.out.println("Digite o email para pesquisar:");
                scanner.next();
                String emailPesquisa = scanner.nextLine();
                List<Pessoa> listEmail = pessoas.stream().filter(n -> n.getEmail().startsWith(emailPesquisa)).toList();
                if (!listEmail.isEmpty()) {
                    System.out.println(listEmail);
                } else {
                    System.out.println("Nenhum usuario foi encontrado");
                }
                break;
            case 3:
                System.out.println("Digite o idade para pesquisar:");
                int idadePesquisa = scanner.nextInt();
                List<Pessoa> listIdade = pessoas.stream().filter(n -> n.getIdade() == idadePesquisa).toList();
                if (!listIdade.isEmpty()) {
                    System.out.println(listIdade);
                } else {
                    System.out.println("Nenhum usuario foi encontrado");
                }
                System.out.println(listIdade);
                break;
        }
    }
}
