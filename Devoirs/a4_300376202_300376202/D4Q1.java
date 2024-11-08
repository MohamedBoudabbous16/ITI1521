public class D4Q1 {
    public static void main (String[] args) {
        SinglyLinkedList<Boolean> l1, l2, l3;
       
        l1 = new SinglyLinkedList<Boolean>();  
        l1.add(Boolean.valueOf(true), 0);
        l1.add(Boolean.valueOf(true), 0);
        l1.add(Boolean.valueOf(true), 0);
        l1.add(Boolean.valueOf(true), 0);
        System.out.println(l1.allTrue());   //affiche true

        l2 = new SinglyLinkedList<Boolean>();
        l2.add(Boolean.valueOf(true), 0);
        l2.add(Boolean.valueOf(true), 0);
        l2.add(Boolean.valueOf(false), 0);
        l2.add(Boolean.valueOf(true), 0);
        System.out.println(l2.allTrue());  //affiche false;

        l3 = new SinglyLinkedList<Boolean>();
        try {
            System.out.println(l3.allTrue());  //lance une exception
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
}
