package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
public class EnviaMensagemController  implements HttpHandler {

    //  public EnviaMensagemController(){
    //        this.mensagemDAO = new MensagemDAO();
    //    }

    public EnviaMensagemController() {


    }
    private static final String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCrND1oDZ1+DijXjmxp/b09DIc1W8AvNRINXs+uu2jX5CQecRV30eSbc0wnHze9oY6iPjw2GPZ6N//WsGRdAX7JjWBJSgg8FIb0m2kIFsNndOzsuGX5P8LAR9lGyWqLlyfD5Tsh3AsvBYgcYRnABMR7rE4VxZL4wbS+TQABf1WKok7kXnN2/h1oa9BRPEd56r+aUVXKAD3sWT/AD1x2OGHyJhJaykf9CJb+ILaCZFL0O0UYeSrEAqFjnZffrFOzZHDFEs/sru7RQCUF1LV5kY2GhoWr9rctjwukuhsmvQlGQJg8kFCb/irjC72Kn5zlb9aSeYLQABhCCaKHyuJ5FthxAgMBAAECggEAAMnWvM5/vr1uVBhNgOM0knX23zC5Csqc9rtsm8yUhfaAsVRyXaz1d18NfypgU4btgQsl9DaTF4Lfom+pZamAqclVM78z2KF8Ud7vmdQ/gf/miaxLeW1xDllCW5Zov4PyoJ8DEcPJeCXnj6BlmcYX2M01RpnEZJGBTWVNwkQBqwfUgHHB+W7auJqY1DtklHP5Y1+BX/1S8mnfNpqUWga3kX9T+8KavU8t756Zfie8TmGyC+rh5X1LkMXA6y75ApTaqngKxQnTPYo4+rBcaEmJlHwqctJl48DWpaz20VUZlJkR19k/WqwLtY2qeyZKoqKuBeG2PvtE1RZyrNSwsdmk4QKBgQDwZorcmLKMN8bzF1gEMqa6Gc87B78hnw4n6IwSuPb+dprpyOjoLyELcrU9CzVcOsyZBNHZhgzksWoKwdtdpef1/8rOYYryQzAifjZ6wNX9hT4C3X2HFKZCRb8FESnt4nyrbXU6EwDwRqlvTm8bgPblXQhNTTW6cgFZHxC/+rtKYQKBgQC2UDovfXrG7XjC3VrM7MeTVd64UWE8wabN2y/9Qf6rxQBi9+iwuO1T1uFVTnzfZ7zf0+LZio9tpjb+dW7ULzYvv4nbn7w3Mh3G6YJ5k0yc3j7CieYOaWbUfeYm2ZSqTdl/kL0VOZuFRnMicZuCWwiva6JnIEeVA8zmujdiBZ/oEQKBgA+vYRgLjnq/mOd7em6rr10tGexMERhsfEv2TE1cbCEmM+1VAn1DtfA9R7334T9nRrolKlv69xRkzvpss5dkn8HZMq5MhvhPkfBuM7fGpS+pZeZh9TK/Ein4ywHVoNq4kFHPDnr/imwi8CMnBvDQdUt5ynTguMS1c4kREdK01UuBAoGAbbzsyRkmhgb64ZCLzz3XA4B0h0200fVeihqdUDwhJxN1oBzJG1a0w/pbuBV+ZJr0vWW07mzQ2JdsEs5s35tramJIgMItcKvh8JEt0DAxtVqxPDf1GkenddAycMAXFEu312kv5069pgM52km36UcSe0S2hIyRici31UnRfFcWYYECgYBkl5zD2txHL/DigDvPeb9hZPZVlZZYpTrjSBC6spxzFxPczJT4tzGxM6FBpa/Df69Cjpv8xnbHGFnXKyBQQcYhw65/66dD2gALpVard+zmY8VPbXo5fugZck2BEqgJdswSC76wLi/XKnFtmfXIqvyrTX7CbaMpsmEzhZlyFvEXpA==";


