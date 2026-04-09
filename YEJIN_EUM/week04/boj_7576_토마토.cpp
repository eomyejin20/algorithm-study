#include <iostream>
#include <queue>
using namespace std;

int main() {
    int M, N;
    cin >> M >> N;
    int arr[1001][1001]; //-1,0,1 상태 저장
    int dist[1001][1001]= {0}; // 익는 날짜 거리로 저장

    // 4방향
    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, 1, -1};

    // BFS를 위한 큐
    // pair<int,int> = (row, col)
    queue<pair<int, int>> q;


    for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            cin >> arr[i][j];
            
            // 처음부터 익은 토마토는 큐에 넣음 (BFS 시작점)
            if(arr[i][j] == 1) {
                q.push({i,j});
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
            if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M)
            continue;

            // 안 익은 토마토
            if(arr[nextRow][nextCol] == 0) {
                arr[nextRow][nextCol] = 1; //익히기
                // 날짜 증가
                // 주위 익혀진 토마토는 현재 날짜에 +1 증가
                dist[nextRow][nextCol] = dist[row][col] +1;
                q.push({nextRow, nextCol}); //큐에 추가
                
            }

        }

    }
    

    int result = 0;
   for (int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(arr[i][j] == 0) {
                cout << -1 << endl;
                return 0;
            }
            result = max(result, dist[i][j]);
        }
    }
    

    cout << result << endl;

    return 0;
}