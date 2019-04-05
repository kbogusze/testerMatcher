package fxcontrollers;

import app.Launcher;
import cache.DeviceCache;
import cache.TesterCache;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import models.Device;
import models.Tester;
import models.TesterScore;
import org.controlsfx.control.CheckComboBox;
import report.TesterRank;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class Controller {
    @FXML
    private StackPane Root_StackPane;
    @FXML
    private CheckComboBox<String> CountrysBox;

    @FXML
    private CheckComboBox<String> DevicesBox;

    @FXML
    private TableView<TesterScore> ResultTable;

    @FXML
    public void initialize() {
        if(!Launcher.isSplashLoaded)
            loadSplashScreen();

        CountrysBox.getItems().addAll(TesterCache.getCountryList());
        DevicesBox.getItems().addAll(DeviceCache.getDeviceList());

        initalizeTable();
        makeTesterRank();
    }

    private void initalizeTable() {
        Field[] allFields = TesterScore.class.getDeclaredFields();
        List<Field> privateFields = Arrays.asList(allFields);
        ResourceBundle bundle = ResourceBundle.getBundle("language.UIResources",new Locale("en"));

        for(Field te : privateFields){
            TableColumn<TesterScore, String> column = new TableColumn<>(bundle.getString(te.getName()));
            column.setCellValueFactory(new PropertyValueFactory<>(te.getName()));
            column.prefWidthProperty().bind(ResultTable.widthProperty().divide(privateFields.size()));
            ResultTable.getColumns().add(column);
        }
    }

    @FXML
    void searchButtonClick(ActionEvent event) {
        makeTesterRank();
    }

    private void makeTesterRank() {
        ResultTable.setItems(FXCollections.observableList(TesterRank.makeTestersReport(filterTesters(),filterDevices())));
    }

    private List<Tester> filterTesters(){
        List<Tester> testers;
        if (CountrysBox.getCheckModel().getCheckedItems().size()>0)
            testers = TesterCache.getTestersByCountry(CountrysBox.getCheckModel().getCheckedItems());
        else
            testers = TesterCache.getAllTesters();
        return testers;
    }

    private List<Device> filterDevices(){
        List<Device> devices;
        if (DevicesBox.getCheckModel().getCheckedItems().size()>0)
            devices = DeviceCache.getDevicesByDeviceDescription(DevicesBox.getCheckModel().getCheckedItems());
        else
            devices = DeviceCache.getAllDevice();
        return devices;
    }

    public void loadSplashScreen() {
        try {
            Launcher.isSplashLoaded = true;

            StackPane pane = FXMLLoader.load(getClass().getResource("/fxml/splash.fxml"));
            Root_StackPane.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0.15);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e) -> {
                    try {
                        StackPane parentContent = FXMLLoader.load(getClass().getResource("/fxml/mainmenu.fxml"));
                        Root_StackPane.getChildren().setAll(parentContent);
                    } catch (IOException ex) {
                        java.util.logging.Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
            });
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}



