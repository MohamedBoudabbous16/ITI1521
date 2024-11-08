public class D4Q2 {
    public static void main(String[] args) {
		LinkedList<Integer> l1, l2;

		l1 = new LinkedList<Integer>();
		for (int i=5; i>0; i--) {
			l1.add(i, 0);
		}

		l2 = new LinkedList<Integer>();
		for (int i=0; i<4; i++) {
			l2.add(i+6, i);
		}
		System.out.println("Avant merge");
		System.out.println(l1);
		System.out.println(" size l1=" + l1.size());
		System.out.println(l2);
		System.out.println(" size l2=" + l2.size());

		l1.merge(l2);

		System.out.println("Apres merge");
		System.out.println(l1);
		System.out.println(" size l1=" + l1.size());
		System.out.println(l2);
		System.out.println(" size l2=" + l2.size());
    }    
}
