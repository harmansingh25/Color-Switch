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

public class Buttonn implements Serializable {

    private Coordinates coord;
    private String name;
    private Color cl;
    Button button;

    public Buttonn(Coordinates coord, String name, Color cl ){
        this.coord=coord;
        this.name=name;
        this.cl=cl;
        button=new Button("JUMP");

        button.setLayoutX(coord.getX());
       button.setLayoutY(coord.getY());


    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getCl() {
        return cl;
    }

    public void setCl(Color cl) {
        this.cl = cl;
    }

    public Button getButton() {
        return button;
    }
}
