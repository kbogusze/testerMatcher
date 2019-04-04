package cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceCacheTest {

    @Test
    void getCacheSize() {
        assertTrue(DeviceCache.getCacheSize()>0);
    }

    @Test
    void getDeviceList() {
        assertTrue(DeviceCache.getDeviceList().contains("iPhone 4"));
    }
}