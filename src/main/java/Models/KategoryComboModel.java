package Models;

import javafx.beans.property.SimpleStringProperty;

public class KategoryComboModel {

    SimpleStringProperty KategoryName = new  SimpleStringProperty();

    public String getKategoryName() {
        return KategoryName.get();
    }

    public SimpleStringProperty kategoryNameProperty() {
        return KategoryName;
    }

    public void setKategoryName(String kategoryName) {
        this.KategoryName.set(kategoryName);
    }

    @Override
    public String toString() {
        return
              KategoryName.get().toString();

    }
}
