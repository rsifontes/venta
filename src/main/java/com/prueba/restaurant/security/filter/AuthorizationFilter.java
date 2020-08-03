package com.prueba.restaurant.security.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.restaurant.error.ApiError;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static com.prueba.restaurant.security.SecurityConstants.HEADER_NAME;
import static com.prueba.restaurant.security.SecurityConstants.KEY;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_NAME);


        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        try {

            UsernamePasswordAuthenticationToken authentication = authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);

        }catch (ExpiredJwtException e){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            ApiError apiError =
                    new ApiError(HttpStatus.UNAUTHORIZED.value(), "Token Expired", Collections.emptyList());


            response.getWriter().write(convertObjectToJson(apiError));
        }
        catch ( BadCredentialsException | ClaimJwtException e){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            ApiError apiError =
                    new ApiError(HttpStatus.UNAUTHORIZED.value(), "Invalid Token", Collections.emptyList());


            response.getWriter().write(convertObjectToJson(apiError));
        }

    }


    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {
        String token = request.getHeader(HEADER_NAME);

        if (token != null) {
            Claims user = Jwts.parser()
                    .setSigningKey(KEY.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }else{
                throw new BadCredentialsException("Acceso Denegado");
            }

        }
        return null;
    }
}
