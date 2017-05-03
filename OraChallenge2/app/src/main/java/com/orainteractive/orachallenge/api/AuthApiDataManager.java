package com.orainteractive.orachallenge.api;

import android.util.Log;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.orainteractive.orachallenge.OraApplication;
import com.orainteractive.orachallenge.PreferencesManager;
import com.orainteractive.orachallenge.api.listener.AuthListener;
import com.orainteractive.orachallenge.model.UserModel;

import java.net.Authenticator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Jorge Vivas on 5/3/17.
 */

public class AuthApiDataManager extends ApiManager {

    private AuthListener mAuthListener;

    public AuthApiDataManager(AuthListener authListener) {
        mAuthListener = authListener;
    }

    public void requestLogin(String email, String password) {
//        Map<String, List<String>> params = new HashMap<String, List<String>>();
//        params.put("email", Collections.singletonList(email));
//        params.put("password", Collections.singletonList(password));

        JsonObject json = new JsonObject();
        json.addProperty("email", email);
        json.addProperty("password", password);

        Log.d("OraChallenge", "Request " + Constants.URL_LOGIN);

        sendRequest(Constants.URL_LOGIN, json, new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                Log.d("OraChallenge", "Response " + result);
                if (result != null && result.has(KEY_DATA)) {
                    UserModel userModel = new UserModel(result.get(KEY_DATA).getAsJsonObject());
                    PreferencesManager.setUserId(userModel.getId());
                    mAuthListener.onLoginResponse(null, userModel);
                } else {
                    mAuthListener.onLoginResponse(e.getLocalizedMessage(), null);
                }
            }
        });

//        Ion.with(OraApplication.getInstance().getContext())
//                .load(Constants.URL_LOGIN)
//                .setJsonObjectBody(json)
//                .asJsonObject()
//                .setCallback(new FutureCallback<JsonObject>() {
//                    @Override
//                    public void onCompleted(Exception e, JsonObject result) {
//                        Log.d("OraChallenge", "Response " + result);
//                    }
//                });

//        sendRequest(Constants.URL_LOGIN, params, new FutureCallback<JsonObject>() {
//            @Override
//            public void onCompleted(Exception e, JsonObject result) {
//                if (result != null && result.has(KEY_DATA)) {
//                    UserModel userModel = new UserModel(result.get(KEY_DATA).getAsJsonObject());
//                    PreferencesManager.setUserId(userModel.getId());
//                    mAuthListener.onLoginResponse(null, userModel);
//                } else {
//                    mAuthListener.onLoginResponse(e.getLocalizedMessage(), null);
//                }
//            }
//        });
    }
}
