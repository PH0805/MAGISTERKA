package Controller;

import DBConnections.DBConnection;
import DBConnections.PytaniaDao;
import Data_Tables.Pytania;
import Models.KategoryComboModel;
import Models.PytanieFX;
import Models.PytanieModel;
import UTILS.ApplicationException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PokazPytaniaController  {
    @FXML
    public Button DodajPytanie;
    @FXML
    public TextArea TrescPytaniaID;
    @FXML
    public TextField OdpowiedzA;
    @FXML
    public TextField OdpowiedzB;
    @FXML
    public TextField OdpowiedzC;
    @FXML
    public TextField OdpowiedzD;
    @FXML
    public TextField OdpowiedzE;
    @FXML
    public TextField PoprawnaODP;
    @FXML
    public ComboBox<KategoryComboModel> WyberzKategorieButton;
    @FXML
    public TableColumn<PytanieFX, String> TreśćPytaniaColumn;
    @FXML
    public TableColumn<PytanieFX, String> Odpowiedz_A_Column;
    @FXML
    public TableColumn<PytanieFX, String> Odpowiedz_B_Coulmn;
    @FXML
    public TableColumn<PytanieFX, String> Odpowiedz_C_Coulmn;
    @FXML
    public TableColumn<PytanieFX, String> Odpowiedz_D_Coulmn;
    @FXML
    public TableColumn<PytanieFX, String> Odpowiedz_E__Coulmn;
    @FXML
    public TableColumn<PytanieFX, String> Poprawna_ODP_Column;
    @FXML
    public TableView<PytanieFX> Tabela;
    @FXML
    public TextField KategoriaTextField;
    @FXML
    public Button AddCategoryButton;
    @FXML
    public Button DeleteCategoryButoon;
    @FXML
    public MenuItem deletemenuItem;


    public PytanieModel pytanieModel;
    public PytanieFX pytanieFX;


    MainViewController mainViewController;

    String eptyString = "";

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }









    public void initialize() throws ApplicationException {


        mainViewController = new MainViewController();
        pytanieModel = new PytanieModel();
        pytanieFX = new PytanieFX();

        pytanieModel.init();
        this.AddCategoryButton.disableProperty().bind(this.KategoriaTextField.textProperty().isEmpty());
        this.DodajPytanie.disableProperty().bind(this.TrescPytaniaID.textProperty().isEmpty());




   this.WyberzKategorieButton.getItems().addAll(pytanieModel.getKategorie_FXObservableList());
   InitTable();
        this.WyberzKategorieButton.getSelectionModel().selectFirst();

   this.Tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
       this.pytanieModel.setPytanieFXObjectPropertyEdit(newValue);

        });

    }

    private void InitTable() {

        this.Tabela.setItems(this.pytanieModel.getPytanieFXObservableList());
        getItemsToColumn();


    }



    public void onDodajPytanie(ActionEvent actionEvent) throws ApplicationException {



        this.pytanieFX.pytanie_FXProperty().bind(TrescPytaniaID.textProperty());
        this.pytanieFX.odp_A_FXProperty().bind(OdpowiedzA.textProperty());
        this.pytanieFX.odp_B_FXProperty().bind(OdpowiedzB.textProperty());
        this.pytanieFX.odp_C_FXProperty().bind(OdpowiedzC.textProperty());
        this.pytanieFX.popr_FXProperty().bind(PoprawnaODP.textProperty());
        this.pytanieFX.odp_D_FXProperty().bind(OdpowiedzD.textProperty());
        this.pytanieFX.odp_E_FXProperty().bind(OdpowiedzE.textProperty());
        this.pytanieFX.kategoria_FXProperty().bind(WyberzKategorieButton.getSelectionModel().getSelectedItem().kategoryNameProperty());


        Pytania pytanie = new Pytania();


        pytanie.setPytanie(this.pytanieFX.getPytanie_FX());
        pytanie.setOdpA(this.pytanieFX.getOdp_A_FX());
        pytanie.setOdpB(this.pytanieFX.getOdp_B_FX());
        pytanie.setOdpC(this.pytanieFX.getOdp_C_FX());
        pytanie.setOdpPopr(this.pytanieFX.getPopr_FX());
        pytanie.setOdpD(this.pytanieFX.getOdp_D_FX());
        pytanie.setOdpE(this.pytanieFX.getOdp_E_FX());
        pytanie.setKategoria(this.pytanieFX.getKategoria_FX());

        PytaniaDao pytaniaDao  = new PytaniaDao(DBConnection.getConnectionSource());
        pytaniaDao.creatOrUpdate(pytanie);
        this.pytanieModel.getPytanieFXObservableList().clear();

        RefreshTableWithCategory();
      //  InitTable();


        DBConnection.closeConnectionSource();


    }



    public void onMainView(ActionEvent actionEvent)  {

        mainViewController.loadMenu();
    }




    public  void  WybranyTest(ActionEvent actionEvent) throws ApplicationException {

        RefreshTableWithCategory();



    }

    private void RefreshTableWithCategory() throws ApplicationException {

        pytanieModel.RefreshTable();

        System.out.println(WyberzKategorieButton.getSelectionModel().getSelectedItem().getKategoryName().toString());

        List<PytanieFX> WyfiltrowanaLista = firtSelectedCombo();

        System.out.println(WyfiltrowanaLista.size());
        this.pytanieModel.getPytanieFXObservableList().clear();
        WyfiltrowanaLista.forEach(c->{
            PytanieFX pytanieFX = Converter_FX(c);


            this.pytanieModel.getPytanieFXObservableList().add(pytanieFX);
        });


        ObservableList<PytanieFX> pytanieFXObservableList2 = this.pytanieModel.getPytanieFXObservableList();


        this.Tabela.setItems(pytanieFXObservableList2);
        getItemsToColumn();
    }

    private void getItemsToColumn() {
        this.TreśćPytaniaColumn.setCellValueFactory(cellData -> cellData.getValue().pytanie_FXProperty());
        this.Odpowiedz_A_Column.setCellValueFactory(cellData -> cellData.getValue().odp_A_FXProperty());
        this.Odpowiedz_B_Coulmn.setCellValueFactory(cellData -> cellData.getValue().odp_B_FXProperty());
        this.Odpowiedz_C_Coulmn.setCellValueFactory(cellData -> cellData.getValue().odp_C_FXProperty());
        this.Odpowiedz_D_Coulmn.setCellValueFactory(cellData -> cellData.getValue().odp_D_FXProperty());
        this.Odpowiedz_E__Coulmn.setCellValueFactory(cellData -> cellData.getValue().odp_E_FXProperty());

        this.Poprawna_ODP_Column.setCellValueFactory(cellData -> cellData.getValue().popr_FXProperty());

        this.TreśćPytaniaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.Odpowiedz_A_Column.setCellFactory(TextFieldTableCell.forTableColumn());
        this.Odpowiedz_B_Coulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.Odpowiedz_C_Coulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.Odpowiedz_D_Coulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.Odpowiedz_E__Coulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.Poprawna_ODP_Column.setCellFactory(TextFieldTableCell.forTableColumn());
    }



    private PytanieFX Converter_FX(PytanieFX c) {
        PytanieFX pytanieFX = new PytanieFX();
        pytanieFX.setId_FX(c.getId_FX());
        pytanieFX.setPytanie_FX(c.getPytanie_FX());
        pytanieFX.setOdp_A_FX(c.getOdp_A_FX());
        pytanieFX.setOdp_B_FX(c.getOdp_B_FX());
        pytanieFX.setOdp_C_FX(c.getOdp_C_FX());
        pytanieFX.setOdp_D_FX(c.getOdp_D_FX());
        pytanieFX.setOdp_E_FX(c.getOdp_E_FX());
        pytanieFX.setPopr_FX(c.getPopr_FX());
        pytanieFX.setKategoria_FX(c.getKategoria_FX());
        return pytanieFX;
    }


    public void deletePytanie(ActionEvent actionEvent) throws ApplicationException {

        pytanieModel.deletePytanieInDataBase();
        RefreshTableWithCategory();

    }

    public void onAddCategorry(ActionEvent actionEvent) {

        KategoryComboModel kategoryComboModel = new KategoryComboModel();

        kategoryComboModel.setKategoryName(this.KategoriaTextField.textProperty().getValue());


        this.pytanieModel.getKategorie_FXObservableList().add(kategoryComboModel);

        this.WyberzKategorieButton.getItems().clear();
        this.WyberzKategorieButton.getItems().addAll(pytanieModel.getKategorie_FXObservableList());

        this.KategoriaTextField.clear();

    }

    public void onDeleteCategoryButton(ActionEvent actionEvent) throws ApplicationException {

        List<PytanieFX> WyfiltrowanaLista = firtSelectedCombo();
        PytaniaDao pytaniaDao = new PytaniaDao(DBConnection.getConnectionSource());
        WyfiltrowanaLista.forEach(e->{

            try {
                pytaniaDao.deleteById(Pytania.class, e.getId_FX());
            } catch (ApplicationException e1) {
                e1.printStackTrace();
            }

        });


        DBConnection.closeConnectionSource();

    }

    private List<PytanieFX> firtSelectedCombo() {
        String s = WyberzKategorieButton.getSelectionModel().getSelectedItem().getKategoryName().toString();

        Predicate<PytanieFX> mNazwa = pytanieFX1 -> pytanieFX1.getKategoria_FX().equals(s);

        return this.pytanieModel.getPytanieFXObservableList().stream().filter(mNazwa).collect(Collectors.toList());
    }
}
