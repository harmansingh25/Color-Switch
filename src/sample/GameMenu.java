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
import java.util.*;

public class GameMenu {
    private Button new_B;
    private Button resume_B;
    private Button exit_B;
    private List savedGames;
    private long highScore;
    private long totalStars;
    private User user;
    private Game game;
    public List getSavedGames(){
        return savedGames;}

    public long getHighScore(){return highScore;}

    public void setHighScore(long highScore){this.highScore = highScore;}

    public void setTotalStars(long totalStars){this.totalStars = totalStars;}


}
