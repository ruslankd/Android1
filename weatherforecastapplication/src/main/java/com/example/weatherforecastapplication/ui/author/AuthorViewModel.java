package com.example.weatherforecastapplication.ui.author;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AuthorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AuthorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Author: Vasya");
    }

    public LiveData<String> getText() {
        return mText;
    }
}