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

public class User {

    private static User gen;
    public static User getInstance(){
        if(gen==null){
            gen=new User();
        }
        return gen;
    }
    private User(){}

    private Game game;
    private GameMenu menu;
    private boolean isHit;



    public boolean isHitByObstacle(){return isHit;}

    public Game getGame(){
        return game;}

    public GameMenu getMenu(){return menu;}

    public boolean getIsHit(){return isHit;}

    public void setGame(Game game){this.game = game;}

    public void setMenu(GameMenu menu){this.menu = menu;}

    public void setIsHit(boolean isHit){this.isHit = isHit;}

}

