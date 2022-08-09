package algo0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main_2667_Comparable {

    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[][] table = new char[n+2][n+2];
    
    for(int i=1; i<=n; i++) {
        char[] chars = br.readLine().toCharArray();
        for(int j=1; j<=n; j++) {
            table[i][j] = chars[j-1];
        }
    }
    LinkedList<Integer> result = new LinkedList<>();
    int total = 0;
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            if(table[i][j] == '1') {
                result.add(search(table,i,j));
                total++;
            }
        }
    }
    Collections.sort(result);
    StringBuilder sb = new StringBuilder();
    sb.append(total).append('\n');
    for(int m : result) {
        sb.append(m).append('\n');
    }
    System.out.println(sb);
    br.close();

}

private static int search(char[][] table, int i, int j) {
    table[i][j] = 0;
    int answer = 1;
    for(int d=0; d<4; d++) {
        int r = i+dr[d];
        int c = j+dc[d];
        if(table[r][c] == '1') {
            answer += search(table,r,c);
        }
    }
    return answer;
}
}