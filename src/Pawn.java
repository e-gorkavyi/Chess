public class Pawn extends ChessPiece {

	private final int[][] moveRulesFifst = {
			{1, 0},
			{2, 0}
	};

	private final int[][] cutRules = {
			{1, 1},
			{1, -1}
	};

	private final int[][] moveRules = {
			{1, 0}
	};

	public Pawn(String color) {
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

		if (line == 1 && color.equals("White")) {
			for (int[] direction : moveRulesFifst) {
				if ((toLine - line) == direction[0] && (toColumn - column) == direction[1])
					if (toLine >= 0 && toLine < chessBoard.board.length && toColumn >= 0 && toColumn < chessBoard.board[0].length)
						if (chessBoard.board[toLine][toColumn] == null) {
							validMove = true;
							break;
						}
			}
		} else if (line != 1 && color.equals("White")) {
			for (int[] direction : moveRules)
				if ((toLine - line) == direction[0] && (toColumn - column) == direction[1])
					if (toLine >= 0 && toLine < chessBoard.board.length && toColumn >= 0 && toColumn < chessBoard.board[0].length)
						if (chessBoard.board[toLine][toColumn] == null) {
							validMove = true;
							break;
						}
		} else if (line == chessBoard.board[0].length - 2 && color.equals("Black"))
			for (int[] direction : moveRulesFifst) {
				if ((line - toLine) == direction[0] && (toColumn - column) == direction[1])
					if (toLine >= 0 && toLine < chessBoard.board.length && toColumn >= 0 && toColumn < chessBoard.board[0].length)
						if (chessBoard.board[toLine][toColumn] == null) {
							validMove = true;
							break;
						}
			}
		 else if (line != chessBoard.board[0].length - 2 && color.equals("Black")) {
			for (int[] direction : moveRules) {
				if ((line - toLine) == direction[0] && (toColumn - column) == direction[1])
					if (toLine >= 0 && toLine < chessBoard.board.length && toColumn >= 0 && toColumn < chessBoard.board[0].length)
						if (chessBoard.board[toLine][toColumn] == null) {
							validMove = true;
							break;
						}
			}
		}

		if (color.equals("White")) {
			for (int[] direction : cutRules)
				if ((toLine - line) == direction[0] && (toColumn - column) == direction[1])
					if (toLine >= 0 && toLine < chessBoard.board.length && toColumn >= 0 && toColumn < chessBoard.board[0].length)
						if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(color))
							validMove = true;
		}else {
			for (int[] direction : cutRules) {
				if ((line - toLine) == direction[0] && (toColumn - column) == direction[1])
					if (toLine >= 0 && toLine < chessBoard.board.length && toColumn >= 0 && toColumn < chessBoard.board[0].length)
						if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(color))
							validMove = true;
			}
		}

		return validMove;
	}

	@Override
	public String getSymbol() {
		return "P";
	}
}
