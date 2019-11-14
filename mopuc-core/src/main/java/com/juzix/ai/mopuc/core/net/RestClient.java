package com.juzix.ai.mopuc.core.net;

import android.content.Context;

import com.juzix.ai.mopuc.core.net.callback.IError;
import com.juzix.ai.mopuc.core.net.callback.IFailure;
import com.juzix.ai.mopuc.core.net.callback.IRequest;
import com.juzix.ai.mopuc.core.net.callback.ISuccess;
import com.juzix.ai.mopuc.core.net.callback.RequestCallbacks;
import com.juzix.ai.mopuc.core.ui.LoaderStyle;
import com.juzix.ai.mopuc.core.ui.MopucLoader;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class RestClient {

    private final String URL;
    private final Map<String, Object> PARAMS;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final Context CONTEXT;


    public RestClient(String URL, Map<String, Object> PARAMS,
                      IRequest REQUEST, ISuccess SUCCESS, IFailure FAILURE,
                      IError ERROR, RequestBody BODY,
                      LoaderStyle loaderStyle, Context context
    ) {
        this.URL = URL;
        this.PARAMS = PARAMS;
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
        this.FAILURE = FAILURE;
        this.ERROR = ERROR;
        this.BODY = BODY;
        this.LOADER_STYLE = loaderStyle;
        this.CONTEXT = context;

    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();

        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        if (LOADER_STYLE != null) {
            MopucLoader.showLoading(CONTEXT, LOADER_STYLE);
        }

        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(REQUEST, SUCCESS, FAILURE, ERROR, LOADER_STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

}
