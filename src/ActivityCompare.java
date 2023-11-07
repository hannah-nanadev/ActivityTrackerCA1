import java.util.Comparator;
//Recieved help for this from Ciara Clerkin, GD2A
public class ActivityCompare implements Comparator<Activity>{
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return a1.getType().compareTo(a2.getType());
    }
}
