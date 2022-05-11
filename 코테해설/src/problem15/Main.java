package problem15;

public class Main {
    public int solution(int[] reward, int[] health, int[] optional) {
        return recursive(1, 0, reward, health, optional);
    }

    int recursive(int attack, int current, int[] reward, int[] health, int[] optional) {
        if (current == reward.length) {
            return 0;
        }

        int time = (health[current] + attack - 1) / attack;
        int pathA = time + recursive(
                attack + reward[current],
                current + 1,
                reward, health, optional);

        if(optional[current] == 0) {
            return pathA;
        } else {
            int pathB = recursive(attack, current + 1, reward, health, optional);
            return Math.min(pathA, pathB);
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] reward = {4, 2, 2, 0, 3, 5};
        int[] health = {10, 20, 20, 20, 40, 30};
        int[] optional = {1, 0, 1, 0, 0, 0};

        System.out.println(main.solution(reward, health, optional));
    }

}
