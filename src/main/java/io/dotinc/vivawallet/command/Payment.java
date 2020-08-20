package io.dotinc.vivawallet.command;

import io.dotinc.vivawallet.exception.VivaWalletException;

import java.io.IOException;

/**
 * @author vbulimac on 20/08/2020.
 */
public interface Payment extends Command {
    <T> T execute(String key) throws IOException, VivaWalletException;
}
