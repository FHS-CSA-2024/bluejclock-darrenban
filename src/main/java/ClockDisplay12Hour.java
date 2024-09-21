package src.main.java;

public class ClockDisplay12Hour{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String amOrPM;
    private String display;

    public ClockDisplay12Hour(){
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        amOrPM = "AM";
        updateDisplay();
    }

    public ClockDisplay12Hour(int hour, int minute){
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);

        if(hour == 0){
            hours.setValue(12);
            amOrPM = "AM";
        }
        else if(hour == 12){
            hours.setValue(12);
            amOrPM = "PM";
        }
        else if(hour < 12){
            hours.setValue(hour);
            amOrPM = "AM";
        }
        else{
            hours.setValue(hour - 12);
            amOrPM = "PM";
        }

        
        minutes.setValue(minute);
        updateDisplay();
    }

    public void timeTick(){
        minutes.increment();

        if(minutes.getValue() == 0){
            if (hours.getValue() == 11){
                hours.increment();
                if(amOrPM.equals("AM"))
                {
                amOrPM = "PM";
                }
                else{
                amOrPM = "AM";
                }
            }
            else if(hours.getValue() == 12){
            hours.setValue(1);
            }
            else{
            hours.increment();
            }
        }

        updateDisplay();
    }

    public void setTime(int hour, int minute){
        
        if(hour == 0){
            hours.setValue(12);
            amOrPM = "AM";
        }
        else if(hour == 12){
            hours.setValue(12);
            amOrPM = "PM";
        }
        else if(hour < 12){
            hours.setValue(hour);
            amOrPM = "AM";
        }
        else{
            hours.setValue(hour - 12);
            amOrPM = "PM";
        }

        
        minutes.setValue(minute);
        updateDisplay();
    }

    public String getTime(){
        
        return display;
        
    }

    private void updateDisplay(){
        String hourString;

        if(hours.getValue() == 0 || hours.getValue() == 12){
            hourString = "12";
        }
        else{
        hourString = hours.getDisplayValue();
        }

        String minuteString = minutes.getDisplayValue();
        display = hourString + ":" + minuteString + " " + amOrPM;
    }
}
