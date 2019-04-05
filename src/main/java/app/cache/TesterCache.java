package app.cache;

import app.models.Tester;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class TesterCache {

    private static final String CSV_FILE_PATH = "/csv/testers.csv";
    private static TesterCache instance;

    private List<Tester> list;

    private TesterCache() {
        readCSV();
    }

    private static TesterCache getInstance() {
        if(instance == null) {
            instance = new TesterCache();
        }
        return instance;
    }

    private void readCSV()  {
        Reader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream(CSV_FILE_PATH)));
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

    public static List<Tester> getAllTesters() {
        return getInstance().list;
    }

    public static List<Tester> getTestersByCountry(List<String> countryList) {
        return getInstance().list.stream()
                .filter(t -> t.getCountry()!=null && countryList.contains(t.getCountry()))
                .collect(Collectors.toList());
    }
}
