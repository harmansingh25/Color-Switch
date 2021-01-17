package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.fxml.*;
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
import javafx.scene.text.*;
import java.io.*;


import java.util.*;

class Circle implements  Serializable{





    private Shape arc1;
    private Shape arc2;
    private Shape arc3;
    private Shape arc4;
    private Group ring;
    private ArrayList<Shape> components=new ArrayList<Shape>();
    private RotateTransition rt;

    public Group getRing() {
        return ring;
    }

    public ArrayList<Shape> getComponents() {
        return components;
    }

    public Shape getArc4() {
        return arc4;
    }

    public Shape getArc3() {
        return arc3;
    }

    public Shape getArc2() {
        return arc2;
    }

    public Shape getArc1() {
        return arc1;
    }

    public Arc makeArc(float r1, float r2, Color c, float angle1, float angle2) {

        Arc arc1 = new Arc();
        arc1.setFill(c);
        arc1.setType(ArcType.ROUND);
        arc1.setCenterX(400.0f);
        arc1.setCenterY(400.0f);
        arc1.setRadiusX(r1);
        arc1.setRadiusY(r2);
        arc1.setStartAngle(angle1);
        arc1.setLength(angle2);

        return arc1;

    }
    public Arc makeArcs(float r1, float r2, Color c, float angle1, float angle2,float a1,float a2) {

        Arc arc1 = new Arc();
        arc1.setFill(c);
        arc1.setType(ArcType.ROUND);
        arc1.setCenterX(a1);
        arc1.setCenterY(a2);
        arc1.setRadiusX(r1);
        arc1.setRadiusY(r2);
        arc1.setStartAngle(angle1);
        arc1.setLength(angle2);

        return arc1;

    }

    public Shape makeArcRing(Arc arc1, Arc arc2,Color c) {
        Shape shape = Shape.subtract(arc1, arc2);
        shape.setFill(c);
        return shape;

    }

    public Group makeRing(Shape a1, Shape a2, Shape a3, Shape a4) {
        Group root=new Group();
        root.getChildren().addAll(a1,a2,a3,a4);
        return root;

    }

    public Group Ring(float a1, float a2){
        Arc a11=makeArcs(125.0f,125.0f,Color.YELLOW,90.0f,90.0f,a1,a2);
        Arc a22=makeArcs(105.0f,105.0f,Color.YELLOW,90.0f,90.0f,a1,a2);
        Arc b11=makeArcs(125.0f,125.0f,Color.GREEN,180.0f,90.0f,a1,a2);
        Arc b22=makeArcs(105.0f,105.0f,Color.GREEN,180.0f,90.0f,a1,a2);
        Arc cc11=makeArcs(125.0f,125.0f,Color.BLUE,270.0f,90.0f,a1,a2);
        Arc cc22=makeArcs(105.0f,105.0f,Color.BLUE,270.0f,90.0f,a1,a2);
        Arc d11=makeArcs(125.0f,125.0f,Color.PINK,0.0f,90.0f,a1,a2);
        Arc d22=makeArcs(105.0f,105.0f,Color.PINK,0.0f,90.0f,a1,a2);

        Shape s11=makeArcRing(a11,a22,Color.rgb(250, 225, 0));
        Shape s22=makeArcRing(b11,b22,Color.rgb(138,43,226));
        Shape s33=makeArcRing(cc11,cc22,Color.rgb(255, 1, 129));
        Shape s44=makeArcRing(d11,d22,Color.rgb(50, 219, 240));

        arc1=s11;
        arc2=s22;
        arc3=s33;
        arc4=s44;

        components.add(s11);
        components.add(s22);
        components.add(s33);
        components.add(s44);



        Group ring2=makeRing(s11,s22,s33,s44);
        ring=ring2;
        return ring2;


    }

    public void rotateRing(RotateTransition rt, Group ring1,int time, boolean auto){

        rt = new RotateTransition(Duration.millis(time), ring1);
        rt.setByAngle(-360);

        if(auto){
            rt.setAutoReverse(true);
        }
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);


