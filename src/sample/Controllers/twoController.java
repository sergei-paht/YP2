package sample.Controllers;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import sample.DatabaseHandler;
import sample.Main;
import sample.POJO.table;
import sample.POJO.tableEduc;
import sample.POJO.tableMyData;
import sample.POJO.tableParents;

public class twoController {
    private ObservableList<table> tableData = FXCollections.observableArrayList();
    private ObservableList<tableEduc> tableDataEduc = FXCollections.observableArrayList();
    private ObservableList<tableMyData> tableDataMyData = FXCollections.observableArrayList();
    private ObservableList<tableParents> tableDataParents = FXCollections.observableArrayList();
    private table selectedAbit = new table();
    private tableEduc selectedEduc = new tableEduc();
    private tableMyData selectedMyData = new tableMyData();
    private tableParents selectedParents = new tableParents();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<table, String> adressAbit;

    @FXML
    private TableColumn<tableParents, String> adressDad;

    @FXML
    private TableColumn<tableParents, String> adressMom;

    @FXML
    private TableColumn<table, String> birthdayAbit;

    @FXML
    private TableColumn<tableEduc, String> defBalAtest;


    @FXML
    private TableColumn<table, String> fioAbit;

    @FXML
    private TableColumn<tableParents, String> fioDad;

    @FXML
    private TableColumn<tableParents, String> fioMom;

    @FXML
    private TableColumn<tableEduc, Integer> idEduc;

    @FXML
    private TableColumn<table, Integer> idPasport;

    @FXML
    private TableColumn<tableParents, Integer> idRodich;

    @FXML
    private TableColumn<table, Integer> idabit;

    @FXML
    private TableColumn<tableEduc, String> lastEduc;

    @FXML
    private Button mainButton;

    @FXML
    private TableColumn<tableEduc, String> numAtest;

    @FXML
    private TableColumn<tableMyData, String> pasportDann;

    @FXML
    private TableColumn<tableEduc, String> specialnost;

    @FXML
    private TableView<table> tableAbitfull;

    @FXML
    private TableView<tableEduc> tableEducationfull;

    @FXML
    private TableView<tableParents> tableParentsfull;

    @FXML
    private TableView<tableMyData> tablePasportfull;

    @FXML
    private TableColumn<table, String> telAbit;

    @FXML
    private TableColumn<tableParents, String> telDad;

    @FXML
    private TableColumn<tableParents, String> telMom;

    @FXML
    private TableColumn<tableParents, String> workDad;

    @FXML
    private TableColumn<tableParents, String> workMom;

    @FXML
    private Button addAbit;

    @FXML
    private Button addEduc;

    @FXML
    private Button addMyData;

    @FXML
    private Button addParents;

    @FXML
    private Button delAbit;

    @FXML
    private Button delEduc;

    @FXML
    private Button delMyData;

    @FXML
    private Button delParents;


    //

    @FXML
    private Button cancelAddAbit;

    @FXML
    private Button cancelAddEduc;

    @FXML
    private Button cancelAddMyData;

    @FXML
    private Button cancelAddParents;

    @FXML
    private Pane paneAbit;

    @FXML
    private Button paneAddAbit;

    @FXML
    private Button paneAddEduc;

    @FXML
    private Button paneAddMyData;

    @FXML
    private Button paneAddParents;

    @FXML
    private TextField paneAdressAbit;

    @FXML
    private TextField paneAdressDad;

    @FXML
    private TextField paneAdressMom;

    @FXML
    private TextField paneBirthdayAbit;

    @FXML
    private TextField paneDefoultAttestat;

    @FXML
    private Pane paneEduc;

    @FXML
    private TextField paneFioAbit;

    @FXML
    private TextField paneFioDad;

    @FXML
    private TextField paneFioMom;

    @FXML
    private TextField paneLastEduc;

    @FXML
    private Pane paneMyData;

    @FXML
    private TextField paneNumAttestat;

    @FXML
    private Pane paneParents;

    @FXML
    private TextField panePasport;

    @FXML
    private TextField paneSpecialnost;

    @FXML
    private TextField paneTelAbit;

    @FXML
    private TextField paneTelDad;

    @FXML
    private TextField paneTelMom;

    @FXML
    private TextField paneWorkDad;

    @FXML
    private TextField paneWorkMom;



