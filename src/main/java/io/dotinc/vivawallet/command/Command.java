package io.dotinc.vivawallet.command;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.auth.BasicAuth;
import io.dotinc.vivawallet.model.auth.BearerTokenRequest;
import io.dotinc.vivawallet.model.auth.BearerTokenResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author vbulimac on 20/08/2020.
 */
public interface Command {

    default<T> List<T> jsonArrayToTypedList(Class<T> cls, JsonArray arr){
        Gson g = new Gson();
        ArrayList<T> result = new ArrayList<>();
        for(JsonElement elemen : arr){
            result.add(g.fromJson(elemen, cls));
        }
        return result;
    }

}
