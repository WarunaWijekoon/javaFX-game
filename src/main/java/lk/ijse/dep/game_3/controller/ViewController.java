package lk.ijse.dep.game_3.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.dep.game_3.AppInitializer;

import java.time.LocalTime;



public class ViewController {

    public AnchorPane root;
    public Label lblDragon1;
    public Label lblDragon2;
    public Label lblHeroMan;
    public Label lblScore;
    public  int sum =0;
    public  int sum1 =0;
    public Label lblScore1;
    public Label lblDeath;
public boolean x =true;
    public Label lblArrowKEy;
    public Label lblFailGame;
    public Group lblVictory;
    public Label lblWinExit;

    public void initialize() {

        sum=0;
        sum1=0;
        lblVictory.setVisible(false);
        lblFailGame.setVisible(false);
        lblWinExit.setVisible(false);
        lblDragon1.setLayoutX(1100);
        lblDragon2.setLayoutX(-200);
       // System.out.println("key event");
        TranslateTransition transition0 = new TranslateTransition();
        Platform.runLater(() -> root.getScene().setOnKeyPressed(keyEvent -> {
            lblArrowKEy.setVisible(false);

          //  System.out.println("enter root ");
            if (keyEvent.getCode() == KeyCode.SPACE) {
              //  System.out.println("key pressed");
                if (lblHeroMan.getLayoutY() == 300) {

                    lblHeroMan.setLayoutY(lblHeroMan.getLayoutY() - 300);


lblHeroMan.setLayoutY(lblHeroMan.getLayoutY());
                    transition0.setByY(-300);
                    transition0.setDuration(Duration.millis(1000));
                    transition0.setCycleCount(2);
                    transition0.setAutoReverse(true);

                    transition0.setNode(lblHeroMan);
                    transition0.play();
                    lblHeroMan.setLayoutY(300);
                  //  System.out.println(lblHeroMan.getLayoutY());
                   // System.out.println("y up transition:"+transition0.getByY());

                }
            }

        }));
       // System.out.println("y tansition down:"+transition0.getByY());
//
//        public void btnExitOnAction (ActionEvent actionEvent){
//
//        }
//
//        public void btnPauseOnAction (ActionEvent actionEvent){
//        }
//        public void btnStartOnAction (ActionEvent actionEvent) throws InterruptedException {

//java.time.LocalTime.now();
        TranslateTransition transition2 = new TranslateTransition();

        transition2.setByX(1500);
        transition2.setDuration(Duration.millis(10000));
        transition2.setCycleCount(100000);
        transition2.setAutoReverse(false);

        transition2.setNode(lblDragon2);
        transition2.play();


        TranslateTransition transition1 = new TranslateTransition();

        transition1.setByX(-2000);
        transition1.setDuration(Duration.millis(12000));

        transition1.setCycleCount(100000);

        transition1.setAutoReverse(false);
        transition1.setNode(lblDragon1);

        transition1.play();

        new Thread(() -> {

            while (x) {



//                if (((int) lblDragon2.getTranslateX() < 720 && (int) lblDragon2.getTranslateX() > 700) ){
//                  if (transition0.getByY()==-300){
//                      System.out.println("win drag 2");
//
//                      transition0.setByY(0);
//
//                  }else if (transition0.getByY()==0){
//
//                      System.out.println("down drag 2");
//                  }
//                }
                if (((int) lblDragon1.getTranslateX() < -640 && (int) lblDragon1.getTranslateX() > -660)||((int) lblDragon2.getTranslateX() < 720 && (int) lblDragon2.getTranslateX() > 700)){
                    if (transition0.getByY()==-300){
                        System.out.println("win drag 1");
                        sum1=sum1+1;
                        Platform.runLater(() -> {

                            lblScore1.setText(String.valueOf(sum1));
                            if (sum1==8){
                                lblVictory.setVisible(true);
                                lblWinExit.setVisible(true);
                                transition1.pause();
                                transition2.pause();
                                transition0.pause();
                                x=false;
                                Platform.runLater(() -> root.getScene().setOnKeyPressed(keyEvent -> {
                                    // lblArrowKEy.setVisible(false);
                                    //  System.out.println("enter root ");
                                    if (keyEvent.getCode() == KeyCode.ENTER) {

                                     System.exit(0);

                                    }}));
                            }
                        });
                        transition0.setByY(0);

                    }else if (transition0.getByY()==0){
                        System.out.println("down drag1");
                        sum=sum+1;
                        System.out.println(sum);
                        Platform.runLater(() -> {

                            if (sum<8){

                            lblScore.setText(String.valueOf(sum));}else {
                                lblDeath.setVisible(false);
                               lblScore.setText("FAIL");
                                transition1.pause();
                                transition2.pause();
                                transition0.pause();
                                lblFailGame.setVisible(true);
                                lblArrowKEy.setText("PRESS ESC TO EXIT");
                               lblArrowKEy.setVisible(true);
                                x=false;
                              Platform.runLater(() -> root.getScene().setOnKeyPressed(keyEvent -> {
                                   // lblArrowKEy.setVisible(false);
                                    //  System.out.println("enter root ");
                                    if (keyEvent.getCode() == KeyCode.ESCAPE) {
                                       System.exit(0);
                                        }}));
                            }

                        });
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }).start();



    }
    }




