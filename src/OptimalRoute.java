import java.util.ArrayList;
import java.util.List;

public class OptimalRoute {

    private final Excursion[] excursions; // массив экскурсий
    private final int totalTime; // общее время = 32 ч
    private final int totalExs; // размер массива экскурсий
    private final int[][] combinations; // массив промежуточных состояний оптимального маршрута
    private List<Excursion> bestSolution; // оптимальное решение

    public OptimalRoute(Excursion[] excursions, int totalTime) {
        this.excursions = excursions;
        this.totalTime = totalTime;
        this.totalExs = excursions.length;
        combinations = new int[totalExs + 1][totalTime + 1];
    }

    public void knapsackProblemSolving() {
        System.out.println("Имеющееся свободное время: " + totalTime / 60);
        System.out.println ("Список всех достопримечательностей:");
        for(Excursion excursion : excursions) {
            System.out.println(excursion);
        }
        for (int j = 0; j <= totalTime; j++) {
            for (int i = 0; i <= totalExs; i++) {
                if (i == 0 || j == 0) {
                    combinations[i][j] = 0;
                } else {
                    if (j < excursions[i - 1].getTime()) {
                        combinations[i][j] = combinations[i - 1][j];
                    } else {
                        int iTime = excursions[i - 1].getTime();
                        int iImportance = excursions[i - 1].getImportance();
                        combinations[i][j] =
                                Math.max(combinations[i - 1][j], iImportance + combinations[i - 1][j - iTime]);
                    }
                }
            }
        }
        if (bestSolution == null) {
            bestSolution = new ArrayList<>();
        }
        int tempTime = totalTime;
        for (int i = totalExs; i >= 1; i--) {
            if (combinations[i][tempTime] > combinations[i - 1][tempTime]) {
                bestSolution.add(excursions[i - 1]);
                tempTime -= excursions[i - 1].getTime();
            }
            if (tempTime == 0) {
                break;
            }
        }
        // наибольшая сумма важности, которую можно получить при максимальной загрузке экскурсий
        int bestSumOfImportance = combinations[totalExs][totalTime];
    }

    public List<Excursion> getBestSolution() {
        return bestSolution;
    }
}
