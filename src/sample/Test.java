package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import javafx.scene.transform.*;

import java.io.Serializable;
import java.util.*;
import javafx.geometry.Bounds;
import org.w3c.dom.css.Rect;
import javafx.scene.text.*;

public class Test extends Application implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    transient public int circ;
    transient public int recta,sq,pl;
    transient public int cc=0;
    transient ArrayList<Scene> collisionScenes=new ArrayList<Scene>();

    transient private ArrayList<sample.Circle> circles=new ArrayList<sample.Circle>();
    transient  private ArrayList<Square> squares=new ArrayList<Square>();
    transient  private ArrayList<Rectangle> rects=new ArrayList<Rectangle>();
    transient private ArrayList<Plus> pluses=new ArrayList<Plus>();
    transient private ArrayList<Switch> switches=new ArrayList<Switch>();
    transient private ArrayList<Star> stars=new ArrayList<Star>();
    transient  private  Main gameMenu;

    private ArrayList<Coordinates> rectC=new ArrayList<Coordinates>();
    private ArrayList<Coordinates> sqC=new ArrayList<Coordinates>();
    private ArrayList<Coordinates> cirC=new ArrayList<Coordinates>();
    private ArrayList<Coordinates> pluC=new ArrayList<Coordinates>();
    private ArrayList<Coordinates> switC=new ArrayList<Coordinates>();
    private ArrayList<Coordinates> starC=new ArrayList<Coordinates>();

    private Coordinates ballC;
    private int switched;
    private int colorb;
    private int difficulty;



    transient Scene scene;

    public Test(Main gameMenu){
        this.gameMenu=gameMenu;
        circles=new ArrayList<sample.Circle>();
//        transient  private ArrayList<Square> squares=new ArrayList<Square>();
//        transient  private ArrayList<Rectangle> rects=new ArrayList<Rectangle>();
//        transient private ArrayList<Plus> pluses=new ArrayList<Plus>();
//        transient private ArrayList<Switch> switches=new ArrayList<Switch>();
//        transient private ArrayList<Star> stars=new ArrayList<Star>();

    }


    public void setStars(ArrayList<Star> stars) {
        this.stars = stars;
    }

    public void setSwitches(ArrayList<Switch> switches) {
        this.switches = switches;
    }

    public void setPluses(ArrayList<Plus> pluses) {
        this.pluses = pluses;
    }

    public void setRects(ArrayList<Rectangle> rects) {
        this.rects = rects;
    }

    public void setSquares(ArrayList<Square> squares) {
        this.squares = squares;
    }

    public void setCircles(ArrayList<sample.Circle> circles) {
        this.circles = circles;
    }

    public ArrayList<Star> getStars() {
        return stars;
    }

    public ArrayList<Switch> getSwitches() {
        return switches;
    }

    public ArrayList<Plus> getPluses() {
        return pluses;
    }

    public ArrayList<Rectangle> getRects() {
        return rects;
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public ArrayList<sample.Circle> getCircles() {
        return circles;
    }

    transient Ball ball;

   public  int score;

    transient public  int state;

    transient private boolean isHit;


//    public void setScoree(int scoree) {
//        this.scoree = scoree;
//    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

//    public int getScoree() {
//        return scoree;
//    }


    public static Text showScore(int x){
        Text text=new Text();
        text.setText(Integer.toString(x));
        text.setX(50);
        text.setY(70);
        text.setFill(Color.RED);
        text.setStrokeWidth(2);

        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        return text;
    }

    public static Text makeText(Coordinates coord, Color cl, String string,int size){
        Text text=new Text();
        text.setText(string);
        text.setX(coord.getX());
        text.setY(coord.getY());
        text.setFill(cl);
        text.setStrokeWidth(1);

        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, size));
        return text;

    }



    transient Button pauseButton;
    transient Image img;
    transient ImageView view;
    transient Text text;
    transient Buttonn jumpButton;



    public void playSaved(Test test,Stage primaryStage) throws Exception {


        int lol1; boolean lol2;
        if(difficulty==0){
            lol1=3000;
            lol2=false;
        }
        else{
            lol1=2000;
            lol2=true;
        }


        test.circles=new ArrayList<sample.Circle>();
        test.stars=new ArrayList<Star>();
        test.switches=new ArrayList<Switch>();
        test.squares=new ArrayList<Square>();
        test.rects=new ArrayList<Rectangle>();
        test.pluses=new ArrayList<Plus>();
        gameMenu=new Main();

        System.out.println(colorb);

        if(colorb==1)
        ball=new Ball(Color.rgb(250, 225, 0), new Coordinates(test.ballC.getX(),test.ballC.getY()));

        else if(colorb==2){
            ball=new Ball(Color.rgb(138,43,226), new Coordinates(test.ballC.getX(),test.ballC.getY()));

        }
        else if(colorb==3){
            ball=new Ball(Color.rgb(255, 1, 129), new Coordinates(test.ballC.getX(),test.ballC.getY()));

        }
        else{
            ball=new Ball(Color.rgb(50, 219, 240), new Coordinates(test.ballC.getX(),test.ballC.getY()));
        }



        pauseButton=new Button();
        pauseButton.setLayoutX(700);
        pauseButton.setLayoutY(30);
        pauseButton.setStyle(

                "-fx-background-radius: 3em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;"

        );

        img = new Image("pause.png");
        view = new ImageView(img);
        view.setFitHeight(55);
        view.setPreserveRatio(true);
        pauseButton.setGraphic(view);



        ArrayList<Text> scores=new ArrayList<Text>();
        scores.add(showScore(test.score));

        Text pauseText=makeText(new Coordinates(690,17), Color.ORANGE,"Pause",20);




        text=new Text();
        text.setText("SCORE");
        text.setX(10);
        text.setY(30);
        text.setFill(Color.WHITE);
        text.setStrokeWidth(2);
        text.setStroke(Color.WHITE);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));




        jumpButton=new Buttonn(new Coordinates(700.0f,700.0f),"JUMP",Color.YELLOW);




        AnchorPane pane =new AnchorPane();
        pane.setStyle(
                "-fx-background-color: #000000; "
        );
        pane.getChildren().addAll(ball.getBall(), jumpButton.getButton(),text,scores.get(0),pauseButton,pauseText);

        scene=new Scene(pane,800,800,Color.BLACK);


        primaryStage.setScene(scene);
        primaryStage.show();

        Parent root = FXMLLoader.load(getClass().getResource("pause.fxml"));

        Scene scen=new Scene(root);

        Button btn=new Button();

        btn=(Button)root.lookup("#resumePause");
        btn.setOnAction(e->{

            state=0;

            primaryStage.setScene(scene);
            primaryStage.show();
        });

        pauseButton.setOnAction(e->{
            state=1;
            primaryStage.setScene(scen);
            primaryStage.show();
        });

        Button btn2=new Button();
        btn2=(Button)root.lookup("#restartButton");
        btn2.setOnAction(e->{
            Test t=new Test(this.gameMenu);
            try {
                t.start(primaryStage);

            }
            catch(Exception x){

            }
            return;
        });

        Button btn3=new Button();
        btn3=(Button)root.lookup("#saveB");
        btn3.setOnAction(e->{
            try {

                for(int i=0;i<circles.size();i++){
                    Bounds bound=circles.get(i).getRing().localToScene(circles.get(i).getRing().getBoundsInLocal());
                    Coordinates ff=new Coordinates(bound.getCenterX(),bound.getCenterY());
                    cirC.add(ff);
                }

                for(int i=0;i<switches.size();i++){

                    Coordinates ff=new Coordinates(switches.get(i).getBall().getCenterX(),switches.get(i).getBall().getCenterY());
                    switC.add(ff);
                }

                ballC=new Coordinates(ball.getBall().getCenterX(),ball.getBall().getCenterY());

                String t=ball.getBall().getFill().toString();
                if(t.equals(Color.rgb(250, 225, 0).toString())){
                    colorb=1;

                }
                else if(t.equals(Color.rgb(138,43,226).toString())){
                    colorb=2;
                }
                else if(t.equals(Color.rgb(255, 1, 129))){
                    colorb=3;
                }
                else{
                    colorb=4;
                }


                System.out.println(this.score);
                Testing.serialize1(this,(int)(gameMenu.getnSaved()%4));
                gameMenu.setnSaved(gameMenu.getnSaved()+1);
                gameMenu.setSerialSav(gameMenu.getSerialSav()+1);
                Controller wt=new Controller();
                wt.toMainMenu(e);
                return;


            }
            catch(Exception er){
                er.printStackTrace();

            }
            return;
        });





        Parent collisionRoot = FXMLLoader.load(getClass().getResource("collision.fxml"));
        Button b1,b2;
        b1=(Button)collisionRoot.lookup("#cont");
        b2=(Button)collisionRoot.lookup("#rest");

        Scene sct = new Scene(collisionRoot);



        b2.setOnAction(e->{
            Test t=new Test(this.gameMenu);
            try {
                t.start(primaryStage);
            }
            catch(Exception x){
            }
            return;
        });

        Parent EnoRoot = FXMLLoader.load(getClass().getResource("notEnough.fxml"));

        Scene notEn=new Scene(EnoRoot);

        Button backNeno=(Button)EnoRoot.lookup("#backEn");

        b1.setOnAction(e->{

            ball.getBall().setCenterY(ball.getBall().getCenterY()+50);
            if(gameMenu.getTotalStars()>=10){

//                if(collisionScenes.size()!=0){
//                    collisionScenes.remove(collisionScenes.get(0));
//                }




                primaryStage.setScene(scene);

                primaryStage.show();
                state=0;

                gameMenu.setTotalStars(gameMenu.getTotalStars()-10);




            }
            else{
                primaryStage.setScene(notEn);
                primaryStage.show();
            }
        });

        backNeno.setOnAction(e->{
            primaryStage.setScene(sct);
            primaryStage.show();
        });




        System.out.println(starC.size());
        for(int i=0;i<starC.size();i++){
            if(i%4==0) {
                Star star = new Star(new Coordinates(375.0, 375.0 - 500 * i));
                star.makeStar();
                stars.add(star);

                pane.getChildren().addAll(star.getButton());

            }
            else{
                Star star = new Star(new Coordinates(375.0, 400.0 - 500 * i));
                star.makeStar();
                stars.add(star);
                pane.getChildren().addAll(star.getButton());

            }


        }
        for(int i=0;i<starC.size();i++){
            Star star=stars.get(i);
            star.getButton().setTranslateY(starC.get(i).getY());
        }


        for(int i=0;i<score;i++){
            Star star=stars.get(i);
            pane.getChildren().remove(star.getButton());


        }







        for(int i=0;i<cirC.size();i++){
            sample.Circle c1=new sample.Circle();
            c1.Ring((float)test.cirC.get(i).getX(),(float)test.cirC.get(i).getY());
            c1.rotateRing(new RotateTransition(),c1.getRing(),lol1,lol2);
            pane.getChildren().addAll(c1.getRing());
            test.circles.add(c1);
            circ=i;

        }



        for(int i=0;i<sqC.size();i++){

            Square square=new Square();
            square.makeSquare(315,485,-30-125-500*4*i,140-125-500*4*i);
            square.getSquare();
            square.rotateSquare(new RotateTransition(), square.getSquare(),lol1,lol2);
            pane.getChildren().addAll(square.getSquare());
            squares.add(square);
            sq=i;
        }

        for(int i=0;i<sqC.size();i++){
            Square square=squares.get(i);
            square.getSquare().setTranslateY(sqC.get(i).getY());
        }
