package io.dotinc.vivawallet.command;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.auth.BearerTokenRequest;
import io.dotinc.vivawallet.model.auth.BearerTokenResponse;

import java.io.IOException;

/**
 * @author vbulimac on 21/08/2020.
 */
public interface Card extends Command {

    String apiBase = "https://demo-api.vivapayments.com/acquiring/v1/cards";

    <T> T execute(String apiKeyBase64) throws IOException, VivaWalletException;

    default String path(String path, Object ... args){
        return String.format("%s%s", apiBase, String.format(path, args));
    }

    default String authHeaderFromToken(BearerTokenRequest bearerTokenRequest) throws IOException, VivaWalletException {
        BearerTokenResponse response = MinimalistClient.authorize(BearerTokenResponse.class, "POST", "https://demo-accounts.vivapayments.com/connect/token", bearerTokenRequest);
        return "Bearer " + response.getAccess_token();
    }

}
