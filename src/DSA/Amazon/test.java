package DSA.Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class test {

        static class State {
            int curDigit, pos;      // curDigit: unit digit after last addition, pos: position in config being matched
            String value;           // reconstructed minimal configuration so far
            State(int curDigit, int pos, String value) {
                this.curDigit = curDigit;
                this.pos = pos;
                this.value = value;
            }
        }

        public static String missingDigits(String config, int x, int y) {
            int n = config.length();
            // Use priority queue for lexicographical minimum result
            Queue<State> queue = new PriorityQueue<>(Comparator.comparing(s -> s.value));
            // To avoid revisiting same state (unit digit, config position), use a boolean array
            boolean[][] visited = new boolean[10][n + 1]; // curDigit in [0..9], pos in [0..n]

            // Start with curDigit=0, pos=0, value=""
            queue.offer(new State(0, 0, ""));

            while (!queue.isEmpty()) {
                State st = queue.poll();
                int cur = st.curDigit;
                int pos = st.pos;
                String val = st.value;

                // Completed config of correct length
                if (pos == n) {
                    return val;
                }

                for (int add : new int[]{x, y}) {
                    int nextCur = (cur + add) % 10;
                    int nextPos = pos;

                    // Try to match config char at this position
                    if (config.charAt(nextPos) - '0' == nextCur) {
                        nextPos++; // matched, move forward in config string
                        if (!visited[nextCur][nextPos]) {
                            visited[nextCur][nextPos] = true;
                            queue.offer(new State(nextCur, nextPos, val + nextCur));
                        }
                    }
                }
            }
            // If no reconstruction possible
            return "-1";
        }

    public static void main(String[] args) {
        String config = "521";
        int x = 5, y = 5;
        System.out.println(missingDigits(config, x, y));
    }

}
