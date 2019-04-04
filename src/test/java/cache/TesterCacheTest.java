package cache;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TesterCacheTest {

    @Test
    void getCacheSize() {
        assertTrue(TesterCache.getCacheSize()>0);
    }

    @Test
    void getCountryList() {
        assertTrue(TesterCache.getCountryList().contains("JP"));
    }

    @Test
    void getAllTesters() {
        assertTrue(TesterCache.getAllTesters().size() == TesterCache.getCacheSize());
    }

    @Test
    void getTestersByCountry() {
        List<String> countryList = Arrays.asList("JP" , "GB");
        assertTrue(!TesterCache.getTestersByCountry(countryList).isEmpty());
    }
}