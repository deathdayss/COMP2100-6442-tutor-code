package finalreview.prefinal.pre20192.Q4;

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
    public String positionToString(Position p) {
    	return "("+p.x +", " + p.y +")";
	}
    public Screen parse() throws OutOfScreenException {
		// TODO: Add your implementation here.
		// Hints: Check {@link Screen} and {@link Pointer} classes to see
    	//        there is any methods/functions you can take advantage of.
    	//        Check the expected outcome in ParserTest.java
    	//        You can make additional methods if needed

		return _screen;

	}

	void MarkPosition(Position old, Position now, boolean isPenDown) throws OutOfScreenException {
    	if (!isPenDown) {
    		return;
		}
		System.out.println("Mark Positions: ");
    	if (old.x == now.x) {
    		int from = Math.min(old.y, now.y);
    		int to = Math.max(old.y, now.y);
    		for (int y = from; y <= to; ++y) {
				System.out.println(positionToString(new Position(old.x, y)));
    			_screen.markVisistedPos(new Position(old.x, y));
			}
		}
    	else {
			int from = Math.min(old.x, now.x);
			int to = Math.max(old.x, now.x);
			for (int x = from; x <= to; ++x) {
				System.out.println(positionToString(new Position(x, old.y)));
				_screen.markVisistedPos(new Position(x, old.y));
			}
		}
	}
}
