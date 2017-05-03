package com.orainteractive.orachallenge.model;

import com.google.gson.JsonObject;

/**
 * Created by Jorge Vivas on 5/3/17.
 */

public class UserModel {

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    private int id;
    private String name;
    private String email;

    public UserModel(JsonObject json) {
        if (json.has(KEY_ID))
            this.id = json.get(KEY_ID).getAsInt();
        if (json.has(KEY_NAME))
            this.name = json.get(KEY_NAME).getAsString();
        if (json.has(KEY_EMAIL))
            this.email = json.get(KEY_EMAIL).getAsString();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
