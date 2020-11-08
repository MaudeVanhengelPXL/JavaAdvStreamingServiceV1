package be.pxl.ja.streamingservice.model;

public class CreditCardNumber {
    private static final int LENGTH = 16;
    private static final int CVC_LENGTH = 3;

    private CreditCardType type;
    private String number;
    private String cvc;

    public CreditCardNumber(String number, String cvc) {
        number = removeBlanks(number);
        if (!isNumeric(number) || number.length() != LENGTH) {
            throw new IllegalArgumentException("A card number must have " + LENGTH + " digits.");
        }
        if (!isNumeric(cvc) || cvc.length() != CVC_LENGTH) {
            throw new IllegalArgumentException("A cvc number mush have " + CVC_LENGTH + " digits.");
        }
        this.type = getCreditCardType(number);
        if (this.type == null) {
            throw new IllegalArgumentException("This is not a valid creditcard");
        }
        this.cvc = cvc;
    }
    private String removeBlanks(String number) {
        return number.replaceAll("\\s+", "");
    }
    private boolean isNumeric(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }
        try {
            Long.parseLong(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public CreditCardType getCreditCardType(String number) {
        for (CreditCardType cardType : CreditCardType.values()) {
            if (cardType.getFirstNumber() == Integer.parseInt(number.substring(0, 1))) {
                return cardType;
            }
        }
        return null;
    }

    public CreditCardType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String getCvc() {
        return cvc;
    }
}
