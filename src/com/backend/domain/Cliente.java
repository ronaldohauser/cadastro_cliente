package com.backend.domain;

import java.util.Objects;

public class Cliente {

    public String Nome;
    public Long cpf;
    public Long tel;
    public String end;
    public Integer num;
    public String Cidade;
    public String Estado;

    public Cliente(String dadosSeparado, String dadosSeparado1, String dadosSeparado2, String dadosSeparado3, String dadosSeparado4, String dadosSeparado5, String dadosSeparado6) {
    }

    public void String (String Nome, String cpf, String tel, String end, String num, String Cidade, String Estado){

        this.Nome = Nome;
        this.cpf = Long.valueOf(cpf.trim());
        this.tel = Long.valueOf(tel.trim());
        this.end = end;
        this.num = Integer.valueOf(num.trim());
        this.Cidade = Cidade;
        this.Estado = Estado;

    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

}
