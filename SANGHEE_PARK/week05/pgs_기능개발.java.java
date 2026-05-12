package week05;

// pgs_기능개발.java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        ArrayList<Integer> list = new ArrayList<>();

        // 첫 번째 숫자는 무조건 추가
        list.add(arr[0]);

        // 이전 숫자와 다를 때만 추가
        for(int i = 1; i < arr.length; i++) {

            if(arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        // ArrayList -> int 배열 변환
        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}