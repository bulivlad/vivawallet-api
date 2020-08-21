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
public class Payment {

    String channelId;

    /**
     * The customer’s email address.
     */
    String email;

    /**
     * The customer’s full name.
     */
    String fullName;

    /**
     * Defines the number of installments for the payment. [1..36]
     */
    Integer installments;

    /**
     * The customer’s phone number.
     */
    String phone;
    Boolean recurringSupport;

}
