package Models;

import DBConnections.DBConnection;
import DBConnections.PytaniaDao;
import Data_Tables.Pytania;
import UTILS.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class PytanieModel {
    private ObjectProperty<PytanieFX> pytanieFXObjectProperty = new SimpleObjectProperty<>(new PytanieFX());
    private ObjectProperty<TextField> TextFieldProperty = new SimpleObjectProperty<>();

    public TextField getTextFieldProperty() {
        return TextFieldProperty.get();
    }

    public ObjectProperty<TextField> textFieldPropertyProperty() {
        return TextFieldProperty;
    }

    public void setTextFieldProperty(TextField textFieldProperty) {
        this.TextFieldProperty.set(textFieldProperty);
    }

    private ObjectProperty<PytanieFX> pytanieFXObjectPropertyEdit = new SimpleObjectProperty<>(new PytanieFX());
    private ObservableList<PytanieFX>  pytanieFXObservableList = FXCollections.observableArrayList();
    private ObservableList<KategoryComboModel>  Kategorie_FXObservableList = FXCollections.observableArrayList();







    public void init() throws ApplicationException {
        PytaniaDao pytaniaDao = new PytaniaDao(DBConnection.getConnectionSource());


/////// Tworzenie Kategori
        List<Pytania> listaPytań =  pytaniaDao.queryForAll(Pytania.class);
        List<String> Kategorie  = new ArrayList<>();
        Kategorie.clear();

        listaPytań.forEach(c->{
            if(Kategorie.contains(c.getKategoria()))
                return;
            Kategorie.add(c.getKategoria());
        });

            this.pytanieFXObservableList.clear();
            this.Kategorie_FXObservableList.clear();


        Kategorie.forEach(c->{
            KategoryComboModel kategoryComboModel = new KategoryComboModel();
            kategoryComboModel.setKategoryName(c.toString());
            this.Kategorie_FXObservableList.add(kategoryComboModel);
            System.out.println(kategoryComboModel.getKategoryName());
        });


        RefreshTable();
    }

    public void RefreshTable() throws ApplicationException {
        this.pytanieFXObservableList.clear();
///////////////////////////  Conwertowania z Bazdy Danych na Propertisy/  UPDATE Z BAZY DACNYH DO PROGRAMU
        PytaniaDao pytaniaDao = new PytaniaDao(DBConnection.getConnectionSource());
        List<Pytania> listaPytań =  pytaniaDao.queryForAll(Pytania.class);
        listaPytań.forEach(c->{
            PytanieFX pytanieFX = new PytanieFX();
            pytanieFX.setId_FX(c.getId());
            pytanieFX.setPytanie_FX(c.getPytanie());
            pytanieFX.setOdp_A_FX(c.getOdpA());
            pytanieFX.setOdp_B_FX(c.getOdpB());
            pytanieFX.setOdp_C_FX(c.getOdpC());
            pytanieFX.setOdp_D_FX(c.getOdpD());
            pytanieFX.setOdp_E_FX(c.getOdpE());
            pytanieFX.setPopr_FX(c.getOdpPopr());
            pytanieFX.setKategoria_FX(c.getKategoria());

            this.pytanieFXObservableList.add(pytanieFX);

        });


        DBConnection.closeConnectionSource();
    }


    public void deletePytanieInDataBase() throws ApplicationException {
        PytaniaDao pytaniaDao = new PytaniaDao(DBConnection.getConnectionSource());
        pytaniaDao.deleteById(Pytania.class, this.getPytanieFXObjectPropertyEdit().getId_FX());
        DBConnection.closeConnectionSource();

    }





    public ObservableList<PytanieFX> getPytanieFXObservableList() {
        return pytanieFXObservableList;
    }

    public void setPytanieFXObservableList(ObservableList<PytanieFX> pytanieFXObservableList) {
        this.pytanieFXObservableList = pytanieFXObservableList;
    }

    public PytanieFX getPytanieFXObjectProperty() {
        return pytanieFXObjectProperty.get();
    }

    public ObjectProperty<PytanieFX> pytanieFXObjectPropertyProperty() {
        return pytanieFXObjectProperty;
    }

    public void setPytanieFXObjectProperty(PytanieFX pytanieFXObjectProperty) {
        this.pytanieFXObjectProperty.set(pytanieFXObjectProperty);
    }



    public ObservableList<KategoryComboModel> getKategorie_FXObservableList() {
        return Kategorie_FXObservableList;
    }

    public void setKategorie_FXObservableList(ObservableList<KategoryComboModel> kategorie_FXObservableList) {
        Kategorie_FXObservableList = kategorie_FXObservableList;
    }

    public PytanieFX getPytanieFXObjectPropertyEdit() {
        return pytanieFXObjectPropertyEdit.get();
    }

    public ObjectProperty<PytanieFX> pytanieFXObjectPropertyEditProperty() {
        return pytanieFXObjectPropertyEdit;
    }

    public void setPytanieFXObjectPropertyEdit(PytanieFX pytanieFXObjectPropertyEdit) {
        this.pytanieFXObjectPropertyEdit.set(pytanieFXObjectPropertyEdit);
    }


}
