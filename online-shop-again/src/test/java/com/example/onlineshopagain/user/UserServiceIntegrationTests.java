package com.example.onlineshopagain.user;

import com.example.onlineshopagain.domain.User;
import com.example.onlineshopagain.dto.SaveUserRequest;
import com.example.onlineshopagain.serive.UserService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;


@SpringBootTest
public class UserServiceIntegrationTests {

    @Autowired
    private UserService userService;

    @Test
    public void createUser_whenUserIsCreated_thenUserIsReturned() {
        SaveUserRequest request = new SaveUserRequest();
        request.setFirstName("alex");
        request.setLastName("florin");

        User user = userService.createUSer(request);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(user.getFirstName()).isNotNull();
        softAssertions.assertThat(user.getFirstName()).isEqualTo(request.getFirstName());
        softAssertions.assertThat(user.getLastName()).isNotNull();
        softAssertions.assertThat(user.getLastName()).isEqualTo(request.getLastName());
        softAssertions.assertThat(user.getId()).isGreaterThan(0L);
        softAssertions.assertThat(user).isNotNull();

        softAssertions.assertAll();
    }

    @Test
    public void createUser_whenFirstNameIsEmpty_thenExceptionIsThrowed() {
        SaveUserRequest request = new SaveUserRequest();
        request.setFirstName("");
        request.setLastName("lastName");

        Exception exception = null;

        try {
            userService.createUSer(request);
        } catch (Exception e) {
            exception = e;
        }

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(exception).isNotNull();
        softAssertions.assertThat(exception).isInstanceOf(TransactionSystemException.class);

        softAssertions.assertAll();
    }

    @Test
    public void createUser_whenFirstNameIsBlank_thenExceptionIsThrowed() {
        SaveUserRequest request = new SaveUserRequest();
        request.setFirstName("Alex");
        request.setLastName("");

        Exception exception = null;

        try {
            userService.createUSer(request);
        } catch (Exception e) {
            exception = e;
        }

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(exception).isNotNull();
        softAssertions.assertThat(exception).isInstanceOf(TransactionSystemException.class);

        softAssertions.assertAll();

    }



}
