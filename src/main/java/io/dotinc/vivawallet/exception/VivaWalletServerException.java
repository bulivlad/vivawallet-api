package io.dotinc.vivawallet.exception;

/**
 * @author vbulimac on 20/08/2020.
 */

public class VivaWalletServerException extends VivaWalletException {
    public VivaWalletServerException(String responseMessage, int responseCode) {
        super(responseMessage, responseCode);
    }
}
