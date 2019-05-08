package Controller;

import Models.GoodQuestionList;
import Models.PytanieFX;
import Models.PytanieModel;
import UTILS.ApplicationException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StartController {
    @FXML
    public Label IdQuestion;
    @FXML
    public RadioButton OdpB;
    @FXML
    public RadioButton OdpA;
    @FXML
    public Label Pytanie;
    @FXML
    public RadioButton OdpC;
    @FXML
    public Label Wynik;
    @FXML
    public Button Powrót, NastepnePytanieButton;
    @FXML
    public Label PytanieLabel;
    @FXML
    public Button backButton;

    @FXML
    public RadioButton OdpD;

    @FXML
    public RadioButton OdpE;
    public ToggleGroup OdpGRP;

    PytanieModel pytanieModel;

    String epmptyString = "";

    MainViewController mainViewController = new MainViewController();

    public MainViewController getMainViewController() {
        return mainViewController;
    }


    private static int count = 0;



    ArrayList<GoodQuestionList> goodQuestionLists = new ArrayList<>();






    public void initialize() {


        pytanieModel = new PytanieModel();


        try {
            pytanieModel.init();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

        ///////////////////////  Filtrowanie po Kategorii
        Predicate<PytanieFX> mNazwa = pytanieFX1 -> pytanieFX1.getKategoria_FX().equals(QuizPropertiesController.getCategroyName());
        List<PytanieFX>  wyfiltrowanalista = this.pytanieModel.getPytanieFXObservableList().stream().filter(mNazwa).collect(Collectors.toList());

        /////// Tworzenie Tablcy Wyników



        for (int i = 0; i<wyfiltrowanalista.size();i++)
        {
            goodQuestionLists.add(new GoodQuestionList());
        }

        this.pytanieModel.getPytanieFXObservableList().clear();

        wyfiltrowanalista.forEach(c->{

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

            this.pytanieModel.getPytanieFXObservableList().add(pytanieFX);

        });
if(QuizPropertiesController.getShuffleQuestion())
{



   Collections.shuffle(this.pytanieModel.getPytanieFXObservableList());


}











        ShowQuestions();


        if(QuizPropertiesController.getNotShowAnwser()) {
            setInVisibleButton();
        }
        else{
            ifAnwserIsEmpty();
        }
        ifAnwserIsEmpty();
/*
        OdpA.setVisible(false);
        OdpB.setVisible(false);
        OdpC.setVisible(false);
        OdpD.setVisible(false);
        OdpE.setVisible(false);
        */

        backButton.setVisible(false);

        startTimer();
    }

    private void ShowQuestions() {
        this.Pytanie.setText(pytanieModel.getPytanieFXObservableList().get(count).getPytanie_FX());
        this.IdQuestion.setText(Integer.toString(count + 1));
        this.OdpA.setText(pytanieModel.getPytanieFXObservableList().get(count).getOdp_A_FX());
        this.OdpB.setText(pytanieModel.getPytanieFXObservableList().get(count).getOdp_B_FX());
        this.OdpC.setText(pytanieModel.getPytanieFXObservableList().get(count).getOdp_C_FX());
        this.OdpD.setText(pytanieModel.getPytanieFXObservableList().get(count).getOdp_D_FX());
        this.OdpE.setText(pytanieModel.getPytanieFXObservableList().get(count).getOdp_E_FX());




    }


    public void NextQuestion() {

        if(count==0){
            backButton.setVisible(false);
        }
        else {
            backButton.setVisible(true);
        }



        selectedFalseButton();

        ShowQuestions();

        if(QuizPropertiesController.getNotShowAnwser()) {
            setInVisibleButton();
        }
        else{
            ifAnwserIsEmpty();
        }











    }

    private void ifAnwserIsEmpty() {
        if(OdpC.getText().equals(epmptyString))
            OdpC.setVisible(false);
        else {
            OdpC.setVisible(true);
        }
        if(OdpA.getText().equals(epmptyString))
        {
            OdpA.setVisible(false);
        }
           else
        {
            OdpA.setVisible(true);
        }
        if(OdpB.getText().equals(epmptyString))
        {
            OdpB.setVisible(false);
        }
           else
        {
            OdpB.setVisible(true);
        }
        if(OdpD.getText().equals(epmptyString))
        {
            OdpD.setVisible(false);
        }
        else
        {
            OdpD.setVisible(true);
        }
        if(OdpE.getText().equals(epmptyString))
        {
            OdpE.setVisible(false);
        }
        else
        {
            OdpE.setVisible(true);
        }

    }

    private void selectedFalseButton() {
        OdpA.setSelected(false);
        OdpB.setSelected(false);
        OdpC.setSelected(false);
        OdpD.setSelected(false);
        OdpE.setSelected(false);
    }


    public void CheckQuestion(ActionEvent actionEvent) {




        if (OdpA.isSelected()) {
            CheckODP_A();
        }

        if (OdpB.isSelected()) {
            CheckODP_B();
        }


        if (OdpC.isSelected()) {
            CheckODP_C();
        }

        if (OdpD.isSelected()) {
            CheckODP_D();
        }
        if (OdpE.isSelected()) {
            CheckODP_E();
        }




        selectedFalseButton();


        count++;

        if (pytanieModel.getPytanieFXObservableList().size() != (count)) {
            NextQuestion();
        } else

            KoniecTestu();
    }



    public void onPoprzedniePytanie()
         {


             count--;


             NextQuestion();



         }


    public void  KoniecTestu()
    {


        goodQuestionLists.stream().filter(goodQuestionList -> goodQuestionList.isGood()==true).map(goodQuestionLists-> goodQuestionLists.getNazwaPytania()).forEach(System.out::print);
        Predicate<GoodQuestionList> mNazwa = goodQuestionList -> goodQuestionList.isGood();
        List<GoodQuestionList> lista  = goodQuestionLists.stream().filter(mNazwa).collect(Collectors.toList());


        Wynik.setText("Zdobyłes "+lista.size()+ " z "+ pytanieModel.getPytanieFXObservableList().size() + " możliwych" );
        IdQuestion.setVisible(false);
        OdpB.setVisible(false);
        OdpA.setVisible(false);
        OdpC.setVisible(false);
        OdpE.setVisible(false);
        OdpD.setVisible(false);
        Pytanie.setVisible(false);
        Powrót.setVisible(true);
        Wynik.setVisible(true);
        NastepnePytanieButton.setVisible(false);
        backButton.setVisible(false);
        goodQuestionLists.forEach(e->{
         System.out.println(e.toString());
        });

    }



    public void onPowrótdoMenu(ActionEvent actionEvent) {
        count = 0;
        mainViewController.loadMenu();
    }

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }












    private void CheckODP_C() {
        if (OdpC.getText().equals(pytanieModel.getPytanieFXObservableList().get(count).getPopr_FX())) {

            goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpC.getText().toString(),true));

        }
        else{
            goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpC.getText().toString(),false));
        }
    }

    private void CheckODP_B() {
        if (OdpB.getText().equals(pytanieModel.getPytanieFXObservableList().get(count).getPopr_FX())) {
            goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpB.getText().toString(),true));

        } else {
            goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpB.getText().toString(),false));
            System.out.println("zła ODpwoiedz");
        }
    }

    private void CheckODP_A() {
        if (OdpA.getText().equals(pytanieModel.getPytanieFXObservableList().get(count).getPopr_FX())) {
            goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpA.getText().toString(),true));

        } else {
            goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpA.getText().toString(),false));
            System.out.println("zła ODpwoiedz");
        }
    }


    private void CheckODP_D() {
        if (OdpD.getText().equals(pytanieModel.getPytanieFXObservableList().get(count).getPopr_FX())) {

            if(goodQuestionLists.size() == count){
                goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpD.getText().toString(),true ));
            }


        } else {
            goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpD.getText().toString(),false));

        }
    }

    private void CheckODP_E() {
        if (OdpE.getText().equals(pytanieModel.getPytanieFXObservableList().get(count).getPopr_FX())) {

            if(goodQuestionLists.size() == count){
                goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpE.getText().toString(),true ));
            }


        } else {
            goodQuestionLists.set(count, new GoodQuestionList(this.Pytanie.getText().toString(),this.OdpE.getText().toString(),false));

        }
    }



    public void setInVisibleButton(){

        OdpA.setVisible(false);
        OdpB.setVisible(false);
        OdpC.setVisible(false);
        OdpD.setVisible(false);
        OdpE.setVisible(false);



    }


    public void startTimer() {

        final boolean[] zmienna = {true};
        Thread t = new Thread(() -> {
            while (zmienna[0]) {
                try {
                    Thread.sleep(3000);
                    Platform.runLater(() ->
                            NastepnePytanieButton.fire());



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(pytanieModel.getPytanieFXObservableList().size()  -1 == (count)){
                    zmienna[0] = false;
                }
            }
        });

        t.setDaemon(true);
        t.start();



    }


}



