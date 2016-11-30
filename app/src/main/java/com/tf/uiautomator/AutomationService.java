package com.tf.uiautomator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

public class AutomationService extends Service {

    private static final String ACTION_CLICK_ITEM = "com.tf.uiautomator.ACTION_CLICK_ITEM";
    private static final String EXTRA_ITEM_TEXT = "itemText";

    public AutomationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (ACTION_CLICK_ITEM.equals(intent.getAction())) {
            try {
                ShellScriptHelper.executeShell("am instrument -w -r   -e text " + intent.getStringExtra(EXTRA_ITEM_TEXT) + " -e debug false -e class com.tf.uiautomator.Clicker com.tf.uiautomator.test/android.support.test.runner.AndroidJUnitRunner");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
