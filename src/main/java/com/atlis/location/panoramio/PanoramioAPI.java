/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlis.location.panoramio;

import com.atlis.location.model.Address;
import com.atlis.location.utils.LocationUtils;
import com.atlis.location.model.BoundingBox;
import com.atlis.location.model.MapRegion;
import com.atlis.location.panoramio.model.impl.PanoramioImages;
import com.atlis.location.utils.PanoramioUrlBuilder;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author nf
 */
public class PanoramioAPI {

    Logger logger = Logger.getLogger(PanoramioAPI.class.getSimpleName());

    Gson gson = new Gson();

    LocationUtils locationUtils = new LocationUtils();

    public static PanoramioAPI with() {
        return new PanoramioAPI();
    }

    public PanoramioImages getImagesForLocation(List<MapRegion> methodParameter, Address address) {
        try {
            return getPanoramioResponse(methodParameter);
        } catch (Throwable th) {
            logger.error("can't get panoramio images from: " + methodParameter, th);
            return null;
        }
    }

    private PanoramioImages getPanoramioResponse(List<MapRegion> mapRegions) throws IOException {
        PanoramioImages panoramioImages;
        Iterator<MapRegion> it = mapRegions.iterator();
        do {
            String responseStr = getPanoramioImages(it.next());
            panoramioImages = gson.fromJson(responseStr, PanoramioImages.class);
        } while (Boolean.valueOf(panoramioImages.getHas_more()).equals(Boolean.FALSE) && it.hasNext());

        return panoramioImages;
    }

    private String getPanoramioImages(MapRegion mapRegion) throws MalformedURLException, IOException {

        BoundingBox boundingBox = locationUtils.getBoundingBox(mapRegion);

        logger.debug("Bounding box of " + mapRegion.getRadius() + ". " + boundingBox);

        String panoramioUrl = new PanoramioUrlBuilder()
                .setMinx(boundingBox.getMinPoint().getLongitude().toString())
                .setMiny(boundingBox.getMinPoint().getLatitude().toString())
                .setMaxx(boundingBox.getMaxPoint().getLongitude().toString())
                .setMaxy(boundingBox.getMaxPoint().getLatitude().toString())
                .build();

        logger.debug("Panoramio Url " + panoramioUrl);
        URL url = new URL(panoramioUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        String response;

        try {
            if (httpURLConnection.getInputStream() == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            response = stringBuilder.toString();
        } catch (Throwable th) {
            logger.error("Something happened while reading from input stream from panoramio.", th);
            return null;
        }

        logger.debug("Panoramio  response " + response);
        return response;
    }
}
