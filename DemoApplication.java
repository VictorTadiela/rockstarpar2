package com.example.demo;

import org.example.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException {
// Defina as informações de conexão
        String url = "jdbc:mysql://127.0.0.1:3306/rockstar";
        String user = "root"; // Nome do usuário
        String password = null; // Senha do banco de dados
// Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(url, user, null)) {
            System.out.println("Conexão realizada com sucesso");
         

                    String queryFuncionarios = " select * from funcionarios";
                    try(Statement funcionarios = conexao.createStatement();
                    ResultSet Funcionarios = funcionarios.executeQuery(queryFuncionarios) ) {
                        System.out.println("---------------------- Funcionarios ----------------------");
                        while (Funcionarios.next()) {
                            System.out.println("");
                            System.out.println("id_funcinario: " + Funcionarios.getString("id_funcionario"));
                            System.out.println("NOME_FUNCIONARIOS: " + Funcionarios.getString("nome_funcionarios"));
                            System.out.println("Data_nascimento: " + Funcionarios.getString("Data_nascimento"));
                            System.out.println("Telefone: " + Funcionarios.getString( "Telefone"));
                            System.out.println("Email: " + Funcionarios.getString("Email"));
                            System.out.println("Emissao: " + Funcionarios.getString("Emissao"));
                            System.out.println("Cargo: " + Funcionarios.getString("Cargo"));
                            System.out.println("Departamento: " + Funcionarios.getString("Departamento"));


                        }
                        String querySalarios = "select * from salarios";
                        try (Statement salarios = conexao.createStatement();
                             ResultSet Salarios = salarios.executeQuery(querySalarios)) {
                            System.out.println("---------------------- Salarios ----------------------");
                            while (Salarios.next()) {
                                System.out.println("");
                                System.out.println("id_salarios: " + Salarios.getString("id_salarios"));
                                System.out.println("Funcionario: "+ Salarios.getString("Fucionario"));
                                System.out.println("Cargo: " + Salarios.getString("Cargo"));
                                System.out.println("Salario: " + Salarios.getString("Salario"));
                                System.out.println("Inicio: " + Salarios.getString("inicio"));
                                System.out.println("Fim: " + Salarios.getString( "Fim"));


                            }

                        }
                    }
                    {

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
