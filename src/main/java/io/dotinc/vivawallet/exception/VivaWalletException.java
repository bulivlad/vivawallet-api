package io.dotinc.vivawallet.exception;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * @author vbulimac on 20/08/2020.
 */

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VivaWalletException extends Exception {
    String responseMessage;
    int responseCode;

    public VivaWalletException(String responseMessage, int responseCode) {
        super(responseMessage);
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
    }
}

