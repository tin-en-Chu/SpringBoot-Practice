package com.example.demo;

import bean.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void testGetForSingleData() {

        ResponseEntity<GetUserResponse> resEntity = restTemplate.getForEntity(
                "https://reqres.in/api/users/1",
                GetUserResponse.class
        );

        // 確認 HTTP 狀態碼
        assertEquals(HttpStatus.OK, resEntity.getStatusCode());

        // 確認 response header
        assertNotNull(resEntity.getHeaders().getContentType());
        assertEquals("application/json;charset=utf-8", resEntity.getHeaders().getContentType().toString());

        // 確認 response body
        GetUserResponse resBody = resEntity.getBody();
        assertNotNull(resBody);

        UserResponse data = resBody.getData();
        assertEquals("1", data.getId());
        assertEquals("george.bluth@reqres.in", data.getEmail());
        assertEquals("George", data.getFirstName());
        assertEquals("Bluth", data.getLastName());
        assertEquals("https://reqres.in/img/faces/1-image.jpg", data.getAvatar());
    }



    @Test
    public void testPostData() {
        CreateUserRequest createReq = CreateUserRequest.of("morpheus", "leader");
        CreateUserResponse createRes = restTemplate.postForObject(
                "https://reqres.in/api/users",
                createReq,
                CreateUserResponse.class
        );

        assertNotNull(createRes);
        assertEquals("morpheus", createRes.getName());
        assertEquals("leader", createRes.getJob());



    }

    @Test
    public void testGetForMultipleData() {
        GetUserListResponse res = restTemplate.getForObject(
                "https://reqres.in/api/users?page={page}&per_page={per_page}",
                GetUserListResponse.class,
                Map.of("page", 2, "per_page", 6)
        );
        assertNotNull(res);

        List<UserResponse> users = res.getData();
        assertEquals(6, users.size());
        assertEquals("7", users.get(0).getId());
        assertEquals("8", users.get(1).getId());
        assertEquals("9", users.get(2).getId());
        assertEquals("10", users.get(3).getId());
        assertEquals("11", users.get(4).getId());
        assertEquals("12", users.get(5).getId());
    }

}
