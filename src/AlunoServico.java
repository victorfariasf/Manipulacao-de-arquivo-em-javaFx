import java.util.ArrayList;

public class AlunoServico {
    public ArrayList<Aluno> transformarParaObjeto(ArrayList<String> alunos, String gabaritoOfcial) {

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
}
