package models;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tester {
    @CsvBindByName
    String testerId;
    @CsvBindByName
    String firstName;
    @CsvBindByName
    String lastName;
    @CsvBindByName
    String country;
    @CsvBindByName
    String lastLogin;

}
