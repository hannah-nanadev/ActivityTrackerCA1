import java.util.Comparator;
public class LevelCompare implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return a1.getLevel().compareTo(a2.getLevel());
    }
}
