#include <string>
#include <vector>
#include <algorithm>

using namespace std;
/**
 * 알고리즘 순서
 * 1. 수포자의 패턴을 저장
 * 2. 정답과 비교해 맞히면 count++
 * 3. count가 가장 큰 수포자의 배열을 리턴
 */

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> p1 = {1, 2, 3, 4, 5};
    vector<int> p2 = {2, 1, 2, 3, 2, 4, 2, 5};
    vector<int> p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    vector<int> score(3, 0);

    for (int i = 0; i < answers.size(); i++) {
        if (answers[i] == p1[i % p1.size()])
            score[0]++;

        if (answers[i] == p2[i % p2.size()])
            score[1]++;

        if (answers[i] == p3[i % p3.size()])
            score[2]++;
    }

    int maxScore = *max_element(score.begin(), score.end());

    for (int i = 0; i < 3; i++) {
        if (score[i] == maxScore)
            answer.push_back(i + 1);
    }

    return answer;
}