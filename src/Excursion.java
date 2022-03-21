public class Excursion {

    private final String excursionName;
    private final int importance;
    private final int time;

    public Excursion(String excursionName, int importance, int time) {
        this.excursionName = excursionName;
        this.importance = importance;
        this.time = time;
    }

    public String getExcursionName() {
        return excursionName;
    }

    public int getImportance() {
        return importance;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Название достопримечательности: " + getExcursionName() + ", " +
                "затраты времени на посещение: " + (double) getTime() / 60 + " ч, " +
                "важность посещения: " + getImportance();
    }
}
