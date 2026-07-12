#include <string>
#include <vector>
#include <queue>

using namespace std;

/**
 * 알고리즘 순서
 * 1. 모든 스코빌 지수를 큐에 저장
 * 2. 가장 작은 값이 K 이상이 될 때까지 반복
 * 3. 가장 작은 두 값을 꺼내 새로운 음식 생성
 *    (첫 번째 + 두 번째 * 2)
 * 4. 섞은 음식을 다시 힙에 넣고 횟수 증가
 */

int solution(vector<int> scoville, int K) {

    priority_queue<int, vector<int>, greater<int>> pq;

    // 힙에 저장
    for (int i = 0; i < scoville.size(); i++) {
        pq.push(scoville[i]);
    }

    int count = 0;

    while (pq.top() < K) {

        // 더 이상 섞을 음식이 없으면 실패
        if (pq.size() == 1)
            return -1;

        int first = pq.top();
        pq.pop();

        int second = pq.top();
        pq.pop();

        pq.push(first + second * 2);
        count++;
    }

    return count;
}