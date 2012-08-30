/*
 * Copyright (C) 2012 p000ison
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-NoDerivs 3.0 Unported License. To view a copy of
 * this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/ or send
 * a letter to Creative Commons, 171 Second Street, Suite 300, San Francisco,
 * California, 94105, USA.
 */

package com.p000ison.dev.simpleclans2.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Collection;

/**
 * Represents a JSONUtil
 */
public class JSONUtil {

    public static String collectionToJSON(String key, Collection collection)
    {
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();

        array.addAll(collection);
        json.put(key, array);

        return json.toJSONString();
    }
}
