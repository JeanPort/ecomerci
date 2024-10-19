package br.com.truedev.ecomerci.security;

import br.com.truedev.ecomerci.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class ECTokenUtil {

    private static final long UM_SEGUNDO = 1000;
    private static final long UM_MINUTO = 60 * UM_SEGUNDO;
    private static final long UMA_HORA = 60 * UM_MINUTO;
    private static final long UM_DIA = 24 * UMA_HORA;
    private static final long UMA_SEMANA = 7 * UM_DIA;

    private static final String EMISSOR = "*TrueDEV*";
    private static final String TOKEN_KEY = "01234567890123456789012345678901";
    private static final String TOKEN_HEADER = "Bearer ";

    public static ECToken generateToken(Usuario usuario){

        Key secretKey = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes());
        String jwt = Jwts.builder().subject(usuario.getLogin())
                .issuer(EMISSOR)
                .expiration(new Date(System.currentTimeMillis()+ UMA_SEMANA))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        return new ECToken(TOKEN_HEADER + jwt);
    }

    public static Authentication decodeToken(HttpServletRequest http) {

        String token = http.getHeader("Authorization");
        token = token.replace(TOKEN_HEADER, "");
        Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(TOKEN_KEY.getBytes()).build().parseSignedClaims(token);

        String login = jwsClaims.getBody().getSubject();
        String emissor = jwsClaims.getBody().getIssuer();
        Date validade = jwsClaims.getBody().getExpiration();

        if (!login.isEmpty() && emissor.equals(EMISSOR) && validade.after(new Date(System.currentTimeMillis()))) {
            return new UsernamePasswordAuthenticationToken(login, null, Collections.emptyList());
        }
        return null;
    }
}
