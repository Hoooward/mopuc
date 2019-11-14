package com.juzix.ai.mopuc.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.juzix.ai.mopuc.core.delegates.MopucDelegate;
import com.juzix.ai.mopuc.core.net.RestClient;
import com.juzix.ai.mopuc.core.net.callback.IError;
import com.juzix.ai.mopuc.core.net.callback.IFailure;
import com.juzix.ai.mopuc.core.net.callback.ISuccess;

public class ExampleDelegate extends MopucDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        this.testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
//                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(getContext(), "failure", Toast.LENGTH_LONG).show();

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_LONG).show();

                    }
                })
                .build()
                .get();

    }
}
