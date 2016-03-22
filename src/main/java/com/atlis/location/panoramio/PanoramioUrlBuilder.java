/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlis.location.panoramio;

/**
 *
 * @author nf
 */
public class PanoramioUrlBuilder {

    private static final String PANORAMIO_PREFIX_URL = "http://www.panoramio.com/map/get_panoramas.php?";
    private static final String PANORAMIO_SET_URL_PARAMETER = "set=";
    private static final String PANORAMIO_FROM_URL_PARAMETER = "from=";
    private static final String PANORAMIO_TO_URL_PARAMETER = "to=";
    private static final String PANORAMIO_SIZE_URL_PARAMETER = "size=";//medium is the default
    private static final String PANORAMIO_MAPFILTER_URL_PARAMETER = "mapfilter=";//When the mapfilter parameter is set to true, photos are filtered such that they look better when they are placed on a map. It takes into account the location and tries to avoid of returning photos of the same location.
    private static final String PANORAMIO_ORDER_URL_PARAMETER = "order=";
    private static final String PANORAMIO_MINX_URL_PARAMETER = "minx=";
    private static final String PANORAMIO_MINY_URL_PARAMETER = "miny=";
    private static final String PANORAMIO_MAXX_URL_PARAMETER = "maxx=";
    private static final String PANORAMIO_MAXY_URL_PARAMETER = "maxy=";
    public static final String URL_PARAM_DELIMETER = "&";

    private String set;
    private String from;
    private String to;
    private String size;
    private String mapFilter;
    private String order;
    private String minx;
    private String miny;
    private String maxx;
    private String maxy;

    public PanoramioUrlBuilder() {
        set = "public";
        from = "0";
        to = "1";
        size = "medium";
        mapFilter = "true";
        order = "popularity";
    }

    public String getSet() {
        return PANORAMIO_SET_URL_PARAMETER + set;
    }

    public String getFrom() {
        return PANORAMIO_FROM_URL_PARAMETER + from;
    }

    public String getTo() {
        return PANORAMIO_TO_URL_PARAMETER + to;
    }

    public String getSize() {
        return PANORAMIO_SIZE_URL_PARAMETER + size;
    }

    public String getMapFilter() {
        return PANORAMIO_MAPFILTER_URL_PARAMETER + mapFilter;
    }

    public String getOrder() {
        return PANORAMIO_ORDER_URL_PARAMETER + order;
    }

    public String getMinx() {
        return PANORAMIO_MINX_URL_PARAMETER + minx;
    }

    public String getMiny() {
        return PANORAMIO_MINY_URL_PARAMETER + miny;
    }

    public String getMaxx() {
        return PANORAMIO_MAXX_URL_PARAMETER + maxx;
    }

    public String getMaxy() {
        return PANORAMIO_MAXY_URL_PARAMETER + maxy;
    }

    public PanoramioUrlBuilder setSet(String set) {
        this.set = set;
        return this;
    }

    public PanoramioUrlBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public PanoramioUrlBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public PanoramioUrlBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public PanoramioUrlBuilder setMapFilter(String mapFilter) {
        this.mapFilter = mapFilter;
        return this;
    }

    public PanoramioUrlBuilder setOrder(String order) {
        this.order = order;
        return this;
    }

    public PanoramioUrlBuilder setMinx(String minx) {
        this.minx = minx;
        return this;
    }

    public PanoramioUrlBuilder setMiny(String miny) {
        this.miny = miny;
        return this;
    }

    public PanoramioUrlBuilder setMaxx(String maxx) {
        this.maxx = maxx;
        return this;
    }

    public PanoramioUrlBuilder setMaxy(String maxy) {
        this.maxy = maxy;
        return this;
    }

    public String build() {

        return new StringBuilder(PANORAMIO_PREFIX_URL)
                .append(getOrder())
                .append(URL_PARAM_DELIMETER)
                .append(getSet())
                .append(URL_PARAM_DELIMETER)
                .append(getSize())
                .append(URL_PARAM_DELIMETER)
                .append(getMapFilter())
                .append(URL_PARAM_DELIMETER)
                .append(getFrom())
                .append(URL_PARAM_DELIMETER)
                .append(getTo())
                .append(URL_PARAM_DELIMETER)
                .append(getMinx())
                .append(URL_PARAM_DELIMETER)
                .append(getMiny())
                .append(URL_PARAM_DELIMETER)
                .append(getMaxx())
                .append(URL_PARAM_DELIMETER)
                .append(getMaxy())
                .toString();
    }

}
