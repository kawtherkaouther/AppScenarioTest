package jwt.security;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jwt.config.SecurityConstants;
@CrossOrigin(origins = "http://localhost:8080") 
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(SecurityConstants.HEADER_STRING);

		res.setHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Headers","*");
		res.addHeader("Access-Control-Expose-Headers","*");

		
		
		if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}

		String jwtToken = req.getHeader(SecurityConstants.HEADER_STRING);
		Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET.getBytes("UTF-8"))
				.parseClaimsJws(jwtToken.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody();

		String username = claims.getSubject();
		ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");

		Collection<GrantedAuthority> authorities = new ArrayList<>();

		roles.forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.get("authority")));
		});

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,	null, authorities);

		System.out.println("------------------- JWTAuthorizationFilter authorities  "+authorities);
		
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(req, res);

	}
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(SecurityConstants.HEADER_STRING);
		if (token != null) {
			// parse the token.
			String user = Jwts.parser().setSigningKey(SecurityConstants.SECRET.getBytes())
								.parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody().getSubject();

			Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
									.parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody();

			String username = claims.getSubject();
			ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");

			Collection<GrantedAuthority> authorities = new ArrayList<>();

			roles.forEach(r -> {
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			});

			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, authorities);
			}
			return null;
		}
		return null;
	}
}