/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlis.location.panoramio.model.impl;

import com.atlis.location.panoramio.model.PanoramioAbs;
import java.util.List;

/**
 *
 * @author nf
 */
public class PanoramioImages extends PanoramioAbs {

    String count;
    String has_more;
    PanoramioMapLocation map_location;
    List<PanoramioImage> photos;

    public String getHas_more() {
        return has_more;
    }

    public void setHas_more(String has_more) {
        this.has_more = has_more;
    }

    public PanoramioMapLocation getMap_location() {
        return map_location;
    }

    public void setMap_location(PanoramioMapLocation map_location) {
        this.map_location = map_location;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<PanoramioImage> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PanoramioImage> photos) {
        this.photos = photos;
    }

}
