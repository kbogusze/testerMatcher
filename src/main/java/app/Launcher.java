package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Launcher extends Application {

    public static Boolean isSplashLoaded = false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = new File("src/main/resources/fxml/mainmenu.fxml").toURL();
        Parent root = FXMLLoader.load(url);
        URL imageUrl = new File("src/main/resources/img/favicon.png").toURL();
        Image applicationIcon = new Image(imageUrl.toString());
        primaryStage.getIcons().add(applicationIcon);
        primaryStage.setTitle("Tester Matcher");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
