class Solution {
    public String solution(String new_id) {        
    	String answer = "";
        
    	//1�ܰ�: ���� �ҹ��ڷ� ���� 
    	new_id = new_id.toLowerCase();
    	
    	//2�ܰ�: �ҹ���, ����, -, _, . �� ���ڿ� ����
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
    	    	
    	//3�ܰ�: 2�� �̻� .���� => �ϳ��� ��ħǥ��
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
    	    	
    	//4�ܰ�: .�� ó���̳� ���� ���� => ����    	
    	if(answer.startsWith(".")) {
    		answer = answer.substring(1);
    	}    	
    	
    	if(answer.endsWith(".")) {
    		answer = answer.substring(0, answer.length() - 1);
    	}
    	
    	//5�ܰ�: new_id�� null �̸� a ����
    	if(answer.length() == 0) {
    		answer = "a";
    	}

    	//6�ܰ�: new_id�� 16�� �̻��̸� 15�̿� ��� ����, 15�� �ǳ� .�̸� .����  
        
    	if(answer.length() > 15) {
    		answer = answer.substring(0, 15);
    		
    		if(answer.charAt(answer.length()-1) == '.') {
    			answer = answer.substring(0, 14);    		
    		}    		
    	}    	    
    	
    	//7�ܰ�: new_id�� 2�� ���� => ���̰� 3�϶����� new_id ������ ���� �ݺ� 
    	if(answer.length() <= 2) {    		
    		while(answer.length() < 3) {
    			answer += answer.charAt(answer.length()-1);    		
    		}
    	}
        	
    	return answer;                
    }
}