import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivos {

    Scanner teclado = new Scanner(System.in);
    private List<Aluno> alunos;

    public Arquivos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public boolean encontrarArquivo(String nomeDoArquivo) {
        File arquivo = new File("src/files/" + nomeDoArquivo + ".txt");
        if (arquivo.exists()) {
            System.out.println("Arquivo existe");
            return true;
        } else {
            System.out.println("Arquivo não existe");
            return false;
        }
    }

    public ArrayList<String> lerArquivoJavaFx(String nomeDoArquivo) {
        ArrayList<String> alunos = new ArrayList<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/files/" + nomeDoArquivo + ".txt"));
            String linha = buffReader.readLine();
            while (linha != null) {
                System.out.println(linha);
                alunos.add(linha);
                linha = buffReader.readLine();
            }
            buffReader.close();
        } catch (IOException e) {
            System.out.println("ERRO" + e.getMessage());
        }

        return alunos;
    }

    // --------------------- AUXILIARES -------------------------

    public void leituraDosAlunos(String nomeDoArquivo) {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/files/" + nomeDoArquivo + ".txt"));
            String linha = buffReader.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = buffReader.readLine();
            }
            buffReader.close();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public String leituraDosAlunos(String nomeDoArquivo, boolean retornarComoString) {
        StringBuilder resultado = new StringBuilder();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/files/" + nomeDoArquivo + ".txt"));
            String linha = buffReader.readLine();
            while (linha != null) {
                resultado.append(linha).append("\n");
                linha = buffReader.readLine();
            }
            buffReader.close();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return resultado.toString();
    }

    public void escreverNoArquivo(String nomeDoArquivo, String texto) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/" + nomeDoArquivo + ".txt", true));
            bw.write(texto);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public double calcularMediaGeral(String nomeDoArquivo, ArrayList<Aluno> alunos) {
        System.out.println(nomeDoArquivo);
        double somaNotas = 0;
        double qntdAlunos = alunos.size();
        for (Aluno x : alunos) {
            somaNotas += x.getNota();
        }
        return somaNotas / qntdAlunos;
    }

    public void reescreverArquivo(String nomeDoArquivo, String conteudo) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/" + nomeDoArquivo + ".txt"));
            bw.write(conteudo);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("ERRO:> " + e.getMessage());
        }

    }
}
