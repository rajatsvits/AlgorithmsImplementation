package algorithms;

import java.util.Scanner;

public class LongestPalindromSubstring {

	private static Scanner sc;

	void LPS(String s)
	{
		char a[]=s.toCharArray();
		int n=a.length;
		boolean table[][]=new boolean[n][n];
		
		int start=0,maxlength=1;
		//For length 1
		for(int i=0;i<n;i++)
			table[i][i]=true;
		
		//For length 2
		for(int i=0;i<n-1;i++)
			if(a[i]==a[i+1])
			{
				table[i][i+1]=true;
				start=i;
				maxlength=2;
			}
		
		//For length grater than 2
		for(int k=3;k<n;k++)
		{
			for(int i=0;i<n-k+1;i++)
			{
				int j=i+k-1;
				if(table[i+1][j-1]==true&&a[i]==a[j])
				{
					table[i][j]=true;
					if(k>maxlength)
					{
						start=i;
						maxlength=k;
					}
				}
			}
		}
		
		System.out.print("The longest palindromic string in String: \""+s+"\" from "+start+" to "+(start+maxlength-1)+" is: ");
		printLPS(s,start,maxlength);
	}
	
	private void printLPS(String s, int start, int maxlength) {
		// TODO Auto-generated method stub
		String a=s.substring(start,start+maxlength);
		System.out.println(a);
	}

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		LongestPalindromSubstring lps = new LongestPalindromSubstring();
		String s=sc.next();
		lps.LPS(s);
		//System.out.println(s);
	}
}
