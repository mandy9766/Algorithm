package d0202;
import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1230_암호문3_최태선 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> original = new LinkedList<>();
			st = new StringTokenizer(br.readLine()," ");
			for (int i=0;i<N;i++) {
				original.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				String order = st.nextToken();
				if(order.equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int size = Integer.parseInt(st.nextToken());
					for (int i=0;i<size;i++) {
						original.add(idx+i,Integer.parseInt(st.nextToken()));
					}
				}else if(order.equals("D")) {
					int idx = Integer.parseInt(st.nextToken());
					int size = Integer.parseInt(st.nextToken());
					for(int i=0;i<size;i++) {
						original.remove(idx);
					}
				}else if(order.equals("A")) {
					int size = Integer.parseInt(st.nextToken());
					for (int i=0;i<size;i++) {
						original.add(Integer.parseInt(st.nextToken()));
					}
					
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i=0;i<10;i++) {
				sb.append(" " + original.get(i) );
			}
			System.out.println("#"+(t+1) + sb);
		}
	}
}
