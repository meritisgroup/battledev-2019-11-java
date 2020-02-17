import java.util.*;

public class Exo2 {

    public static void main(String[] argv) throws Exception {
        List<Integer> input = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int i = Integer.parseInt(line);
            input.add(i);
        }

        Integer[] lengths = new Integer[input.size()];
        input.toArray(lengths);

        Arrays.sort(lengths);
        int min = lengths[0];

        int sum = 0;
        for (int i = 0; i < lengths.length; i++) {
            sum += lengths[i] - min;
        }

        System.out.println(sum);
    }

}
