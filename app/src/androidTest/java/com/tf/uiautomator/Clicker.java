package com.tf.uiautomator;

/**
 * Created by kamran on 30/11/16.
 */

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class Clicker {

    @Test
    public void clickOnItem() throws UiObjectNotFoundException, InterruptedException {
        if (InstrumentationRegistry.getArguments().containsKey("text")) {
            UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                    .findObject(new UiSelector()
                            .text(InstrumentationRegistry.getArguments().getString("text")))
                    .click();
        }
    }
}
