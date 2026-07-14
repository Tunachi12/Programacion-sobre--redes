import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class CifradoAES {
    private static final String CLAVE = "AgendaSegura2026";
    private static final int TAMANIO_IV = 12;
    private static final int TAMANIO_TAG = 128;

    public static String encriptar(String texto) throws Exception {
        byte[] claveBytes = CLAVE.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec clave = new SecretKeySpec(claveBytes, "AES");

        byte[] iv = new byte[TAMANIO_IV];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parametros = new GCMParameterSpec(TAMANIO_TAG, iv);

        cipher.init(Cipher.ENCRYPT_MODE, clave, parametros);

        byte[] cifrado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        byte[] resultado = new byte[iv.length + cifrado.length];

        System.arraycopy(iv, 0, resultado, 0, iv.length);
        System.arraycopy(cifrado, 0, resultado, iv.length, cifrado.length);

        return Base64.getEncoder().encodeToString(resultado);
    }

    public static String desencriptar(String textoCifrado) throws Exception {
        byte[] datos = Base64.getDecoder().decode(textoCifrado);

        byte[] iv = new byte[TAMANIO_IV];
        byte[] cifrado = new byte[datos.length - TAMANIO_IV];

        System.arraycopy(datos, 0, iv, 0, TAMANIO_IV);
        System.arraycopy(datos, TAMANIO_IV, cifrado, 0, cifrado.length);

        byte[] claveBytes = CLAVE.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec clave = new SecretKeySpec(claveBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parametros = new GCMParameterSpec(TAMANIO_TAG, iv);

        cipher.init(Cipher.DECRYPT_MODE, clave, parametros);

        byte[] textoPlano = cipher.doFinal(cifrado);

        return new String(textoPlano, StandardCharsets.UTF_8);
    }
}
