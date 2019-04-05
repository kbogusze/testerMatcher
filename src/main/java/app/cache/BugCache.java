package app.cache;

import app.models.Bug;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

public class BugCache {

    private static final String CSV_FILE_PATH = "/csv/bugs.csv";
    private static BugCache instance;

    private List<Bug> list;

    private BugCache() {
        readCSV();
    }

    private static BugCache getInstance() {
        if(instance == null) {
            instance = new BugCache();
        }
        return instance;
    }

    private void readCSV()  {
        Reader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream(CSV_FILE_PATH)));
         CsvToBean<Bug> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Bug.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
         list = csvToBean.parse();
    }

    public static int getCacheSize() {
        return getInstance().list.size();
    }

    public static Optional<Bug> findAnyByBugId(String id) {
        return getInstance().list.stream().filter(p ->p.getBugId()!=null && p.getBugId().equals(id)).findAny();
    }

    public static long findOccurenceByDeviceIDAndTesterID(String deviceId, String testerId) {
        return getInstance().list.stream()
                .filter(p -> p.getDeviceId()!=null && p.getDeviceId().equals(deviceId)
                    && p.getTesterId()!=null && p.getTesterId().equals(testerId)).count();
    }

}
