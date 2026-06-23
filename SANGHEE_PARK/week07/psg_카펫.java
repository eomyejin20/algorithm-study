class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        // w >= h 조건을 위해 w를 큰 값부터 탐색
        for (int w = total; w >= 1; w--) {
            if (total % w != 0) continue; // 약수가 아니면 스킵

            int h = total / w;

            if (w < h) break; // w >= h 조건 위반 시 종료

            // 노란 격자 조건: (w-2) * (h-2) == yellow
            // h >= 3 이어야 노란색 공간이 존재
            if (h < 3) continue;

            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};
            }
        }

        return new int[]{};
    }
}