
import java.util.*;
public class BFS_DFS 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int jug1,jug2;
		System.out.println("Enter the Capacity of Jug1: ");
		jug1 = sc.nextInt();
		System.out.println("Enter the Capacity of Jug2: ");
		jug2 = sc.nextInt();
		int state[] = new int[2];
		System.out.println("Enter the Final State seperated by spaces: ");
		state[0] =  sc.nextInt();
		state[1] = sc.nextInt();
		System.out.println("Enter 1 to search using BFS");
		System.out.println("Enter 2 to search using DFS");
		System.out.println("Enter 3 to Exit");
		int option = sc.nextInt();
		switch(option)
		{
		case 1:
			BFS(jug1,jug2,state);
			break;
		case 2: DFS(jug1,jug2,state);
				break;
		case 3: System.exit(0);
		default: System.out.println("Wrong Choice...!!!");
		}
		sc.close();
	}
	public static boolean isGoalState(int j1, int j2, int state[])
	{
		if(j1 == state[0] && j2 == state[1])
			return true;
		return false;		
	}
	public static ArrayList<String> getSuccessors(int jug1, int jug2, String node)
	{
		ArrayList<String> succ = new ArrayList<String>();
		int j1 = Character.getNumericValue(node.charAt(1));
		int j2 = Character.getNumericValue(node.charAt(3));
		String s1 = null;
		if(j1 == 0 && j2 == 0)
		{
			s1 = "(" + (char)('0' + jug1) + "," + (char)('0' + j2) + ")";
			succ.add(s1);
			s1 = "(" + (char)('0' + j1) + "," + (char)('0' + jug2) + ")";
			succ.add(s1);
		}
		else if(j1 == jug1 && j2 == 0)
		{
			s1 = "(" + (char)('0' + j1) + "," + (char)('0' + jug2) + ")";
			succ.add(s1);
			s1 = "(" + '0' + "," + (char)('0' + j2) + ")";
			succ.add(s1);
			j2 = jug2;
			j1 = j1 - j2;
			s1 = "(" + (char)('0' + j1) + "," + (char)('0' + j2) + ")";
			succ.add(s1);
		}
		else if(j1 == 0 && j2 == jug2)
		{
			s1 = "(" + (char)('0' + jug1) + "," + (char)('0' + j2) + ")";
			succ.add(s1);
			s1 = "(" + (char)('0' + j1) + "," + '0' + ")";
			succ.add(s1);
			j1 = j2;
			j2 = 0;
			s1 = "(" + (char)('0' + j1) + "," + (char)('0' + j2) + ")";
			succ.add(s1);
		}
		else if(j1 == jug1 && j2 == jug2)
		{
			s1 = "(" + '0' + "," + (char)('0' + j2) + ")";
			succ.add(s1);
			s1 = "(" + (char)('0' + j1) + "," + '0' + ")";
			succ.add(s1);
		}
		else if(j1 < jug1 && j2 == jug2)
		{
			s1 = "(" + '0' + "," + (char)('0' + j2) + ")";
			succ.add(s1);
			s1 = "(" + (char)('0' + j1) + "," + '0' + ")";
			succ.add(s1);
			if(j1+j2 <= jug1)
			{
				j1 = j1 + j2;
				j2 = 0;
			}
			else
			{
				j2 = j1 + j2;
				j1 = jug1;
				j2 = j2 - j1;
			}
			s1 = "(" + (char)('0' + j1) + "," + (char)('0' + j2) + ")";
			succ.add(s1);
		}
		else if(j1 == jug1 && j2 < jug2)
		{
			s1 = "(" + '0' + "," + (char)('0' + j2) + ")";
			succ.add(s1);
			s1 = "(" + (char)('0' + j1) + "," + '0' + ")";
			succ.add(s1);
			j1 = j1 - jug2 + j2;
			j2 = jug2;
			s1 = "(" + (char)('0' + j1) + "," + (char)('0' + j2) + ")";
			succ.add(s1);
		}
		else if(j1 < jug1 && j2 == 0)
		{
			s1 = "(" + '0' + "," + (char)('0' + j2) + ")";
			succ.add(s1);
			s1 = "(" + (char)('0' + j1) + "," + (char)('0' + jug2) + ")";
			succ.add(s1);
			if(j1 > jug2)
			{
				j2 = j1;
				j1 = j1 - jug2;
				j2 = j2 - j1;
			}
			else
			{
				j2 = j1;
				j1 = 0;
			}
			s1 = "(" + (char)('0' + j1) + "," + (char)('0' + j2) + ")";
			succ.add(s1);
		}
		else if(j1 == 0 && j2 < jug2)
		{
			s1 = "(" + (char)('0' + jug1) + "," + (char)('0' + j2) + ")";
			succ.add(s1);
			s1 = "(" + (char)('0' + j1) + "," + '0' + ")";
			succ.add(s1);
			j1 = j2;
			j2 = 0;
			s1 = "(" + (char)('0' + j1) + "," + (char)('0' + j2) + ")";
			succ.add(s1);
		}
		return succ;		
	}
	public static void BFS(int jug1, int jug2, int state[])
	{
		Queue<String> q = new LinkedList<String>();
		ArrayList<String> path = new ArrayList<String>();
		Set<String> closed = new HashSet<String>();
		ArrayList<String> succ = new ArrayList<String>();
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		q.add("(0,0)");
		String node;
		char s1, s2;
		int j1, j2, i = 0;
		String str = "";
		j1 = j2 = 0;
		System.out.println("Expanded Nodes = ");
		do
		{
			node = q.poll();
			System.out.print(node + " ");
			s1 = node.charAt(1);
			j1 = Character.getNumericValue(s1);
			s2 = node.charAt(3);
			j2 = Character.getNumericValue(s2);
			str = "(" + (char)('0' + state[0]) + "," + (char)('0' + state[1]) + ")";
			boolean x = isGoalState(j1, j2, state);
			if(x == true)
			{	
				System.out.println("\n\n");
				sequence(a1, a2, str,path);
				System.out.println("\n*****Final State Reached*****");
				break;
			}
			if(!(closed.contains(node)))
			{
				closed.add(node);
				succ = getSuccessors(jug1,jug2,node);
				for(String child:succ)
				{	
					q.add(child);
					if(!(closed.contains(child)) && !(a2.contains(child)))
					{
						a1.add(node);
						a2.add(child);
					}
				}
			}
			i++;
		}while(i < 100);
	}
	public static void DFS(int jug1, int jug2, int state[])
	{
		Stack<String> q = new Stack<String>(); 
		ArrayList<String> path = new ArrayList<String>();
		Set<String> closed = new HashSet<String>();
		ArrayList<String> succ = new ArrayList<String>();
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		q.push("(0,0)");
		String node;
		char s1, s2;
		int j1, j2, i = 0;
		String str = "";
		j1 = j2 = 0;
		System.out.println("Expanded Nodes = ");
		do
		{
			node = q.pop();
			System.out.print(node + " ");
			s1 = node.charAt(1);
			j1 = Character.getNumericValue(s1);
			s2 = node.charAt(3);
			j2 = Character.getNumericValue(s2);
			str = "(" + (char)('0' + state[0]) + "," + (char)('0' + state[1]) + ")";
			boolean x = isGoalState(j1, j2, state);
			if(x == true)
			{	
				System.out.println("\n\n");
				sequence(a1, a2, str,path);
				System.out.println("*****Final State Reached*****");
				break;
			}
			if(!(closed.contains(node)))
			{
				closed.add(node);
				succ = getSuccessors(jug1,jug2,node);
				for(String child:succ)
				{	
					q.add(child);
					if(!(closed.contains(child)) && !(a2.contains(child)))
					{
						a1.add(node);
						a2.add(child);
					}
				}
			}
			i++;
		}while(i < 100);
	}
	public static void sequence(ArrayList<String> a1, ArrayList<String> a2,String state,ArrayList<String> path)
	{
		int x;
		if(state == "(0,0)")
		{
			path.add(state);
			System.out.println("The Solution Path is:");
			Collections.reverse(path);
			System.out.println(path);
		}
		else
		{
			x = a2.indexOf(state);
			path.add(state);
			sequence(a1, a2, a1.get(x),path);
		}		
	}	
}
