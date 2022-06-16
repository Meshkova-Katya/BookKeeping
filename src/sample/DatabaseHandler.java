package sample;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String url = "jdbc:mysql://127.0.0.1:3306/bookkeeping";
        String userName = dbUser;
        String password = dbPass;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, userName, password);
        return dbConnection;
    }

    public void registration(User user) throws SQLException {
        String insert = "INSERT INTO " + USER_TABLE + " ( " + USER_LOGIN + ", " + USER_PASSWORD + ") " +
                "VALUES (?, ?)";
        try {
            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {
                prSt.setString(1, user.getLogin());
                prSt.setString(2, user.getPassword());

                // Добавляет в бд
                prSt.executeUpdate();

                dialogInfo();
            }
        } catch (SQLException | ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Пользователь с таким логином уже создан!");
            alert.showAndWait();
        }
    }

    public void updateTransfer() throws SQLException {
        String insert = "INSERT INTO transfers (id_transfer, date_transfer," +
                " transfer_type," +
                " sum_transfer, id_recipient) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {
                prSt.setInt(1, TranslationHolder.getId_transfer());
                prSt.setDate(2, new Date(TranslationHolder.getDate().getTime()));
                prSt.setString(3, TranslationHolder.getViewTransfer());
                prSt.setDouble(4, TranslationHolder.getSum());
                prSt.setString(5, TranslationHolder.getNumberOrganization());
                // Обновляет данные в БД
                prSt.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            error(e.getMessage());
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

    public List<Translation> getTransfers() {
        String sql = "Select * from transfers";
        List<Translation> list = new ArrayList<>();

        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Translation p = createTransfer(rs);
                list.add(p);
            }

        } catch (SQLException ex) {
            error(ex.getMessage());
        }
        return list;
    }

    private Translation createTransfer(ResultSet rs) throws SQLException {
        Translation p = new Translation();
        try {
            p.setId(rs.getInt("id"));
            p.setId_transfer(rs.getInt("id_transfer"));
            p.setDate_transfer(rs.getDate("date_transfer"));
            p.setTransfer_type(rs.getString("transfer_type"));
            p.setSum_transfer(rs.getInt("sum_transfer"));
            p.setId_recipient(rs.getInt("id_recipient"));
        } catch (SQLException ex) {
            error(ex.getMessage());
        }
        return p;
    }

    public List<Translation> getTransferByNumber(String number) {
        String sql = "Select * from transfers where id_transfer LIKE '%" + number + "%'";
        List<Translation> list = new ArrayList<>();

        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Translation p = createTransfer(rs);
                list.add(p);
            }

        } catch (SQLException ex) {
            error(ex.getMessage());
        }
        return list;
    }


    private void dialogInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационный диалог");
        alert.setHeaderText("Новый пользователь зарегистрирован!");
        alert.showAndWait();
    }

    private void error(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();
    }

}
