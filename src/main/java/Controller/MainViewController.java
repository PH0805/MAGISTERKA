package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;



public class MainViewController {
    @FXML
    public Button ButtonStart;
    @FXML
    public Button ButtonPokażPytania;
    @FXML
    public Button ButtonWyjscie;
    @FXML
    public BorderPane BorderPaneMainView;

    MenuController menuController = new MenuController();

    public void initialize(){
        menuController = null;
        loadMenu();

    }

    public void loadMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/MenuOptions.fxml"));

        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MenuController menuController = loader.getController();
        menuController.setMainViewController(this);
        setCenterNew(parent);
    }

    public void setCenterNew(Parent parent) {
        BorderPaneMainView.setCenter(parent);
        BorderPaneMainView.setAlignment(parent, Pos.TOP_CENTER);
    }



}
