#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {

    // (우선순위, 원래 위치) 저장할 큐 생성
    queue<pair<int, int>> q;

    // 프로세스 실행 순서 저장
    int answer = 0;

    // 프로세스를 입력 순서대로 큐에 저장
    for(int i = 0; i < priorities.size(); i++) {
        q.push({priorities[i], i});
    }

    // 큐가 빌 때까지 반복
    while(!q.empty()) {

        // 현재 프로세스의 우선순위와 위치 저장
        int priority = q.front().first;
        int index = q.front().second;

        // 현재 프로세스를 큐에서 꺼내기
        q.pop();

        // 현재 프로세스보다 높은 우선순위 존재 여부
        bool isHigher = false;

        // 비교용 큐 복사
        queue<pair<int, int>> temp = q;

        // 큐 전체 탐색
        while(!temp.empty()) {

            // 더 높은 우선순위가 존재하면
            if(temp.front().first > priority) {
                isHigher = true;
                break;
            }

            temp.pop();
        }

        // 더 높은 우선순위가 있으면
        // 현재 프로세스를 다시 큐 뒤에 삽입
        if(isHigher) {
            q.push({priority, index});
        }

        // 현재 프로세스가 가장 높은 우선순위라면 실행
        else {

            // 실행 순서 증가
            answer++;

            // 찾고 있는 프로세스라면 실행 순서 반환
            if(index == location) {
                return answer;
            }
        }
    }

    return answer;
}