package controller;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AdminAddUserToGroupRequest;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserRequest;
import com.amazonaws.services.cognitoidp.model.AttributeType;
import com.amazonaws.services.cognitoidp.model.SignUpRequest;

public class UsuarioController {
    private static final String USER_POOL_ID = "us-east-1_e7lMuU87P";
    private static final String CLIENT_ID = "r3oa0mk92ahiv8hd2kifr1vqr";
    private static final String REGION = "us-east-1";
    private AWSCognitoIdentityProvider cognitoClient;

    public UsuarioController() {
        // Inicialize o cliente do Cognito
        cognitoClient = AWSCognitoIdentityProviderClientBuilder.standard()
                .withRegion(Regions.fromName(REGION))
                .build();
    }

    public boolean registrarUsuario(String nome, String email, String senha) {
        try {
            SignUpRequest signUpRequest = new SignUpRequest()
                    .withClientId(CLIENT_ID)
                    .withUsername(email)
                    .withPassword(senha)
                    .withUserAttributes(
                            new AttributeType().withName("name").withValue(nome),
                            new AttributeType().withName("email").withValue(email)
                    );

            cognitoClient.signUp(signUpRequest);
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao registrar usuário: " + e.getMessage());
            return false;
        }
    }

    public boolean adicionarUsuarioAoGrupo(String email, String groupName) {
        try {
            AdminCreateUserRequest addUserRequest = new AdminCreateUserRequest()
                    .withUserPoolId(USER_POOL_ID)
                    .withUsername(email)
                    .withUserAttributes(
                            new AttributeType().withName("email").withValue(email)
                    );

            cognitoClient.adminCreateUser(addUserRequest);

            AdminAddUserToGroupRequest addUserToGroupRequest = new AdminAddUserToGroupRequest()
                    .withUserPoolId(USER_POOL_ID)
                    .withUsername(email)
                    .withGroupName(groupName);

            cognitoClient.adminAddUserToGroup(addUserToGroupRequest);
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao adicionar usuário ao grupo: " + e.getMessage());
            return false;
        }
    }
}
