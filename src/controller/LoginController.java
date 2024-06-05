package controller;


import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AuthenticationResultType;
import com.amazonaws.services.cognitoidp.model.InitiateAuthRequest;

public class LoginController {
    private static final String CLIENT_ID = "r3oa0mk92ahiv8hd2kifr1vqr";
    private static final String USER_POOL_ID = "us-east-1_e7lMuU87P";
    private static final String REGION = "us-east-1";
    private static final String ARN = "arn:aws:cognito-idp:us-east-1:339712927852:userpool/us-east-1_e7lMuU87P";
    private static final String TOKEN_SIGNING_KEY_URL = "https://cognito-idp.us-east-1.amazonaws.com/us-east-1_e7lMuU87P/.well-known/jwks.json";

    private AWSCognitoIdentityProvider cognitoClient;

    public LoginController() {
        cognitoClient = AWSCognitoIdentityProviderClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();
    }

    public AuthenticationResultType iniciarLogin(String email, String senha) {
        try {
            InitiateAuthRequest authRequest = new InitiateAuthRequest()
                    .withAuthFlow("USER_PASSWORD_AUTH")
                    .withClientId(CLIENT_ID)
                    .addAuthParametersEntry("USERNAME", email)
                    .addAuthParametersEntry("PASSWORD", senha);

            return cognitoClient.initiateAuth(authRequest).getAuthenticationResult();
        } catch (Exception e) {
            System.err.println("Erro ao autenticar usuário: " + e.getMessage());
            return null;
        }
    }
}