        rt.play();

    }

}
public class Main extends Application implements Serializable {

    transient private GameMenu gameMenu;

    private static long highScore;
    private static long totalStars;
    private static long nSaved;
    private long serialHS;
    private long serialTS;
    private long serialSav;


    public void setSerialSav(long serialSav) {
        this.serialSav = serialSav;
    }

    public static void setnSaved(long nSaved) {
        Main.nSaved = nSaved;
    }

    public static void setHighScore(long highScore) {
        Main.highScore = highScore;
    }

    public long getSerialSav() {
        return serialSav;
    }

    public static long getnSaved() {
        return nSaved;
    }

    public long getSerialTS() {
        return serialTS;
    }

    public long getSerialHS() {
        return serialHS;
    }

    public void setSerialTS(long serialTS) {
        this.serialTS = serialTS;
    }

    public void setSerialHS(long serialHS) {
        this.serialHS = serialHS;
    }

    transient private Test game;



    public static long getHighScore() {
        return highScore;
    }

    public static long getTotalStars() {
        return totalStars;
    }

    public Test getGame() {
        return game;
    }

    public void setHighscore(long highscore) {
        this.highScore=highscore;

    }

    public void setTotalStars(long totalStars) {
        this.totalStars = totalStars;

    }

    public void setGame(Test game) {
        this.game = game;
    }

    public static Scene s;

    public static void main(String[] args) {
        launch(args);
    }

    public Scene MainScene() throws Exception{

       Parent roots=FXMLLoader.load(getClass().getResource("sample.fxml"));



        Circle c1=new Circle();
        Arc a1=c1.makeArc(100.0f,100.0f,Color.YELLOW,90.0f,90.0f);
        Arc a2=c1.makeArc(80.0f,80.0f,Color.YELLOW,90.0f,90.0f);
        Arc b1=c1.makeArc(100.0f,100.0f,Color.GREEN,180.0f,90.0f);
        Arc b2=c1.makeArc(80.0f,80.0f,Color.GREEN,180.0f,90.0f);
        Arc cc1=c1.makeArc(100.0f,100.0f,Color.BLUE,270.0f,90.0f);
        Arc cc2=c1.makeArc(80.0f,80.0f,Color.BLUE,270.0f,90.0f);
        Arc d1=c1.makeArc(100.0f,100.0f,Color.PINK,0.0f,90.0f);
        Arc d2=c1.makeArc(80.0f,80.0f,Color.PINK,0.0f,90.0f);

        Shape s1=c1.makeArcRing(a1,a2,Color.rgb(250, 225, 0));
        Shape s2=c1.makeArcRing(b1,b2,Color.rgb(138,43,226));
        Shape s3=c1.makeArcRing(cc1,cc2,Color.rgb(255, 1, 129));
        Shape s4=c1.makeArcRing(d1,d2,Color.rgb(50, 219, 240));



        Group ring1=c1.makeRing(s1,s2,s3,s4);






        Arc a11=c1.makeArc(135.0f,135.0f,Color.YELLOW,90.0f,90.0f);
        Arc a21=c1.makeArc(110.0f,110.0f,Color.YELLOW,90.0f,90.0f);
        Arc b12=c1.makeArc(135.0f,135.0f,Color.GREEN,180.0f,90.0f);
        Arc b22=c1.makeArc(110.0f,110.0f,Color.GREEN,180.0f,90.0f);
        Arc cc11=c1.makeArc(135.0f,135.0f,Color.BLUE,270.0f,90.0f);
        Arc cc22=c1.makeArc(110.0f,110.0f,Color.BLUE,270.0f,90.0f);
        Arc d12=c1.makeArc(135.0f,135.0f,Color.PINK,0.0f,90.0f);
        Arc d22=c1.makeArc(110.0f,110.0f,Color.PINK,0.0f,90.0f);

        Shape s11=c1.makeArcRing(a11,a21,Color.rgb(250, 225, 0));
        Shape s22=c1.makeArcRing(b12,b22,Color.rgb(138,43,226));
        Shape s33=c1.makeArcRing(cc11,cc22,Color.rgb(255, 1, 129));
        Shape s44=c1.makeArcRing(d12,d22,Color.rgb(50, 219, 240));



        Group ring2=c1.makeRing(s11,s22,s33,s44);


        Arc a111=c1.makeArc(75.0f,75.0f,Color.YELLOW,90.0f,90.0f);
        Arc a211=c1.makeArc(60.0f,60.0f,Color.YELLOW,90.0f,90.0f);
        Arc b112=c1.makeArc(75.0f,75.0f,Color.GREEN,180.0f,90.0f);
        Arc b212=c1.makeArc(60.0f,60.0f,Color.GREEN,180.0f,90.0f);
        Arc cc111=c1.makeArc(75.0f,75.0f,Color.BLUE,270.0f,90.0f);
        Arc cc212=c1.makeArc(60.0f,60.0f,Color.BLUE,270.0f,90.0f);
        Arc d112=c1.makeArc(75.0f,75.0f,Color.PINK,0.0f,90.0f);
        Arc d212=c1.makeArc(60.0f,60.0f,Color.PINK,0.0f,90.0f);

        Shape s111=c1.makeArcRing(a111,a211,Color.rgb(250, 225, 0));
        Shape s212=c1.makeArcRing(b112,b212,Color.rgb(138,43,226));
        Shape s313=c1.makeArcRing(cc111,cc212,Color.rgb(255, 1, 129));
        Shape s414=c1.makeArcRing(d112,d212,Color.rgb(50, 219, 240));



        Group ring3=c1.makeRing(s111,s212,s313,s414);
        ring3.setLayoutX(500);
        ring3.setLayoutX(10);




        Button roundButton = new Button();

        roundButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 100px; " +
                        "-fx-min-height: 100px; " +
                        "-fx-max-width: 100px; " +
                        "-fx-max-height: 100px;"
        );




