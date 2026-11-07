package models.update_user;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SuccessfulUpdateUserDataResponseModel(
        String name,
        String job,
        Instant updatedAt,
        Support support,
        @JsonProperty("_meta") Meta meta
) {

    public record Support(
            String url,
            String text,
            @JsonProperty("sponsored_by") String sponsoredBy
    ) {
    }

    public record Meta(
            @JsonProperty("powered_by") String poweredBy,
            @JsonProperty("docs_url") String docsUrl,
            @JsonProperty("upgrade_url") String upgradeUrl,
            @JsonProperty("example_url") String exampleUrl,
            String variant,
            String message,
            Cta cta,
            String context
    ) {
    }

    public record Cta(
            String label,
            String url
    ) {
    }
}