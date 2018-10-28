package org.deepfrequencies.sudoku.domain;

public class Location {
	public final int i;
	public final int j;

	public Location(int x, int y) {
		this.i = x;
		this.j = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (i != other.i)
			return false;
		return j != other.j ? false : true;
	}
}
