package fxcontrollers;

import cache.DeviceCache;
import cache.TesterCache;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.controlsfx.control.CheckComboBox;

public class Controller {

    @FXML
    private CheckComboBox<String> CountrysBox;

    @FXML
    private CheckComboBox<String> DevicesBox;

    @FXML
    private TableView<?> ResultTable;

    @FXML
    public void initialize() {
        CountrysBox.getItems().addAll(TesterCache.getCountryList());
        DevicesBox.getItems().addAll(DeviceCache.getDeviceList());
    }

    @FXML
    void searchButtonClick(ActionEvent event) {

    }

}



