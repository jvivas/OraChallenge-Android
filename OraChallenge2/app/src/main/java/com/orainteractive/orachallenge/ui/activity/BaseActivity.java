package com.orainteractive.orachallenge.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;

import com.devspark.appmsg.AppMsg;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.orainteractive.orachallenge.R;

/**
 * Created by Jorge Vivas on 5/2/17.
 */

public class BaseActivity extends AppCompatActivity {

    private KProgressHUD mHud;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopProgressHud();
    }

    public void showErrorMessage(String message, int gravity) {
        if (message == null)
            message = getString(R.string.error_default);
        AppMsg appMsg = AppMsg.makeText(this, message, AppMsg.STYLE_ALERT);
        appMsg.setLayoutGravity(gravity);
        appMsg.show();
    }

    public void showSuccessMessage(String message, int gravity) {
        AppMsg appMsg = AppMsg.makeText(this, message, AppMsg.STYLE_INFO);
        appMsg.setLayoutGravity(gravity);
        appMsg.show();
    }

    public void showProgressHud() {
        mHud = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .show();
    }

    public void stopProgressHud() {
        if (mHud != null && mHud.isShowing())
            mHud.dismiss();
    }

    public boolean isEmailValid(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


}
