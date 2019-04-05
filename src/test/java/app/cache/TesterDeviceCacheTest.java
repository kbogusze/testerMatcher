package app.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesterDeviceCacheTest {

    @Test
    void getCacheSize() {
        assertTrue(TesterDeviceCache.getCacheSize()>0);
    }

    @Test
    void isCurrentlyHavingThisDevice() {
        assertTrue(TesterDeviceCache.isCurrentlyHavingThisDevice("1","1"));
    }
}