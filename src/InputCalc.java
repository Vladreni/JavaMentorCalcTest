import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputCalc {

    public Integer a;
    public Integer b;
    public char sign;
    String[] operands;
    public int flagRim;

    public InputCalc() throws IOException {
        sign = getSign(read());
        try {
            a = Integer.parseInt(operands[0]);
            b = Integer.parseInt(operands[1]);
        } catch (Exception ex) {
            notDigit();
            a = Integer.parseInt(operands[0]);
            b = Integer.parseInt(operands[1]);
        } finally {
            if (a > 10 || a < 1 || b > 10 || b < 1) {
                System.out.println("Operands is wrong! > 10 or < 1");
                System.exit(0);
            }
        }
    }

    public String read () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return (reader.readLine());
    }

    public char getSign(String input) {
        char sign = '0';
        char[] signs = new char[] {'+', '-', '*', '/'};
        int i = -1;
        while (i++ < 3)
            if (input.indexOf(signs[i]) != -1) {
                sign = signs[i];
                break;
            }
        if (sign == '0')
        {
            System.out.println("NO operation!");
            System.exit(0);
        }
        else {
            this.operands = input.split("\\" + sign);
            if (this.operands.length != 2)
            {
                System.out.println("Operation is wrong!");
                System.exit(0);
            }
        }
        this.operands[0] = this.operands[0].trim();
        this.operands[1] = this.operands[1].trim();

        return sign;
    }

    void notDigit() {
        int[] rim = new int[] {0, 0, 0};
        isRim(rim);
        isRim(rim);
        if (rim[0] == 2) {
            this.operands[0] = Integer.toString(rim[1]);
            this.operands[1] = Integer.toString(rim[2]);
            flagRim = 1;
        }
        else if (rim[0] < 2) {
            System.out.println("Operands is wrong!");
            System.exit(0);
        }
    }

    void isRim(int[] rim) {
        String[] rimDigit = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int i = -1;
        while (i++ < 9) {
            if (operands[rim[0]].equals(rimDigit[i])) {
                rim[0]++;
                rim[rim[0]] = i+1;
                break;
            }
        }
    }
}
