package au.infomedia.example.endpoint;

import au.infomedia.example.repository.UserRepository;
import au.infomedia.xsd.generated.LoginRequest;
import au.infomedia.xsd.generated.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoginEndpoint {

    private static final String NAMESPACE_URI = "http://schemas.xmlsoap.org/soap/envelope/";

    private UserRepository userRepository;

    @Autowired
    public LoginEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LoginRequest")
    @ResponsePayload
    public LoginResponse getCountry(@RequestPayload LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.setLogin(userRepository.findUser(request.getUsername()));
        response.setMessages("Hey!");
        response.setResultCode("Success");
        return response;
    }
}
