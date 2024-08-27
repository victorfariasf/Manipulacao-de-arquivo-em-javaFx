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
    AlunoServico servico = new AlunoServico();

    public void criarArquivoFx(String nomeDoArquivo, String conteudo) {
        arquivo.escreverNoArquivo(nomeDoArquivo, conteudo);
    }

    public void atualizarArquivoFx(String disciplina, String conteudo) {
        arquivo.reescreverArquivo(disciplina, conteudo);
    }

    public boolean verificaExistenciaDeArquivo(String nomeDoArquivo) {
        return arquivo.encontrarArquivo(nomeDoArquivo);
    }

    public String lerAlgumDadoDoArquivoJavaFx(String nomeDoArquivo) {
        return arquivo.leituraDosAlunos(nomeDoArquivo, true);
    }

    public ArrayList<String> lerDisciplinaJavaFx(String nomeDoArquivo) {
        return arquivo.lerArquivoJavaFx(nomeDoArquivo);
    }

    public ArrayList<Aluno> StringParaObjetoAluno(ArrayList<String> alunos, String gabaritoOficial) {
        return servico.transformarParaObjeto(alunos, gabaritoOficial);
    }

    public double pegarMediaDaTurma(String disciplina, ArrayList<Aluno> alunos) {
        return arquivo.calcularMediaGeral(null, alunos);
    }

    public ArrayList<String> acessoAsDisciplinas() {
        return arquivo.verificarArquivos();
    }
}
