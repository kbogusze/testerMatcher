package app.models;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bug {
    @CsvBindByName
    String bugId;
    @CsvBindByName
    String deviceId;
    @CsvBindByName
    String testerId;

}
