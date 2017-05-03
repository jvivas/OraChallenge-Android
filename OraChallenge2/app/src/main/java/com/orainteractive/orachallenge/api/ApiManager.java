package com.orainteractive.orachallenge.api;

import android.util.Log;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.orainteractive.orachallenge.OraApplication;

import java.util.List;
import java.util.Map;

/**
 * Created by Jorge Vivas on 5/2/17.
 */

public class ApiManager {

    public static final String KEY_DATA = "data";
    public static final String KEY_META = "meta";
    public static final String KEY_PAGINATION = "pagination";

    public void sendRequest(String url, JsonObject json, FutureCallback<JsonObject> callback) {
        Ion.with(OraApplication.getInstance().getContext())
                .load(url)
                .setJsonObjectBody(json)
                .asJsonObject()
                .setCallback(callback);
    }
}
