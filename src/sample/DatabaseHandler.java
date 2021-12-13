package sample;

import javafx.scene.control.Alert;

import java.sql.*;

import static sample.ConstOrganizatsiyaRecipient.NAME_RECIPIENT;

import static sample.ConstUser.*;

public class DatabaseHandler extends Configs {
    static Connection dbConnection;


    static {
        try {
            dbConnection = getDbConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost/bookkeeping?serverTimezone=Europe/Moscow&useSSL=false";
        String userName = dbUser;
        String password = dbPass;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, userName, password);
        return dbConnection;
    }

    public void registration(User user) throws SQLException {

        String insert = "INSERT INTO " + USER_TABLE + " ( " + USER_LOGIN + ", " + USER_PASSWORD + ") " + "VALUES (?, ?)";


        try {

            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {


                prSt.setString(1, user.getLogin());
                prSt.setString(2, user.getPassword());

                // Добавляет в бд
                prSt.executeUpdate();

                dialogInfo();


            }
        } catch (SQLException | ClassNotFoundException e) {

            error();
        }
    }

    public User authorization(String login, String password) {
        User user = null;
        String select = "SELECT * FROM " + USER_TABLE + " WHERE " +
                USER_LOGIN + "=? AND " + USER_PASSWORD + "=?";

        try (PreparedStatement prSt = getDbConnection().prepareStatement(select)) {

            prSt.setString(1, login);
            prSt.setString(2, password);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                user = new User();


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /*
        public void add() {

            String select = "SELECT * FROM " + ORGANIZATSIYA_TABLE;
            try (PreparedStatement prSt = getDbConnection().prepareStatement(select)) {

                ResultSet resultSet = prSt.executeQuery();
                while (resultSet.next()) {
                OrganizatsiyaRecipient    organizatsiyaRecipient = new OrganizatsiyaRecipient();
                    organizatsiyaRecipient.setId_recipient(resultSet.getString(1));
                    organizatsiyaRecipient.setName_recipient(resultSet.getString(2));
                    organizatsiyaRecipient.getCity_recipient();
                    organizatsiyaRecipient.getStreet_recipient();
                    organizatsiyaRecipient.getType_organization();

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            }

        }

     */
    public void info(OrganizatsiyaRecipient organizatsiyaRecipient) {
         organizatsiyaRecipient = new OrganizatsiyaRecipient();
        String select = "SELECT * FROM " + USER_TABLE + " WHERE " +
                NAME_RECIPIENT + "= ПРОТЕК ";

        try (PreparedStatement prSt = getDbConnection().prepareStatement(select)) {


            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                prSt.setString(1, organizatsiyaRecipient.getId_recipient());
                prSt.setString(2, organizatsiyaRecipient.getName_recipient());
                prSt.setString(3, organizatsiyaRecipient.getCity_recipient());
                prSt.setString(4, organizatsiyaRecipient.getStreet_recipient());
                prSt.setString(5, organizatsiyaRecipient.getType_organization());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dialogInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационный диалог");
        alert.setHeaderText("Новый пользователь зарегистрирован!");
        alert.showAndWait();
    }

    private void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Пользователь с таким логином уже создан!");
        alert.showAndWait();
    }
}
