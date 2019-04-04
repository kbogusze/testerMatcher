package cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesterDeviceCacheTest {

    @Test
    void getCacheSize() {
        assertTrue(TesterDeviceCache.getCacheSize()>0);
    }
}