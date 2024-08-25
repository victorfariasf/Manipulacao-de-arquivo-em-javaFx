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
import java.util.ArrayList;

public class Fachada {

    Scanner teclado = new Scanner(System.in);
    List<Aluno> alunos = new ArrayList<>();
    Arquivos arquivo = new Arquivos(alunos);

    /*
     * public void criacaoDeArquivo(String nomeDoArquivo) {
     * arquivo.criarArquivo(nomeDoArquivo);
     * }
     */

    public void criarArquivoFx(String nomeDoArquivo, String conteudo) {
        arquivo.escreverNoArquivo(nomeDoArquivo, conteudo);
    }

    public void atualizarArquivoFx(String disciplina, String conteudo) {
        arquivo.reescreverArquivo(disciplina, conteudo);
    }

    /*
     * public void leituraDosArquivos(String nomeDoArquivo) {
     * arquivo.leituraDosAlunos(nomeDoArquivo);
     * }
     */

    public boolean verificaExistenciaDeArquivo(String nomeDoArquivo) {
        return arquivo.encontrarArquivo(nomeDoArquivo);
    }

    /*
     * public void lerDisciplina(String nomeDoArquivo) {
     * arquivo.lerArquivo(nomeDoArquivo, alunos);
     * }
     */

    public String lerAlgumDadoDoArquivoJavaFx(String nomeDoArquivo) {
        return arquivo.leituraDosAlunos(nomeDoArquivo, true);
    }

    public ArrayList<String> lerDisciplinaJavaFx(String nomeDoArquivo) {
        return arquivo.lerArquivoJavaFx(nomeDoArquivo);
    }

    public ArrayList<Aluno> transformarParaObjeto(ArrayList<String> alunos, String nomeDaDisciplina) {

        String gabaritoOfcial = arquivo.leituraDosAlunos(nomeDaDisciplina + "GABARITO", true);
        ArrayList<Aluno> alunosObj = new ArrayList<>();

        for (String x : alunos) {
            String[] dados = x.split("\t");
            alunosObj.add(new Aluno(dados[0], dados[1], gabaritoOfcial));
        }

        for (Aluno x : alunosObj) {
            x.calcularNota();
        }
        return alunosObj;
    }

    public double pegarMediaDaTurma(String disciplina, ArrayList<Aluno> alunos) {
        return arquivo.calcularMediaGeral(null, alunos);
    }

}
