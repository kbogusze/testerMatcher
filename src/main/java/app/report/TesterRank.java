package app.report;

import app.cache.BugCache;
import app.cache.TesterDeviceCache;
import app.models.Device;
import app.models.Tester;
import app.models.TesterScore;

import java.util.ArrayList;
import java.util.List;

public class TesterRank {

    public static List<TesterScore> makeTestersReport(List<Tester> testerList, List<Device> devices){
        List<TesterScore> result = new ArrayList<>();
        for(Tester t : testerList)
        {
            result.add(makeTesterResume(t,devices));
        }
        result.sort((o1, o2) -> o2.getBugNoReported().compareTo(o1.getBugNoReported()));
        return result;
    }

    public static TesterScore makeTesterResume(Tester t, List<Device> devices) {
        TesterScore result = new TesterScore(t);
        for(Device d : devices)
        {
            Long occurance = BugCache.findOccurenceByDeviceIDAndTesterID(d.getDeviceId(), t.getTesterId());
            result.putScore(occurance, d.getDeviceId());
            if(TesterDeviceCache.isCurrentlyHavingThisDevice(t.getTesterId(),d.getDeviceId()))
                result.addDevice(d.getDescription());
        }
        return result;
    }

}
