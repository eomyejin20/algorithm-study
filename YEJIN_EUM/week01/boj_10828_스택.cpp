#include <iostream>
#include <string>
using namespace std;

int main() {
    int N;
    cin >> N;

    int stack[10000];
    int top = -1;
    int value;
    string cmd;

    for(int i = 0; i < N; i++) {
        cin >> cmd;

        if( cmd == "push"){
            cin >> value;
            stack[++top] = value;
        }

        else if (cmd == "pop") {
            if (top == -1) 
            cout << -1 << "\n";
            else cout << stack [top--] << "\n";
        }

        else if (cmd == "size") {
            cout << top + 1 << "\n";
        }

        else if (cmd == "empty") {
            if(top == -1)
            cout << 1 << "\n";
            else cout << 0 << "\n";
        }

        else if(cmd == "top") {
            if(top == -1)
            cout << -1 << "\n";
            else cout << stack[top] << "\n";
        }
    }

    return 0;
}