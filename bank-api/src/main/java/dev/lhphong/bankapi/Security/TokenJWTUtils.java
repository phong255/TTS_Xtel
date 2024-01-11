package dev.lhphong.bankapi.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.Date;

public class TokenJWTUtils {
    public static final long EXPIRATION_TIME = 86400000;
    public static final String SECRET_KEY = "SecretKeyHongPhong";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";

    public static String generateJWT(String userId){
        return Jwts.builder()
                .setId(userId)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY.getBytes())
                .compact();
    }

    public static void authentication(String token){
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
    }
}