    @FXML
    void initialize() {
        paneAbit.setVisible(false);
        paneEduc.setVisible(false);
        paneMyData.setVisible(false);
        paneParents.setVisible(false);

        addAbit.setOnAction(event -> {
            paneAbit.setVisible(true);
        });
        addEduc.setOnAction(event -> {
            paneEduc.setVisible(true);
        });
        addMyData.setOnAction(event -> {
            paneMyData.setVisible(true);
        });
        addParents.setOnAction(event -> {
            paneParents.setVisible(true);
        });
        cancelAddAbit.setOnAction(event -> {
            paneAbit.setVisible(false);
        });
        cancelAddEduc.setOnAction(event -> {
            paneEduc.setVisible(false);
        });
        cancelAddMyData.setOnAction(event -> {
            paneMyData.setVisible(false);
        });
        cancelAddParents.setOnAction(event -> {
            paneParents.setVisible(false);
        });
// добавление данных
        paneAddAbit.setOnAction(event -> {
            paneAbit.setVisible(false);
            if (!(paneFioAbit.getText().isEmpty() || paneBirthdayAbit.getText().isEmpty()
                    || paneAdressAbit.getText().isEmpty() || paneTelAbit.getText().isEmpty())) {
                try {
                        dbConnection = getDbConnection();
                        PreparedStatement statement = dbConnection.prepareStatement
                                ("INSERT into абитуриенты(`ФИО абитуриента`,`Дата рождения`,`Домашний адрес`,`Контактный телефон`)VALUES(?,?,?,?)");
                        statement.setString(1, paneFioAbit.getText());
                        statement.setString(2, paneBirthdayAbit.getText());
                        statement.setString(3, paneAdressAbit.getText());
                        statement.setString(4, paneTelAbit.getText());
                        statement.executeUpdate();
                        tableRefresh();
                    }
                catch (Exception e) {
                    e.printStackTrace();
                }}
        });

        paneAddEduc.setOnAction(event -> {
            paneEduc.setVisible(false);
            if (!(paneLastEduc.getText().isEmpty() || paneNumAttestat.getText().isEmpty()
                    || paneDefoultAttestat.getText().isEmpty() || paneSpecialnost.getText().isEmpty())) {
                try {
                    dbConnection = getDbConnection();
                    PreparedStatement statement = dbConnection.prepareStatement
                            ("INSERT into образование(`Уровень предыдущего образования`,`Номер аттестата`,`Средний балл аттестата`,Специальность)VALUES(?,?,?,?)");
                    statement.setString(1, paneLastEduc.getText());
                    statement.setString(2, paneNumAttestat.getText());
                    statement.setString(3, paneDefoultAttestat.getText());
                    statement.setString(4, paneSpecialnost.getText());
                    statement.executeUpdate();
                    tableRefresh();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }}
        });

        paneAddMyData.setOnAction(event -> {
            paneMyData.setVisible(false);
            if (!(panePasport.getText().isEmpty())) {
                try {
                    dbConnection = getDbConnection();
                    PreparedStatement statement = dbConnection.prepareStatement
                            ("INSERT into `личные данные`(`Паспортные данные`)VALUES(?)");
                    statement.setString(1, panePasport.getText());
                    statement.executeUpdate();
                    tableRefresh();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }}
        });

        paneAddParents.setOnAction(event -> {
            paneParents.setVisible(false);
            if (!(paneFioMom.getText().isEmpty() || paneAdressMom.getText().isEmpty()
                    || paneTelMom.getText().isEmpty() || paneWorkMom.getText().isEmpty() || paneFioDad.getText().isEmpty()
                    || paneAdressDad.getText().isEmpty()
                    || paneTelDad.getText().isEmpty() || paneWorkDad.getText().isEmpty())) {
                try {
                    dbConnection = getDbConnection();
                    PreparedStatement statement = dbConnection.prepareStatement
                            ("INSERT into родители(`ФИО мамы`,`Домашний адрес мамы`,`Контактный телефон мамы`,`Место работы мамы`," +
                                    " `ФИО папы`,`Домашний адрес папы`,`Контактный телефон папы`,`Место работы папы`)VALUES(?,?,?,?,?,?,?,?)");
                    statement.setString(1, paneFioMom.getText());
                    statement.setString(2, paneAdressMom.getText());
                    statement.setString(3, paneTelMom.getText());
                    statement.setString(4, paneWorkMom.getText());
                    statement.setString(5, paneFioDad.getText());
                    statement.setString(6, paneAdressDad.getText());
                    statement.setString(7, paneTelDad.getText());
                    statement.setString(8, paneWorkDad.getText());
                    statement.executeUpdate();
                    tableRefresh();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }}
        });

        DatabaseHandler dataBaseHandler = new DatabaseHandler();

        initAbit();
        idabit.setCellValueFactory(new PropertyValueFactory<table, Integer>("idAbit"));
        fioAbit.setCellValueFactory(new PropertyValueFactory<table, String>("fioAbit"));
        birthdayAbit.setCellValueFactory(new PropertyValueFactory<table, String>("birthdayAbit"));
        adressAbit.setCellValueFactory(new PropertyValueFactory<table, String>("adressAbit"));
        telAbit.setCellValueFactory(new PropertyValueFactory<table, String>("telAbit"));
        // заполняем таблицу данными
        tableAbitfull.setItems(tableData);

        initEduc();
        idEduc.setCellValueFactory(new PropertyValueFactory<tableEduc, Integer>("idAbit"));
        lastEduc.setCellValueFactory(new PropertyValueFactory<tableEduc, String>("levelLastEducation"));
        numAtest.setCellValueFactory(new PropertyValueFactory<tableEduc, String>("numberAtestat"));
        defBalAtest.setCellValueFactory(new PropertyValueFactory<tableEduc, String>("defoultBallAtestat"));
        specialnost.setCellValueFactory(new PropertyValueFactory<tableEduc, String>("specialnost"));
        // заполняем таблицу данными
        tableEducationfull.setItems(tableDataEduc);

        initMyData();
        idPasport.setCellValueFactory(new PropertyValueFactory<table, Integer>("idAbit"));
        pasportDann.setCellValueFactory(new PropertyValueFactory<tableMyData, String>("pasportAbit"));

        // заполняем таблицу данными
        tablePasportfull.setItems(tableDataMyData);

        initParents();
        idRodich.setCellValueFactory(new PropertyValueFactory<tableParents, Integer>("idAbit"));
        fioMom.setCellValueFactory(new PropertyValueFactory<tableParents, String>("fioMom"));
        adressMom.setCellValueFactory(new PropertyValueFactory<tableParents, String>("adressMom"));
        telMom.setCellValueFactory(new PropertyValueFactory<tableParents, String>("telMom"));
        workMom.setCellValueFactory(new PropertyValueFactory<tableParents, String>("workMom"));
        fioDad.setCellValueFactory(new PropertyValueFactory<tableParents, String>("fioDad"));
        adressDad.setCellValueFactory(new PropertyValueFactory<tableParents, String>("adressDad"));
        telDad.setCellValueFactory(new PropertyValueFactory<tableParents, String>("telDad"));
        workDad.setCellValueFactory(new PropertyValueFactory<tableParents, String>("workDad"));
        // заполняем таблицу данными
        tableParentsfull.setItems(tableDataParents);


        mainButton.setOnAction(event -> {
            mainButton.getScene().getWindow().hide();
            Main.OpenIcon("/sample/Windows/sample.fxml");
        });

        // Удаление

        delAbit.setOnAction(event -> {
            selectedAbit = tableAbitfull.getSelectionModel().getSelectedItem();
            selectedAbit.getIdAbit();
            dataBaseHandler.deleteRowAbit(selectedAbit.getIdAbit(), "абитуриенты");
            tableAbitfull.getItems().remove(selectedAbit);
        });

        delMyData.setOnAction(event -> {
            selectedMyData = tablePasportfull.getSelectionModel().getSelectedItem();
            selectedMyData.getIdAbit();
            dataBaseHandler.deleteRowMyData(selectedMyData.getIdAbit(), "личные данные");
            tablePasportfull.getItems().remove(selectedMyData);
        });

        delEduc.setOnAction(event -> {
            selectedEduc = tableEducationfull.getSelectionModel().getSelectedItem();
            selectedEduc.getIdAbit();
            dataBaseHandler.deleteRowEduc(selectedEduc.getIdAbit(), "образование");
            tableEducationfull.getItems().remove(selectedEduc);
        });

        delParents.setOnAction(event -> {
            selectedParents = tableParentsfull.getSelectionModel().getSelectedItem();
            selectedParents.getIdAbit();
            dataBaseHandler.deleteRowParents(selectedParents.getIdAbit(), "родители");
            tableParentsfull.getItems().remove(selectedParents);
        });
    }

