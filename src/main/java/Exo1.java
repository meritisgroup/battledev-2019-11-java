import java.util.*;

public class Exo1 {

    public static void main(String[] argv) throws Exception {
        List<String> input = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }

        int N = Integer.parseInt(input.get(0));
        String[] names = new String[input.size() - 1];
        int[] lengths = new int[input.size() - 1];

        for (int i = 1; i < input.size(); i++) {
            String[] array = input.get(i).split(" ");
            names[i - 1] = array[0];
            lengths[i - 1] = Integer.parseInt(array[1]);
        }

        String minName = names[0];
        int minLength = lengths[0];

        for (int i = 1; i < names.length; i++) {
            if (lengths[i] < minLength) {
                minLength = lengths[i];
                minName = names[i];
            }
        }

        System.out.println(minName);
    }

}
