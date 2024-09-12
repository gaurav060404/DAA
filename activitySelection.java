import java.util.Arrays;
import java.util.Comparator;

public class activitySelection {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int finish[] = { 2, 4, 6, 7, 9, 9 };

        int n = start.length;

        printMaxActivities(start, finish, n);
    }

    private static void printMaxActivities(int[] start, int[] finish, int n) {
        // Create an array of activities
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], finish[i]);
        }

        // Sort activities by finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        for (int i = 0; i < activities.length; i++) {
            System.out.println("(" + activities[i].start + ", " + activities[i].finish + ") " );
        }

        System.out.println("Following activities are selected: ");

        // The first activity always gets selected
        int i = 0;
        System.out.print("(" + activities[i].start + ", " + activities[i].finish + ") ");

        // Consider the rest of the activities
        for (int j = 1; j < n; j++) {
            // If this activity has a start time greater than or equal to the finish time of the previously selected activity
            if (activities[j].start >= activities[i].finish) {
                System.out.print("(" + activities[j].start + ", " + activities[j].finish + ") ");
                i = j;
                System.out.println(i);
            }
        }
    }

    // Activity class to store start and finish times
    static class Activity {
        int start, finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}
