package sample;

import javafx.stage.Stage;

import java.io.*;

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


public class Testing {



    public static void serialize(long highScore, long totalStars)throws IOException{
        Main m=new Main();
        m.setSerialHS(highScore);
        m.setSerialTS(totalStars);


        ObjectOutputStream out = null;
        try {
             out = new ObjectOutputStream (
                     new FileOutputStream("out.txt"));
             out.writeObject(m);
             } finally {
             out.close();
             }

    }

    public static Main deserialize()throws IOException,ClassNotFoundException{
        ObjectInputStream in=null;

        Main s1=new Main();

        try{
            in=new ObjectInputStream(
                    new FileInputStream("out.txt"));
            s1= (Main) in.readObject();


        }

        finally{
            in.close();
        }

        return s1;
    }

    public static void serialize1(Test test,int no)throws IOException{

        System.out.println(test.score);



        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream (
                    new FileOutputStream("out"+Integer.toString(no)+".txt"));
            out.writeObject(test);
        } finally {
            out.close();
        }

    }

    public static Test deserialize1(int no)throws IOException,ClassNotFoundException{
        ObjectInputStream in=null;



        try{
            in=new ObjectInputStream(
                    new FileInputStream("out"+Integer.toString(no)+".txt"));
            Test s1= (Test) in.readObject();

            return s1;




        }

        finally{
            in.close();
        }


    }



    public static void main(String[] args)throws IOException,ClassNotFoundException{
      serialize(10,10);
        //serialize1(new Test(new Main()));
       // deserialize1();

    }
}
