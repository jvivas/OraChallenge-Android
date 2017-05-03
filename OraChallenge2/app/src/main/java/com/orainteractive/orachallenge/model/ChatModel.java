package com.orainteractive.orachallenge.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge Vivas on 5/3/17.
 */

public class ChatModel {

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LAST_MESSAGE = "last_chat_message";
    private static final String KEY_USERS = "users";

    private int id;
    private String name;
    private ChatMessageModel lastMessage;
    private List<UserModel> users;


    public ChatModel(JsonObject json) {
        if (json.has(KEY_ID))
            this.id = json.get(KEY_ID).getAsInt();
        if (json.has(KEY_NAME))
            this.name = json.get(KEY_NAME).getAsString();
        if (json.has(KEY_LAST_MESSAGE))
            this.lastMessage = new ChatMessageModel(json.get(KEY_LAST_MESSAGE).getAsJsonObject());
        if (json.has(KEY_USERS)) {
            users = new ArrayList<>();
            JsonArray jsonArray = json.get(KEY_USERS).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                UserModel userModel = new UserModel(jsonElement.getAsJsonObject());
                users.add(userModel);
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ChatMessageModel getLastMessage() {
        return lastMessage;
    }

    public List<UserModel> getUsers() {
        return users;
    }
}
