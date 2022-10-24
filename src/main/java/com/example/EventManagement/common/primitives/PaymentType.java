package com.example.EventManagement.common.primitives;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.Objects;

/**
 * Participant Payment type domain primitive.
 */
@EqualsAndHashCode
@ToString
public final class PaymentType {
    public enum PaymentEnums {
        CASH("cash"),
        TRANSFER("transfer");

        public final String type;

        PaymentEnums(String type) {
            this.type = type;
        }
    }

    private final @NonNull String paymentType;
    private @NonNull boolean validPaymentType = false;

    public PaymentType(@NonNull String paymentType) {

        for(PaymentEnums payment : PaymentEnums.values()) {
            if (Objects.equals(payment.type, paymentType)) {
                validPaymentType = true;
                break;
            }
        }

        if (!validPaymentType) {
            throw new IllegalArgumentException("Payment type not chosen!");
        }

        this.paymentType = paymentType;
    }

    public String value() {
        return paymentType;
    }
}
