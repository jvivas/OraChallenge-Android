package com.orainteractive.orachallenge.api.listener;

import com.orainteractive.orachallenge.model.UserModel;

/**
 * Created by Jorge Vivas on 5/3/17.
 */

public interface AuthListener {
    void onLoginResponse(String errorMessage, UserModel userModel);
}
