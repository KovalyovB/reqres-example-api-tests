package api;

public class ApiClient {

    public final GetUsersApiClient getUsers = new GetUsersApiClient();
    public final CreateUserApiClient makeUsers = new CreateUserApiClient();
    public final UpdateUserApiClient updateUsers = new UpdateUserApiClient();

}
