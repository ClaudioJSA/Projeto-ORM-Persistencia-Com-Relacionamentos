/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import credential.Credential;

/**
 *
 * @author ev;
 */

public class Autentication {

    public static boolean autenticate(Credential credential) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, credential.getUsername());
                statement.setString(2, credential.getPassword());
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next(); // Retorna true se encontrar um usuário com as credenciais
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}