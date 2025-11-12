package DSA.Amazon;

import java.util.*;

public class test1 {
    public static int minimizeReleaseDays(List<Integer> schedule, List<Integer> refactorDays) {
        int n = schedule.size();
        int m = refactorDays.size();
        int[] lastRelease = new int[m];
        Arrays.fill(lastRelease, -1);

        // Find latest release day for each module
        for (int day = 0; day < n; day++) {
            int mod = schedule.get(day);
            if (mod > 0) {
                lastRelease[mod - 1] = day;
            }
        }

        // If any module never appears in schedule, impossible
        for (int i = 0; i < m; i++) {
            if (lastRelease[i] == -1) return -1;
        }

        boolean[] used = new boolean[n];
        int[] work = new int[n];

        // Mark release days
        for (int i = 0; i < m; i++) {
            work[lastRelease[i]] = i + 1; // release marker
        }

        int total = 0;

        // Simulate day by day
        for (int day = 0; day < n; day++) {
            int mod = work[day];
            if (mod == 0) continue;

            int moduleIdx = mod - 1;
            int need = refactorDays.get(moduleIdx);

            // Assign available refactor days before release
            for (int j = day - 1; j >= 0 && need > 0; j--) {
                if (!used[j] && work[j] == 0) {
                    used[j] = true;
                    need--;
                }
            }

            // Not enough refactor time before release
            if (need > 0) return -1;

            total = day + 1;
        }

        return total;
    }

    public static void main(String[] args) {
        List<Integer> schedule = Arrays.asList(1, 2, 3, 1, 3, 2, 2, 1, 1, 3);
        List<Integer> refactorDays = Arrays.asList(1, 2, 2);

        int result = minimizeReleaseDays(schedule, refactorDays);
        System.out.println(result);

    }
}
