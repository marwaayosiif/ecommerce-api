package gov.iti.jets.services.dto.error;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NotFoundErrorMessage {
    private String errorMessage;
    private String errorDescription;
    private int errorCode;

    public NotFoundErrorMessage( String errorMessage, String errorDescription, int errorCode ) {
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
        this.errorCode = errorCode;
    }

    public NotFoundErrorMessage() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage( String errorMessage ) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription( String errorDescription ) {
        this.errorDescription = errorDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode( int errorCode ) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "NotFoundErrorMessage{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
