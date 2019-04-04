package cache;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.Device;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeviceCache {

    private static final String CSV_FILE_PATH = "csv/devices.csv";
    private static DeviceCache instance;

    private List<Device> list;

    private DeviceCache() {
        try {
            readCSV();
        } catch (IOException e) {
            e.printStackTrace();
            list = new ArrayList<>();
        } finally {
        }
    }

    private static DeviceCache getInstance() {
        if(instance == null) {
            instance = new DeviceCache();
        }
        return instance;
    }

    private void readCSV() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        CsvToBean<Device> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Device.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        list = csvToBean.parse();
    }

    public static int getCacheSize() {
        return getInstance().list.size();
    }
}
