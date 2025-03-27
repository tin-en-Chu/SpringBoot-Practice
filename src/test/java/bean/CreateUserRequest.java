package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String name;
    private String job;
    private static CreateUserRequest req = new CreateUserRequest();

    public static CreateUserRequest of(String name, String job) {
        req.name = name;
        req.job = job;
        return req;
    }
}
