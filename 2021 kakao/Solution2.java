class new_id {
	public String solution(String new_id) {
		String answer = new_id.toLowerCase();
		
		answer = answer.replaceAll("[^a-z0-9-_.]", "");
		answer = answer.replaceAll("[.]{2,}", ".");
		answer = answer.replaceAll("^[.]|[.]$", "");
		
		if(answer.equals("")) {
			answer += "a";
		}
		
		if(answer.length() > 15) {
			answer = answer.substring(0, 15);
			answer = answer.replaceAll("[.]$", "");
		}
		
		if(answer.length() <= 2) {
			while(answer.length() < 3) {
				answer += answer.charAt(answer.length()-1);
			}
		}
				
		return answer;
	
	}
}
