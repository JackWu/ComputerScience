package algorithm.misc;

public class StringAlgo {
	
	public void replaceStrSpaceWith(char[] str){
		int spaceCount = 0, NewLength, i=0;
		for(i=0; i<str.length; i++){
			if(str[i] ==' '){
				spaceCount++;
			}
		}
		
		NewLength = str.length + spaceCount * 2;
		
		
		
		char[] newStr = new char[NewLength*2];
		newStr[NewLength]='\0';
		
		for(int j = 0; j<str.length; j++){
			newStr[j] = str[j];
		}
		
		for(i = str.length -1; i>=0; i--){
			if(newStr[i] == ' '){
				newStr[NewLength-1] = '0';
				newStr[NewLength-2] = '2';
				newStr[NewLength-3] = '%';
				NewLength= NewLength-3;
			}else{
				newStr[NewLength - 1] = newStr[i];
				NewLength = NewLength -1;
				
			}
		}

		for(int z = 0; z<newStr.length; z++){
			System.out.print(newStr[z] + " ");
		}
	}


}
