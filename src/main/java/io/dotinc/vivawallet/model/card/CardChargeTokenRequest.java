package io.dotinc.vivawallet.model.card;

import io.dotinc.vivawallet.enums.CardChargeTokenAction;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author vbulimac on 21/08/2020.
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardChargeTokenRequest {

    String cardToken;

    String chargeToken;

    CardChargeTokenAction action;

}
