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
public class RetrieveTransactionRequest {

    String transactionId;
    String orderCode;

    /**
     * Date format yyyy-MM-dd
     */
    String date;

    /**
     * Date format yyyy-MM-dd
     */
    String clearanceDate;
    String sourcecode;

}
