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
public class CardType {

    /**
     * Enum: "0" "1" "2" "3" "4" "5" "6" "7" "8"
     * The ID of the type of the card.
     */
    Integer cardTypeId;

    /**
     * Enum:
     * "Visa"
     * "Mastercard"
     * "Diners"
     * "Amex"
     * "Invalid"
     * "Unknown"
     * "Maestro"
     * "Discover"
     * "JCB"
     *
     * The name of the type of the card.
     */
    String name;

}
