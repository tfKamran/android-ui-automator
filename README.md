# android-ui-automator
An application that can emulate clicks on a device in any other application

## Build

    ./gradlew assembleDebugAndroidTest

## Install

    adb install -r app/build/outputs/apk/app-debug-androidTest.apk 

## Click

    adb shell am startservice -a com.tf.uiautomator.ACTION_CLICK_ITEM -e itemText "OK"
