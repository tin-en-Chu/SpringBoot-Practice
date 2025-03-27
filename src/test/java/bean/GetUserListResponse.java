package bean;

import lombok.Data;

import java.util.List;
@Data
public class GetUserListResponse {
    private List<UserResponse> data;
}
