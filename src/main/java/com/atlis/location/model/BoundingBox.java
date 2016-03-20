/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlis.location.model;

import com.atlis.location.panoramio.model.PanoramioAbs;

/**
 *
 * @author nf
 */
public class BoundingBox  extends PanoramioAbs{

    MapPoint minPoint;
    MapPoint maxPoint;

    public BoundingBox(MapPoint minPoint, MapPoint maxPoint) {
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    public MapPoint getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(MapPoint minPoint) {
        this.minPoint = minPoint;
    }

    public MapPoint getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(MapPoint maxPoint) {
        this.maxPoint = maxPoint;
    }

}
