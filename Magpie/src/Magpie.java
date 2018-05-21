public class Magpie {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		if(statement.trim().length()==0) {
			response = "Say something pleeeaaase.";
		}else if (statement.indexOf("no") >= 0) {
			response = "Why must you hurt me so?";
		} else if (statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family caused the zombie apocalypse.";
		}else if(statement.indexOf("mother") >= 0){
			response = "How is she doing?";
		}else if(statement.indexOf("Ms.Dreyer") >= 0 
				|| statement.indexOf("Mr.Wang") >= 0 
				|| statement.indexOf("Ms.Arge") >= 0){
			if(statement.indexOf("Ms.") >= 0) {
				response = "She sounds like a good teacher.";
			}else if(statement.indexOf("Mr.") >= 0) {
				response = "He sounds like a good teacher.";
			}
		}else if(statement.indexOf("I") >= 0){
			response = "Conceited aren't you";
		}else if(statement.indexOf("food") >= 0){
			response = "Let's go get some fries";
		}else if(statement.indexOf("gum") >= 0){
			response = "Don't you hate it when you step on gum?";
		} else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "Really?";
		} else if (whichResponse == 5) {
			response = "I'm sorry, even my most intelligible brain cannot comprehend your klingon dialect";
		}

		return response;
	}
}
