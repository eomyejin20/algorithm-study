package org.example.week04;

import java.util.*;
import java.io.*;

// boj_7576_토마토.java
// 상하좌우 이동, 한칸 이동 바용 같음, 최단거리 = BFS
// 시작점이 여러개인 BFS
public class Boj7576 {
    static int n, m; // 상자 크기
    static int[][] box; // 토마토 상자 입력

    //인접 토마토 좌우상하
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        Queue<int[]> queue = new LinkedList<>(); // BFS에 쓸 큐, 토마토 좌표 저장

        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 빠르게 받기 위한 BufferedReader 생성
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄 입력을 공백 기준으로 나눔

        m = Integer.parseInt(st.nextToken()); // 상자 가로 크기
        n = Integer.parseInt(st.nextToken()); // 상자 세로 크기

        // 토마토 상자 및 익는 시간 배열
        box = new int[n][m];

        // 배열 입력 및 초기화
        for(int i=0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++){
                // 토마토 입력 받음
                box[i][j] = Integer.parseInt(st.nextToken());

                //시작 점이 여러개이므로 시작점(1)인 애들 바로 큐에 입력
                if(box[i][j]==1){
                    queue.offer(new int[]{i,j});
                }
                // 1익은 토마토, 0 안 익은 토마토
            }
        }

        //BFS
        while(!queue.isEmpty()){ // 큐가 비어있지 않을 때 반복
            int[] now = queue.poll(); //가장 먼저 들어온 애 내보냄(현재 위치)
            int x = now[0];
            int y = now[1];

            for(int i = 0; i<4; i++){
                //현재 위치를 기준으로 상하좌우 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 토마토 방문
                if(ny<m && ny>=0 && nx<n && nx>=0 && box[nx][ny]==0){
                    box[nx][ny] = box[x][y] + 1; // 익은 토마토랑 날짜 체크
                    queue.offer(new int[]{nx, ny}); // 새로운 익은 토마토 큐에 추가
                }
            }
        }

        int max = Integer.MIN_VALUE; // 최댓값
        boolean hasZero = false;// 0있나 없나 확인

        // 배열 전체 확인, 0있으면 다 못익음, 걸린 날짜: 최댓값-1 출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j]==0){
                    // 아직 안 익은 토마토 있음
                    hasZero = true;
                }
                max = Math.max(max, box[i][j]);// 걸린 날짜
            }
        }

        if (hasZero){
            System.out.println(-1);
        }else {
            System.out.println(max-1);
        }

    }
}
