package io.dotinc.vivawallet.model.transaction.retrieve;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author vbulimac on 21/08/2020.
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditCard {

    /**
     * The name of the card owner.
     */
    String cardHolderName;

    /**
     * A descriptive name of the bank that issued the card.
     */
    String cardIssuingBank;

    /**
     * The type of the card.
     */
    CardType cardType;

    /**
     * The card's origin country in ISO 3166-1 alpha-2.
     */
    String countryCode;

    /**
     * The number of the card that was used.
     */
    String number;

    /**
     * The token that is generated based on the details of the card.
     */
    String token;

}
