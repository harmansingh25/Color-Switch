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
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
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
import javafx.scene.control.*;
import javafx.fxml.FXML;
import sample.Main;

import java.io.IOException;
import java.util.*;





public class Controller {

    @FXML
    Button button,play,resumeG,end;
    @FXML   //for highScore
    ImageView yellow1 ,yellow2, white1 ,white2;
    @FXML //for totalStars
    ImageView red1 ,red2, white11 ,white12;
    @FXML
    Button pause;  // PLaygame
    @FXML
    Button resumeBack;
    ImageView round1,round2,round3,round4;
    @FXML
    Button emm; //pause
     @FXML
    ImageView r1,r2,r3,r4;
    @FXML //help
    Button helpB;


    public void toHighScore(ActionEvent event)throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("highScore.fxml"));


        Node node6 = root.lookup("#yellow1");
        RotateTransition rw = new RotateTransition(Duration.millis(1000), node6);
        rw.setByAngle(360);
        rw.setCycleCount(Animation.INDEFINITE);
        rw.setInterpolator(Interpolator.LINEAR);
        rw.play();



        Node node7 = root.lookup("#yellow2");
        RotateTransition rw1 = new RotateTransition(Duration.millis(1000), node7);
        rw1.setByAngle(-360);
        rw1.setCycleCount(Animation.INDEFINITE);
        rw1.setInterpolator(Interpolator.LINEAR);
        rw1.play();



        Node node8 = root.lookup("#white1");
        ScaleTransition st = new ScaleTransition(Duration.seconds(0.66), node8);
        st.setToX(0);
        st.setToY(0);
        st.setCycleCount(Animation.INDEFINITE);
        st.setInterpolator(Interpolator.LINEAR);
        st.setAutoReverse(true);
        st.play();




        Node node9 = root.lookup("#white2");
        ScaleTransition st1 = new ScaleTransition(Duration.seconds(0.66), node9);
        st1.setToX(0);
        st1.setToY(0);
        st1.setCycleCount(Animation.INDEFINITE);
        st1.setInterpolator(Interpolator.LINEAR);
        st1.setAutoReverse(true);
        st1.play();


        Scene scene = new Scene(root);

        Text highText=(Text) root.lookup("#highS");
        highText.setText(Long.toString(Main.getHighScore()));

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    public void toTotalStars(ActionEvent event)throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("totalStars.fxml"));
        Node node6 = root.lookup("#white11");
        TranslateTransition translate3 = new TranslateTransition();
        translate3.setByY(210);
        translate3.setDuration(Duration.millis(1000));
        translate3.setCycleCount(500);
        translate3.setAutoReverse(true);
        translate3.setNode(node6);
        translate3.play();



        Node node7 = root.lookup("#red2");
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(380);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(500);
        translate.setAutoReverse(true);
        translate.setNode(node7);
        translate.play();



        Node node8 = root.lookup("#red1");
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setByX(-390);
        translate1.setDuration(Duration.millis(1000));
        translate1.setCycleCount(Animation.INDEFINITE);
        translate1.setAutoReverse(true);
        translate1.setNode(node8);
        translate1.play();




        Node node9 = root.lookup("#white12");
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setByY(-210);
        translate2.setDuration(Duration.millis(1000));
        translate2.setCycleCount(Animation.INDEFINITE);
        translate2.setAutoReverse(true);
        translate2.setNode(node9);
        translate2.play();






        Scene scene = new Scene(root);

        Text highText=(Text) root.lookup("#totalStar");
        highText.setText(Long.toString(Main.getTotalStars()));

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


    public void toPlayGame(ActionEvent event)throws Exception{

//        Parent root = FXMLLoader.load(getClass().getResource("playGame.fxml"));
//
//        Circle c1=new Circle();
//        Arc a1=c1.makeArc(100.0f,100.0f,Color.YELLOW,90.0f,90.0f);
//        Arc a2=c1.makeArc(80.0f,80.0f,Color.YELLOW,90.0f,90.0f);
//        Arc b1=c1.makeArc(100.0f,100.0f,Color.GREEN,180.0f,90.0f);
//        Arc b2=c1.makeArc(80.0f,80.0f,Color.GREEN,180.0f,90.0f);
//        Arc cc1=c1.makeArc(100.0f,100.0f,Color.BLUE,270.0f,90.0f);
//        Arc cc2=c1.makeArc(80.0f,80.0f,Color.BLUE,270.0f,90.0f);
//        Arc d1=c1.makeArc(100.0f,100.0f,Color.PINK,0.0f,90.0f);
//        Arc d2=c1.makeArc(80.0f,80.0f,Color.PINK,0.0f,90.0f);
//
//        Shape s1=c1.makeArcRing(a1,a2,Color.rgb(250, 225, 0));
//        Shape s2=c1.makeArcRing(b1,b2,Color.rgb(138,43,226));
//        Shape s3=c1.makeArcRing(cc1,cc2,Color.rgb(255, 1, 129));
//        Shape s4=c1.makeArcRing(d1,d2,Color.rgb(50, 219, 240));
//
//
//
//        Group ring1=c1.makeRing(s1,s2,s3,s4);
//
//
//
//        StackPane st=new StackPane();
//
//        st.getChildren().addAll(root,ring1);
//
//        Scene scene = new Scene(st);
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(scene);
//        window.show();



        Test test=new Test(new Main());

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        test.start(window);





    }

    public void toResumeMenu(ActionEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resume.fxml"));

        String s="round";
        for(int i=0;i<4;i++){
           String jj=s+Integer.toString(i+1);
           Node node=root.lookup("#"+jj);
           FadeTransition fade=new FadeTransition();
           fade.setDuration(Duration.millis(1000));
            fade.setFromValue(10);
            fade.setToValue(0.1);
            fade.setCycleCount(Animation.INDEFINITE);
            fade.setAutoReverse(true);
            fade.setNode(node);
            fade.play();

        }

        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();


    }
    public void toPauseMenu(ActionEvent event)throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("pause.fxml"));
        String s="r";
        for(int i=0;i<4;i++){
            String jj=s+Integer.toString(i+1);
            Node node=root.lookup("#"+jj);
            if((i+1)<=2) {
                FadeTransition fade = new FadeTransition();
                fade.setDuration(Duration.millis(1000));
                fade.setFromValue(10);
                fade.setToValue(0.1);
                fade.setCycleCount(Animation.INDEFINITE);
                fade.setAutoReverse(true);
                fade.setNode(node);
                fade.play();
            }
            else{
                ScaleTransition st = new ScaleTransition(Duration.seconds(0.66), node);
                st.setToX(0);
                st.setToY(0);
                st.setCycleCount(Animation.INDEFINITE);
                st.setInterpolator(Interpolator.LINEAR);
                st.setAutoReverse(true);
                st.play();


            }

        }
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();


    }
    public void toHelpMenu(ActionEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();




    }
    public void endGame(ActionEvent event)throws IOException {
        Testing.serialize(Main.getHighScore(),Main.getTotalStars());

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();

    }
    public  void toMainMenu(ActionEvent event)throws Exception {

//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        Scene scene = new Scene(root);
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(scene);
//        window.show();
        Scene scene;
        Main n=new Main();
        scene=n.MainScene();

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();


    }

    public void resetScore(ActionEvent e)throws Exception{

        Main.setHighScore(0);

    }

    public void saved0(ActionEvent event)throws Exception{

        Test ff=Testing.deserialize1(0);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ff.playSaved(ff,window);
    }
    public void saved1(ActionEvent event)throws Exception{

        Test ff=Testing.deserialize1(1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ff.playSaved(ff,window);
    }
    public void saved2(ActionEvent event)throws Exception{

        Test ff=Testing.deserialize1(2);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ff.playSaved(ff,window);
    }
    public void saved3(ActionEvent event)throws Exception{

        Test ff=Testing.deserialize1(3);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ff.playSaved(ff,window);
    }
}
