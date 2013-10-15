package algorithm.recursion;

public class backtracking {
	
	public boolean foundSolution = false;
	
	int maxCandidate = 2;
	boolean[] candidates = {true, false};
	boolean[] solution = new boolean[4];
	
	public void processSolution(boolean[] sol){
		System.out.print("{");
		for(int i = 0; i < sol.length; i++){
			if(sol[i] == true)
				System.out.print(i + " ");
		}
		System.out.print("}");
	}
	
	public boolean isSolution(int n, int k){
		
		return n==k;
		
	}
	public boolean[] constructCandidates(int candidateSize, boolean[] candidates){
		
		candidates[0] = true;
		candidates[1] = false;
		
		return candidates;
		
		
	}
	public boolean backtrack(boolean[] solution, int k, int n){
		
		if(isSolution(n, k)){
			processSolution(solution);
			System.out.println();
			return true;
		} else{
			k = k+1;
			
			
			for(int i=0; i < candidates.length; i++ ){
				solution[k] = candidates[i];
				backtrack(solution, k, n);
			}
			
			if(foundSolution) return true;
			
		}
		return false;
		
	}
	
	public void testBackTrack(){
		
		backtrack(solution, 0, 3);
	}
}
