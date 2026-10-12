// class Solution {
//     public int daysBetweenDates(String date1, String date2) {
//         return Math.abs(toDays(date1) - toDays(date2));
//     }
// }

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDays(date1) - toDays(date2));
    }

    public int toDays(String date) {
        String[] arr = date.split("-");

        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);

        int totalDays = 0;

        // Count days of previous years
        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // Days in each month
        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Handle leap year
        if (isLeapYear(year)) {
            days[1] = 29;
        }

        // Count days of previous months
        for (int m = 0; m < month - 1; m++) {
            totalDays += days[m];
        }

        // Add days of current month
        totalDays += day;

        return totalDays;
    }

    public boolean isLeapYear(int year) {
        return year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0);
    }
}
