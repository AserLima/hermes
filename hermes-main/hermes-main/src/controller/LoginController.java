package controller; // Use a more descriptive package name (DCL01-J)

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.naming.ldap.LdapException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

public class LoginController implements HttpHandler {

    private static final int HASH_ITERATIONS = 65536; // Adjust iterations as needed
    private static final int HASH_LENGTH = 512; // Adjust hash length as needed

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            try (
                    InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "UTF-8");
                    BufferedReader br = new BufferedReader(isr);
                    OutputStream os = exchange.getResponseBody()
            ) {
                String formData = br.readLine();
                Map<String, String> formDataMap = parseFormData(formData);

                validateUserInput(formDataMap.get("email"), formDataMap.get("senha"));

                String hashedPassword = hashPassword(formDataMap.get("senha"));



                String response = "Login successful!"; // Replace with appropriate response
                exchange.sendResponseHeaders(200, response.getBytes().length);
                os.write(response.getBytes());
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | LdapException e) {
                exchange.sendResponseHeaders(500, "Internal server error".getBytes().length);
                e.printStackTrace(); // Log the exception for debugging
            } catch (IOException e) {
                exchange.sendResponseHeaders(500, "Internal server error".getBytes().length);
                e.printStackTrace();
            }
        } else {
            String response = "Only POST requests are supported for login.";
            exchange.sendResponseHeaders(405, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }



    private void validateUserInput(String email, String senha) throws IOException {

        if (email == null || email.isBlank() || senha == null || senha.isBlank()) {
            throw new IOException("Email and password are required.");
        }
    }


}