    private void tableRefresh() {
        tableAbitfull.getItems().clear();
        initAbit();
        idabit.setCellValueFactory(new PropertyValueFactory<table, Integer>("idAbit"));
        fioAbit.setCellValueFactory(new PropertyValueFactory<table, String>("fioAbit"));
        birthdayAbit.setCellValueFactory(new PropertyValueFactory<table, String>("birthdayAbit"));
        adressAbit.setCellValueFactory(new PropertyValueFactory<table, String>("adressAbit"));
        telAbit.setCellValueFactory(new PropertyValueFactory<table, String>("telAbit"));

        tableEducationfull.getItems().clear();
        initEduc();
        idEduc.setCellValueFactory(new PropertyValueFactory<tableEduc, Integer>("idAbit"));
        lastEduc.setCellValueFactory(new PropertyValueFactory<tableEduc, String>("levelLastEducation"));
        numAtest.setCellValueFactory(new PropertyValueFactory<tableEduc, String>("numberAtestat"));
        defBalAtest.setCellValueFactory(new PropertyValueFactory<tableEduc, String>("defoultBallAtestat"));
        specialnost.setCellValueFactory(new PropertyValueFactory<tableEduc, String>("specialnost"));

        tablePasportfull.getItems().clear();
        initMyData();
        idPasport.setCellValueFactory(new PropertyValueFactory<table, Integer>("idAbit"));
        pasportDann.setCellValueFactory(new PropertyValueFactory<tableMyData, String>("pasportAbit"));

        tableParentsfull.getItems().clear();
        initParents();
        idRodich.setCellValueFactory(new PropertyValueFactory<tableParents, Integer>("idAbit"));
        fioMom.setCellValueFactory(new PropertyValueFactory<tableParents, String>("fioMom"));
        adressMom.setCellValueFactory(new PropertyValueFactory<tableParents, String>("adressMom"));
        telMom.setCellValueFactory(new PropertyValueFactory<tableParents, String>("telMom"));
        workMom.setCellValueFactory(new PropertyValueFactory<tableParents, String>("workMom"));
        fioDad.setCellValueFactory(new PropertyValueFactory<tableParents, String>("fioDad"));
        adressDad.setCellValueFactory(new PropertyValueFactory<tableParents, String>("adressDad"));
        telDad.setCellValueFactory(new PropertyValueFactory<tableParents, String>("telDad"));
        workDad.setCellValueFactory(new PropertyValueFactory<tableParents, String>("workDad"));

    }

