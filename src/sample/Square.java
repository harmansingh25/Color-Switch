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



public class Square implements Serializable {

    private Line l1;
    private Line l2;
    private Line l3;
    private Line l4;
    private ArrayList<Line> lines=new ArrayList<Line>();
    private Group square;

    public ArrayList<Line> getLines() {
        return lines;
    }

    public Group getSquare() {
        return square;
    }


    public Line makeLine(double Sx, double Ex, double Sy, double Ey,Color color){
        Line line=new Line();
        line.setStartX(Sx);
        line.setEndX(Ex);
        line.setStartY(Sy);
        line.setEndY(Ey);
        line.setStroke(color);
        line.setStrokeWidth(16.50f);

        return line;

    }

    public Group makeSquare(double a1,double a2,double a3,double a4){
       l1=makeLine(a1,a2,a3,a3,Color.rgb(250, 225, 0));
       l2=makeLine(a1,a1,a3,a4,Color.rgb(138,43,226));
       l3=makeLine(a1,a2,a4,a4,Color.rgb(255, 1, 129));
       l4=makeLine(a2,a2,a3,a4,Color.rgb(50, 219, 240));
        lines.add(l1);
        lines.add(l2);
        lines.add(l3);
        lines.add(l4);
        Group g1=new Group(l1,l2,l3,l4);
        square=g1;
        return g1;

        //325 a1
        // 475 a2
        // 50 a3
        // 200 a4
    }

    public void rotateSquare(RotateTransition rt, Group square1,int time, boolean auto){
        rt = new RotateTransition(Duration.millis(time), square1);
        rt.setByAngle(360);

        if(auto){
        rt.setAutoReverse(true);}

        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);


        rt.play();
    }

}
