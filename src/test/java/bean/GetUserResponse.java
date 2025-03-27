package bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserResponse {
    private UserResponse data;
}
