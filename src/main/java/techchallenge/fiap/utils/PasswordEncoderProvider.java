package techchallenge.fiap.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoderProvider {
    public static String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }
}