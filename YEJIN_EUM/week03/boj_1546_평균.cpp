#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;

    int num[1000];
    int max = 0;
    int sum = 0;

    for (int i = 0; i < N; i++) {
        cin >> num[i];

        if (num[i] > max) {
            max = num[i+1];
        }
    }

    for (int i = 0; i < N; i++) {
        num[i] = num[i]/max*100;
        sum += num[i];
    }

    cout << sum / N << endl;

    return 0;
}