        Image img = new Image("play_icon.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(100);
        view.setPreserveRatio(true);


        roundButton.setGraphic(view);




        roundButton.setOnAction(e->{
            try{
                Controller c=new Controller();
               c.toPlayGame(e);
            }
           catch(Exception ee){

            }





        });



        RotateTransition rt = new RotateTransition(Duration.millis(3000), ring1);
        rt.setByAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);


        rt.play();

        RotateTransition rtt = new RotateTransition(Duration.millis(3000), ring2);
        rtt.setByAngle(-360);
        rtt.setCycleCount(Animation.INDEFINITE);
        rtt.setInterpolator(Interpolator.LINEAR);



        rtt.play();

        RotateTransition rot = new RotateTransition(Duration.millis(3000), ring3);
        rot.setByAngle(-360);
        rot.setCycleCount(Animation.INDEFINITE);
        rot.setInterpolator(Interpolator.LINEAR);



        rot.play();

        Node node1 = roots.lookup("#button");

        RotateTransition rtto = new RotateTransition(Duration.millis(3000), node1);
        rtto.setByAngle(-360);
        rtto.setCycleCount(Animation.INDEFINITE);
        rtto.setInterpolator(Interpolator.LINEAR);



        rtto.play();

        Node node2 = roots.lookup("#trophy");

        RotateTransition rtto1 = new RotateTransition(Duration.millis(3000), node2);
        rtto1.setByAngle(360);
        rtto1.setCycleCount(Animation.INDEFINITE);
        rtto1.setInterpolator(Interpolator.LINEAR);




        rtto1.play();






        Node node3 = roots.lookup("#star");

        RotateTransition rtto2 = new RotateTransition(Duration.millis(1000), node3);
        rtto2.setByAngle(120);
        rtto2.setAutoReverse(true);
        rtto2.setCycleCount(Animation.INDEFINITE);
        rtto2.setInterpolator(Interpolator.LINEAR);




        rtto2.play();


        //for color switch

