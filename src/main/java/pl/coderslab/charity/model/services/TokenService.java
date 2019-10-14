package pl.coderslab.charity.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.DTO.TokenDTO;
import pl.coderslab.charity.model.entities.User;
import pl.coderslab.charity.model.entities.VerificationToken;
import pl.coderslab.charity.model.repositories.TokenRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class TokenService {

    private final TokenRepository tokenRepository;
    private final ModelMapper modelMapper;

    public TokenService(TokenRepository tokenRepository, ModelMapper modelMapper) {
        this.tokenRepository = tokenRepository;
        this.modelMapper = modelMapper;
    }


    public void createToken(User user,String token) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user);
        verificationToken.setToken(token);
        tokenRepository.save(verificationToken);
    }


    private TokenDTO toDto(VerificationToken verificationToken) {
        return modelMapper.map(verificationToken, TokenDTO.class);
    }

    private VerificationToken toEntity(TokenDTO tokenDTO) {
        return modelMapper.map(tokenDTO, VerificationToken.class);
    }

}
