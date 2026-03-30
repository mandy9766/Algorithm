package d0128;

import java.util.Scanner;

class swea_1289_cts_solve
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int t=0;t<T;t++){
            int ans = 0;
            String str = sc.nextLine();
            char[] originalArr = str.toCharArray();
            char[] nowArr = new char[originalArr.length];
            for(int i=0;i<nowArr.length;i++){
                nowArr[i] = '0';
            }
            

            for(int i=0;i<nowArr.length;i++){
                if(nowArr[i] != originalArr[i]){
                    for(int j=i;j<nowArr.length;j++){
                        if (originalArr[i] == '1'){
                            nowArr[j] = '1';
                        }
                        else{
                            nowArr[j] = '0';
                        }
                    }
                    ans++;
                }
            }

            System.out.println("#"+(t+1)+" "+ans);
        }

    }
}
