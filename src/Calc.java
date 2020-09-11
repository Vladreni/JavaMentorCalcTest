import java.io.IOException;

public class Calc {

    public static void main (String[] args) throws IOException {

        InputCalc input = new InputCalc();
        int result = OutputCalc(input.a, input.b, input.sign);
        if (input.flagRim == 1) {
            Rim rim = new Rim();
            rim.rimResult(result);
        }
        else
            System.out.println(result);
    }

    public static int OutputCalc(Integer a, Integer b, char sign) {
        int number;
        if (sign == '+')
            number = (a+b);
        else if (sign == '-')
            number = (a-b);
        else if (sign == '*')
            number = (a*b);
        else
            number = (a/b);

        return number;
    }
}
