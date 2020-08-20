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
public class NativeTransactionCustomerRequest {

    String email;
    String phone;
    String fullName;
    String requestLang;
    String countryCode;
}
