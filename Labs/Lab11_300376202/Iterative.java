import java.util.Stack;

public class Iterative {

	public static BitList complement(BitList bl) {

		BitList result = new BitList();
		Iterator iterator = bl.iterator();


		Stack<Integer> stack = new Stack<>();

		while (iterator.hasNext()) {
			int bit = iterator.next();
			stack.push(bit == BitList.ZERO ? BitList.ONE : BitList.ZERO);
		}

		while (!stack.isEmpty()) {
			result.addFirst(stack.pop());
		}

		return result;
	}
	public static BitList or(BitList bl1, BitList bl2) {
		checkInputLists(bl1, bl2);

		Iterator it1 = bl1.iterator();
		Iterator it2 = bl2.iterator();

		BitList result = new BitList();

		while (it1.hasNext() && it2.hasNext()) {
			int bit1 = it1.next();
			int bit2 = it2.next();
			result.addFirst(bit1 | bit2);
		}

		return reverseList(result);
	}

	public static BitList and(BitList bl1, BitList bl2) {
		checkInputLists(bl1, bl2);

		BitList result = new BitList();
		Iterator it1 = bl1.iterator();
		Iterator it2 = bl2.iterator();

		while (it1.hasNext() && it2.hasNext()) {
			int bit1 = it1.next();
			int bit2 = it2.next();
			result.addFirst(bit1 & bit2);
		}

		return reverseList(result);
	}

	public static BitList xor(BitList bl1, BitList bl2) {
		checkInputLists(bl1, bl2);

		BitList result = new BitList();
		Iterator it1 = bl1.iterator();
		Iterator it2 = bl2.iterator();

		while (it1.hasNext() && it2.hasNext()) {
			int bit1 = it1.next();
			int bit2 = it2.next();
			result.addFirst(bit1 ^ bit2);
		}

		return reverseList(result);
	}

	private static void checkInputLists(BitList bl1, BitList bl2) {
		if (bl1 == null || bl2 == null) {
			throw new IllegalArgumentException("Input BitList cannot be null");
		}

		if (bl1.toString().isEmpty() || bl2.toString().isEmpty()) {
			throw new IllegalArgumentException("BitLists cannot be empty");
		}
		if (bl1.toString().length() != bl2.toString().length()) {
			throw new IllegalArgumentException("BitLists must be of the same length");
		}
	}


	private static BitList reverseList(BitList list) {
		BitList reversed = new BitList();
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			reversed.addFirst(iterator.next());
		}

		return reversed;
	}
}


