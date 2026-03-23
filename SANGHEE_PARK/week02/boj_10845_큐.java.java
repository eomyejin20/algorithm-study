package org.example.week02;

import java.io.*;
import java.util.*;

//boj_10845_큐.java
public class Boj10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] queue = new int [n]; //n 보다 큰 공간은 필요로 하지 않음
        int front; //머리쪽 인덱스 값, pop시 참조
        int rear; //꼬리쪽 인덱스 값, push시 참조
        front = rear = 0; // 초기값 설정


        for (int i=0; i<n; i++ ){ //n만큼 명령어 받음
            String[] cmd = br.readLine().split(" ");// 명령어 입력 받음

            switch (cmd[0]){// 명령어 첫 칸에 따른 명령어 실행
                case "push":
                    queue[rear++] = Integer.parseInt(cmd[1]); //큐의 맨 뒤에 숫자 push, rear값 증가
                    //System.out.println(queue[rear-1]);//rear 위치에 값이 먼저 들어간 후, rear++이 수행 됨
                    break;
                case "pop":
                    if(front==rear){ //큐 비었으면 -1 출력
                        System.out.println(-1);
                    }else {
                        int popValue = queue[front++]; //큐의 맨 앞의 숫자 pop후 front 증가
                        System.out.println(popValue);
                    }
                    break;
                case "size":
                    System.out.println(rear-front); //큐 사이즈 출력 (맨 뒤 인덱스 - 맨 앞 인덱스)
                    break;
                case "empty":
                    if(front==rear){ //큐 비었으면 -1 출력
                        System.out.println(1);
                    }else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(front==rear){ //큐 비었으면 -1 출력
                        System.out.println(-1);
                    }else {
                        System.out.println(queue[front]);
                    }
                    break;
                case "back":
                    if(front==rear){ //큐 비었으면 -1 출력
                        System.out.println(-1);
                    }else {
                        System.out.println(queue[rear-1]);// push시 +1햇으므로 -1이 큐의 가장 마지막 부분
                    }
                    break;
            }
        }

    }
}
