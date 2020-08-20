package io.dotinc.vivawallet.command;

import io.dotinc.vivawallet.exception.VivaWalletException;

import java.io.IOException;

/**
 * @author vbulimac on 20/08/2020.
 */
public interface Payment extends Command {
    String apiBase = "https://demo.vivapayments.com/api/orders";

    <T> T execute(String apiKeyBase64) throws IOException, VivaWalletException;

    default String path(String path, Object ... args){
        return String.format("%s%s", apiBase, String.format(path, args));
    }
}
