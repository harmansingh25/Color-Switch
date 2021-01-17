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


public class Switch implements Serializable {

    private Color cl;
    private Coordinates coord;
    Circle ball;

    public Switch(Color cl, Coordinates coord){

        this.cl=cl;
        this.coord=coord;
        ball=new Circle();
        ball.setCenterX(coord.getX());
        ball.setCenterY(coord.getY());
        ball.setRadius(15.0f);
        ball.setFill(cl);



    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public void setCl(Color cl) {
        this.cl = cl;
    }


    public Color getCl() {
        return cl;
    }

    public Circle getBall() {
        return ball;
    }
}
