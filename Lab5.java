import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyTravelPlannerTest {

    private MyTravelPlanner planner;

    @BeforeEach
    void setUp() {
        planner = new MyTravelPlanner();
    }

    // Example of a weekday, sunny weather, appointments fit train schedule
    @Test
    void testWeekdaySunnyWithTrainSchedule() {
        LocalDate date = LocalDate.of(2023, 9, 25); // Monday
        String output = planner.getPlan(date, "Sunny", LocalTime.of(7, 0), LocalTime.of(20, 0));
        assertEquals("Please take the train to go to the city, and the train to get back home on " + date + ".", output);
    }

    // Example of a weekend, snowy weather
    @Test
    void testWeekendSnowyWeather() {
        LocalDate date = LocalDate.of(2023, 9, 30); // Saturday
        String output = planner.getPlan(date, "Snowy", LocalTime.of(11, 0), LocalTime.of(19, 0));
        assertEquals("Please cancel or reschedule your appointments on " + date + ".", output);
    }

    // More test cases should be added below to cover various scenarios

    // Test cases for rainy weather on weekdays
    @Test
    void testWeekdayRainyWeather() {
        LocalDate date = LocalDate.of(2023, 10, 3); // Tuesday
        String output = planner.getPlan(date, "Rainy", LocalTime.of(9, 0), LocalTime.of(17, 0));
        assertEquals("Please cancel or reschedule your appointments on " + date + ".", output);
    }

    // Test case for sunny weather but appointments outside train schedule on weekend
    @Test
    void testWeekendSunnyOutsideTrainSchedule() {
        LocalDate date = LocalDate.of(2023, 10, 1); // Sunday
        String output = planner.getPlan(date, "Sunny", LocalTime.of(9, 0), LocalTime.of(21, 0));
        assertEquals("Please drive on " + date + ".", output);
    }

  // Test case for appointments right at the start of the weekday train schedule
  @Test
  void testWeekdayAppointmentAtTrainScheduleStart() {
      LocalDate date = LocalDate.of(2023, 10, 2); // Monday
      String output = planner.getPlan(date, "Sunny", LocalTime.of(6, 0), LocalTime.of(18, 0));
      assertEquals("Please take the train to go to the city, and the train to get back home on " + date + ".", output);
  }
  
  // Test case for appointments right at the end of the weekend train schedule
  @Test
  void testWeekendAppointmentAtTrainScheduleEnd() {
      LocalDate date = LocalDate.of(2023, 10, 7); // Saturday
      String output = planner.getPlan(date, "Sunny", LocalTime.of(11, 0), LocalTime.of(22, 0));
      assertEquals("Please take the train to go to the city, and the train to get back home on " + date + ".", output);
  }
  
  // Test case for cloudy weather with appointments barely fitting the train schedule on a weekday
  @Test
  void testWeekdayCloudyWithTightTrainSchedule() {
      LocalDate date = LocalDate.of(2023, 10, 4); // Wednesday
      String output = planner.getPlan(date, "Cloudy", LocalTime.of(6, 30), LocalTime.of(22, 30));
      assertEquals("Please take the train to go to the city, and the train to get back home on " + date + ".", output);
  }
  
  // Test case for appointments outside the train schedule on a sunny weekday, requiring driving
  @Test
  void testWeekdaySunnyOutsideTrainSchedule() {
      LocalDate date = LocalDate.of(2023, 10, 5); // Thursday
      String output = planner.getPlan(date, "Sunny", LocalTime.of(5, 0), LocalTime.of(23, 30));
      assertEquals("Please drive on " + date + ".", output);
  }
  
  // Test case for a very late last appointment on a sunny weekend, beyond the last train
  @Test
  void testWeekendSunnyLateLastAppointment() {
      LocalDate date = LocalDate.of(2023, 10, 8); // Sunday
      String output = planner.getPlan(date, "Sunny", LocalTime.of(11, 0), LocalTime.of(23, 0));
      assertEquals("Please drive on " + date + ".", output);
  }

}
