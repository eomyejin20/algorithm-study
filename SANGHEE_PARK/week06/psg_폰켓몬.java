package org.example.week06;

import java.util.HashSet;

public class PSG1845 {
    class Solution {
        public int solution(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num);
            return Math.min(set.size(), nums.length / 2);
        }
    }
}
