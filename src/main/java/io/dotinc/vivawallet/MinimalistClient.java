package io.dotinc.vivawallet;

import com.google.gson.Gson;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.exception.VivaWalletForbiddenException;
import io.dotinc.vivawallet.exception.VivaWalletServerException;
import io.dotinc.vivawallet.exception.VivaWalletUnauthorizedException;
import io.dotinc.vivawallet.model.auth.BearerTokenRequest;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;

/**
 * @author vbulimac on 20/08/2020.
 */
public class MinimalistClient {
    public static <T, D> T call(Class<T> cls, String method, String url, D data, String base64EncodedApiKey) throws IOException, VivaWalletException {
        Gson gson = new Gson();
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");
        if(base64EncodedApiKey != null){
            con.setRequestProperty("authorization", base64EncodedApiKey);
        }

        if(data != null){
            String payload = gson.toJson(data);
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(payload);
            wr.flush();
            wr.close();
        }

        int responseCode = con.getResponseCode();
        if(responseCode >= 400 && responseCode <= 500){
            if(responseCode == 401){
                throw new VivaWalletUnauthorizedException(con.getResponseMessage(), responseCode);
            }
            if(responseCode == 403){
                throw new VivaWalletForbiddenException(con.getResponseMessage(), responseCode);
            }
            throw new VivaWalletException(con.getResponseMessage(), responseCode);
        }
        if(responseCode >= 500){
            throw new VivaWalletServerException(con.getResponseMessage(), responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        if(cls.equals(Void.class)){
            return null;
        }

        return new Gson().fromJson(response.toString(), cls);
    }

    public static <T> T authorize(Class<T> cls, String method, String url, BearerTokenRequest data) throws IOException, VivaWalletException {
        String basicKey = "Basic " + new String(Base64.getEncoder().encode((data.getClientId() + ":" + data.getClientSecret()).getBytes()));
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "multipart/form-data");
        con.setRequestProperty("Authorization", basicKey);


        String payload = "grant_type=client_credentials";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(payload);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        if(responseCode >= 400 && responseCode <= 500){
            if(responseCode == 401){
                throw new VivaWalletUnauthorizedException(con.getResponseMessage(), responseCode);
            }
            if(responseCode == 403){
                throw new VivaWalletForbiddenException(con.getResponseMessage(), responseCode);
            }
            throw new VivaWalletException(con.getResponseMessage(), responseCode);
        }
        if(responseCode >= 500){
            throw new VivaWalletServerException(con.getResponseMessage(), responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        if(cls.equals(Void.class)){
            return null;
        }

        return new Gson().fromJson(response.toString(), cls);
    }
}
