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
        return MinimalistClient.call(CardChargeTokenResponse.class, "GET", path("/chargetokens?token=%s", cardChargeTokenRequest.getCardToken()), null, apiKeyBase64);
    }

}
