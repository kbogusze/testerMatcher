package cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesterCacheTest {

    @Test
    void getCacheSize() {
        assertTrue(TesterCache.getCacheSize()>0);
    }
}