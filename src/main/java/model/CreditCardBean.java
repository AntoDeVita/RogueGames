package model;

public class CreditCardBean {
    private String EmailUT;
    private String cif;
    private String CVV;
    private String Scadenza;

    public CreditCardBean() {
    }

    public CreditCardBean(String EmailUT, String cif, String CVV, String Scadenza) {
        this.EmailUT = EmailUT;
        this.cif = cif;
        this.CVV = CVV;
        this.Scadenza = Scadenza;
    }

    public String getEmailUT() {
        return EmailUT;
    }

    public void setEmailUT(String EmailUT) {
        this.EmailUT = EmailUT;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getScadenza() {
        return Scadenza;
    }

    public void setScadenza(String Scadenza) {
        this.Scadenza = Scadenza;
    }
}

