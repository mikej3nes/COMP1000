import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;

public class Lab6 {

    public String getPlan(LocalDate dateOfPlan, String weatherPrediction, LocalTime firstAppointment, LocalTime lastAppointment) {
        // Check if it's a weekend
        boolean isWeekend = dateOfPlan.getDayOfWeek() == DayOfWeek.SATURDAY || dateOfPlan.getDayOfWeek() == DayOfWeek.SUNDAY;

        // Early return if weather is bad
        if (weatherPrediction.equalsIgnoreCase("Rainy") || weatherPrediction.equalsIgnoreCase("Snowy")) {
            return "Please cancel or reschedule your appointments on " + dateOfPlan + ".";
        }

        // Determine train schedule based on the day
        LocalTime firstTrain = isWeekend ? LocalTime.of(10, 0) : LocalTime.of(6, 0);
        LocalTime lastTrain = isWeekend ? LocalTime.of(22, 0) : LocalTime.of(23, 0);

        // Check if the appointment times are within the train schedules
        if (!firstAppointment.isBefore(firstTrain) && !lastAppointment.isAfter(lastTrain.minusHours(1))) {
            // Recommend taking the train
            return "Please take the train to go to the city, and the train to get back home on " + dateOfPlan + ".";
        } else {
            // Recommend driving if the appointment times don't align with train times
            return "Please drive on " + dateOfPlan + ".";
        }
    }
}
