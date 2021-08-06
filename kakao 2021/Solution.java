class Solution {
    public String solution(String new_id) {        
    	String answer = "";
        
    	//1단계: 영문 소문자로 변경 
    	new_id = new_id.toLowerCase();
    	
    	//2단계: 소문자, 숫자, -, _, . 외 문자열 제외
    	for(int i = 0; i < new_id.length(); i++) {
    		char ch = new_id.charAt(i);
    		
    		if(ch >= 'a' && ch <= 'z') {
    			answer += ch;
    		} else if(ch >= '0' && ch <= '9'){
    			answer += ch;
    		} else if(ch == '-' || ch == '_' || ch == '.') {
    			answer += ch;
    		}
    	}
    	    	
    	//3단계: 2번 이상 .연속 => 하나의 마침표로
    	String id = "";
    	for(int i = 0; i < answer.length(); i++) {    		    		    		
    		if(answer.charAt(i) == '.') {
    			if(i != answer.length() - 1) {
    				if(answer.charAt(i) != answer.charAt(i+1)) {
	    				id += answer.charAt(i);
	    			}
    			} else {
    				id += answer.charAt(i);
    			}
    		} else {
    			id += answer.charAt(i);
    		}        		  
    	}
    	answer = id;
    	    	
    	//4단계: .가 처음이나 끝에 존재 => 제거    	
    	if(answer.startsWith(".")) {
    		answer = answer.substring(1);
    	}    	
    	
    	if(answer.endsWith(".")) {
    		answer = answer.substring(0, answer.length() - 1);
    	}
    	
    	//5단계: new_id가 null 이면 a 대입
    	if(answer.length() == 0) {
    		answer = "a";
    	}

    	//6단계: new_id가 16자 이상이면 15이외 모두 제거, 15자 맨끝 .이면 .제거  
        
    	if(answer.length() > 15) {
    		answer = answer.substring(0, 15);
    		
    		if(answer.charAt(answer.length()-1) == '.') {
    			answer = answer.substring(0, 14);    		
    		}    		
    	}    	    
    	
    	//7단계: new_id가 2자 이하 => 길이가 3일때까지 new_id 마지막 글자 반복 
    	if(answer.length() <= 2) {    		
    		while(answer.length() < 3) {
    			answer += answer.charAt(answer.length()-1);    		
    		}
    	}
        	
    	return answer;                
    }
}
