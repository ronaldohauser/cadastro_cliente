package com.backend;

import com.backend.dao.ClienteMapDAO;
import com.backend.dao.IClienteDAO;
import com.backend.domain.Cliente;

import javax.swing.*;

public class JavaApp {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        //tela inicial mostrando as opções disponiveis
        String opcao = JOptionPane.showInputDialog(null,
                "Digite uma opção: 1- CADASTRO 2- CONSULTAR 3- EXCLUSÃO 4- ALTERAR 5- SAIR",
                "CADASTRO", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
            opcao = JOptionPane.showInputDialog(null,
                    " Digite uma opção: 1- CADASTRO 2- CONSULTAR 3- EXCLUSÃO 4- ALTERAR 5- SAIR",
                    "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isOpcaoCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados separados por vírgula conforme exemplo: Nome, CPF, Tel, Endereço, Número, Cidade, Estado. ",
                        "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF para consulta: ",
                        "CONSULTAR", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExcluir(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF para exclusão: ",
                        "EXCLUSÃO", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados separados por vírgula conforme exemplo para alterar: Nome, CPF, Tel, Endereço, Número, Cidade, Estado. ",
                        "ALTERAR", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);

            }
            opcao = JOptionPane.showInputDialog(null,
                    " Digite uma opção: 1- CADASTRO 2- CONSULTAR 3- EXCLUSÃO 4- ALTERAR 5- SAIR",
                    "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        }


    }

    private static void alterar(String dados) {
        String[] dadosSeparados = dados.split(",");
        //utilizado o while para forçar o usuário a digitar todas as informações
        while (dadosSeparados.length != 7 ) {
            JOptionPane.showMessageDialog(null, "DIGITE AS INFORMAÇÕES CORRETAMENTE", "FALHA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        iClienteDAO.alterar(cliente);
        JOptionPane.showMessageDialog(null, "CLIENTE ALTERADO COM SUCESSO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
    }


    private static void excluir(String dados) {
        iClienteDAO.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "CLIENTE EXCLUÍDO COM SUCESSO", "EXCLUSÃO", JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isExcluir(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void consultar(String dados) {
        if (!dados.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "CPF DEVE CONTER APENAS NUMEROS", "FALHA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "CLIENTE ENCONTRADO" + cliente.toString(), "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "CLIENTE NÃO ENCONTRADO", "FALHA", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private static boolean isConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        //utilizado o while para forçar o usuário a digitar todas as informações
        while (dadosSeparados.length != 7 ) {
            JOptionPane.showMessageDialog(null, "DIGITE AS INFORMAÇÕES CORRETAMENTE", "FALHA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "CLIENTE JÁ SE ENCONTRA CADASTRADO", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }


    private static void sair() {
        JOptionPane.showMessageDialog(null, "ATÉ LOGO!", "FIM DO PROGRAMA!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }


    private static boolean isOpcaoCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }
}