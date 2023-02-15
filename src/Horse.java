public class Horse extends ChessPiece {

	private final int[][] moveRules = {
			{1, 2},
			{2, 1},
			{2, -1},
			{1, -2},
			{-1, -2},
			{-2, -1},
			{-2, 1},
			{-1, 2}
	};

	public Horse(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard,
									 int line,
									 int column,
									 int toLine,
									 int toColumn) {
		boolean validMove = false;

		for (int[] direction : moveRules) {
			if ((toLine - line) == direction[0] && (toColumn - column) == direction[1]) {
				if (toLine >= 0 &&
						toLine < chessBoard.board.length &&
						toColumn >= 0 && toColumn < chessBoard.board[0].length) {
					if (line != toLine || column != toColumn) {
						if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(color)) {
							validMove = true;
							break;
						}
					}
				}
			}
		}

		return validMove;
	}

	@Override
	public String getSymbol() {
		return "H";
	}
}
