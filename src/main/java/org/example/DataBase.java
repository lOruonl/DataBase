package org.example;

import java.sql.*;

public class DataBase extends DataBaseRoots{

    public void selectRows() throws SQLException{
        String sql = "SELECT * FROM konta";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
           while(resultSet.next()){
               int id = resultSet.getInt("id");
               String email = resultSet.getString("email");
               String haslo = resultSet.getString("haslo");
               System.out.printf("ID: %d, Email: %s, Haslo: %s \n", id, email, haslo);
           }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addUser(String emailUser, String hasloUser) throws SQLException {
        String sql = "INSERT INTO konta(id, email, haslo) VALUES (NULL, ?, ?)";
        try(Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            PreparedStatement statement = connection.prepareStatement(sql)) {
            String email = emailUser;
            String haslo = hasloUser;
            statement.setString(1, email);
            statement.setString(2, haslo);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Nowy wiersz zostal dodany pomyslnie.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateAllRows(int id, String email, String haslo) throws SQLException{
        String sql = "UPDATE konta SET email = ?, haslo = ? WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            PreparedStatement statement = connection.prepareStatement(sql)){
            int idToUpdate = id;
            String newEmail = email;
            String newHaslo = haslo;
            statement.setString(1, newEmail);
            statement.setString(2, newHaslo);
            statement.setInt(3, idToUpdate);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                System.out.println("Wiersz o ID " + idToUpdate + " został zaktualizowany pomyślnie.");
            else
                System.out.println("Wiersz o ID " + idToUpdate + " nie został znaleziony.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateEmail (int id, String email) throws SQLException {
        String sql = "UPDATE konta SET email = ? WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            PreparedStatement statement = connection.prepareStatement(sql)){
            int idToUpdate = id;
            String newEmail = email;
            statement.setString(1, newEmail);
            statement.setInt(2, idToUpdate);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                System.out.println("Wiersz o ID " + idToUpdate + " został zaktualizowany pomyślnie.");
            else
                System.out.println("Wiersz o ID " + idToUpdate + " nie został znaleziony.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateHaslo (int id, String haslo) throws SQLException {
        String sql = "UPDATE konta SET haslo = ? WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            PreparedStatement statement = connection.prepareStatement(sql)){
            int idToUpdate = id;
            String newHaslo = haslo;
            statement.setString(2, newHaslo);
            statement.setInt(2, idToUpdate);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                System.out.println("Wiersz o ID " + idToUpdate + " został zaktualizowany pomyślnie.");
            else
                System.out.println("Wiersz o ID " + idToUpdate + " nie został znaleziony.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUser(int idUser) throws SQLException {
        String sql = "DELETE FROM konta WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int idToDelete = idUser;
            statement.setInt(1, idToDelete);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
                System.out.println("Wiersz o ID " + idToDelete + " zostal usuniety pomyslnie.");
            else
                System.out.println("Wiersz o ID " + idToDelete + " nie zostal znaleziony");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
