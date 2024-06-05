package DAO;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;
import model.Usuario;

public class UsuarioDAO {

    private final String clientId;
    private final String userPoolId;
    private final AWSCognitoIdentityProvider cognitoClient;

    public UsuarioDAO() {
        this.clientId = "r3oa0mk92ahiv8hd2kifr1vqr";
        this.userPoolId = "us-east-1_e7lMuU87P";
        this.cognitoClient = AWSCognitoIdentityProviderClientBuilder.standard()
                .withRegion("us-east-1")
                .build();
    }

    public boolean registrarUsuario(Usuario usuario, String senha) {
        try {
            SignUpRequest signUpRequest = new SignUpRequest()
                    .withClientId(clientId)
                    .withUsername(usuario.getEmail())
                    .withPassword(senha)
                    .withUserAttributes(
                            new AttributeType().withName("name").withValue(usuario.getNome()),
                            new AttributeType().withName("email").withValue(usuario.getEmail())
                    );

            SignUpResult result = cognitoClient.signUp(signUpRequest);
            return result != null && result.getUserConfirmed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean adicionarUsuarioAoGrupo(String email, String groupName) {
        try {
            AdminAddUserToGroupRequest addUserToGroupRequest = new AdminAddUserToGroupRequest()
                    .withUserPoolId(userPoolId)
                    .withUsername(email)
                    .withGroupName(groupName);

            cognitoClient.adminAddUserToGroup(addUserToGroupRequest);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

