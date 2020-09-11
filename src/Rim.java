
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rim {
    String[] rimDigit = new String[]{"I", "V", "X", "L", "C"};
    int[] arabDigit = new int[]{1, 5, 10, 50, 100};
    Map<Integer, String> map;

    public Rim() {
        map = addToMap(rimDigit);
    }

    Map<Integer, String> addToMap (String[] rimDigit){
        Map<Integer, String> map = new HashMap<>();

        int i = -1;
        while (i++ < (rimDigit.length - 1))
            map.put(this.arabDigit[i], rimDigit[i]);
        return (map);
    }

    public void rimResult(int result) {
        if (result == 0) {
            System.out.println("0");
            System.exit(0);
        }
        ArrayList<String> rr = new ArrayList<>();
        int minus = 1;
        if (result < 0) {
            result *= -1;
            minus = -1;
        }
        int i = 4;
        while (result > 0) {
            int n = result / arabDigit[i];
            if (n > 3) {
                if (rr.size() > 0 && rr.get(rr.size()-1).equals(map.get(arabDigit[i+1]))) {
                    rr.remove(rr.size()-1);
                    rr.add(map.get(arabDigit[i]));
                    rr.add(map.get(arabDigit[i + 2]));
                }
                else {
                    rr.add(map.get(arabDigit[i]));
                    rr.add(map.get(arabDigit[i + 1]));
                }
                result %= arabDigit[i];
                //i--;
            }
            else if (n > 0) {
                while (n > 0) {
                    rr.add(map.get(arabDigit[i]));
                    n--;
                }
                result %= arabDigit[i];
            }
            i--;
        }
        if (minus == -1)
            System.out.print('-');
        for (String x : rr ) {
            System.out.print(x);
        }
    }
}
