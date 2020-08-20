package io.dotinc.vivawallet.exception;

/**
 * @author vbulimac on 20/08/2020.
 */

public class VivaWalletUnauthorizedException extends VivaWalletException {
    public VivaWalletUnauthorizedException(String responseMessage, int responseCode) {
        super(responseMessage, responseCode);
    }
}
