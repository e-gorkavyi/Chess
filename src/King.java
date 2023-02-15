public class King extends ChessPiece implements Movable {

	public King(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
		return (canMoveStraight(chessBoard, line, column, toLine, toColumn, 1, color) ||
				canMoveDiagonals(chessBoard, line, column, toLine, toColumn, 1, color)) &&
				!isUnderAttack(chessBoard, toLine, toColumn);
	}

	@Override
	public String getSymbol() {
		return "K";
	}

	public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {

		// Scan board for seeking enemy piece
		for (int linePos = 0; linePos < chessBoard.board.length; linePos++) {
			for (int columnPos = 0; columnPos < chessBoard.board[0].length; columnPos++) {
				if (chessBoard.board[linePos][columnPos] != null)
					if (!chessBoard.board[linePos][columnPos].getColor().equals(color))
						if (chessBoard.board[linePos][columnPos].canMoveToPosition(chessBoard,
								linePos,
								columnPos,
								line,
								column))
							return true;
			}
		}

		return false;
	}
}
