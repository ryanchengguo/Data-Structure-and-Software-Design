import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */
        Stack<HtmlTag> TagStack = new Stack<>();

		for (HtmlTag item : tags) {

			if (item.isOpenTag()) {

				TagStack.push(item);

			} else {

				if (!item.isSelfClosing()) { // if is closing tag

					if (TagStack.isEmpty()) { // closing tag with no opening tag,  everything okay until then

						return null;
					}			

					if (item.matches(TagStack.peek())) {

						TagStack.pop();

					} else {  // closing tag with no opening tag

						return TagStack;
					}
				}
			}
		}
		return TagStack; 
	}
}