    public static void main(String[] args) throws Exception {
        String encryptedData = "= \"MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCrND1oDZ1+DijXjmxp/b09DIc1W8AvNRINXs+uu2jX5CQecRV30eSbc0wnHze9oY6iPjw2GPZ6N//WsGRdAX7JjWBJSgg8FIb0m2kIFsNndOzsuGX5P8LAR9lGyWqLlyfD5Tsh3AsvBYgcYRnABMR7rE4VxZL4wbS+TQABf1WKok7kXnN2/h1oa9BRPEd56r+aUVXKAD3sWT/AD1x2OGHyJhJaykf9CJb+ILaCZFL0O0UYeSrEAqFjnZffrFOzZHDFEs/sru7RQCUF1LV5kY2GhoWr9rctjwukuhsmvQlGQJg8kFCb/irjC72Kn5zlb9aSeYLQABhCCaKHyuJ5FthxAgMBAAECggEAAMnWvM5/vr1uVBhNgOM0knX23zC5Csqc9rtsm8yUhfaAsVRyXaz1d18NfypgU4btgQsl9DaTF4Lfom+pZamAqclVM78z2KF8Ud7vmdQ/gf/miaxLeW1xDllCW5Zov4PyoJ8DEcPJeCXnj6BlmcYX2M01RpnEZJGBTWVNwkQBqwfUgHHB+W7auJqY1DtklHP5Y1+BX/1S8mnfNpqUWga3kX9T+8KavU8t756Zfie8TmGyC+rh5X1LkMXA6y75ApTaqngKxQnTPYo4+rBcaEmJlHwqctJl48DWpaz20VUZlJkR19k/WqwLtY2qeyZKoqKuBeG2PvtE1RZyrNSwsdmk4QKBgQDwZorcmLKMN8bzF1gEMqa6Gc87B78hnw4n6IwSuPb+dprpyOjoLyELcrU9CzVcOsyZBNHZhgzksWoKwdtdpef1/8rOYYryQzAifjZ6wNX9hT4C3X2HFKZCRb8FESnt4nyrbXU6EwDwRqlvTm8bgPblXQhNTTW6cgFZHxC/+rtKYQKBgQC2UDovfXrG7XjC3VrM7MeTVd64UWE8wabN2y/9Qf6rxQBi9+iwuO1T1uFVTnzfZ7zf0+LZio9tpjb+dW7ULzYvv4nbn7w3Mh3G6YJ5k0yc3j7CieYOaWbUfeYm2ZSqTdl/kL0VOZuFRnMicZuCWwiva6JnIEeVA8zmujdiBZ/oEQKBgA+vYRgLjnq/mOd7em6rr10tGexMERhsfEv2TE1cbCEmM+1VAn1DtfA9R7334T9nRrolKlv69xRkzvpss5dkn8HZMq5MhvhPkfBuM7fGpS+pZeZh9TK/Ein4ywHVoNq4kFHPDnr/imwi8CMnBvDQdUt5ynTguMS1c4kREdK01UuBAoGAbbzsyRkmhgb64ZCLzz3XA4B0h0200fVeihqdUDwhJxN1oBzJG1a0w/pbuBV+ZJr0vWW07mzQ2JdsEs5s35tramJIgMItcKvh8JEt0DAxtVqxPDf1GkenddAycMAXFEu312kv5069pgM52km36UcSe0S2hIyRici31UnRfFcWYYECgYBkl5zD2txHL/DigDvPeb9hZPZVlZZYpTrjSBC6spxzFxPczJT4tzGxM6FBpa/Df69Cjpv8xnbHGFnXKyBQQcYhw65/66dD2gALpVard+zmY8VPbXo5fugZck2BEqgJdswSC76wLi/XKnFtmfXIqvyrTX7CbaMpsmEzhZlyFvEXpA==\";\n"; // Replace with your actual encrypted data

        // Convert the private key from Base64 to PrivateKey object
        byte[] privateKeyBytes = Base64.getDecoder().decode(PRIVATE_KEY);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // Decrypt the data
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedData = new String(decryptedBytes);

        System.out.println("Decrypted Data: " + decryptedData);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {


        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();
            HashMap<String, String> formDataMap = parseFormData(formData);
            String response = null;
            try {
                response = Decrypt(formDataMap.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            String response = "Only POST requests are supported for form submission.";
            exchange.sendResponseHeaders(405, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

    }

    private HashMap<String, String> parseFormData(String formData) {
        HashMap<String, String> formDataMap = new HashMap<>();
        String[] pairs = formData.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];
                formDataMap.put(key, value);
            }
        }
        return formDataMap;
    }

    private static String Decrypt(String data) throws Exception {
         String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCrND1oDZ1+DijXjmxp/b09DIc1W8AvNRINXs+uu2jX5CQecRV30eSbc0wnHze9oY6iPjw2GPZ6N//WsGRdAX7JjWBJSgg8FIb0m2kIFsNndOzsuGX5P8LAR9lGyWqLlyfD5Tsh3AsvBYgcYRnABMR7rE4VxZL4wbS+TQABf1WKok7kXnN2/h1oa9BRPEd56r+aUVXKAD3sWT/AD1x2OGHyJhJaykf9CJb+ILaCZFL0O0UYeSrEAqFjnZffrFOzZHDFEs/sru7RQCUF1LV5kY2GhoWr9rctjwukuhsmvQlGQJg8kFCb/irjC72Kn5zlb9aSeYLQABhCCaKHyuJ5FthxAgMBAAECggEAAMnWvM5/vr1uVBhNgOM0knX23zC5Csqc9rtsm8yUhfaAsVRyXaz1d18NfypgU4btgQsl9DaTF4Lfom+pZamAqclVM78z2KF8Ud7vmdQ/gf/miaxLeW1xDllCW5Zov4PyoJ8DEcPJeCXnj6BlmcYX2M01RpnEZJGBTWVNwkQBqwfUgHHB+W7auJqY1DtklHP5Y1+BX/1S8mnfNpqUWga3kX9T+8KavU8t756Zfie8TmGyC+rh5X1LkMXA6y75ApTaqngKxQnTPYo4+rBcaEmJlHwqctJl48DWpaz20VUZlJkR19k/WqwLtY2qeyZKoqKuBeG2PvtE1RZyrNSwsdmk4QKBgQDwZorcmLKMN8bzF1gEMqa6Gc87B78hnw4n6IwSuPb+dprpyOjoLyELcrU9CzVcOsyZBNHZhgzksWoKwdtdpef1/8rOYYryQzAifjZ6wNX9hT4C3X2HFKZCRb8FESnt4nyrbXU6EwDwRqlvTm8bgPblXQhNTTW6cgFZHxC/+rtKYQKBgQC2UDovfXrG7XjC3VrM7MeTVd64UWE8wabN2y/9Qf6rxQBi9+iwuO1T1uFVTnzfZ7zf0+LZio9tpjb+dW7ULzYvv4nbn7w3Mh3G6YJ5k0yc3j7CieYOaWbUfeYm2ZSqTdl/kL0VOZuFRnMicZuCWwiva6JnIEeVA8zmujdiBZ/oEQKBgA+vYRgLjnq/mOd7em6rr10tGexMERhsfEv2TE1cbCEmM+1VAn1DtfA9R7334T9nRrolKlv69xRkzvpss5dkn8HZMq5MhvhPkfBuM7fGpS+pZeZh9TK/Ein4ywHVoNq4kFHPDnr/imwi8CMnBvDQdUt5ynTguMS1c4kREdK01UuBAoGAbbzsyRkmhgb64ZCLzz3XA4B0h0200fVeihqdUDwhJxN1oBzJG1a0w/pbuBV+ZJr0vWW07mzQ2JdsEs5s35tramJIgMItcKvh8JEt0DAxtVqxPDf1GkenddAycMAXFEu312kv5069pgM52km36UcSe0S2hIyRici31UnRfFcWYYECgYBkl5zD2txHL/DigDvPeb9hZPZVlZZYpTrjSBC6spxzFxPczJT4tzGxM6FBpa/Df69Cjpv8xnbHGFnXKyBQQcYhw65/66dD2gALpVard+zmY8VPbXo5fugZck2BEqgJdswSC76wLi/XKnFtmfXIqvyrTX7CbaMpsmEzhZlyFvEXpA==";

        String encryptedData = data; // Replace with your actual encrypted data


        // Convert the private key from Base64 to PrivateKey object
        byte[] privateKeyBytes = Base64.getDecoder().decode(PRIVATE_KEY);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);


        // Decrypt the data
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedData = new String(decryptedBytes);

        return (decryptedData);


    }
}



