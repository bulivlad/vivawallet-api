package io.dotinc.vivawallet.command;

import io.dotinc.vivawallet.exception.VivaWalletException;

import java.io.IOException;

/**
 * @author vbulimac on 20/08/2020.
 */
public interface Native extends Command {
    String apiBase = "https://demo-api.vivapayments.com";

    <T> T execute(String key) throws IOException, VivaWalletException;

    default String path(String path, Object ... args){
        return String.format("%s%s", apiBase, String.format(path, args));
    }
}
