
#include <string>
#include <vector>

using namespace std;

/**
 * 알고리즘 순서
 * 1~n까지 소수의 개수를 출력하는 문제
 * 소수는 1과 자기 자신으로만 나누어짐
2345가있으면 반복문 돌아가면서 자신의 배수를 제거 
 * 1. 2~N까지 소수찾기 반복문
 * 2. 배수를 제거 2, 3, 5,7등 소수의 배수제거 
 */

int solution(int n) {
    int answer = 0;
    // 소수로 초기화
    vector<bool> isPrime(n + 1, true);

    for(int i = 2; i <= n; i++) {

        //소수라면
        if( isPrime[i] ) {

            // 소수의 배수를 제거
            for(int j = i * 2; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    for(int k = 2; k <= n; k++) {
        if( isPrime[k] ) {
            answer++;
        }
    }


    return answer;
}