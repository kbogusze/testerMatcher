package models;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Device {
    @CsvBindByName
    String deviceId;
    @CsvBindByName
    String description;
}
