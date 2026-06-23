#include <string>
#include <vector>

using namespace std;
/**
 * 알고리즘 순서
 * 1. brown+yellow = 전체크기를 구함
 * 2. 약수 후보를 구함 9면 33
 */

vector<int> solution(int brown, int yellow) {
    vector<int> answer;

    int total = brown + yellow;
    for(int  height = 3; height <= total; height++) {

        if(total % height == 0) {
            int width = total / height;

            if((width-2)*(height-2) == yellow) {
                answer.push_back(width);
                answer.push_back(height);

                return answer;
            }
        }
    }

    return answer;
}