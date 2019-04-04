package report;

import cache.DeviceCache;
import cache.TesterCache;
import models.Device;
import models.Tester;
import models.TesterScore;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TesterRankTest {

    @Test
    void makeTesterReport() {
        List<TesterScore> testerScores = TesterRank.makeTestersReport(TesterCache.getAllTesters(), DeviceCache.getAllDevice());
        assertTrue(testerScores.size()>0);
    }

    @Test
    void makeTesterResumeFor() {
        List<Tester> t = TesterCache.getAllTesters();
        List<Device> d = DeviceCache.getAllDevice();
        TesterScore testerScore = TesterRank.makeTesterResume(t.get(0), d);
        assertTrue(testerScore != null);
        assertTrue(testerScore.getBugNoReported() >= 0);
    }
}