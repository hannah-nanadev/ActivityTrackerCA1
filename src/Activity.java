import java.util.Arrays;

public class Activity {

    //Enum for intensity levels
    enum intensityLevel{
        VeryLight,
        Light,
        Moderate,
        Vigorous,
        VeryVigorous
    }

    //Variables input by csv
    private String type;
    private String date;
    private int duration;
    private double distance;
    private int avgHeartRate;

    //Variables calculated based on above
    private double kmPerHour;
    private intensityLevel level;
    private double intensityValue;
    private double calsBurned;

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
        this.level = calcIntensity(type, this.kmPerHour);
        this.intensityValue = calcIntValue(type, this.level);
        this.calsBurned = calcCalsBurned(duration, this.intensityValue);
    }

    /////Getters
    //For independent variables
    public String getType()
    {
        return type;
    }
    public String getDate()
    {
        return date;
    }
    public int getDuration()
    {
        return duration;
    }
    public double getDistance()
    {
        return distance;
    }
    public int getAvgHeartRate()
    {
        return avgHeartRate;
    }

    //For dependent variables
    public double getKmPerHour()
    {
        return kmPerHour;
    }
    public String getLevel()
    {
        return level.toString();
    }
    public double getIntensityValue()
    {
        return intensityValue;
    }
    public double getCalsBurned()
    {
        return calsBurned;
    }

    /////Setters (updates dependent variables simultaneously where relevant)
    public void setType(String type)
    {
        this.type = type;
        level = calcIntensity(type, kmPerHour);
        intensityValue = calcIntValue(type, level);
        calsBurned = calcCalsBurned(duration, intensityValue);
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public void setDuration(int duration)
    {
        this.duration = duration;
        kmPerHour = kmPH(duration, distance);
        level = calcIntensity(type, kmPerHour);
        intensityValue = calcIntValue(type, level);
        calsBurned = calcCalsBurned(duration, intensityValue);
    }
    private void setDistance(double distance)
    {
        this.distance = distance;
        kmPerHour = kmPH(duration, distance);
        level = calcIntensity(type, kmPerHour);
        intensityValue = calcIntValue(type, level);
        calsBurned = calcCalsBurned(duration, intensityValue);
    }
    private void setAvgHeartRate(int avgHeartRate)
    {
        this.avgHeartRate = avgHeartRate;
    }

    //Override Object method
    public String toString()
    {
        return("Type: "+type
                +"\nDate: " +date
                +"\nDuration: "+duration +"minutes"
                +"\nDistance: "+distance+"km"
                +"\nAverage Heart Rate: "+avgHeartRate+"bpm");
    }






    //Internal calculation methods
    private double kmPH(int duration, double distance)
    {
        double dduration = (double)duration/60; //Converts minutes to hours + converts int to double for calculation
        return distance/dduration; //speed = distance/time
    }

    //Determines which of the below methods to run based on activity type - Gets intensity label
    private intensityLevel calcIntensity(String type, double kmph)
    {
        return switch (type) {
            case "Swimming" -> swimIntensity(kmph);
            case "Running" -> runIntensity(kmph);
            case "Cycling" -> bikeIntensity(kmph);
            default -> null;
        };
    }

    private intensityLevel swimIntensity(double kmph)
    {
        if(kmph<1.25)
            return intensityLevel.VeryLight;
        else if(kmph<2)
            return  intensityLevel.Light;
        else if(kmph<2.75)
            return  intensityLevel.Moderate;
        else if(kmph<3.5)
            return intensityLevel.Vigorous;
        else
            return intensityLevel.VeryVigorous;
    }

    private intensityLevel runIntensity(double kmph)
    {
        if(kmph<4)
            return intensityLevel.VeryLight;
        else if(kmph<8)
            return intensityLevel.Light;
        else if(kmph<12)
            return intensityLevel.Moderate;
        else if(kmph<16)
            return intensityLevel.Vigorous;
        else
            return intensityLevel.VeryVigorous;
    }

    private intensityLevel bikeIntensity(double kmph)
    {
        if(kmph<8)
            return intensityLevel.VeryLight;
        else if(kmph<17)
            return intensityLevel.Light;
        else if(kmph<25)
            return intensityLevel.Moderate;
        else if(kmph<33)
            return intensityLevel.Vigorous;
        else
            return intensityLevel.VeryVigorous;
    }

    //Determines which of the below methods to run based on activity type - Determines intensity value
    private double calcIntValue(String type, intensityLevel level)
    {
        return switch (type) {
            case "Swimming" -> swimIntValue(level);
            case "Running" -> runIntValue(level);
            case "Cycling" -> bikeIntValue(level);
            default -> 0;
        };
    }

    private double swimIntValue(intensityLevel level)
    {
        return switch (level) {
            case VeryLight -> 5;
            case Light -> 6.3;
            case Moderate -> 7.6;
            case Vigorous -> 8.9;
            case VeryVigorous -> 10.2;
            default -> 0;
        };
    }

    private double runIntValue(intensityLevel level)
    {
        return switch (level) {
            case VeryLight -> 4.1;
            case Light -> 7.2;
            case Moderate -> 10;
            case Vigorous -> 15.4;
            case VeryVigorous -> 20.8;
            default -> 0;
        };
    }

    private double bikeIntValue(intensityLevel level)
    {
        return switch (level) {
            case VeryLight -> 2;
            case Light -> 5;
            case Moderate -> 7;
            case Vigorous -> 13;
            case VeryVigorous -> 15;
            default -> 0;
        };
    }

    private double calcCalsBurned(int duration, double intValue)
    {
        return (double)duration*intValue;
    }
}
