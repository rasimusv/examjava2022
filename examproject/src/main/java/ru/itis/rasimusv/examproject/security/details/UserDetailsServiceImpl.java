package ru.itis.rasimusv.examproject.security.details;

import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.rasimusv.examproject.models.RefreshToken;
import ru.itis.rasimusv.examproject.repositories.RefreshTokensRepository;

import java.util.function.Supplier;

@Component("tokenUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RefreshTokensRepository refreshTokensRepository;

    public UserDetailsServiceImpl(RefreshTokensRepository refreshTokensRepository) {
        this.refreshTokensRepository = refreshTokensRepository;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        RefreshToken result = refreshTokensRepository.findByToken(token).orElseThrow((Supplier<Throwable>) () -> new UsernameNotFoundException("Token not found"));
        return new UserDetailsImpl(result.getUser());
    }
}
