package algorithms;

import java.util.Stack;

public class MinInO1throughStackWithSpaceO1 {

	//Stack<Integer> s;
	int minElement=Integer.MAX_VALUE;
	int maxElement =Integer.MIN_VALUE;
	
	Stack<Integer> min;
	Stack<Integer> max;
	
	public MinInO1throughStackWithSpaceO1()
	{
		//s= new Stack<Integer>();
		min = new Stack<>();
		max = new Stack<>();
		
	}
	
	public void push(int item)
	{
		if(min.isEmpty())
		{
			min.push(item);
			minElement =item;
		}
		else if(minElement>=item)
		{
			min.push(2*item-minElement);
			minElement=item;
		}
		else
			min.push(item);
		
		if(max.isEmpty())
		{
			max.push(item);
			maxElement =item;
		}
		else if(maxElement<=item)
		{
			max.push(maxElement-2*item);
			maxElement=item;
		}
		else
			max.push(item);
		
	
		
		
	}
	
	public void pop()
	{
		if(min.isEmpty())
			System.out.println("Stack is empty");
		else if(min.peek()<minElement)
		{
			int poped=min.pop();
			minElement=2*minElement-poped;
			
		}
		else
			min.pop();
		
		if(max.isEmpty())
			System.out.println("Stack is empty");
		else if(max.peek()>maxElement)
		{
			int poped=max.pop();
			maxElement=poped-2*maxElement;
			
		}
		else
			max.pop();
		
		
		
	}
	
	public static void main(String[] args) {

        MinInO1throughStackWithSpaceO1 ds = new MinInO1throughStackWithSpaceO1();

        System.out.println("Push 7, 6, 5: ");
        ds.push(7);
        ds.push(6);
        ds.push(5);

        //System.out.println("S1: " + ds.s);
        System.out.println("S2: " + ds.min);
        System.out.println("S3: " + ds.max);

        System.out.println("Min till now: " + ds.minElement);
        System.out.println("Max till now: " + ds.maxElement);

        System.out.println("Push 4, 8: ");
        ds.push(4);
        ds.push(8);

      //  System.out.println(ds.s);
        System.out.println(ds.min);
        System.out.println(ds.max);

        System.out.println("Min till now: " + ds.minElement);
        System.out.println("Max till now: " + ds.maxElement);

        System.out.println("1 pop(): ");
        ds.pop();


        System.out.println("Min till now: " + ds.minElement);
        System.out.println("Max till now: " + ds.maxElement);

        System.out.println("1 pop(): ");
        ds.pop();

        System.out.println("Min till now: " + ds.minElement);
        System.out.println("Max till now: " + ds.maxElement);
    }
}
