import java.util.Comparator;
public class CalorieCompare implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return Double.compare(a1.getCalsBurned(), a2.getCalsBurned());
    }
}