        Arc a1111=c1.makeArcs(30.0f,30.0f,Color.YELLOW,90.0f,90.0f,300.0f,10.0f);
        Arc a2111=c1.makeArcs(25.0f,25.0f,Color.YELLOW,90.0f,90.0f,300.0f,10.0f);
        Arc b1121=c1.makeArcs(30.0f,30.0f,Color.GREEN,180.0f,90.0f,300.0f,10.0f);
        Arc b2121=c1.makeArcs(25.0f,25.0f,Color.GREEN,180.0f,90.0f,300.0f,10.0f);
        Arc cc1111=c1.makeArcs(30.0f,30.0f,Color.BLUE,270.0f,90.0f,300.0f,10.0f);
        Arc cc2121=c1.makeArcs(25.0f,25.0f,Color.BLUE,270.0f,90.0f,300.0f,10.0f);
        Arc d1121=c1.makeArcs(30.0f,30.0f,Color.PINK,0.0f,90.0f,300.0f,10.0f);
        Arc d2121=c1.makeArcs(25.0f,25.0f,Color.PINK,0.0f,90.0f,300.0f,10.0f);

        Shape s1111=c1.makeArcRing(a1111,a2111,Color.rgb(250, 225, 0));
        Shape s2121=c1.makeArcRing(b1121,b2121,Color.rgb(138,43,226));
        Shape s3131=c1.makeArcRing(cc1111,cc2121,Color.rgb(255, 1, 129));
        Shape s4141=c1.makeArcRing(d1121,d2121,Color.rgb(50, 219, 240));



        Group ring4=c1.makeRing(s1111,s2121,s3131,s4141);





        Node node4 = roots.lookup("#o1");

        RotateTransition qrtto2 = new RotateTransition(Duration.millis(1000), node4);
        qrtto2.setByAngle(-360);

        qrtto2.setCycleCount(Animation.INDEFINITE);
        qrtto2.setInterpolator(Interpolator.LINEAR);




        qrtto2.play();





        Node node5 = roots.lookup("#o2");

        RotateTransition wrtto2 = new RotateTransition(Duration.millis(1000), node5);
        wrtto2.setByAngle(360);

        wrtto2.setCycleCount(Animation.INDEFINITE);
        wrtto2.setInterpolator(Interpolator.LINEAR);




        wrtto2.play();











        Group root1=new Group(ring1);
        Group root2=new Group(ring2);
        Group root3=new Group(ring3);
        Group root4=new Group(ring4);
        //root3.getChildren().addAll(root1,root2);

        StackPane stt=new StackPane();
        stt.getChildren().addAll(roots,root1,root2,root3,roundButton);
        // g1.add(stt,1,1);


        Scene scene = new Scene(stt);

