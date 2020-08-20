package io.dotinc.vivawallet.exception;

/**
 * @author vbulimac on 20/08/2020.
 */

public class VivaWalletForbiddenException extends VivaWalletException {
    public VivaWalletForbiddenException(String responseMessage, int responseCode) {
        super(responseMessage, responseCode);
    }
}
