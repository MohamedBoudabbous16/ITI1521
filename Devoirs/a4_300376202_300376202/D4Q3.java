public class D4Q3 {

    public static void main(String[] args) {

		LinkedList<String> l= new LinkedList<String>();

		l.add("A", 0);
        l.add("B", 1);
        l.add("C", 2);
        System.out.println(l);

        Iterator<String> i = l.iterator();
        System.out.println(i.next()); // affiche A
        System.out.println(i.next()); // affiche B
        System.out.println(i.next()); // affiche C
        System.out.println(i.next()); // boucle vers l’avant et affiche A
        System.out.println(i.next()); // affiche B
        System.out.println(i.prev()); // affiche A
        System.out.println(i.prev()); // boucle vers l’arrière et affiche C
        System.out.println(i.prev()); // affiche B		
    }    
}
