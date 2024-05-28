package Testando.main.view;

import Testando.main.cadastros.CadastroPessoa;

import java.io.*;
import java.util.Scanner;

public class Arquivo {
    Scanner scanner;
    CadastroPessoa cadastroPessoa;

    public Arquivo() {
        this.scanner = new Scanner(System.in);
        this.cadastroPessoa = new CadastroPessoa();
    }

    public void menuCadastroPessoa() {
        File file = new File("C:\\ProjetoCadastro\\br.com.cadastro.projeto\\src\\view\\formulario.txt");
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
    }
    public void menuPrincipalTxt(){
        File file = new File("C:\\ProjetoCadastro\\br.com.cadastro.projeto\\src\\view\\MenuPrincipal.txt");
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
    }

}
