package cache;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.Tester;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TesterCache {

    private static final String CSV_FILE_PATH = "csv/testers.csv";
    private static TesterCache instance;

    private List<Tester> list;

    private TesterCache() {
        try {
            readCSV();
        } catch (IOException e) {
            e.printStackTrace();
            list = new ArrayList<>();
        } finally {
        }
    }

    private static TesterCache getInstance() {
        if(instance == null) {
            instance = new TesterCache();
        }
        return instance;
    }

    private void readCSV() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        CsvToBean<Tester> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Tester.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        list = csvToBean.parse();
    }

    public static int getCacheSize() {
        return getInstance().list.size();
    }

    public static List<String> getCountryList() {
        return getInstance().list.stream().map(t->t.getCountry()).distinct().collect(Collectors.toList());
    }
}
