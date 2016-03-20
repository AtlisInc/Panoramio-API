/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlis.location.panoramio.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author michaelassraf
 */
public abstract class PanoramioAbs {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
