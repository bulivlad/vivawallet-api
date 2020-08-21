package io.dotinc.vivawallet;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.exception.VivaWalletForbiddenException;
import io.dotinc.vivawallet.exception.VivaWalletServerException;
import io.dotinc.vivawallet.exception.VivaWalletUnauthorizedException;
import io.dotinc.vivawallet.model.auth.BearerTokenRequest;
import okhttp3.*;

import java.io.IOException;
import java.util.Base64;

/**
 * @author vbulimac on 20/08/2020.
 */
public class MinimalistClient {
    public static <T, D> T call(Class<T> cls, String method, String url, D data, String base64EncodedApiKey) throws IOException, VivaWalletException {
        Gson gson = new Gson();

        OkHttpClient client = new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", base64EncodedApiKey)
                .url(url);

        if(data != null){
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), gson.toJson(data));
            requestBuilder.method(method, requestBody);
        } else {
            requestBuilder.method(method, null);
        }

        Response response = client.newCall(requestBuilder.build()).execute();

        int responseCode = response.code();
        String body = response.body().string();
        if(responseCode >= 400 && responseCode <= 500){
            if(responseCode == 401){
                throw new VivaWalletUnauthorizedException(body, responseCode);
            }
            if(responseCode == 403){
                throw new VivaWalletForbiddenException(body, responseCode);
            }
            throw new VivaWalletException(body, responseCode);
        }
        if(responseCode >= 500){
            throw new VivaWalletServerException(body, responseCode);
        }

        T responseBody = new Gson().fromJson(body, cls);
        if(responseBody == null) {
            return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create().fromJson(body, cls);
        }

        return responseBody;
    }

    public static <T> T authorize(Class<T> cls, String method, String url, BearerTokenRequest data) throws IOException, VivaWalletException {
        String basicKey = "Basic " + new String(Base64.getEncoder().encode((data.getClientId() + ":" + data.getClientSecret()).getBytes()));

        OkHttpClient client = new OkHttpClient();
        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("grant_type", "client_credentials")
                .build();
        Request request = new Request.Builder()
                .url("https://demo-accounts.vivapayments.com/connect/token")
                .method("POST", body)
                .addHeader("Authorization", basicKey)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        Response response = client.newCall(request).execute();


        int responseCode = response.code();
        String responseBody = response.body().string();
        if(responseCode >= 400 && responseCode <= 500){
            if(responseCode == 401){
                throw new VivaWalletUnauthorizedException(responseBody, responseCode);
            }
            if(responseCode == 403){
                throw new VivaWalletForbiddenException(responseBody, responseCode);
            }
            throw new VivaWalletException(responseBody, responseCode);
        }
        if(responseCode >= 500){
            throw new VivaWalletServerException(responseBody, responseCode);
        }

        return new Gson().fromJson(responseBody, cls);
    }
}
