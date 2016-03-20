/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlis.location.panoramio.model.impl;

import com.atlis.location.panoramio.model.PanoramioAbs;

/**
 *
 * @author nf
 */
public class PanoramioMapLocation extends PanoramioAbs {

    String lat;
    String lon;
    String panoramio_zoom;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getPanoramio_zoom() {
        return panoramio_zoom;
    }

    public void setPanoramio_zoom(String panoramio_zoom) {
        this.panoramio_zoom = panoramio_zoom;
    }

}
