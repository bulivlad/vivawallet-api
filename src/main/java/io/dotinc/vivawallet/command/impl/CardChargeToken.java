package io.dotinc.vivawallet.command.impl;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.command.Card;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.card.CardChargeTokenRequest;
import io.dotinc.vivawallet.model.card.CardChargeTokenResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.IOException;

/**
 * @author vbulimac on 21/08/2020.
 */

@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardChargeToken implements Card {

    CardChargeTokenRequest cardChargeTokenRequest;

    @Override
    public CardChargeTokenResponse execute(String apiKeyBase64) throws IOException, VivaWalletException {
        switch (cardChargeTokenRequest.getAction()) {
            case RETRIEVE_CARD_FOR_CHARGE_TOKEN:
                return retrieveCardToken(apiKeyBase64);
            case RETRIEVE_CHARGE_TOKEN_FOR_CARD:
                return retrieveChargeToken(apiKeyBase64);
        }
        throw new IllegalArgumentException("Invalid action " + cardChargeTokenRequest.getAction());
    }

    private CardChargeTokenResponse retrieveCardToken(String apiKeyBase64) throws IOException, VivaWalletException {
        return MinimalistClient.call(CardChargeTokenResponse.class, "GET", path("/tokens?chargetoken=%s", cardChargeTokenRequest.getChargeToken()), null, apiKeyBase64);
    }

    private CardChargeTokenResponse retrieveChargeToken(String apiKeyBase64) throws IOException, VivaWalletException {
        return MinimalistClient.call(CardChargeTokenResponse.class, "GET", path("/chargetokens?token=%s", cardChargeTokenRequest.getCardToken()), null, apiKeyBase64);
    }

}
