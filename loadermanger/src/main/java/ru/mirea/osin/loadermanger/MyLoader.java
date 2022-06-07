package ru.mirea.osin.loadermanger;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyLoader extends AsyncTaskLoader<String> {
    private String firstName;
    private String newString;
    public static final String ARG_WORD = "word";
    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            firstName = args.getString(ARG_WORD);
        newString = shuffleString(firstName);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public String loadInBackground() {
        // emulate long-running operation
        SystemClock.sleep(5000);
        return newString;
    }
    public static String shuffleString(String string)
    {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return shuffled;
    }
}