        return scene;

    }

    @Override
    public  void start(Stage primaryStage)throws Exception{

        Main initl = Testing.deserialize();
        highScore = initl.getSerialHS();
        totalStars = initl.getSerialTS();
        nSaved =initl.getSerialSav();



        Parent roots=FXMLLoader.load(getClass().getResource("sample.fxml"));



        Circle c1=new Circle();
        Arc a1=c1.makeArc(100.0f,100.0f,Color.YELLOW,90.0f,90.0f);
        Arc a2=c1.makeArc(80.0f,80.0f,Color.YELLOW,90.0f,90.0f);
        Arc b1=c1.makeArc(100.0f,100.0f,Color.GREEN,180.0f,90.0f);
        Arc b2=c1.makeArc(80.0f,80.0f,Color.GREEN,180.0f,90.0f);
        Arc cc1=c1.makeArc(100.0f,100.0f,Color.BLUE,270.0f,90.0f);
        Arc cc2=c1.makeArc(80.0f,80.0f,Color.BLUE,270.0f,90.0f);
        Arc d1=c1.makeArc(100.0f,100.0f,Color.PINK,0.0f,90.0f);
        Arc d2=c1.makeArc(80.0f,80.0f,Color.PINK,0.0f,90.0f);

        Shape s1=c1.makeArcRing(a1,a2,Color.rgb(250, 225, 0));
        Shape s2=c1.makeArcRing(b1,b2,Color.rgb(138,43,226));
        Shape s3=c1.makeArcRing(cc1,cc2,Color.rgb(255, 1, 129));
        Shape s4=c1.makeArcRing(d1,d2,Color.rgb(50, 219, 240));



        Group ring1=c1.makeRing(s1,s2,s3,s4);






        Arc a11=c1.makeArc(135.0f,135.0f,Color.YELLOW,90.0f,90.0f);
        Arc a21=c1.makeArc(110.0f,110.0f,Color.YELLOW,90.0f,90.0f);
        Arc b12=c1.makeArc(135.0f,135.0f,Color.GREEN,180.0f,90.0f);
        Arc b22=c1.makeArc(110.0f,110.0f,Color.GREEN,180.0f,90.0f);
        Arc cc11=c1.makeArc(135.0f,135.0f,Color.BLUE,270.0f,90.0f);
        Arc cc22=c1.makeArc(110.0f,110.0f,Color.BLUE,270.0f,90.0f);
        Arc d12=c1.makeArc(135.0f,135.0f,Color.PINK,0.0f,90.0f);
        Arc d22=c1.makeArc(110.0f,110.0f,Color.PINK,0.0f,90.0f);

        Shape s11=c1.makeArcRing(a11,a21,Color.rgb(250, 225, 0));
        Shape s22=c1.makeArcRing(b12,b22,Color.rgb(138,43,226));
        Shape s33=c1.makeArcRing(cc11,cc22,Color.rgb(255, 1, 129));
        Shape s44=c1.makeArcRing(d12,d22,Color.rgb(50, 219, 240));



        Group ring2=c1.makeRing(s11,s22,s33,s44);


        Arc a111=c1.makeArc(75.0f,75.0f,Color.YELLOW,90.0f,90.0f);
        Arc a211=c1.makeArc(60.0f,60.0f,Color.YELLOW,90.0f,90.0f);
        Arc b112=c1.makeArc(75.0f,75.0f,Color.GREEN,180.0f,90.0f);
        Arc b212=c1.makeArc(60.0f,60.0f,Color.GREEN,180.0f,90.0f);
        Arc cc111=c1.makeArc(75.0f,75.0f,Color.BLUE,270.0f,90.0f);
        Arc cc212=c1.makeArc(60.0f,60.0f,Color.BLUE,270.0f,90.0f);
        Arc d112=c1.makeArc(75.0f,75.0f,Color.PINK,0.0f,90.0f);
        Arc d212=c1.makeArc(60.0f,60.0f,Color.PINK,0.0f,90.0f);

        Shape s111=c1.makeArcRing(a111,a211,Color.rgb(250, 225, 0));
        Shape s212=c1.makeArcRing(b112,b212,Color.rgb(138,43,226));
        Shape s313=c1.makeArcRing(cc111,cc212,Color.rgb(255, 1, 129));
        Shape s414=c1.makeArcRing(d112,d212,Color.rgb(50, 219, 240));



        Group ring3=c1.makeRing(s111,s212,s313,s414);
        ring3.setLayoutX(500);
        ring3.setLayoutX(10);



        //Button roundButton = new Button();
//
//        roundButton.setStyle(
//                "-fx-background-radius: 5em; " +
//                        "-fx-min-width: 100px; " +
//                        "-fx-min-height: 100px; " +
//                        "-fx-max-width: 100px; " +
//                        "-fx-max-height: 100px;"
//        );
//
//
//
//
//        Image img = new Image("play_icon.png");
//        ImageView view = new ImageView(img);
//        view.setFitHeight(100);
//        view.setPreserveRatio(true);
//    roundButton.setGraphic(view);




        RotateTransition rt = new RotateTransition(Duration.millis(3000), ring1);
        rt.setByAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);



        rt.play();

        RotateTransition rtt = new RotateTransition(Duration.millis(3000), ring2);
        rtt.setByAngle(-360);
        rtt.setCycleCount(Animation.INDEFINITE);
        rtt.setInterpolator(Interpolator.LINEAR);



        rtt.play();

        RotateTransition rot = new RotateTransition(Duration.millis(3000), ring3);
        rot.setByAngle(-360);
        rot.setCycleCount(Animation.INDEFINITE);
        rot.setInterpolator(Interpolator.LINEAR);



        rot.play();

        Node node1 = roots.lookup("#button");

        RotateTransition rtto = new RotateTransition(Duration.millis(3000), node1);
        rtto.setByAngle(-360);
        rtto.setCycleCount(Animation.INDEFINITE);
        rtto.setInterpolator(Interpolator.LINEAR);



        rtto.play();

        Node node2 = roots.lookup("#trophy");

        RotateTransition rtto1 = new RotateTransition(Duration.millis(3000), node2);
        rtto1.setByAngle(360);
        rtto1.setCycleCount(Animation.INDEFINITE);
        rtto1.setInterpolator(Interpolator.LINEAR);




        rtto1.play();






        Node node3 = roots.lookup("#star");

        RotateTransition rtto2 = new RotateTransition(Duration.millis(1000), node3);
        rtto2.setByAngle(120);
        rtto2.setAutoReverse(true);
        rtto2.setCycleCount(Animation.INDEFINITE);
        rtto2.setInterpolator(Interpolator.LINEAR);




        rtto2.play();


        //for color switch

        Arc a1111=c1.makeArcs(30.0f,30.0f,Color.YELLOW,90.0f,90.0f,300.0f,10.0f);
        Arc a2111=c1.makeArcs(25.0f,25.0f,Color.YELLOW,90.0f,90.0f,300.0f,10.0f);
        Arc b1121=c1.makeArcs(30.0f,30.0f,Color.GREEN,180.0f,90.0f,300.0f,10.0f);
        Arc b2121=c1.makeArcs(25.0f,25.0f,Color.GREEN,180.0f,90.0f,300.0f,10.0f);
        Arc cc1111=c1.makeArcs(30.0f,30.0f,Color.BLUE,270.0f,90.0f,300.0f,10.0f);
        Arc cc2121=c1.makeArcs(25.0f,25.0f,Color.BLUE,270.0f,90.0f,300.0f,10.0f);
        Arc d1121=c1.makeArcs(30.0f,30.0f,Color.PINK,0.0f,90.0f,300.0f,10.0f);
        Arc d2121=c1.makeArcs(25.0f,25.0f,Color.PINK,0.0f,90.0f,300.0f,10.0f);

        Shape s1111=c1.makeArcRing(a1111,a2111,Color.rgb(250, 225, 0));
        Shape s2121=c1.makeArcRing(b1121,b2121,Color.rgb(138,43,226));
        Shape s3131=c1.makeArcRing(cc1111,cc2121,Color.rgb(255, 1, 129));
        Shape s4141=c1.makeArcRing(d1121,d2121,Color.rgb(50, 219, 240));



        Group ring4=c1.makeRing(s1111,s2121,s3131,s4141);





        Node node4 = roots.lookup("#o1");

        RotateTransition qrtto2 = new RotateTransition(Duration.millis(1000), node4);
        qrtto2.setByAngle(-360);

        qrtto2.setCycleCount(Animation.INDEFINITE);
        qrtto2.setInterpolator(Interpolator.LINEAR);




        qrtto2.play();





        Node node5 = roots.lookup("#o2");

        RotateTransition wrtto2 = new RotateTransition(Duration.millis(1000), node5);
        wrtto2.setByAngle(360);

        wrtto2.setCycleCount(Animation.INDEFINITE);
        wrtto2.setInterpolator(Interpolator.LINEAR);




        wrtto2.play();
















        Group root1=new Group(ring1);
        Group root2=new Group(ring2);
        Group root3=new Group(ring3);
        Group root4=new Group(ring4);
        //root3.getChildren().addAll(root1,root2);

        StackPane stt=new StackPane();
        stt.getChildren().addAll(roots,root1,root2,root3);
       // g1.add(stt,1,1);


        s = new Scene(stt);
        //scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        primaryStage.setScene(s);
        primaryStage.show();
    }
}