//
//
//
        for(int i=0;i<rectC.size();i++){

            if(i%2==0 && i%4!=0) {
                Rectangle rect = new Rectangle();
                rect.makeRectangle(300, 500, -20-125 - 500 * i, 140-125 - 500* i);
                rect.rotateRect(new RotateTransition(), rect.getRectangle(),lol1,true);
                pane.getChildren().addAll(rect.getRectangle());
                rects.add(rect);
                recta=i;
            }

        }

        for(int i=0;i<rects.size();i++){
            Rectangle rect=rects.get(i);
            rect.getRectangle().setTranslateY(rectC.get(i).getY());
        }
        for(int i=0;i<pluC.size();i++){

            if(i!=0 && i%2==0 && i%4!=0) {
                Plus plus = new Plus();
                plus.makePlus(330.0, 300.0 - 500 * i, 230.0, 400.0 - 500 * i, 330.0, 400.0 - 500 * i, 430.0, 400.0 - 500 * i, 330.0, 500.0 - 500* i);
                plus.rotatePlus(new RotateTransition(), plus.getPlus(),lol1,lol2);
                pane.getChildren().addAll(plus.getPlus());
                pluses.add(plus);
                pl=i;

            }
        }

        for(int i=0;i<pluses.size();i++){
            Plus plus=pluses.get(i);
            plus.getPlus().setTranslateY(pluC.get(i).getY());
        }

        ArrayList<Color> colors=new ArrayList<Color>();
        colors.add(Color.rgb(250, 225, 0));
        colors.add(Color.rgb(138,43,226));
        colors.add(Color.rgb(255, 1, 129));
        colors.add(Color.rgb(50, 219, 240));

        for(int i=0;i<switC.size();i++){
            Switch ballSwitch=new Switch(colors.get(i%4),new Coordinates(test.switC.get(i).getX(),test.switC.get(i).getY()));
            switches.add(ballSwitch);
            pane.getChildren().addAll(ballSwitch.getBall());
        }

