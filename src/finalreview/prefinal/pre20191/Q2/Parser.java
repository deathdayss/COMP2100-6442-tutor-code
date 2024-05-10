package finalreview.prefinal.pre20191.Q2;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * @author huy.pham
 */
public class Parser {
	private Tokenizer _tokenizer;
	private Screen _screen;

	public Parser(Tokenizer tokenizer, Screen screen) {
		_tokenizer = tokenizer;
		_screen = screen;
	}

    /**
     * This should parse all the tokens, turn the pointer and mark its visited positions for
     * every move.
     *
     * If there is no more token, this should return the current screen
     *
     * @return a screen object containing pointer's trace information.
     * @throws Exception
     */
    public Screen parse() throws OutOfScreenException {
        // TODO: Add your implementation here.
        // hints: Check {@link Screen} and {@link Pointer} classes to see there is any methods/functions you can take advantage of.

 		return _screen;
	}

	private void markMove(Position old, Position moved) throws OutOfScreenException {
    	if (old.x == moved.x) {
    		markBetween(old.y, moved.y, old.x, false);
		}
    	if (old.y == moved.y) {
			markBetween(old.x, moved.x, old.y, true);
		}
	}

	private void markBetween(int start, int end, int place, boolean horizontal) throws OutOfScreenException {
    	for (int i = Math.min(start, end); i <= Math.max(start, end); ++i) {
    		if (horizontal) {
    			try {
					_screen.markVisistedPos(new Position(i, place));
				} catch (OutOfScreenException e) {

				}
			}
    		else {
				try {
					_screen.markVisistedPos(new Position(place, i));
				} catch (OutOfScreenException e) {

				}
			}
		}
	}
}
