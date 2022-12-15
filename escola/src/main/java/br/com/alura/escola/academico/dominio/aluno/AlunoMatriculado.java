package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.academico.dominio.Evento;
import br.com.alura.escola.shared.dominio.CPF;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Evento {

    private final CPF cfpDoAluno;
    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cfpDoAluno) {
        this.cfpDoAluno = cfpDoAluno;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    public CPF getCfpDoAluno() {
        return cfpDoAluno;
    }


}
