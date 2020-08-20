package io.dotinc.vivawallet.model.checkout;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author vbulimac on 20/08/2020.
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NativeTransactionRequest {

    Integer amount;
    Boolean preauth;
    String sourceCode;
    String chargeToken;
    Integer installments;
    String merchantTrns;
    String customerTrns;
    Integer currencyCode;
    NativeTransactionCustomerRequest customer;


}
