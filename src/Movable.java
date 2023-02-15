public interface Movable {
	default boolean canMoveStraight(ChessBoard chessBoard,
								   int line,
								   int column,
								   int toLine,
								   int toColumn,
								   int limit,
									String color) {

		if (toLine == line || toColumn == column){
			if (!(toLine == line && toColumn == column)) {
				if (
						toLine >= 0 &&
								toLine < chessBoard.board.length &&
								toColumn >= 0 &&
								toColumn < chessBoard.board[0].length
				) {
					// Circles for collision check
					for (int checkLine = Math.min(line, toLine) + 1; // Line check
						 checkLine < Math.max(line, toLine);
						 checkLine++) {
						for (int checkColumn = Math.min(column, toColumn) + 1; // Column check
							 checkColumn < Math.max(column, toColumn);
							 checkColumn++) {
							if (chessBoard.board[checkLine][checkColumn] != null &&
							chessBoard.board[checkLine][checkColumn].getColor().equals(color))
								return false;
						}
					}

					return chessBoard.board[toLine][toColumn] == null ||
							!chessBoard.board[toLine][toColumn].getColor().equals(color) &&
									(Math.abs(toLine - line) <= limit) &&
									(Math.abs(toColumn - column) <= limit);
				}
			}
		}
		return false;
	}

	default boolean canMoveDiagonals(ChessBoard chessBoard,
									 int line,
									 int column,
									 int toLine,
									 int toColumn,
									 int limit,
									 String color) {

		if (toLine != line && toColumn != column) {
			if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
				if (toLine >= 0 && toLine < chessBoard.board.length && toColumn >= 0 && toColumn < chessBoard.board[0].length) {

					// Right diagonal check
					for (int checkLine = Math.min(line, toLine) + 1, checkColumn = Math.min(column, toColumn) + 1;
						 checkLine < Math.max(line, toLine);
						 checkLine++, checkColumn++)
						if (chessBoard.board[checkLine][checkColumn] != null && chessBoard.board[checkLine][checkColumn].getColor().equals(color))
							return false;

					// Left diagonal check
					for (int checkLine = Math.min(line, toLine) + 1, checkColumn = Math.min(column, toColumn) + 1;
						 checkLine < Math.max(line, toLine);
						 checkLine++, checkColumn--)
						if (chessBoard.board[checkLine][checkColumn] != null && chessBoard.board[checkLine][checkColumn].getColor().equals(color))
							return false;
				}

				return chessBoard.board[toLine][toColumn] == null ||
						!chessBoard.board[toLine][toColumn].getColor().equals(color) &&
								(Math.abs(toLine - line) <= limit) &&
								(Math.abs(toColumn - column) <= limit);
			}
		}
		return false;
	}
}
