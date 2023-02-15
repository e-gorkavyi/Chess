public class Bishop extends ChessPiece implements Movable {

	public Bishop(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
		return canMoveDiagonals(
				chessBoard,
				line,
				column,
				toLine,
				toColumn,
				chessBoard.board.length - 1,
				color);
	}

	@Override
	public String getSymbol() {
		return "B";
	}
}
