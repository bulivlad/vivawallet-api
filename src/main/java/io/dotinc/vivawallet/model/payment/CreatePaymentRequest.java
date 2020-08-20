package io.dotinc.vivawallet.model.payment;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author vbulimac on 20/08/2020.
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePaymentRequest {

    /**
     * The username that initiated this action, used optionally for your own logging purposes.
     */
    String actionUser;

    /**
     * If this parameter is set to true, the payment form asks the cardholder to optionally accept recurring payments
     * from the merchant.
     */
    Boolean allowRecurring = false;

    /**
     * The requested amount in the currency's smallest unit of measurement. It must always be greater than 30
     * (which is the minimum amount you can charge with Viva Wallet).
     * For example, if you want to create a payment for €100.37, you need to pass the value "10037".
     */
    Integer amount;

    /**
     * This optional parameter adds a friendly description to the payment order that you want to display to the cardholder
     * on the payment form. It can either be your customer order code or a short description of items/services purchased.
     */
    String customerTrns;

    /**
     * If this parameter is set to true, the customer will not have the option to pay by card
     * (either credit, debit or prepaid), and the checkout page will not display the Card payment option.
     */
    Boolean disableCard = false;

    /**
     * If this parameter is set to true, the customer will not have the option to pay in cash at a Viva Spot, and the
     * checkout page will not display the Cash and E-Banking/Phone banking options.
     *
     * Even if this option is set and the E-Banking/Phone banking options will not be displayed, the customer will still
     * be able to make a payment from these channels if they know how to use the Viva Wallet Order Code from their
     * e-banking environment. In order for the Cash tab to be available, the PaymentTimeOut option should also be at
     * least one hour (3600).
     */
    Boolean disableCash = false;

    /**
     * If this parameter is set to true, the Order can accept any amount, irrespective of the RequestAmount option.
     * It will also allow multiple payments to be performed for the same Payment Order.
     */
    Boolean disableExactAmount;

    /**
     * If this parameter is set to true, the customer will not have the option to pay over the phone (IVR).
     */
    Boolean disableIVR = false;

    /**
     * If this parameter is set to true, the customer will not have the option to pay using the Pay@Home service.
     *
     * In order for the Pay@Home tab to be available the PaymentTimeOut option should also be at least two working days (172800).
     */
    Boolean disablePayAtHome;

    /**
     * The cardholder's e-mail address, used on the payment form.
     */
    String email;

    /**
     * Same as PaymentTimeOut but expressed in absolute datetime in ISO 8601 format. Note that if set, ExpirationDate
     * overrides the PaymentTimeOut option.
     */
    String expirationDate;

    /**
     * The cardholder's full name, used on the payment form.
     */
    String fullName;

    /**
     * If true, a PreAuth transaction will be performed. This will hold the selected amount as unavailable
     * (without the customer being charged) for a period of time.
     *
     * PreAuth transactions with a debit card or credit card hold the balance as unavailable either until the merchant
     * clears the transaction or the hold "falls off". In the case of debit cards, authorization holds can fall off the
     * account (thus rendering the balance available again) anywhere from 1–5 days after the transaction date depending
     * on the bank's policy; in the case of credit cards, holds may last as long as 30 days, depending on the issuing bank.
     */
    Boolean isPreAuth = false;

    /**
     * The maximum number of installments that the cardholder can choose for this transaction. If this parameter is
     * omitted, the cardholder will not see an option for selecting number of installments.
     *
     * Greece only.
     */
    Integer maxInstallments;

    /**
     * This can be either an ID or a short description that helps you uniquely identify the transaction. For example,
     * this can be your customer order reference number.
     */
    String merchantTrns;

    /**
     * By default, the time given to the cardholder to complete an online payment is 300 seconds (5 minutes). If the
     * cardholder does not complete the payment within this time frame, the Payment Order is automatically cancelled.
     * By using this parameter, you can define a different life span for your Payment Order.
     */
    Integer paymentTimeOut = 300;

    /**
     * The cardholder's telephone number, used on the payment form.
     */
    String phone;

    /**
     * The language in which the payment form is displayed. Consists of two-letter ISO 639-1 language code combined with
     * two-letter ISO 3166-1 alpha-2 country code. This parameter is also included in the target URL the application uses
     * to redirect the user after the successful/unsuccessful completion of a payment.
     *
     * If no parameter is passed, the system assumes el-GR. The payment form is currently displayed in the English
     * language for all values other than el-GR.
     */
    String requestLang;

    /**
     * If you wish to create a Payment Order without redirecting the customer to the payment page, use the value "4"
     * and the system will automatically send your customer an e-mail notification. This is equivalent to the Payment
     * Notification option from the merchant environment.
     */
    Integer serviceId;

    /**
     * Sources can be created and managed from the merchant's profile. A source is used for grouping and filtering
     * transactions (i.e. a merchant may have more than one website or different product categories).
     */
    String sourceCode;

    /**
     * You can add several tags to a transaction that will help in grouping and filtering from your merchant profile.
     */
    List<String> tags;



}
