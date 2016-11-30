package com.tf.uiautomator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by kamran on 30/11/16.
 */

public class ShellScriptHelper {

    public static String executeShell(String command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("su");

        DataOutputStream os = new DataOutputStream(process.getOutputStream());
        os.writeBytes(command);
        os.writeBytes("\nexit\n");

        os.flush();
        os.close();
        process.waitFor();

        return inputStreamToString(process.getInputStream());
    }

    public static String inputStreamToString(InputStream stream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        String read;

        while ((read = bufferedReader.readLine()) != null) {
            stringBuilder.append(read);
        }

        bufferedReader.close();
        return stringBuilder.toString();
    }
}