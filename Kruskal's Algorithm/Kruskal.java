import java.util.*;

public class Kruskal {
	/*
	 * N = number of vertices
	 * M = number of edges
	 * total = total number of edges in MST
	 * vsum = sum of weight of every edge in MST
	 */
	static int N,M,total=0,vsum=0;
	static int[] f = new int[1000];
	// the edge class
	static class Edge{
		int start, end, val;
		public Edge(int s, int e, int v){
			start = s;
			end = e;
			val = v;
		}
	}
	//the edge set
	static Edge[] edge = new Edge[1000];
	//the set of minimum spanning tree
	static Edge[] MST = new Edge[1000];
	//merge function of merge sort
	static void merge(int l, int mid, int r) {
		int i = l, j = mid + 1, k = 0;
		Edge[] temp = new Edge[r - l + 1];
		while(i <= mid && j <= r) {
			if(edge[i].val < edge[j].val)
				temp[k++] = edge[i++];
			else
				temp[k++] = edge[j++];
		}
		while(i <= mid)
			temp[k++] = edge[i++];
		while(j <= r)
			temp[k++] = edge[j++];
		for(int k1 = 0; k1 < k; k1++)
			edge[k1 + l] = temp[k1]; 
	}
	//merge sort 
	static void mergesort(int l, int r) {
		int mid = (l+r)/2;
		if(l < r) {
			mergesort(l, mid);
			mergesort(mid+1, r);
			merge(l, mid, r);
		}
	}
	//find function for Union-find(To represents the MST)
	static int find(int k) {
		if(f[k] == k) return k;
		else {
			f[k] = find(f[k]);
			return f[k];
		}
	}
	static void kruskal() {
		for(int i = 0; i < M; i++) {
			//get the two vertices of that edge
			int u = find(edge[i].start);
			int v = find(edge[i].end);
			if(u != v) {//if adding the edge will not form a cycle
				f[u] = v;//union them(or add the edge in MST)
				vsum += edge[i].val;//increase the total weight of MST
				MST[total++] = edge[i];//add the edge to the MST edge list(to output them)
				if(total == N-1) break;//break the loop if the MST is already formed
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i = 1; i <= N; i++)
			f[i] = i;
		for(int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int v = sc.nextInt();
			edge[i] = new Edge(s, e, v);
		}
		mergesort(0, M-1);//sort the edge list
		kruskal();//kruskal's algorithm
		System.out.println("The edges in MST are:");
		for(int i = 0; i < total; i++) {
			System.out.printf("(%d, %d)\n", MST[i].start, MST[i].end);
		}
		System.out.println("The weight sum is: " + vsum);
		System.out.println("The number of edge is MST is: " + total);
	}
}
