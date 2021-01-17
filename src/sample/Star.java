package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.fxml.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.animation.TranslateTransition;

import java.io.Serializable;
import java.util.*;

public class Star implements Serializable {

    private Button button;
    private Coordinates coord;
     public Star(Coordinates coord){
         this.coord=coord;
     }
    Image img = new Image("star1.png");
  ImageView view = new ImageView(img);



    public void makeStar(){

         button=new Button();
         button.setLayoutX(coord.getX());
         button.setLayoutY(coord.getY());

         button.setStyle(

               "-fx-background-radius: 3em; " +
                        "-fx-min-width: 50px; " +
                      "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;"

        );


        view.setFitHeight(55);
        view.setPreserveRatio(true);
        button.setGraphic(view);

     }
    public Button getButton() {
        return button;
    }

}
