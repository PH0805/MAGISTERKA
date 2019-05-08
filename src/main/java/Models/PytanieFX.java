package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PytanieFX {

    IntegerProperty  id_FX = new SimpleIntegerProperty();
    StringProperty Pytanie_FX =new SimpleStringProperty();
    StringProperty Odp_A_FX =new SimpleStringProperty();
    StringProperty Odp_B_FX =new SimpleStringProperty();
    StringProperty Odp_C_FX =new SimpleStringProperty();
    StringProperty Odp_D_FX =new SimpleStringProperty();
    StringProperty Odp_E_FX =new SimpleStringProperty();
    StringProperty kategoria_FX =new SimpleStringProperty();

    StringProperty Popr_FX =new SimpleStringProperty();

    public int getId_FX() {
        return id_FX.get();
    }

    public IntegerProperty id_FXProperty() {
        return id_FX;
    }

    public void setId_FX(int id_FX) {
        this.id_FX.set(id_FX);
    }

    public String getPytanie_FX() {
        return Pytanie_FX.get();
    }

    public StringProperty pytanie_FXProperty() {
        return Pytanie_FX;
    }

    public void setPytanie_FX(String pytanie_FX) {
        this.Pytanie_FX.set(pytanie_FX);
    }

    public String getOdp_A_FX() {
        return Odp_A_FX.get();
    }

    public StringProperty odp_A_FXProperty() {
        return Odp_A_FX;
    }

    public void setOdp_A_FX(String odp_A_FX) {
        this.Odp_A_FX.set(odp_A_FX);
    }

    public String getOdp_B_FX() {
        return Odp_B_FX.get();
    }

    public StringProperty odp_B_FXProperty() {
        return Odp_B_FX;
    }

    public void setOdp_B_FX(String odp_B_FX) {
        this.Odp_B_FX.set(odp_B_FX);
    }

    public String getOdp_C_FX() {
        return Odp_C_FX.get();
    }

    public StringProperty odp_C_FXProperty() {
        return Odp_C_FX;
    }

    public void setOdp_C_FX(String odp_C_FX) {
        this.Odp_C_FX.set(odp_C_FX);
    }

    public String getPopr_FX() {
        return Popr_FX.get();
    }

    public StringProperty popr_FXProperty() {
        return Popr_FX;
    }

    public void setPopr_FX(String popr_FX) {
        this.Popr_FX.set(popr_FX);
    }

    public String getOdp_D_FX() {
        return Odp_D_FX.get();
    }

    public StringProperty odp_D_FXProperty() {
        return Odp_D_FX;
    }

    public void setOdp_D_FX(String odp_D_FX) {
        this.Odp_D_FX.set(odp_D_FX);
    }

    public String getOdp_E_FX() {
        return Odp_E_FX.get();
    }

    public StringProperty odp_E_FXProperty() {
        return Odp_E_FX;
    }

    public void setOdp_E_FX(String odp_E_FX) {
        this.Odp_E_FX.set(odp_E_FX);
    }

    public String getKategoria_FX() {
        return kategoria_FX.get();
    }

    public StringProperty kategoria_FXProperty() {
        return kategoria_FX;
    }

    public void setKategoria_FX(String kategoria_FX) {
        this.kategoria_FX.set(kategoria_FX);
    }

    @Override
    public String toString() {
        return
                 kategoria_FX.get();

    }
}
