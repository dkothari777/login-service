package io.djk.loginservice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dkothari on 2/22/19.
 */
public class UserUnitTests {

    private User subject;

    @Before
    public void setup() {
        subject = new User();
        subject.setUsername("testUser");
        subject.setPassword("testPassword");
    }

    @Test
    public void getUser_returnUser() {
        assertThat(subject.getUsername()).isEqualTo("testUser");
    }

    @Test
    public void getPassword_returnPassword() {
        assertThat(subject.getPassword()).isEqualTo("testPassword");
    }
}
