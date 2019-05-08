package Sample;

import UTILS.FillDataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane borderPane = FXMLLoader.load(this.getClass().getResource("/MainView.fxml"));
        Scene scene = new Scene(borderPane);
        stage.setWidth(700);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.setTitle("QUIZ");

        stage.show();


    }
}
