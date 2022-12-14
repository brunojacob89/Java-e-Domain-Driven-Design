package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador ) {
        this.repositorio = repositorio;
        this.publicador = publicador;
    }

    //Padrao de Projeto COMMAND
    public void executa(MatricularAlunoDto dados) {

        Aluno novoAluno = dados.criarAluno();
        repositorio.matricular(novoAluno);

        AlunoMatriculado evento = new AlunoMatriculado(novoAluno.getCpf());
        publicador.publicar(evento);
    }
}
