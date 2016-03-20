package com.atlis.panoramio.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.atlis.location.model.MapRegion;
import com.atlis.location.panoramio.PanoramioAPI;
import com.atlis.location.panoramio.model.impl.PanoramioImage;
import com.atlis.location.panoramio.model.impl.PanoramioImages;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michaelassraf
 */
public class PanoramioAPIUnitTest {

    @Test
    public void testPanoramioAPIUnitTest() {
        Double latitude = 40.7470;
        Double longitude = -73.9860;
        Double radius = 5.0;
        MapRegion mapRegion = new MapRegion().buildMapRegion(latitude, longitude, radius);
        PanoramioImages panoramioImages = PanoramioAPI.with().getImagesForLocation(Arrays.asList(mapRegion));
        List<PanoramioImage> images = panoramioImages.getPhotos();
        assertNotNull("Can't fetch images at all", images);
    }
}
