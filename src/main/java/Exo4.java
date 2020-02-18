import java.util.*;

class Item {
    public double goldPerWeight;
    public int weight;
    public boolean isPowder;

    public double getGoldPerWeight() {
        return goldPerWeight;
    }

    public static Item precious(int gold, int weight) {
        Item item = new Item();
        item.goldPerWeight = (double) gold / weight;
        item.weight = weight;
        item.isPowder = false;
        return item;
    }

    public static Item powder(int goldPerWeight, int totalWeight) {
        Item item = new Item();
        item.goldPerWeight = (double) goldPerWeight;
        item.weight = totalWeight;
        item.isPowder = true;
        return item;
    }
}

public class Exo4 {

    public static int pickUpFirst(int C, List<Item> items) {
        double currentGold = 0.0;
        double currentWeight = 0.0;

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (currentWeight + item.weight > C) {
                if (item.isPowder) {
                    double usedWeight = C - currentWeight;
                    currentGold += item.goldPerWeight * usedWeight;
                    currentWeight += usedWeight;
                }
            } else {
                currentGold += item.goldPerWeight * item.weight;
                currentWeight += item.weight;
            }
        }

        return (int) currentGold;
    }

    public static void main(String[] argv) throws Exception {
        List<String> input = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }

        // Nombre de pierres précieuses
        int N = Integer.parseInt(input.get(0).split(" ")[0]);

        // Nombre de types de poudres
        int M = Integer.parseInt(input.get(0).split(" ")[1]);

        // Poids maximum de la lampe
        int C = Integer.parseInt(input.get(0).split(" ")[2]);

        List<Item> items = new ArrayList<>();

        // Liste des pierres précieuses
        for (int i = 1; i < N + 1; i++) {
            String[] array = input.get(i).split(" ");
            items.add(Item.precious(Integer.parseInt(array[0]), Integer.parseInt(array[1])));
        }

        // Liste des poudres
        for (int i = N + 1; i < input.size(); i++) {
            String[] array = input.get(i).split(" ");
            items.add(Item.powder(Integer.parseInt(array[0]), Integer.parseInt(array[1])));
        }

        items.sort(Comparator.comparing(Item::getGoldPerWeight));
        Collections.reverse(items);

        int result = pickUpFirst(C, items);

        System.out.println(result);
    }

}
