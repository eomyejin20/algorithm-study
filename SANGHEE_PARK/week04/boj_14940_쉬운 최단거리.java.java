package org.example.week04;

import java.util.*;
import java.io.*;

// boj_14940_쉬운 최단거리.java
// 상하좌우 이동, 한칸 이동 바용 같음, 최단거리 = BFS
public class Boj14940 {
    static int n, m;          // 지도 크기
    static int[][] map;       // 입력 지도
    static int[][] dist;      // 최단거리 저장

    //상하좌우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Queue<int[]> queue = new LinkedList<>(); // BFS에 쓸 큐, 좌표 x,y 저장 때문에 int[]

        // 시작점을 저장할 변수
        int startX = 0;
        int startY = 0;

        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 빠르게 받기 위한 BufferedReader 생성
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄 입력을 공백 기준으로 나눔

        n = Integer.parseInt(st.nextToken()); // 세로 크기
        m = Integer.parseInt(st.nextToken()); // 가로 크기

        // 지도 및 최던거리 저장 배열
        map = new int[n][m];
        dist =new int[n][m];

        // 배열 입력 받음
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()); // 입력 줄 바꿈
            for(int j=0; j<m; j++){
                // 지도를 입력 받음 n*m크기  map[][]
                map[i][j] = Integer.parseInt(st.nextToken());

                //dist를 전부 -1로 초기화
                dist[i][j] = -1; // 최단거리 배열 초기화

                // 시작점 값이 2일때 죄표 기억 (sx,sy)
                if(map[i][j]==2){
                    startX = i;
                    startY = j;
                }

                // 입력값이 0인 곳(벽)은 dist를 0으로 바꿔둠
                if(map[i][j]==0){
                    dist[i][j]=0;
                }

            }
        }

        // BFS
        // 시작점0, BFS 돌면서 거리 갱신함.
        queue.offer(new int[]{startX,startY}); // 큐에 시작점 입력
        dist[startX][startY]=0; //최단거리 배열에 시작점 0으로 변경

        while(!queue.isEmpty()){ // 큐가 비어있지 않을 때 반복
            int[] now = queue.poll(); //현재 위치 큐에서 내보냄
            int x = now[0];
            int y = now[1];

            for(int i = 0; i < 4; i++){
                // 현재 위치를 기준으로 상하좌우 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 조건
                // 1. 범위 안인가?
                // 2. 갈 수 있는 땅인가?
                // 3. 아직 방문 안 했느가?
                if( ny<m && ny>=0 && nx<n && nx>=0 && map[nx][ny]==1 && dist[nx][ny]==-1){ //배열 인덱스 0부터 시작 주의
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx,ny});
                }

            }
        }

        // 출력 형식 지정
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
