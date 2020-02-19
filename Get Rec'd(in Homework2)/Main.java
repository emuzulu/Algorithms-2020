import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] d = new int[5100];//the maximum length for a start vertex
	static int[] a = new int[5100];//width of rec
	static int[] b = new int[5100];//length of rec
	static int[][] G = new int[5100][5100];//the DAG
	static int  n = 0;//number of rec
	static int dp(int i) {//to get the d(i)
		if(d[i] > 0)//if the answer have already been recorded
			return d[i];
		d[i] = 1;//initialize the max length to 1
		for(int j = 1; j <= n; j++) {
			if(G[i][j] == 1)
				d[i] = Math.max(d[i], dp(j)+1);//get d(i) recursively by the formula 
		}
		return d[i];//return the maximum lenth at i
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if ((a[i] < a[j] && b[i] < b[j]) || (b[i] < a[j] && a[i] < b[j]))//if i can nest in j(rotation permitted)
					G[i][j] = 1;// form the DAG
			}
		}
		int maxi = 0;
		for(int i = 1; i <= n; i++) {
			if(dp(maxi) < dp(i)) {//if there is a longer length start from i
				maxi = i;//change the index
			}
		}
		System.out.println(d[maxi]);//output the answer
	}
}
