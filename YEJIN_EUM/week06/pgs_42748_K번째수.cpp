#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {

    // 결과를 저장할 벡터
    vector<int> answer;

    // commands의 각 명령을 순서대로 처리
    for(int i = 0; i < commands.size(); i++) {

        // 시작 위치, 끝 위치, k번째 위치 저장
        // 문제는 1번부터 시작하므로 인덱스에 맞게 -1 처리
        int start = commands[i][0] - 1;
        int end = commands[i][1] - 1;
        int k = commands[i][2] - 1;

        // 잘라낸 배열 저장용 벡터
        vector<int> temp;

        // start ~ end 구간 배열 자르기
        for(int j = start; j <= end; j++) {
            temp.push_back(array[j]);
        }

        // 잘라낸 배열 오름차순 정렬
        sort(temp.begin(), temp.end());

        // 정렬된 배열의 k번째 값 저장
        answer.push_back(temp[k]);
    }

    // 최종 결과 반환
    return answer;
}