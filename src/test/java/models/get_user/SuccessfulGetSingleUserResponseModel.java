package models.get_user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SuccessfulGetSingleUserResponseModel(
        User data,
        Support support,
        @JsonProperty("_meta") Meta meta
) {

    public record User(
            int id,
            String email,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") String lastName,
            String avatar
    ) {
    }

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