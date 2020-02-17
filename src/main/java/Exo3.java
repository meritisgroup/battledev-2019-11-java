import java.util.*;

class Action {

    public int time = -1;
    public boolean pickUp = true;
    public int cableIndex = -1;
    public Action relatedAction = null;

    public static Action createPickUp(int time) {
        Action action = new Action();
        action.time = time;
        action.pickUp = true;
        return action;
    }

    public static Action createLeave(int time, Action pickUpAction) {
        Action action = new Action();
        action.time = time;
        action.pickUp = false;
        action.relatedAction = pickUpAction;
        pickUpAction.relatedAction = action;
        return action;
    }

    public Double getTimeLine() {
        if (pickUp) {
            return time + 0.5;
        } else {
            return (double) time;
        }
    }

}

public class Exo3 {

    public static List<Integer> assignCables(int N, List<Action> actions) {
        List<Integer> assigned = new ArrayList<Integer>();
        List<Integer> freeCables = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) freeCables.add(i);

        for (Action action : actions) {
            if (action.pickUp) {
                if (freeCables.size() == 0) {
                    return null;
                } else {
                    int cable = freeCables.get(0);
                    freeCables.remove(0);
                    action.cableIndex = cable;
                    assigned.add(cable);
                }
            } else {
                freeCables.add(action.relatedAction.cableIndex);
            }
        }

        return assigned;
    }

    public static void main(String[] argv) throws Exception {
        List<String> input = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }

        int N = Integer.parseInt(input.get(0).split(" ")[0]);
        int M = Integer.parseInt(input.get(0).split(" ")[1]);

        List<Action> actions = new ArrayList<Action>();
        for (int i = 1; i < input.size(); i++) {
            String[] array = input.get(i).split(" ");

            int start = Integer.parseInt(array[0]);
            int end = Integer.parseInt(array[1]);

            Action pickUp = Action.createPickUp(start);
            Action leave = Action.createLeave(end, pickUp);

            actions.add(pickUp);
            actions.add(leave);
        }

        Collections.sort(actions, new Comparator<Action>() {
            @Override
            public int compare(Action a1, Action a2) {
                return a1.getTimeLine().compareTo(a2.getTimeLine());
            }
        });

        List<Integer> assigned = assignCables(N, actions);

        if (assigned == null || assigned.size() <= 0) {
            System.out.println("pas possible");
        } else {
            for (int i = 0; i < assigned.size(); i++) {
                System.out.print((assigned.get(i) + 1) + " ");
            }
            System.out.println("");
        }
    }

}
