package dev.lhphong.bankapi.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Base64;
import java.util.Date;

public class TokenJWTUtils {
    public static final long EXPIRATION_TIME = 86400000;
    public static final String SECRET_KEY = "SecretKeyHongPhong";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final String username = "user_bank";
    public static String encode(){
        return JWT.create()
                .withIssuer("lhphong")
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .withClaim("user",username)
                .sign(Algorithm.HMAC512(SECRET_KEY));
    }

    private static DecodedJWT makeDecoder(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(SECRET_KEY)).withIssuer("lhphong").build();
        if(token == null || token.trim().length() == 0)
            return null;
        return verifier.verify(token.trim());
    }

    public static String decode(String token){
        token = token.replace("Bearer","");
        DecodedJWT decodedJWT = makeDecoder(token);
        if(decodedJWT == null)
            return null;
        return decodedJWT.getClaim("userName").asString();
    }

    public static void main(String[] args) {
        System.out.println(encode());
    }
}
