package com.rapido.globalservice.localization;

public class LanguageDetectionResponse {

    private String selectedLanguage;

    public LanguageDetectionResponse() {
    }

    public LanguageDetectionResponse(
            String selectedLanguage
    ) {
        this.selectedLanguage =
                selectedLanguage;
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(
            String selectedLanguage
    ) {
        this.selectedLanguage =
                selectedLanguage;
    }
}