package cache;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.TesterDevice;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TesterDeviceCache {
    private static final String CSV_FILE_PATH = "csv/tester_device.csv";
    private static TesterDeviceCache instance;

    private List<TesterDevice> list;

    private TesterDeviceCache() {
        try {
            readCSV();
        } catch (IOException e) {
            e.printStackTrace();
            list = new ArrayList<>();
        } finally {
        }
    }

    private static TesterDeviceCache getInstance() {
        if(instance == null) {
            instance = new TesterDeviceCache();
        }
        return instance;
    }

    private void readCSV() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        CsvToBean<TesterDevice> csvToBean = new CsvToBeanBuilder(reader)
                .withType(TesterDevice.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        list = csvToBean.parse();
    }

    public static int getCacheSize() {
        return getInstance().list.size();
    }
}
