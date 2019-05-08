package Controller;

import Models.PytanieModel;
import UTILS.ApplicationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;




public class QuizPropertiesController {


    /////////////////////////////////////////////////STATIC FIELDS ////////////////////////////
    private static  String CategroyName;
    private static Boolean NotShowAnwser = false;
    private static Boolean ShuffleQuestion = false;




    public static String getCategroyName() {
        return CategroyName;
    }

    public static void setCategroyName(String categroyName) {
        CategroyName = categroyName;
    }


    public static Boolean getNotShowAnwser() {
        return NotShowAnwser;
    }

    public static void setNotShowAnwser(Boolean notShowAnwser) {
        NotShowAnwser = notShowAnwser;
    }


    public static Boolean getShuffleQuestion() {
        return ShuffleQuestion;
    }

    public static void setShuffleQuestion(Boolean shuffleQuestion) {
        ShuffleQuestion = shuffleQuestion;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public ComboBox WybierzButtonCombo;
    @FXML
    public CheckBox wielokrotnegoWyboruCheckBuutton;
    @FXML
    public Button StartButton;
    @FXML
    public CheckBox wyświetlOdpCheckBuutton;
    @FXML
    public CheckBox losowaKolejnośćPytańCheckBuutton;
    @FXML
    public CheckBox odpowiedziLosowaCheckBuutton;
    @FXML
    public TextField TimeTextField;

     public MainViewController mainViewController;
    public PytanieModel pytanieModel;
    public StartController startController;







    public void initialize() throws ApplicationException {

        pytanieModel = new PytanieModel();

        pytanieModel.init();
        startController = new StartController();
        this.WybierzButtonCombo.getItems().addAll(pytanieModel.getKategorie_FXObservableList());

    }





    public void onWybierzKategorie(ActionEvent actionEvent) {






    }

    public void  QuizSettings(){

        if(this.wyświetlOdpCheckBuutton.isSelected())
        {
            setNotShowAnwser(true);
        }


        if(this.losowaKolejnośćPytańCheckBuutton.isSelected())
        {
            setShuffleQuestion(true);
        }




        String wybranaKategoria = this.WybierzButtonCombo.getSelectionModel().selectedItemProperty().getValue().toString();
        setCategroyName(wybranaKategoria);


    }




    public void openStart() throws IOException {

        QuizSettings();


        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Start.fxml"));
        Pane gridPane = null;
        try {
            gridPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StartController startController = loader.getController();
        startController.setMainViewController(mainViewController);
        mainViewController.setCenterNew(gridPane);

    }

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }



}
