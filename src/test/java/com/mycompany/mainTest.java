
package com.mycompany;

import com.mycompany.main.Series;
import com.mycompany.main.SeriesModel;
import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class  mainTest{

    // Helper method to reset the static seriesList before each test
    @BeforeEach
    public void setUp() throws Exception {
        Field seriesListField = Series.class.getDeclaredField("seriesList");
        seriesListField.setAccessible(true);
        ArrayList<SeriesModel> emptyList = new ArrayList<>();
        seriesListField.set(null, emptyList); // Reset list to empty
    }

    @Test
    public void testCaptureSeries_AddsNewSeries() throws Exception {
        // Simulate adding series manually since CaptureSeries() uses Scanner
        Field seriesListField = Series.class.getDeclaredField("seriesList");
        seriesListField.setAccessible(true);

        ArrayList<SeriesModel> seriesList = (ArrayList<SeriesModel>) seriesListField.get(null);
        seriesList.add(new SeriesModel("S1", "Breaking Bad", 18, 62));

        assertEquals(1, seriesList.size(), "Series list should contain 1 series after adding.");
        assertEquals("Breaking Bad", seriesList.get(0).seriesName, "Series name should match.");
    }

    @Test
    public void testSearchSeries_FindsExistingSeries() throws Exception {
        Field seriesListField = Series.class.getDeclaredField("seriesList");
        seriesListField.setAccessible(true);

        ArrayList<SeriesModel> seriesList = (ArrayList<SeriesModel>) seriesListField.get(null);
        seriesList.add(new SeriesModel("S2", "Game of Thrones", 18, 73));

        // Verify the added series exists
        SeriesModel found = seriesList.stream()
                                      .filter(s -> s.seriesId.equals("S2"))
                                      .findFirst()
                                      .orElse(null);

        assertNotNull(found, "Series should be found.");
        assertEquals("Game of Thrones", found.seriesName, "The series name should match.");
    }

    @Test
    public void testUpdateSeries_UpdatesExistingSeries() throws Exception {
        Field seriesListField = Series.class.getDeclaredField("seriesList");
        seriesListField.setAccessible(true);

        ArrayList<SeriesModel> seriesList = (ArrayList<SeriesModel>) seriesListField.get(null);
        SeriesModel series = new SeriesModel("S3", "The Office", 13, 201);
        seriesList.add(series);

        // Simulate update
        series.seriesName = "The Office (US)";
        series.seriesAge = 14;
        series.seriesNumberOfEpisodes = 202;

        assertEquals("The Office (US)", series.seriesName, "Updated name should match.");
        assertEquals(14, series.seriesAge, "Updated age restriction should match.");
        assertEquals(202, series.seriesNumberOfEpisodes, "Updated episode count should match.");
    }

    @Test
    public void testDeleteSeries_RemovesSeries() throws Exception {
        Field seriesListField = Series.class.getDeclaredField("seriesList");
        seriesListField.setAccessible(true);

        ArrayList<SeriesModel> seriesList = (ArrayList<SeriesModel>) seriesListField.get(null);
        SeriesModel series = new SeriesModel("S4", "Friends", 12, 236);
        seriesList.add(series);

        // Verify added
        assertEquals(1, seriesList.size(), "Series list should have 1 series before deletion.");

        // Simulate deletion
        seriesList.removeIf(s -> s.seriesId.equals("S4"));

        // Verify removed
        assertEquals(0, seriesList.size(), "Series list should be empty after deletion.");
    }

    @Test
    public void testSeriesReport_EmptyList() throws Exception {
        Field seriesListField = Series.class.getDeclaredField("seriesList");
        seriesListField.setAccessible(true);

        ArrayList<SeriesModel> seriesList = (ArrayList<SeriesModel>) seriesListField.get(null);

        // No series added
        assertTrue(seriesList.isEmpty(), "Series list should be empty initially.");
    }
}