//        System.out.println(switched);
//        for(int i=0;i<switched;i++){
//            Switch x=switches.get(i);
//            pane.getChildren().remove(x.getBall());
//
//        }








        new AnimationTimer() {





            @Override

            public void handle(long l) {

                if (state == 0) {


                    jumpButton.getButton().setOnAction(e -> {
                        cc++;
                        ball.getBall().setCenterY(ball.getBall().getCenterY() - 70);

                    });

                    if (cc >= 1 && ball.getBall().getCenterY() < 700)


                        ball.getBall().setCenterY(ball.getBall().getCenterY() + 3);


                    outer:for (int i = 0; i < circles.size(); i++) {
                        sample.Circle circle = circles.get(i);
                        ArrayList<Shape> arcs = circle.getComponents();
                        for (Shape shape : arcs) {


                            if (Shape.intersect(ball.getBall(), shape).getBoundsInLocal().getWidth() != -1 && !ball.getBall().getFill().toString().equals(shape.getFill().toString())) {





                                primaryStage.setScene(sct);

                                primaryStage.show();
                                state = 1;
                                break outer;




                            }
                        }
                    }
                    outer:for (int i = 0; i < squares.size(); i++) {

                        Square sq=squares.get(i);
                        ArrayList<Line> arcs = sq.getLines();
                        for (Shape shape : arcs) {


                            if (Shape.intersect(ball.getBall(), shape).getBoundsInLocal().getWidth() != -1 && !ball.getBall().getFill().toString().equals(shape.getStroke().toString())) {





                                primaryStage.setScene(sct);

                                primaryStage.show();
                                state = 1;
                                break outer;




                            }
                        }
                    }
                    outer:for (int i = 0; i < rects.size(); i++) {

                        Rectangle sq=rects.get(i);
                        ArrayList<Line> arcs = sq.getLines();
                        for (Shape shape : arcs) {


                            if (Shape.intersect(ball.getBall(), shape).getBoundsInLocal().getWidth() != -1 && !ball.getBall().getFill().toString().equals(shape.getStroke().toString())) {





                                primaryStage.setScene(sct);

                                primaryStage.show();
                                state = 1;
                                break outer;




                            }
                        }
                    }
                    outer:for (int i = 0; i < pluses.size(); i++) {

                        Plus sq=pluses.get(i);
                        ArrayList<Line> arcs = sq.getLines();
                        for (Shape shape : arcs) {


                            if (Shape.intersect(ball.getBall(), shape).getBoundsInLocal().getWidth() != -1 && !ball.getBall().getFill().toString().equals(shape.getStroke().toString())) {





                                primaryStage.setScene(sct);

                                primaryStage.show();
                                state = 1;
                                break outer;




                            }
                        }
                    }

                    outer: for (int i = 0; i < switches.size(); i++) {
                        Switch sw = switches.get(i);
                        if (Shape.intersect(ball.getBall(), sw.getBall()).getBoundsInLocal().getWidth() != -1) {
                            ball.getBall().setFill(sw.getBall().getFill());
                            pane.getChildren().remove(sw.getBall());

                            switched++;
                            break outer;
                        }
                    }


                    for (int i = 0; i < stars.size(); i++) {
                        Star sw = stars.get(i);

                        if (sw.getButton().intersects(sw.getButton().sceneToLocal(ball.getBall().localToScene(ball.getBall().getBoundsInLocal())))) {
                            pane.getChildren().remove(sw.getButton());
                            stars.remove(sw);

                            score++;
                            if (gameMenu.getHighScore() < (long) score) {
                                gameMenu.setHighscore((long) score);
                            }
                            gameMenu.setTotalStars(gameMenu.getTotalStars() + 1);


                            if (scores.size() != 0) {
                                Text rem = scores.get(0);
                                scores.remove(rem);
                                pane.getChildren().remove(rem);
                            }


                            Text d = showScore(score);
                            scores.add(d);

                            pane.getChildren().addAll(d);
                        }
                    }


                    if (ball.getBall().getCenterY() < 400) {
                        for (int i = 0; i < squares.size(); i++) {
                            Square sq = squares.get(i);
                            sq.getSquare().setTranslateY(sq.getSquare().getTranslateY() + 5);
                            sqC.set(i, new Coordinates(0, sq.getSquare().getTranslateY()));
                        }
                        for (int i = 0; i < rects.size(); i++) {
                            Rectangle rect = rects.get(i);
                            rect.getRectangle().setTranslateY(rect.getRectangle().getTranslateY() + 5);
                            rectC.set(i, new Coordinates(0,rect.getRectangle().getTranslateY()));
                        }
                        for (int i = 0; i < pluses.size(); i++) {
                            Plus plus = pluses.get(i);
                            plus.getPlus().setTranslateY(plus.getPlus().getTranslateY() + 5);
                            pluC.set(i,new Coordinates(0,plus.getPlus().getTranslateY()));

                        }
                        for (int i = 0; i < circles.size(); i++) {
                            sample.Circle circle = circles.get(i);
                            circle.getRing().setTranslateY(circle.getRing().getTranslateY() + 5);

                        }
                        for (int i = 0; i < switches.size(); i++) {
                            Switch sw = switches.get(i);


                            sw.getBall().setCenterY(sw.getBall().getCenterY() + 5);

                        }



                        for (int i = 0; i < stars.size(); i++) {
                            Star star = stars.get(i);
                            star.getButton().setTranslateY(star.getButton().getTranslateY() + 5);
                            starC.set(i,new Coordinates(0,star.getButton().getTranslateY()));

                        }
                        ball.getBall().setCenterY(ball.getBall().getCenterY() + 5);
                    }


                    //Difficult
                    if(difficulty!=1 && score%5==0 && score!=0){

                        for(int i=0;i<circles.size();i++){
                            circles.get(i).rotateRing(new RotateTransition(),circles.get(i).getRing(),2000,true);
                        }
                        for(int i=0;i<squares.size();i++){
                            squares.get(i).rotateSquare(new RotateTransition(),squares.get(i).getSquare(),2000,true);
                        }
                        for(int i=0;i<rects.size();i++){
                            rects.get(i).rotateRect(new RotateTransition(),rects.get(i).getRectangle(),2000,true);
                        }
                        for(int i=0;i<pluses.size();i++){
                            pluses.get(i).rotatePlus(new RotateTransition(),pluses.get(i).getPlus(),2000,true);
                        }
                        difficulty=1;

                    }






                    if(score%120==0 && score!=0){
                        for(int i=0;i<120;i++){


                            if(i%4==0) {
                                Star star = new Star(new Coordinates(375.0, 375.0 - 500 * i));
                                star.makeStar();
                                stars.add(star);
                                pane.getChildren().addAll(star.getButton());
                                starC.add(new Coordinates(0,0));
                            }
                            else{
                                Star star = new Star(new Coordinates(375.0, 400.0 - 500 * i));
                                star.makeStar();
                                stars.add(star);
                                pane.getChildren().addAll(star.getButton());
                                starC.add(new Coordinates(0,0));
                            }

                        }



                        for(int i=0;i<30;i++){
                            sample.Circle c1=new sample.Circle();
                            c1.Ring(400,400-500*4*i);
                            c1.rotateRing(new RotateTransition(),c1.getRing(),3000,false);
                            pane.getChildren().addAll(c1.getRing());
                            circles.add(c1);
                            circ=i;

                        }



                        for(int i=0;i<30;i++){

                            Square square=new Square();
                            square.makeSquare(315,485,-30-125-500*4*i,140-125-500*4*i);
                            square.rotateSquare(new RotateTransition(), square.getSquare(),3000,false);
                            pane.getChildren().addAll(square.getSquare());
                            sqC.add(new Coordinates(0,0));
                            squares.add(square);
                            sq=i;
                        }



                        for(int i=0;i<4*30;i++){

                            if(i%2==0 && i%4!=0) {
                                Rectangle rect = new Rectangle();
                                rect.makeRectangle(300, 500, -20-125 - 500 * i, 140-125 - 500* i);
                                rect.rotateRect(new RotateTransition(), rect.getRectangle(),3000,true);
                                rectC.add(new Coordinates(0,0));
                                pane.getChildren().addAll(rect.getRectangle());
                                rects.add(rect);
                                recta=i;
                            }

                        }
                        for(int i=0;i<4*30;i++){

                            if(i!=0 && i%2==0 && i%4!=0) {
                                Plus plus = new Plus();
                                plus.makePlus(330.0, 300.0 - 500 * i, 230.0, 400.0 - 500 * i, 330.0, 400.0 - 500 * i, 430.0, 400.0 - 500 * i, 330.0, 500.0 - 500* i);
                                plus.rotatePlus(new RotateTransition(), plus.getPlus(),3000,false);
                                pane.getChildren().addAll(plus.getPlus());
                                pluC.add(new Coordinates(0,0));
                                pluses.add(plus);
                                pl=i;

                            }
                        }

                        ArrayList<Color> colors=new ArrayList<Color>();
                        colors.add(Color.rgb(250, 225, 0));
                        colors.add(Color.rgb(138,43,226));
                        colors.add(Color.rgb(255, 1, 129));
                        colors.add(Color.rgb(50, 219, 240));

                        for(int i=0;i<30;i++){
                            Switch ballSwitch=new Switch(colors.get(i%4),new Coordinates(400,630-500*i));
                            switches.add(ballSwitch);
                            pane.getChildren().addAll(ballSwitch.getBall());
                        }





                    }
                }

            }

        }.start();;










    }






    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        ball=new Ball(Color.rgb(50, 219, 240), new Coordinates(400,750));


        pauseButton=new Button();
        pauseButton.setLayoutX(700);
        pauseButton.setLayoutY(30);
        pauseButton.setStyle(

                "-fx-background-radius: 3em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;"

        );

        img = new Image("pause.png");
         view = new ImageView(img);
        view.setFitHeight(55);
        view.setPreserveRatio(true);
        pauseButton.setGraphic(view);



        ArrayList<Text> scores=new ArrayList<Text>();
        scores.add(showScore(0));

        Text pauseText=makeText(new Coordinates(690,17), Color.ORANGE,"Pause",20);




        text=new Text();
        text.setText("SCORE");
        text.setX(10);
        text.setY(30);
        text.setFill(Color.WHITE);
        text.setStrokeWidth(2);
        text.setStroke(Color.WHITE);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));




       jumpButton=new Buttonn(new Coordinates(700.0f,700.0f),"JUMP",Color.YELLOW);

        Circle circle=ball.getBall();


        AnchorPane pane =new AnchorPane();
        pane.setStyle(
                "-fx-background-color: #000000; "
        );
        pane.getChildren().addAll(circle, jumpButton.getButton(),text,scores.get(0),pauseButton,pauseText);

       scene=new Scene(pane,800,800,Color.BLACK);


        primaryStage.setScene(scene);
        primaryStage.show();

        Parent root = FXMLLoader.load(getClass().getResource("pause.fxml"));

        Scene scen=new Scene(root);

        Button btn=new Button();

        btn=(Button)root.lookup("#resumePause");
        btn.setOnAction(e->{

            state=0;

            primaryStage.setScene(scene);
            primaryStage.show();
        });

        pauseButton.setOnAction(e->{
            state=1;
            primaryStage.setScene(scen);
            primaryStage.show();
        });

        Button btn2=new Button();
        btn2=(Button)root.lookup("#restartButton");
        btn2.setOnAction(e->{
            Test t=new Test(this.gameMenu);
            try {
                t.start(primaryStage);

            }
            catch(Exception x){

            }
            return;
        });

        Button btn3=new Button();
        btn3=(Button)root.lookup("#saveB");
        btn3.setOnAction(e->{
            try {
                for(int i=0;i<circles.size();i++){
                    Bounds bound=circles.get(i).getRing().localToScene(circles.get(i).getRing().getBoundsInLocal());
                    Coordinates ff=new Coordinates(bound.getCenterX(),bound.getCenterY());
                    cirC.add(ff);
                }

                for(int i=0;i<switches.size();i++){

                    Coordinates ff=new Coordinates(switches.get(i).getBall().getCenterX(),switches.get(i).getBall().getCenterY());
                    switC.add(ff);
                }

                ballC=new Coordinates(ball.getBall().getCenterX(),ball.getBall().getCenterY());

                String t=ball.getBall().getFill().toString();
                if(t.equals(Color.rgb(250, 225, 0).toString())){
                    colorb=1;

                }
                else if(t.equals(Color.rgb(138,43,226).toString())){
                    colorb=2;
                }
                else if(t.equals(Color.rgb(255, 1, 129))){
                    colorb=3;
                }
                else{
                    colorb=4;
                }


                System.out.println(this.score);
                Testing.serialize1(this,(int)(gameMenu.getnSaved()%4));
                gameMenu.setnSaved(gameMenu.getnSaved()+1);
                gameMenu.setSerialSav(gameMenu.getSerialSav()+1);
                Controller wt=new Controller();
                wt.toMainMenu(e);
                return;
               // Controller.toMainMenu(e);

            }
            catch(Exception er){
                er.printStackTrace();

            }
            return;
        });





        Parent collisionRoot = FXMLLoader.load(getClass().getResource("collision.fxml"));
        Button b1,b2;
        b1=(Button)collisionRoot.lookup("#cont");
        b2=(Button)collisionRoot.lookup("#rest");

        Scene sct = new Scene(collisionRoot);



        b2.setOnAction(e->{
            Test t=new Test(this.gameMenu);
            try {
                t.start(primaryStage);
            }
            catch(Exception x){
            }
            return;
        });

        Parent EnoRoot = FXMLLoader.load(getClass().getResource("notEnough.fxml"));

        Scene notEn=new Scene(EnoRoot);

        Button backNeno=(Button)EnoRoot.lookup("#backEn");

        b1.setOnAction(e->{

            ball.getBall().setCenterY(ball.getBall().getCenterY()+50);
            if(gameMenu.getTotalStars()>=10){

//                if(collisionScenes.size()!=0){
//                    collisionScenes.remove(collisionScenes.get(0));
//                }




                primaryStage.setScene(scene);

                primaryStage.show();
                state=0;

                gameMenu.setTotalStars(gameMenu.getTotalStars()-10);




            }
            else{
                primaryStage.setScene(notEn);
                primaryStage.show();
            }
        });

        backNeno.setOnAction(e->{
            primaryStage.setScene(sct);
            primaryStage.show();
        });




        for(int i=0;i<120;i++){


            if(i%4==0) {
                Star star = new Star(new Coordinates(375.0, 375.0 - 500 * i));
                star.makeStar();
                stars.add(star);
                pane.getChildren().addAll(star.getButton());
                starC.add(new Coordinates(0,0));
            }
            else{
                Star star = new Star(new Coordinates(375.0, 400.0 - 500 * i));
                star.makeStar();
                stars.add(star);
                pane.getChildren().addAll(star.getButton());
                starC.add(new Coordinates(0,0));
            }

        }



        for(int i=0;i<30;i++){
            sample.Circle c1=new sample.Circle();
            c1.Ring(400,400-500*4*i);
            c1.rotateRing(new RotateTransition(),c1.getRing(),3000,false);
            pane.getChildren().addAll(c1.getRing());
            circles.add(c1);
            circ=i;

        }



        for(int i=0;i<30;i++){

            Square square=new Square();
            square.makeSquare(315,485,-30-125-500*4*i,140-125-500*4*i);
            square.rotateSquare(new RotateTransition(), square.getSquare(),3000,false);
            pane.getChildren().addAll(square.getSquare());
            sqC.add(new Coordinates(0,0));
            squares.add(square);
            sq=i;
        }



        for(int i=0;i<4*30;i++){

          if(i%2==0 && i%4!=0) {
                Rectangle rect = new Rectangle();
                rect.makeRectangle(300, 500, -20-125 - 500 * i, 140-125 - 500* i);
                rect.rotateRect(new RotateTransition(), rect.getRectangle(),3000,true);
                rectC.add(new Coordinates(0,0));
                pane.getChildren().addAll(rect.getRectangle());
                rects.add(rect);
                recta=i;
            }

        }
        for(int i=0;i<4*30;i++){

            if(i!=0 && i%2==0 && i%4!=0) {
                Plus plus = new Plus();
                plus.makePlus(330.0, 300.0 - 500 * i, 230.0, 400.0 - 500 * i, 330.0, 400.0 - 500 * i, 430.0, 400.0 - 500 * i, 330.0, 500.0 - 500* i);
                plus.rotatePlus(new RotateTransition(), plus.getPlus(),3000,false);
                pane.getChildren().addAll(plus.getPlus());
                pluC.add(new Coordinates(0,0));
                pluses.add(plus);
                pl=i;

            }
        }

        ArrayList<Color> colors=new ArrayList<Color>();
        colors.add(Color.rgb(250, 225, 0));
        colors.add(Color.rgb(138,43,226));
        colors.add(Color.rgb(255, 1, 129));
        colors.add(Color.rgb(50, 219, 240));

        for(int i=0;i<30;i++){
            Switch ballSwitch=new Switch(colors.get(i%4),new Coordinates(400,630-500*i));
            switches.add(ballSwitch);
            pane.getChildren().addAll(ballSwitch.getBall());
        }








            new AnimationTimer() {





                @Override

                public void handle(long l) {

                    if (state == 0) {


                        jumpButton.getButton().setOnAction(e -> {
                            cc++;
                            ball.getBall().setCenterY(ball.getBall().getCenterY() - 70);

                        });

                        if (cc >= 1 && ball.getBall().getCenterY() < 700)


                            ball.getBall().setCenterY(ball.getBall().getCenterY() + 3);


                        outer:for (int i = 0; i < circles.size(); i++) {
                            sample.Circle circle = circles.get(i);
                            ArrayList<Shape> arcs = circle.getComponents();
                            for (Shape shape : arcs) {


                                if (Shape.intersect(ball.getBall(), shape).getBoundsInLocal().getWidth() != -1 && !ball.getBall().getFill().toString().equals(shape.getFill().toString())) {





                                        primaryStage.setScene(sct);

                                        primaryStage.show();
                                        state = 1;
                                        break outer;




                                }
                            }
                        }
                        outer:for (int i = 0; i < squares.size(); i++) {

                            Square sq=squares.get(i);
                            ArrayList<Line> arcs = sq.getLines();
                            for (Shape shape : arcs) {


                               if (Shape.intersect(ball.getBall(), shape).getBoundsInLocal().getWidth() != -1 && !ball.getBall().getFill().toString().equals(shape.getStroke().toString())) {





                                    primaryStage.setScene(sct);

                                    primaryStage.show();
                                    state = 1;
                                    break outer;




                                }
                            }
                        }
                        outer:for (int i = 0; i < rects.size(); i++) {

                            Rectangle sq=rects.get(i);
                            ArrayList<Line> arcs = sq.getLines();
                            for (Shape shape : arcs) {


                                if (Shape.intersect(ball.getBall(), shape).getBoundsInLocal().getWidth() != -1 && !ball.getBall().getFill().toString().equals(shape.getStroke().toString())) {





                                    primaryStage.setScene(sct);

                                    primaryStage.show();
                                    state = 1;
                                    break outer;




                                }
                            }
                        }
                        outer:for (int i = 0; i < pluses.size(); i++) {

                            Plus sq=pluses.get(i);
                            ArrayList<Line> arcs = sq.getLines();
                            for (Shape shape : arcs) {


                                if (Shape.intersect(ball.getBall(), shape).getBoundsInLocal().getWidth() != -1 && !ball.getBall().getFill().toString().equals(shape.getStroke().toString())) {





                                    primaryStage.setScene(sct);

                                    primaryStage.show();
                                    state = 1;
                                    break outer;




                                }
                            }
                        }

                       outer: for (int i = 0; i < switches.size(); i++) {
                            Switch sw = switches.get(i);
                            if (Shape.intersect(ball.getBall(), sw.getBall()).getBoundsInLocal().getWidth() != -1) {
                                ball.getBall().setFill(sw.getBall().getFill());
                                pane.getChildren().remove(sw.getBall());

                                switched++;
                                break outer;
                            }
                        }


                        for (int i = 0; i < stars.size(); i++) {
                            Star sw = stars.get(i);

                            if (sw.getButton().intersects(sw.getButton().sceneToLocal(ball.getBall().localToScene(ball.getBall().getBoundsInLocal())))) {
                                pane.getChildren().remove(sw.getButton());
                                stars.remove(sw);

                                score++;
                                if (gameMenu.getHighScore() < (long) score) {
                                    gameMenu.setHighscore((long) score);
                                }
                                gameMenu.setTotalStars(gameMenu.getTotalStars() + 1);


                                if (scores.size() != 0) {
                                    Text rem = scores.get(0);
                                    scores.remove(rem);
                                    pane.getChildren().remove(rem);
                                }


                                Text d = showScore(score);
                                scores.add(d);

                                pane.getChildren().addAll(d);
                            }
                        }


                        if (ball.getBall().getCenterY() < 400) {
                            for (int i = 0; i < squares.size(); i++) {
                                Square sq = squares.get(i);
                                sq.getSquare().setTranslateY(sq.getSquare().getTranslateY() + 5);
                                sqC.set(i, new Coordinates(0, sq.getSquare().getTranslateY()));
                            }
                            for (int i = 0; i < rects.size(); i++) {
                                Rectangle rect = rects.get(i);
                                rect.getRectangle().setTranslateY(rect.getRectangle().getTranslateY() + 5);
                                rectC.set(i, new Coordinates(0,rect.getRectangle().getTranslateY()));
                            }
                            for (int i = 0; i < pluses.size(); i++) {
                                Plus plus = pluses.get(i);
                                plus.getPlus().setTranslateY(plus.getPlus().getTranslateY() + 5);
                                pluC.set(i,new Coordinates(0,plus.getPlus().getTranslateY()));

                            }
                            for (int i = 0; i < circles.size(); i++) {
                                sample.Circle circle = circles.get(i);
                                circle.getRing().setTranslateY(circle.getRing().getTranslateY() + 5);

                            }
                            for (int i = 0; i < switches.size(); i++) {
                                Switch sw = switches.get(i);


                                sw.getBall().setCenterY(sw.getBall().getCenterY() + 5);

                            }



                        for (int i = 0; i < stars.size(); i++) {
                            Star star = stars.get(i);
                            star.getButton().setTranslateY(star.getButton().getTranslateY() + 5);
                            starC.set(i,new Coordinates(0,star.getButton().getTranslateY()));

                        }
                            ball.getBall().setCenterY(ball.getBall().getCenterY() + 5);
                    }


                        //Difficult
                    if(difficulty!=1 && score%5==0 && score!=0){

                        for(int i=0;i<circles.size();i++){
                            circles.get(i).rotateRing(new RotateTransition(),circles.get(i).getRing(),2000,true);
                        }
                        for(int i=0;i<squares.size();i++){
                            squares.get(i).rotateSquare(new RotateTransition(),squares.get(i).getSquare(),2000,true);
                        }
                        for(int i=0;i<rects.size();i++){
                            rects.get(i).rotateRect(new RotateTransition(),rects.get(i).getRectangle(),2000,true);
                        }
                        for(int i=0;i<pluses.size();i++){
                            pluses.get(i).rotatePlus(new RotateTransition(),pluses.get(i).getPlus(),2000,true);
                        }
                        difficulty=1;

                    }

                        if(score%120==0 && score!=0){
                            for(int i=0;i<120;i++){


                                if(i%4==0) {
                                    Star star = new Star(new Coordinates(375.0, 375.0 - 500 * i));
                                    star.makeStar();
                                    stars.add(star);
                                    pane.getChildren().addAll(star.getButton());
                                    starC.add(new Coordinates(0,0));
                                }
                                else{
                                    Star star = new Star(new Coordinates(375.0, 400.0 - 500 * i));
                                    star.makeStar();
                                    stars.add(star);
                                    pane.getChildren().addAll(star.getButton());
                                    starC.add(new Coordinates(0,0));
                                }

                            }



                            for(int i=0;i<30;i++){
                                sample.Circle c1=new sample.Circle();
                                c1.Ring(400,400-500*4*i);
                                c1.rotateRing(new RotateTransition(),c1.getRing(),3000,false);
                                pane.getChildren().addAll(c1.getRing());
                                circles.add(c1);
                                circ=i;

                            }



                            for(int i=0;i<30;i++){

                                Square square=new Square();
                                square.makeSquare(315,485,-30-125-500*4*i,140-125-500*4*i);
                                square.rotateSquare(new RotateTransition(), square.getSquare(),3000,false);
                                pane.getChildren().addAll(square.getSquare());
                                sqC.add(new Coordinates(0,0));
                                squares.add(square);
                                sq=i;
                            }



                            for(int i=0;i<4*30;i++){

                                if(i%2==0 && i%4!=0) {
                                    Rectangle rect = new Rectangle();
                                    rect.makeRectangle(300, 500, -20-125 - 500 * i, 140-125 - 500* i);
                                    rect.rotateRect(new RotateTransition(), rect.getRectangle(),3000,true);
                                    rectC.add(new Coordinates(0,0));
                                    pane.getChildren().addAll(rect.getRectangle());
                                    rects.add(rect);
                                    recta=i;
                                }

                            }
                            for(int i=0;i<4*30;i++){

                                if(i!=0 && i%2==0 && i%4!=0) {
                                    Plus plus = new Plus();
                                    plus.makePlus(330.0, 300.0 - 500 * i, 230.0, 400.0 - 500 * i, 330.0, 400.0 - 500 * i, 430.0, 400.0 - 500 * i, 330.0, 500.0 - 500* i);
                                    plus.rotatePlus(new RotateTransition(), plus.getPlus(),3000,false);
                                    pane.getChildren().addAll(plus.getPlus());
                                    pluC.add(new Coordinates(0,0));
                                    pluses.add(plus);
                                    pl=i;

                                }
                            }

                            ArrayList<Color> colors=new ArrayList<Color>();
                            colors.add(Color.rgb(250, 225, 0));
                            colors.add(Color.rgb(138,43,226));
                            colors.add(Color.rgb(255, 1, 129));
                            colors.add(Color.rgb(50, 219, 240));

                            for(int i=0;i<30;i++){
                                Switch ballSwitch=new Switch(colors.get(i%4),new Coordinates(400,630-500*i));
                                switches.add(ballSwitch);
                                pane.getChildren().addAll(ballSwitch.getBall());
                            }





                        }
                    }

                }

            }.start();;










    }
}
