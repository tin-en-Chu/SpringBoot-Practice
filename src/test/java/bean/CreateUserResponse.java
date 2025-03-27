package bean;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CreateUserResponse {
    private String id;
    private String name;
    private String job;
    private ZonedDateTime createdAt;
}