package med.voll.api.infra.security;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {
    
    public String generarToken() {
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
            .withIssuer("voll med")
            .withSubject("melvin.gonzalez")
            .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }
}
