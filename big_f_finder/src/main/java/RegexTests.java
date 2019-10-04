import java.util.regex.Pattern;

public class RegexTests {

    public static void main(String[] args) {
        System.out.println(Pattern.compile("^(username=11%)+.*(password=11)$").matcher("username=111%4011&password=11").matches() == true);
    }
}
