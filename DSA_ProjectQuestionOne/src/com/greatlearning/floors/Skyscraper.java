package com.greatlearning.floors;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Skyscraper {
	
	public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Integer> queueOne = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> queueTwo = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		System.out.println("Enter the total number of floors in the building : ");
		int numberOfFloors = sc.nextInt();
		int [] floorsSize = new int[numberOfFloors];
		
		
		for(int i=0; i<numberOfFloors; i++) {
			System.out.println("Enter the floor size given on day: "+(i+1));
			floorsSize[i]=sc.nextInt();
			
			while(floorsSize[i]<=0) {
				System.out.println("Error ! please enter values greater than 0 :");
				floorsSize[i]=sc.nextInt();
			}
			queueOne.add(floorsSize[i]);
		}
		
		sc.close();
		
		System.out.println("The order of construction is as follows : ");
		
		for(int i=0; i<numberOfFloors; i++) {
			System.out.println("Day "+(i+1)+" : ");
			
			if(queueOne.peek()==floorsSize[i]) {
				System.out.print(queueOne.poll()+" ");
				
				while(!queueTwo.isEmpty() && queueTwo.peek()==queueOne.peek()) {
					System.out.print(queueOne.poll()+" ");
					queueTwo.remove();
				}
			}else {
				queueTwo.add(floorsSize[i]);
			}

			System.out.println();
		}
		
		
	}

}
