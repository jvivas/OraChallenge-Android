package com.orainteractive.orachallenge.model;

import com.google.gson.JsonObject;

/**
 * Created by Jorge Vivas on 5/3/17.
 */

public class ChatMessageModel {

    private static final String KEY_ID = "id";
    private static final String KEY_CHAT_ID = "chat_id";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_USER = "user";

    private int id;
    private int chatId;
    private int userId;
    private String message;
    private String createdAt;
    private UserModel user;

    public ChatMessageModel(JsonObject json) {
        if (json.has(KEY_ID))
            this.id = json.get(KEY_ID).getAsInt();
        if (json.has(KEY_CHAT_ID))
            this.chatId = json.get(KEY_CHAT_ID).getAsInt();
        if (json.has(KEY_USER_ID))
            this.userId = json.get(KEY_USER_ID).getAsInt();
        if (json.has(KEY_MESSAGE))
            this.message = json.get(KEY_MESSAGE).getAsString();
        if (json.has(KEY_CREATED_AT))
            this.createdAt = json.get(KEY_CREATED_AT).getAsString();
        if (json.has(KEY_USER)) {
            this.user = new UserModel(json.get(KEY_USER).getAsJsonObject());
        }
    }

    public int getId() {
        return id;
    }

    public int getChatId() {
        return chatId;
    }

    public int getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public UserModel getUser() {
        return user;
    }
}
