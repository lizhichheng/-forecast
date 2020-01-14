package com.example.lastest;

public interface HttpCallbackListener {
    void OnFinish(String response);
    void OnError(Exception e);
}
