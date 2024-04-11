package iterator;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class IteratorClass implements Iterator {

	private int counter;
	private int length;

	private GameObject[] list ;
	public IteratorClass(List<GameObject> list) {
		this.length = list.size();
		this.list = new GameObject[this.length];
		this.list =  list.toArray(this.list);
		this.counter = 0;
	}

	@Override
	public boolean hasNext() {
		return (counter) < length;
	}

	@Override
	public GameObject next() {
		return this.list[counter++];
	}

}
