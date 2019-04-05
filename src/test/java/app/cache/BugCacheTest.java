package app.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BugCacheTest {

    @Test
    void initCacheTest() {
        assertTrue(BugCache.getCacheSize()>0);
    }

    @Test
    void findByBugId() {
        assertTrue(BugCache.findAnyByBugId("1").isPresent());
    }
}