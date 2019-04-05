package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static Boolean isSplashLoaded = false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/mainmenu.fxml") );
        Parent root = fxmlLoader.load();
        Image applicationIcon = new Image(this.getClass().getResource("/img/favicon.png").toString());
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
