package models.create_user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SuccessfulCreateUserResponseModel(
        Integer id,
        String token,
        Support support,
        @JsonProperty("_meta") Meta meta
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public record Support(
            String url,
            String text,
            String sponsoredBy
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public record Meta(
            String poweredBy,
            String docsUrl,
            String upgradeUrl,
            String exampleUrl,
            String variant,
            String message,
            Cta cta,
            String context,
            boolean persisted,
            String persistence
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Cta(
            String label,
            String url
    ) {
    }
}