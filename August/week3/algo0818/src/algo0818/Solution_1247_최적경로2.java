package algo0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로2 {

    static int T, N, comY, comX, homeY, homeX, min;
    static int[][] cust; // 고객의 정보 ( src )
    // 순열, 조합, 부분집합 
    static int[] tgt;
    static boolean[] select;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine()); // 고객수
            cust = new int[N][2]; // 0: y, 1: x
            select = new boolean[N];
            tgt = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            comY = Integer.parseInt(st.nextToken());
            comX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());

            // N 개의 고객
            for (int i = 0; i < N; i++) {
                cust[i][0] = Integer.parseInt(st.nextToken());
                cust[i][1] = Integer.parseInt(st.nextToken());
            }

            // 순열
            perm(0); // 0: tgt 의 맨 앞부터 채우겠다.
            System.out.println("#" + t + " " + min);
        }

}

static void perm(int tgtIdx) {
    // 기저조건
    if( tgtIdx  == N ) {
        // complete code
        // 현재 순열의 경우의 수가 하나 완성된 상태
        // 거리계산 후 최소값인지 확인, 갱신
        
        // 회사 - 첫번째 고객
        int sum = distance(comY, comX, cust[ tgt[0] ][0], cust[ tgt[0] ][1] );
        // 첫번째 고객 - 마지막 고객
        for (int i = 0; i < N-1; i++) {
            sum += distance(
                    cust[ tgt[i] ][0], cust[ tgt[i] ][1],
                    cust[ tgt[i+1] ][0], cust[ tgt[i+1] ][1]
                );
        }
        // 마지막 고객 - 집
        sum += distance(homeY, homeX, cust[ tgt[N-1] ][0], cust[ tgt[N-1] ][1] );
        
        min = Math.min(min, sum);
        
        return;
    }
    // src (cust) 의 N 개 고객 중 하나씩 선택해 가는 과정을 거친다. 단, 이미 이전에 선택한 고객은 제외
    for (int i = 0; i < N; i++) {
        if( select[i] ) continue; // 이미 이전에 선태된 고객은 skip
        select[i] = true;
        tgt[tgtIdx] = i; // 현재 tgtIdx 자리에 i 를 선택
        perm( tgtIdx + 1 );
        select[i] = false;
    }
}

static int distance( int y1, int x1, int y2, int x2 ) {
    return Math.abs(y1 - y2) + Math.abs(x1 - x2);
}
}