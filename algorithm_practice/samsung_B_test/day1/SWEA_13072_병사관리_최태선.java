package algorithm_practice.samsung_B_test.day1;

import java.io.*;
import java.util.*;





class UserSolution
{
	public class Node{
		int id;
		int v;
		Node nxt;

		Node(){}
		Node(int id,int v){
			this.id = id;
			this.v = v;
			this.nxt = null;
		}
		Node(int id,int v,Node nxt){
			this.id = id;
			this.v = v;
			this.nxt = nxt;
		}
	} 
	public int [] version = new int[100001]; // 버전관리로 병사가 살아있는지 체크
	public int [] num = new int[100001]; // id가 속한 팀 번호

	public Node getNewNode(int id,Node nxt){
		return new Node(id,++version[id],nxt);
	}
	public class Team{
		Node[] head = new Node[6];
		Node[] tail = new Node[6];
	}
	public Team[] t = new Team[6];

	public void init()
	{
		for(int team = 1; team<=5;team++){
			t[team] = new Team();
			for(int score = 1;score<=5;score++){
				t[team].head[score] = getNewNode(0, null);
				t[team].tail[score] = t[team].head[score];
			}
		}
		for(int id=0;id<= 100000;id++){
			version[id] = 0;
			num[id] = 0;
		}
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		Node newNode = getNewNode(mID, null);
		t[mTeam].tail[mScore].nxt = newNode;
		t[mTeam].tail[mScore] = newNode;
		num[mID] = mTeam;
	}
	
	public void fire(int mID)
	{
		version[mID] = -1;
	}

	public void updateSoldier(int mID, int mScore)
	{
		hire(mID, num[mID], mScore);
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		if(mChangeScore < 0){
			for(int from= 1; from<=5;from++){
				int to = from + mChangeScore;
				to = (to<1)? 1: ((to>5)? 5 : to);
				if(from == to) continue;

				if(t[mTeam].head[from].nxt == null) continue;
				t[mTeam].tail[to].nxt = t[mTeam].head[from].nxt;
				t[mTeam].tail[to] = t[mTeam].tail[from];

				t[mTeam].head[from].nxt = null;
				t[mTeam].tail[from] = t[mTeam].head[from];

			}
		}
		if(mChangeScore>0){
			for (int from = 5; from >= 1; from--) {
                int to = from + mChangeScore;
                to = (to < 1) ? 1 : ((to > 5) ? 5 : to);
                if (from == to) continue;

                if (t[mTeam].head[from].nxt == null) continue;

                t[mTeam].tail[to].nxt = t[mTeam].head[from].nxt;
                t[mTeam].tail[to] = t[mTeam].tail[from];

                t[mTeam].head[from].nxt = null;
                t[mTeam].tail[from] = t[mTeam].head[from];
            }
		}
	}
	
	public int bestSoldier(int mTeam)
	{
		for(int score = 5;score>=1;score--){
			Node node = t[mTeam].head[score].nxt;
			if(node == null) continue;

			int bestId = 0;
			while(node != null){
				if(node.v == version[node.id]){
					bestId = (bestId < node.id) ? node.id : bestId;
				}
				node = node.nxt;
			}
			if(bestId != 0) return bestId;
		}
		return 0;
	}

}

class Solution
{
	private final static int CMD_INIT				= 1;
	private final static int CMD_HIRE				= 2;
	private final static int CMD_FIRE				= 3;
	private final static int CMD_UPDATE_SOLDIER		= 4;
	private final static int CMD_UPDATE_TEAM		= 5;
	private final static int CMD_BEST_SOLDIER		= 6;
	
	private final static UserSolution usersolution = new UserSolution();
	
	private static boolean run(BufferedReader br) throws Exception
	{
		StringTokenizer st;
		
		int numQuery;

		int mID, mTeam, mScore, mChangeScore;
	
		int userAns, ans;
	
		boolean isCorrect = false;

		numQuery = Integer.parseInt(br.readLine());
		
		for (int q = 0; q < numQuery; ++q)
		{
			st = new StringTokenizer(br.readLine(), " ");

			int cmd;
			cmd = Integer.parseInt(st.nextToken());
			
			switch(cmd)
			{
			case CMD_INIT:
				usersolution.init();
				isCorrect = true;
				break;
			case CMD_HIRE:
				mID = Integer.parseInt(st.nextToken());
				mTeam = Integer.parseInt(st.nextToken());
				mScore = Integer.parseInt(st.nextToken());
				usersolution.hire(mID, mTeam, mScore);
				break;
			case CMD_FIRE:
				mID = Integer.parseInt(st.nextToken());
				usersolution.fire(mID);
				break;
			case CMD_UPDATE_SOLDIER:
				mID = Integer.parseInt(st.nextToken());
				mScore = Integer.parseInt(st.nextToken());
				usersolution.updateSoldier(mID, mScore);
				break;
			case CMD_UPDATE_TEAM:
				mTeam = Integer.parseInt(st.nextToken());
				mChangeScore = Integer.parseInt(st.nextToken());
				usersolution.updateTeam(mTeam, mChangeScore);
				break;
			case CMD_BEST_SOLDIER:
				mTeam = Integer.parseInt(st.nextToken());
				userAns = usersolution.bestSoldier(mTeam);
				ans = Integer.parseInt(st.nextToken());
				if (userAns != ans) {
					isCorrect = false;
				}
				break;
			default:
				isCorrect = false;
				break;
			}
		}
		
		return isCorrect;
	}
	
	public static void main(String[] args) throws Exception
	{
		int TC, MARK;
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase)
		{
			int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
		}

		br.close();
	}
    
}