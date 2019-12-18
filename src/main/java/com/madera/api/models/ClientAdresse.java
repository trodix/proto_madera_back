package com.madera.api.models;

/**
 * DTO ClientAdresse
 *
 * @author LADOUCE Fabien, CHEVALLIER Romain, HELIOT David
 * @version 0.2-PRE-RELEASE
 */
public class ClientAdresse {

    Integer clientId;

    Integer adresseId;

    Boolean adresseFacturation;

    public ClientAdresse() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(Integer adresseId) {
        this.adresseId = adresseId;
    }

    public Boolean getAdresseFacturation() {
        return adresseFacturation;
    }

    public void setAdresseFacturation(Boolean adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }
}