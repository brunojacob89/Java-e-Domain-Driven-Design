package br.com.alura.escola.shared.dominio;

import java.util.regex.Pattern;

public class CPF {

   private String numero;

    public CPF(String numero) {
        if(numero == null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw  new IllegalArgumentException("br.com.alura.escola.aluno.CPF invalido!");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero;
    }
}
