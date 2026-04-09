#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int arr[1001][1001]; //0,1,2 상태 저장
    int dist[1001][1001]= {0}; //거리

    // 4방향
    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, 1, -1};

    // BFS를 위한 큐
    // pair<int,int> = (row, col)
    queue<pair<int, int>> q;

    //시작점 1곳
    int statRow, startCol;


    for (int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> arr[i][j];
            
            // BFS 시작점 2
            if(arr[i][j] == 2) {
                q.push({i,j});
                dist[i][j] = 0;
            }else {
                dist[i][j] = -1;
            }
        }
    }

    // 큐 탐색 시작
    while (!q.empty()) {
        // 큐 처음 값 <r,x>
        int row = q.front().first;
        int col = q.front().second;
        q.pop();

        // 상하좌우 4방향 dir
        for(int dir = 0; dir < 4; dir++) {
            int nextRow = row + dx[dir];
            int nextCol = col + dy[dir];

            // 범위 밖이면 무시
            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m)
            continue;

            // 갈 수 있는 곳 && 아직 방문 안한 곳
            if(arr[nextRow][nextCol] == 1 && dist[nextRow][nextCol] == -1 ) {
               dist[nextRow][nextCol] = dist[row][col] +1;
               
                q.push({nextRow, nextCol}); //큐에 추가
                
            }

        }

    }
    
   for (int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if (arr[i][j] == 0) {
                cout << "0" << " ";
            } else {
                cout << dist[i][j] << " ";
            }
        }
        cout << "\n";
    }

    return 0;
}