    private void initParents() {
        try {
            dbConnection = getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM родители");
            while (resSet.next()) {
                tableDataParents.add(new tableParents(resSet.getInt("Код абитуриента") ,resSet.getString("ФИО мамы"), resSet.getString("Домашний адрес мамы"),
                        resSet.getString("Контактный телефон мамы"), resSet.getString("Место работы мамы"), resSet.getString("ФИО папы"), resSet.getString("Домашний адрес папы"),
                        resSet.getString("Контактный телефон папы"), resSet.getString("Место работы папы")));


            }
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println("Проблемс с бд");
        }
    }

    private void initMyData() {
        try {
            dbConnection = getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM `личные данные`");
            while (resSet.next()) {
                tableDataMyData.add(new tableMyData(resSet.getInt("Код абитуриента") ,resSet.getString("Паспортные данные")));


            }
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println("Проблемс с бд");
        }
    }

    private void initEduc() {
        try {
            dbConnection = getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM образование");
            while (resSet.next()) {
                tableDataEduc.add(new tableEduc(resSet.getInt("Код абитуриента") ,resSet.getString("Уровень предыдущего образования"), resSet.getString("Номер аттестата"),
                        resSet.getString("Средний балл аттестата"), resSet.getString("Специальность")));


            }
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println("Проблемс с бд");
        }
    }

    private void initAbit() {
        try {
            dbConnection = getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM абитуриенты");
            while (resSet.next()) {
                tableData.add(new table(resSet.getInt("Код абитуриента"), resSet.getString("ФИО абитуриента"), resSet.getString("Дата рождения"),
                        resSet.getString("Домашний адрес"), resSet.getString("Контактный телефон")));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println("Проблемс с бд");
        }
    }

    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + "localHost" + ":" + "3306" + "/" + "YP2";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, "root", "1234");
        return dbConnection;
    }

}
