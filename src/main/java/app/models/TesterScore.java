package app.models;
import app.cache.DeviceCache;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class TesterScore {
    String firstName;

    String lastName;

    String country;

    String lastLogin;

    Long bugNoReported;

    String description;

    String nowHave;

    public TesterScore(Tester t) {
        this.firstName = t.getFirstName();
        this.lastName = t.getLastName();
        this.country = t.getCountry();
        this.lastLogin = t.getLastLogin();
        this.bugNoReported = Long.valueOf(0);
        this.description = "";
        this.nowHave = "";
    }

    public void putScore(Long occurance, String deviceId) {
        this.bugNoReported += occurance;
        Optional<Device> deviceByID = DeviceCache.getDeviceByID(deviceId);
        if(deviceByID.isPresent()) {
            StringBuilder str
                    = new StringBuilder(this.description);
            str.append(occurance + " bugs found using " + deviceByID.get().getDescription() + "\n");
            this.description = str.toString();
        }
    }


    public void addDevice(String description) {
        StringBuilder str
                = new StringBuilder(this.nowHave);
        str.append(description + "\n");
        this.nowHave = str.toString();
    }
}
