#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N;
    cin >> N;

    int P[1000];
    int sum = 0;
    int total = 0;

    for (int i = 0; i < N; i++) {
        cin >> P[i];
    }

    sort(P, P + N);

    for (int  i = 0; i < N; i++) {
        sum += P[i];
        total += sum;
    }

    cout << total << endl;

    return 0;
}