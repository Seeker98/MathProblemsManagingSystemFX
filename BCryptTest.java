package mainentry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Scanner;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

public class BCryptTest {
    public static void main(String[] args){
        Scanner scanner =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode=base64Encoder.encode(scanner.next().getBytes());
        System.out.println(encode);

        BASE64Decoder base64Decoder=new BASE64Decoder();
        String decode=null;
        try {
            decode = new String(base64Decoder.decodeBuffer(scanner.next()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(decode);
            /*String string = scanner.next();
            String hashed=null;
            boolean check=true;
            if("".equals(string)) {
                hashed = BCrypt.hashpw(string, BCrypt.gensalt());
                check=BCrypt.checkpw(string,"$2a$10$gr2hK8O2.apAmDeTmdnIZueI/b4lMdUczmj7XpwnATweX/9NKAu7O");
                System.out.println(check);
            }*/


    }
}
