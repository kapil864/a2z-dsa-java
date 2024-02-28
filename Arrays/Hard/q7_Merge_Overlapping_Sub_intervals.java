import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class q7_Merge_Overlapping_Sub_intervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<List<Integer>> intervals = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> interval = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                interval.add(sc.nextInt());
            }
            intervals.add(interval);
        }
        List<List<Integer>> mergedIntervals = mergeIntervalsOptimal(intervals);
        for (List<Integer> l : mergedIntervals) {
            System.out.println(l);
        }
        sc.close();
    }

    // Sort the array and look for next interval -> is interval can be extended , or
    // it is a part of interval
    // TC = O(NlogN +2N)
    private static List<List<Integer>> mergeIntervalsBrute(List<List<Integer>> intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        intervals.sort(new Comparator<List<Integer>>() {

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) == o2.get(0)) {
                    if (o1.get(1) > o2.get(1)) {
                        return 1;
                    }
                    return -1;
                } else if (o1.get(0) > o2.get(0)) {
                    return 1;
                }
                return -1;
            }

        });

        int idx = 0;
        while (idx < intervals.size()) {

            if (!ans.isEmpty() && intervals.get(idx).get(0) <= ans.get(ans.size() - 1).get(1)) {
                idx++;
                continue;
            }

            List<Integer> newInterval = new ArrayList<>();
            int start = intervals.get(idx).get(0);
            int ed = intervals.get(idx).get(1);

            for (int i = idx + 1; i < intervals.size(); i++) {
                if (intervals.get(i).get(0) <= ed) {
                    ed = Integer.max(ed, intervals.get(i).get(1));
                } else {
                    break;
                }
            }
            newInterval.add(start);
            newInterval.add(ed);
            ans.add(newInterval);
            idx++;
        }

        return ans;
    }

    // optimal Approach
    private static List<List<Integer>> mergeIntervalsOptimal(List<List<Integer>> intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        intervals.sort(new Comparator<List<Integer>>() {

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) == o2.get(0)) {
                    if (o1.get(1) > o2.get(1)) {
                        return 1;
                    }
                    return -1;
                } else if (o1.get(0) > o2.get(0)) {
                    return 1;
                }
                return -1;
            }

        });

        int idx = 0;
        while (idx < intervals.size()) {

            if (!ans.isEmpty() && intervals.get(idx).get(0) <= ans.get(ans.size() - 1).get(1)) {
                idx++;
                continue;
            }

            List<Integer> newInterval = new ArrayList<>();
            int start = intervals.get(idx).get(0);
            int ed = intervals.get(idx).get(1);

            for (int i = idx + 1; i < intervals.size(); i++) {
                if (intervals.get(i).get(0) <= ed) {
                    ed = Integer.max(ed, intervals.get(i).get(1));
                } else {

                    // break the loop since the all intervals are checked and this next interval is not overlapping
                    idx = i;
                    break;
                }
            }
            newInterval.add(start);
            newInterval.add(ed);
            ans.add(newInterval);
            idx++;
        }

        return ans;
    }

}
