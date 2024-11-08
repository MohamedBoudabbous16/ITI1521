/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

	private Post[] messages;
	private int size = 0;
	public static final int MAX_SIZE = 25;

	public NewsFeed() {
		messages = new Post[MAX_SIZE];
	}

	public void add(Post message) {
		if (size < MAX_SIZE) {
			messages[size] = message;
			size++;
		}
	}

	public Post get(int index) {
		if (index >= 0 && index < size) {
			return messages[index];
		} else {
			return null;
		}
	}

	public int size() {
		return size;
	}

	public void sort() {
		for (int i = 0; i < this.size - 1; i++) {
			int argMin = i;
			for (int j = i + 1; j < size; j++) {
				if (messages[j].compareTo(messages[argMin]) < 0) {
					argMin = j;
				}
			}
			Post tmp = messages[argMin];
			messages[argMin] = messages[i];
			messages[i] = tmp;
		}
	}

	public NewsFeed getPhotoPost() {
		NewsFeed photoFeed = new NewsFeed();
		for (int i = 0; i < size; i++) {
			if (messages[i] instanceof PhotoPost) { // Using instanceof for simplicity
				photoFeed.add(messages[i]);
			}
		}
		return photoFeed;
	}


  	public NewsFeed plus(NewsFeed other){

		NewsFeed old = new NewsFeed();
		for (int i = 0; i < this.size(); i++){
			old.add(this.messages[i]);
		}
		for (int j = 0; j < other.size(); j++){
			old.add(other.messages[j]);
		}
		old.sort();
		return old;
	}

}
