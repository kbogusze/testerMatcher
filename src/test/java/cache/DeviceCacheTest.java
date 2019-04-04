package cache;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void getAllDevice() {
        assertTrue(DeviceCache.getCacheSize()==DeviceCache.getAllDevice().size());
    }

    @Test
    void getDevicesByDeviceDescription() {
        List<String> list = Arrays.asList("iPhone 4" , "iPhone 4S");
        assertTrue(DeviceCache.getDevicesByDeviceDescription(list).size()==2);
    }
}