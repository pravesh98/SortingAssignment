package com.net;

import java.util.HashMap;

public class DataSorter {

	public String sort(String input) {
		
		HashMap<String,Object> hashMap=new HashMap<>();
		String number[]=input.split(" ");
		String out="";
		String[] key=new String[number.length];
		float[] value=new float[number.length];
		
		//populating hashmap
		for(String n:number)
			hashMap.put( n.split("=")[0],n.split("=")[1]);
		
		
		//populating arrays for string
		int i=0;
		for(String n:number)
		{
			key[i]=n.split("=")[0];
			value[i]=Float.parseFloat(n.split("=")[1]);
			i++;
		}
		
		
		for(int k=0;k<number.length;k++)
		{
			for(int j=0;j<number.length;j++)
			{
				//sorting based on value
				if(value[k]>value[j])
				{
					float temp=value[k];
					value[k]=value[j];
					value[j]=temp;
					
					String t=key[k];
					key[k]=key[j];
					key[j]=t;
				}
				//if value is equal 
				else if(value[k]==value[j])
				{
					int cmp=key[k].compareTo(key[j]);
					if(cmp<0)
					{
						float temp=value[k];
						value[k]=value[j];
						value[j]=temp;
						
						String t=key[k];
						key[k]=key[j];
						key[j]=t;
					}
				}
			}
		}
		
		int k;
		for(k=0;k<number.length-1;k++)
			out+=key[k]+"="+hashMap.get(key[k])+";";
		
		out+=key[k]+"="+hashMap.get(key[k]);	
		
		return out;
	}	
}