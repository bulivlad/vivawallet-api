package io.dotinc.vivawallet.model.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author vbulimac on 20/08/2020.
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BearerTokenResponse {
    String access_token;
    Integer expires_in;
    String token_type;
    String scope;
}
