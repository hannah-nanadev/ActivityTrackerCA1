import java.util.Arrays;

public class Activity {

    //Variables input by csv
    private String type;
    private String date;
    private int duration;
    private double distance;
    private int avgHeartRate;

    //Variables calculated based on above
    private String intensityLevel;
    private double intensityValue;
    private double kmPerHour;

    //Constructor
    public Activity(String type, String date, int duration, double distance, int heartRate)
    {
        //CSV Variables
        this.type = type;
        this.date = date;
        this.duration = duration;
        this.distance = distance;
        this.avgHeartRate = heartRate;

        //Calculated variables
        this.kmPerHour = kmPH(duration, distance);
    }

    //Internal calculation methods
    private double kmPH(int duration, double distance)
    {
        double dduration = (double)duration/60; //Converts minutes to hours + converts int to double for calculation
        return distance/dduration; //speed = distance/time
    }

    private double intValue(String intensity, String type)
    {
        return 0;
    }

    //Determines which of the below methods to run based on activity type
    private String calcIntensity(String type, double kmph)
    {
        switch(type)
        {
            case "Swimming":
                break;
            case "Running":
                break;
            case "Cycling":
                break;
            default:
                return "ERROR";
        }
        return "FUNCTION NOT FINISHED YET";
    }

    private String swimIntensity(double kmph)
    {
        switch(kmph)
        {
            case kmph<=0.5:
                return "Very Light";
            case kmph<=1.25:
                return "Light";
            case kmph<=2:
                return "Moderate";
            case kmph<=2.75:
                return "Vigorous";
            default:
                return "Very Vigorous";
        }
    }

}
