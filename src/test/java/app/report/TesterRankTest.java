package app.report;

import app.cache.DeviceCache;
import app.cache.TesterCache;
import app.models.Device;
import app.models.Tester;
import app.models.TesterScore;
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