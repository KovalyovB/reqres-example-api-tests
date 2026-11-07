package models.get_user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SuccessfulGetUserRequestModel(
        @JsonProperty("x-api-key") String xApiKey
) {}

