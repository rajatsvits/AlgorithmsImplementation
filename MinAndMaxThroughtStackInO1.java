package algorithms;

import java.util.Stack;

public class MinInO1throughStack {

	Stack<Integer> s;
	Stack<Integer> min;
	Stack<Integer> max;
	
	public MinInO1throughStack()
	{
		s= new Stack<Integer>();
		min = new Stack<>();
		max = new Stack<>();
		
	}
	
	public void push(int item)
	{
		if(min.isEmpty())
			min.push(item);
		else if(min.peek()>=item)
			min.push(item);
		
		if(max.isEmpty())
			max.push(item);
		else if(max.peek()<=item)
			max.push(item);
		
		
		s.push(item);
	}
	
	public int pop()
	{
		int poped=0;
		if(s.isEmpty())
			poped= -1;
		else
			poped=s.pop();
		
		if(poped==min.peek())
			min.pop();
		
		if(poped ==max.peek())
			max.pop();
		
		return 0;
	}
	
	public static void main(String[] args) {

        MinInO1throughStack ds = new MinInO1throughStack();

        System.out.println("Push 7, 6, 5: ");
        ds.push(7);
        ds.push(6);
        ds.push(5);

        System.out.println("S1: " + ds.s);
        System.out.println("S2: " + ds.min);
        System.out.println("S3: " + ds.max);

        System.out.println("Min till now: " + ds.min.peek());
        System.out.println("Max till now: " + ds.max.peek());

        System.out.println("Push 4, 3: ");
        ds.push(4);
        ds.push(3);

        System.out.println(ds.s);
        System.out.println(ds.min);
        System.out.println(ds.max);

        System.out.println("Min till now: " + ds.min.peek());
        System.out.println("Max till now: " + ds.max.peek());

        System.out.println("1 pop(): ");
        ds.pop();
        System.out.println("Min till now: " + ds.min.peek());
        System.out.println("Max till now: " + ds.max.peek());

        System.out.println("1 pop(): ");
        ds.pop();
        
        System.out.println("Min till now: " + ds.min.peek());
        System.out.println("Max till now: " + ds.max.peek());

    }
}
