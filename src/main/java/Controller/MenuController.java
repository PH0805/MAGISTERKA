package Controller;

import javafx.application.Platform;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


import java.io.IOException;


public class MenuController {

    public Button DrukuTest;
    MainViewController mainViewController;

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }


    public void openProperties() throws IOException {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/QuizProperties.fxml"));
        Pane gridPane = null;
        try {
            gridPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        QuizPropertiesController quizPropertiesController = loader.getController();
        quizPropertiesController.setMainViewController(mainViewController);
        mainViewController.setCenterNew(gridPane);

    }






    public void openPokażPytania() {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/PokażPytania.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PokazPytaniaController pokazPytaniaController = loader.getController();
        pokazPytaniaController.setMainViewController(mainViewController);
        mainViewController.setCenterNew(pane);


    }

    public void OpenWyjscie() {

        Platform.exit();
    }


}
