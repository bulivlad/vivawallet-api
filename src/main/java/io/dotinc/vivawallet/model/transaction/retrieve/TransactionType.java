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
public class TransactionType {

    /**
     * The transaction type name.
     */
    String name;

    /**
     * The unique ID of the transaction type.
     */
    String transactionTypeId;

}
