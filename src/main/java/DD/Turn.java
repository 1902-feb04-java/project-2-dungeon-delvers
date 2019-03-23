package DD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Turn {
	private int[] turns;
	private int max = 0;
	private int pos = 0;
	
	public Turn() {
		super();
	}
	
	public Turn(int dungeonMasterId, int monsterCount, int... playerIds)
	{
		ArrayList<Integer> i = new ArrayList<Integer>();
		for (int pi : playerIds)
		{
			i.add(pi);
		}
		
		 for (int x = 0; x < monsterCount; x++)
		{
			i.add(dungeonMasterId);
		}
		i.add(dungeonMasterId);
		Collections.shuffle(i);
		int[] toArr = new int[i.size()];
		for (int x = 0; x < toArr.length; x++)
		{
			toArr[x] = (int)i.get(x);
		}
		turns = toArr;
	}
	
	public boolean isNext(int id)
	{
		if (id == turns[pos])
		{
			next();
			return true;
		}
		return false; 
		
	}
	
	private void next()
	{
		if ((pos + 1) == max)
		{
			pos = 0;
		}
		else
		{
			pos++;
		}
	}

	public int[] getTurns() {
		return turns;
	}

	public void setTurns(int[] turns) {
		this.turns = turns;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Turn [turns="
				+ (turns != null ? Arrays.toString(Arrays.copyOf(turns, Math.min(turns.length, maxLen))) : null)
				+ ", max=" + max + ", pos=" + pos + "]";
	}
}
