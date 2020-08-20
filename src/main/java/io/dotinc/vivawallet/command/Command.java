package io.dotinc.vivawallet.command;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.auth.BearerTokenRequest;
import io.dotinc.vivawallet.model.auth.BearerTokenResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vbulimac on 20/08/2020.
 */
public interface Command {
    String apiBase = "https://demo.vivapayments.com/api/orders";

    default<T> List<T> jsonArrayToTypedList(Class<T> cls, JsonArray arr){
        Gson g = new Gson();
        ArrayList<T> result = new ArrayList<>();
        for(JsonElement elemen : arr){
            result.add(g.fromJson(elemen, cls));
        }
        return result;
    }

    default String authHeaderFromToken(BearerTokenRequest bearerTokenRequest) throws IOException, VivaWalletException {
        BearerTokenResponse response = MinimalistClient.authorize(BearerTokenResponse.class, "POST", "/connect/token", bearerTokenRequest);
        return "Bearer " + response.getAccess_token();
    }

    default String path(String path, Object ... args){
        return String.format("%s%s", apiBase, String.format(path, args));
    }
}
