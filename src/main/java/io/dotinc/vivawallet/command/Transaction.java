package io.dotinc.vivawallet.command;

import io.dotinc.vivawallet.enums.TransactionAction;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.auth.BasicAuth;

import java.io.IOException;
import java.util.Base64;

/**
 * @author vbulimac on 21/08/2020.
 */
public interface Transaction extends Command {
    String apiBase = "https://demo.vivapayments.com/api/orders";

    <T> T execute(String apiKeyBase64, TransactionAction transactionAction) throws IOException, VivaWalletException;

    default String path(String path, Object ... args){
        return String.format("%s%s", apiBase, String.format(path, args));
    }

    default String authHeaderFromApiKey(BasicAuth basicAuth) {
        return "Basic " + new String(Base64.getEncoder().encode((basicAuth.getMerchantId() + ":" + basicAuth.getApiKey()).getBytes()));
    }
}
