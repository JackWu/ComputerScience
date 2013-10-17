package algorithm.recursion;

import java.util.ArrayList;

public class subSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> set = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++){
			set.add(i);
		}
		ArrayList<ArrayList<Integer>> temp = getSubSet2(set);
		System.out.println("temp array size: "+temp.size());
		
//		for(int i = 0; i < temp.size(); i ++){
//			for(int j = 0; j < temp.get(i).size(); j++){
//				System.out.print(temp.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}



	}
	static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		
		if(set.size() == index){
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}else{
			allsubsets = getSubSets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> subset : allsubsets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	
	static ArrayList<ArrayList<Integer>> getSubSet2(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		
		int max = 1 << set.size();
		System.out.println("Max binary bit"+ Integer.toBinaryString(max));
		System.out.println("Max binary bit size" + Integer.toBinaryString(max).length());
		
		for(int i = 0; i < max; i++){
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			System.out.println("While loop starts here");
			while(k>0){
				System.out.println(Integer.toBinaryString(k));
				if((k&1)>0){
					subset.add(set.get(index));
				}
				k>>=1;
				index++;
			}
			System.out.println();
			System.out.println("While loop ends here");
			allsubsets.add(subset);
		}
		
		return allsubsets;
	}

}
