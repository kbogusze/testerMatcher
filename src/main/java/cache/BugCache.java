package cache;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.Bug;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BugCache {

    private static final String CSV_FILE_PATH = "/csv/bugs.csv";
    private static BugCache instance;

    private List<Bug> list;

    private BugCache() {
        try {
            readCSV();
        } catch (IOException e) {
            e.printStackTrace();
            list = new ArrayList<>();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            list = new ArrayList<>();
        }
    }

    private static BugCache getInstance() {
        if(instance == null) {
            instance = new BugCache();
        }
        return instance;
    }

    private void readCSV() throws IOException, URISyntaxException {
         Reader reader = Files.newBufferedReader(Paths.get(getClass().getResource(CSV_FILE_PATH).toURI()));
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
