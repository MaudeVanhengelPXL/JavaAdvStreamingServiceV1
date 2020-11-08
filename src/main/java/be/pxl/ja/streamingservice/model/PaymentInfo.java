package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.InvalidDateException;

import java.time.LocalDate;
import java.time.Period;

public class PaymentInfo {
    private String firstname;
    private String lastname;
    private CreditCardNumber cardNumber;
    private LocalDate expirationDate;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public CreditCardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CreditCardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (Period.between(LocalDate.now(), expirationDate).getMonths() < 0) {
            throw new InvalidDateException(expirationDate, "expiration date", "Must be valid for at least 1 month.");
        }
    }
}
