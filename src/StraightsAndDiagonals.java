public class StraightsAndDiagonals extends ChessPiece {

	public StraightsAndDiagonals(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard,
									 int line,
									 int column,
									 int toLine,
									 int toColumn) {
		return false;
	}

	@Override
	public String getSymbol() {
		return "";
	}

	public boolean canMoveStraight(ChessBoard chessBoard,
								   int line,
								   int column,
								   int toLine,
								   int toColumn,
								   int limit) {
		boolean validMove = false;

		if (toLine == line || toColumn == column){
			if (!(toLine == line && toColumn == column)) {
				if (
						toLine >= 0 &&
								toLine < chessBoard.board.length &&
								toColumn >= 0 &&
								toColumn < chessBoard.board[0].length
				) {
					if ((Math.abs(toLine - line) <= limit) && (Math.abs(toColumn - column) <= limit)){
						validMove = true;
					}
				}
			}
		}
		return validMove;
	}

	public boolean canMoveDiagonals(ChessBoard chessBoard,
									int line,
									int column,
									int toLine,
									int toColumn,
									int limit) {
		boolean validMove = false;

		if (toLine != line && toColumn != column){
			if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
				if (
						toLine >= 0 &&
								toLine < chessBoard.board.length &&
								toColumn >= 0 &&
								toColumn < chessBoard.board[0].length
				) {
					if ((Math.abs(toLine - line) <= limit) && (Math.abs(toColumn - column) <= limit)){
						validMove = true;
					}
				}
			}
		}
		return validMove;
	}
}
