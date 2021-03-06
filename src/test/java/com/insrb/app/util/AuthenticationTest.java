package com.insrb.app.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.insrb.app.exception.InsuAuthException;
import com.insrb.app.exception.InsuAuthExpiredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class AuthenticationTest {
    private String email = "vingorius@gmail.com";

    @Test
    @DisplayName("인증 토큰으로 부터 id(email)을 가져와야 한다.")
    public void test02_varifyToken() throws InsuAuthException, InsuAuthExpiredException {
        String token = (String) InsuAuthentication.CreateToken(email);
        assertEquals(email, InsuAuthentication.GetUserIdFromToken(token));
    }

    @Test
    @DisplayName("어제 발행된 토큰은 AuthExpiredException 발생하여야한다.")
    public void test03_varifyToken() throws InsuAuthException {
        String yesterday_token = (String) InsuAuthentication.CreateYesterdayToken(email);
        Assertions.assertThrows(InsuAuthExpiredException.class, () -> {
            assertEquals(email, InsuAuthentication.GetUserIdFromToken(yesterday_token));
        });
    }

}
    