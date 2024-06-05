package controller;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;

public class UsuarioController {

    private static final String USER_POOL_ID = "us-east-1_e7lMuU87P";
    private static final String CLIENT_ID = "<MASKED>";
    private static final String REGION = "us-east-1";

    private final AWSCognitoIdentityProvider cognitoClient;

    public UsuarioController() {
        cognitoClient = AWSCognitoIdentityProviderClientBuilder.standard()
                .withRegion(Regions.fromName(REGION))
                .build();
    }

    private void validateUserInput(String nome, String email, String senha, String telefone) {

    }

    public boolean registrarUsuario(String nome, String email, String senha, String telefone) throws CognitoServiceException {
        validateUserInput(nome, email, senha, telefone);

        SignUpRequest signUpRequest = new SignUpRequest()
                .withClientId(CLIENT_ID)
                .withUsername(email)
                .withPassword(senha)
                .withUserAttributes(
                        new AttributeType().withName("name").withValue(nome),
                        new AttributeType().withName("email").withValue(email),
                        new AttributeType().withName("phone_number").withValue(telefone)
                );

        try {
            cognitoClient.signUp(signUpRequest);
            return true;
        } catch (AWSCognitoIdentityProviderException e) {
            throw new CognitoServiceException(e.getMessage()); // Wrap AWS exception in custom exception (ERR00-J)
        }
    }

    public boolean adicionarUsuarioAoGrupo(String email, String groupName) throws CognitoServiceException {
        try {
            AdminAddUserToGroupRequest addUserToGroupRequest = new AdminAddUserToGroupRequest()
                    .withUserPoolId(USER_POOL_ID)
                    .withUsername(email)
                    .withGroupName(groupName);

            cognitoClient.adminAddUserToGroup(addUserToGroupRequest);
            return true;
        } catch (AWSCognitoIdentityProviderException e) {
            throw new CognitoServiceException(e.getMessage());
        }
    }
}

