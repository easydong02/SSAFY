package algo0811;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1227 {

static int T, sy, sx, ey, ex, ans;
static char[][] map = new char[100][]; // 배열 낭비를 줄인다.
// 자료 구조 
static Queue<Node> queue = new ArrayDeque<>();
static boolean[][] visit;

// 사방탐색 delta 상 - 하 - 좌 - 우
static int[] dy = { -1, 1, 0, 0 };
static int[] dx = {  0, 0,-1, 1 };

public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    for (int t = 1; t <= 10; t++) {
         br.readLine();
         
         // 입력 처리, 시작점, 끝점 확보
         for (int i = 0; i < 100; i++) {
             map[i] = br.readLine().toCharArray(); // 새로운 배열을 만들어서 리턴해준다.
             for (int j = 0; j < 100; j++) {
                if(map[i][j] == '2') {
                    sy = i;
                    sx = j;
                }else if( map[i][j] == '3' ) {
                    ey = i;
                    ex = j;
                }
            }
        }
         
         // 탐색 시작
         
         // 초기화
         ans = 0;
         queue.clear();
         visit = new boolean[100][100];
         
//             bfs( sy, sx );

             dfs( sy, sx );
             System.out.println("#" + t + " " + ans);

        }
    }

    // 방문했던 곳을 다시 시작하기 위해서 잠깐 담아놓는 자료구조가 필요 Queue
    // 별도의 클래스를 일반적으로 만든다. ( 클래스 또는 배열 )
    // visit
    // 한번만 호출
    static void bfs( int y, int x ) {

        // 최초 y, x 를 이용해서 Node 한 개를 담는다.
        queue.offer(new Node(y, x));
        visit[y][x] = true;

        while( ! queue.isEmpty() ) {

            Node node = queue.poll();

            // 정답 체크
            if( node.y == ey && node.x == ex ) {
                ans = 1;
                return;
            }
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if( ny < 0 || nx < 0 || ny >= 100 || nx >= 100 || visit[ny][nx] || map[ny][nx] == '1' ) continue;

                queue.offer(new Node(ny, nx));
                visit[ny][nx] = true;
            }

        }
    }

    // 무조건 재귀 호출
    static void dfs( int y, int x ) {

        visit[y][x] = true;

    if( y == ey && x == ex ) {
        ans = 1;
        return;
        
    }
    for (int d = 0; d < 4; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];
        
        if( ny < 0 || nx < 0 || ny >= 100 || nx >= 100 || visit[ny][nx] || map[ny][nx] == '1' ) continue;
        
        dfs( ny, nx );
    }
}

static class Node{
    int y, x;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    @Override
    public String toString() {
        return "Node [y=" + y + ", x=" + x + "]";
    }
}
}
