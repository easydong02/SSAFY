package java0726;

public class FourMagicSquare {
	private int[][] magic;
	private int n;
	public FourMagicSquare() {
		this(4);
	}
	public FourMagicSquare(int n) {
		super();
		this.n = n;
		magic=new int[n][n];
	}
	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(magic[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void make() {
		makeA();
		makeR();
	}
	private void makeR() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if((0<=i && i<n/4)|| (n/4*3<=i && i<n) ) {//i 양쪽 가
					if(n/4<=j && j<n/4*3) {// 중앙
						magic[i][j]=n*n-(i*n+j);
					}
				}else {   //i가 중앙 
					if((0<=j && j<n/4)|| (n/4*3<=j && j<n) ) {//j 양쪽 가
						magic[i][j]=n*n-(i*n+j);
					}
				}
			}
		}
	}
	private void makeA() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j]=i*n+j+1;
			}
		}
	}
}






