public class Solution {

    public static void main(String[] args) {
        Excursion[] excursions = init();
        double spentTime = 0;
        int totalTime = 32 * 60;

        OptimalRoute optimalRoute = new OptimalRoute(excursions, totalTime);
        optimalRoute.knapsackProblemSolving();
        System.out.println();
        System.out.println("Оптимальный маршрут посещения достопримечательностей:");
        for (Excursion excursion : optimalRoute.getBestSolution()) {
            System.out.println(excursion);
            spentTime += ((double) excursion.getTime() / 60);
        }
        System.out.println("Общее затраченное время (ч): " + spentTime);
        System.out.println("Оставшееся свободное время (ч): " + (((double) totalTime / 60) - spentTime));
    }

    public static Excursion[] init() {
        return new Excursion[] {
                new Excursion("Всероссийский музей А.С. Пушкина и филиалы", 1, 6 * 60), // 1
                new Excursion("Литературно-мемориальный музей Ф.М. Достоевского", 2, 4 * 60), // 2
                new Excursion("Казанский собор", 3, 4 * 60), // 3
                new Excursion("Кунсткамера", 4, (int) (3.5 * 60)), // 4
                new Excursion("Екатерининский дворец", 5, (int) (1.5 * 60)), // 5
                new Excursion("Зоологический музей", 6, (int) (5.5 * 60)), // 6
                new Excursion("Петропавловская крепость", 7, 10 * 60), // 7
                new Excursion("Русский музей", 8, 5 * 60), // 8
                new Excursion("Спас на Крови", 9, 2 * 60), // 9
                new Excursion("Петропавловская крепость", 10, 5 * 60), // 10
                new Excursion("Эрмитаж", 11, 8 * 60), // 11
                new Excursion("Зимний дворец Петра I", 12, 7 * 60), // 12
                new Excursion("Музей восковых фигур", 13, 2 * 60), // 13
                new Excursion("Петербургский музей кукол", 14, 60), // 14
                new Excursion("Ленинградский зоопарк", 15, 9 * 60), // 15
                new Excursion("Музей современного искусства Эрарта", 16, 7 * 60), // 16
                new Excursion("Медный всадник", 17, 60), // 17
                new Excursion("Музей микроминиатюры «Русский Левша»", 18, 3 * 60), // 18
                new Excursion("Музей обороны и блокады Ленинграда", 19, 2 * 60), // 19
                new Excursion("Навестить друзей", 20, 12 * 60) // 20
        };
    }

}
