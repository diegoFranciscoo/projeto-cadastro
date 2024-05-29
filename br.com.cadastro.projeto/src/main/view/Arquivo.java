package Testando.main.view;

import Testando.main.cadastros.CadastroPessoa;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Arquivo {
    Scanner scanner;
    CadastroPessoa cadastroPessoa;

    public Arquivo() {
        this.scanner = new Scanner(System.in);
        this.cadastroPessoa = new CadastroPessoa();
    }

    public void menuCadastroPessoa() {
        Path menuCadastro = Paths.get("br.com.cadastro.projeto/src/txt/formulario.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(menuCadastro.toFile()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void menuPrincipalTxt(){
        Path menuPrincipal = Paths.get("br.com.cadastro.projeto/src/txt/MenuPrincipal.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(menuPrincipal.toFile()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
