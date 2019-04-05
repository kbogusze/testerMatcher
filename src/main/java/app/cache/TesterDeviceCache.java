package app.cache;

import app.models.TesterDevice;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class TesterDeviceCache {
    private static final String CSV_FILE_PATH = "/csv/tester_device.csv";
    private static TesterDeviceCache instance;

    private List<TesterDevice> list;

    private TesterDeviceCache() {
        readCSV();
    }

    private static TesterDeviceCache getInstance() {
        if(instance == null) {
            instance = new TesterDeviceCache();
        }
        return instance;
    }

    private void readCSV(){
        Reader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream(CSV_FILE_PATH)));
        CsvToBean<TesterDevice> csvToBean = new CsvToBeanBuilder(reader)
                .withType(TesterDevice.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        list = csvToBean.parse();
    }

    public static int getCacheSize() {
        return getInstance().list.size();
    }

    public static boolean isCurrentlyHavingThisDevice(String testerId, String deviceId)
    {
        return getInstance().list.stream().filter(t->t.getTesterId().equals(testerId) && t.getDeviceId().equals(deviceId)).findAny().isPresent();
    }
}
