package com.orainteractive.orachallenge.model;

import java.util.List;

/**
 * Created by Jorge Vivas on 5/3/17.
 */

public class ChatMessageListModel {

    private List<ChatMessageModel> chatMessages;
    private PaginationModel pagination;

    public ChatMessageListModel(List<ChatMessageModel> chatMessages, PaginationModel pagination) {
        this.chatMessages = chatMessages;
        this.pagination = pagination;
    }

    public List<ChatMessageModel> getChatMessages() {
        return chatMessages;
    }

    public PaginationModel getPagination() {
        return pagination;
    }
}
