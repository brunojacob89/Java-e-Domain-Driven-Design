package br.com.alura.escola.academico.infra.aluno;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.academico.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscaPorCPF(CPF cpf) {
        return this.matriculados.stream()
                .filter(aluno -> aluno.getCpf().equals(cpf.getNumero())) // filtra se existe aluno com cpf passado
                .findFirst()// se encontrado devolve o primeiro
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf)); // caso nao encontrado devolve um erro
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
