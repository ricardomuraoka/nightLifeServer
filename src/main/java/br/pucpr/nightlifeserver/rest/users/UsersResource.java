package br.pucpr.nightlifeserver.rest.users;

import br.pucpr.nightlifeserver.lib.security.JWT;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersResource {
    private JWT jwt;

    public UsersResource(JWT jwt) {
        this.jwt = jwt;
    }

    @PostMapping("/test")
    public ResponseEntity<TestUserDto> getTestUser(
            @Valid @RequestBody TestUserDto credentials
    ) {
        var token = jwt.createToken(credentials.getToken());
        return token == null ?
                ResponseEntity.status(HttpStatus.UNAUTHORIZED).build() :
                ResponseEntity.ok(new TestUserDto(token));
    }
}
