package models.create_user;

public record SuccessfulCreateUserRequestModel(
        String email,
        String password
) {
}
