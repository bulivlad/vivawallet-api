package io.dotinc.vivawallet.model.card;

import com.google.gson.annotations.SerializedName;
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
public class CardChargeTokenResponse {

    String chargeToken;
    
    @SerializedName("token")
    String cardToken;

}
