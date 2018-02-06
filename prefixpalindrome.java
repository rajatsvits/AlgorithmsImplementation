int prefixPalindrome(String s) {

    
    int maxlength=1,start=0;
    int n= s.length();
    boolean table[][] = new boolean[n][n];
    char a[] = s.toCharArray();
    for(int i=0;i<n;i++)
    {
        table[i][i]=true;
        //Arrays.fill(table[i],true);
    }
    //length 2
    for(int i=0;i<n-1;i++)
    {
        if(a[i]==a[i+1])
        {
            table[i][i+1]=true;
            start=i;
            maxlength=2;
        }
    }
    
    for(int i=3;i<=n;i++)
    {
        //starting index
        for(int j=0;j<n-i+1;j++)
        {
            //ending index
            int k=j+i-1;
            if(table[j+1][k-1]==true&&a[j]==a[k])
            {
                
                table[j][k]=true;
                if(k>maxlength)
                {
                    start=j;
                    maxlength=i;
                }
            }
        }
    }
    
    int c=0;
    for(int i=0;i<n;i++)
    {
        if(table[0][i]==true)
            c++;;
    }
    return c;
    
    
    /*int c=1;
    char a=s.charAt(0);
    for(int i=1;i<s.length();i++)
    {
        if(a==s.charAt(i))
        {
            int j=0;
            for(j=1;j<i;j++)
            {
                if(s.charAt(j)!=s.charAt(i-j))
                    break;
            }
            if(j==i)
                c++;
        }
    }*/
}
