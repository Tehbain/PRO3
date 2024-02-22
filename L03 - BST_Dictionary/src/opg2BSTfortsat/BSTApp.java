package opg2BSTfortsat;

public class BSTApp {



    public static void main(String[] args) {
        // breadth-first inserts giver et ordnet træ
        BST biTree = new BST<>(new Integer[]{60,55,100,45,57,67,107,59,101});
        System.out.println("---------------------");

        //Opg 1.3
        {
            System.out.println("ROOT ELEMENT IS: " + biTree.root.element);
            System.out.println("PREORDER");
                biTree.preorder();
            System.out.println();
            System.out.println("INORDER");
                biTree.inorder();
            System.out.println();
            System.out.println("POSTORDER");
                biTree.postorder();
            System.out.println();
            System.out.println("--------------------");
        }

        //Opg 2
        {
            System.out.print("IS ROOT A LEAF? ");
            System.out.println(biTree.isLeaf(biTree.root));
            System.out.print("IS ROOT INTERNAL? ");
            System.out.println(biTree.isInternal(biTree.root));

            System.out.println("HEIGHT SHOULD BE 3 for BST biTree");
            System.out.println("   Height is: " + biTree.height());
            System.out.println("------------------");
        }

        //Opg 3
        {
            System.out.println("SUM FOR BST biTree SHOULD BE: 651");
            System.out.println("   biTree sum actual: " + biTree.sum());
            System.out.println("----------------------");
        }
        //Opg 4
        {
            System.out.println("FindMax should return: 107");
            System.out.println("   Max is: " + biTree.findMax());
            System.out.println("FindMin should return: 45");
            System.out.println("   Min is: " + biTree.findMin());
        }

        /*
        Opgave 2
            Tilføj nedenstående metoder i det udleverede binære søgetræ(fra sidste gang). Dvs
            implementer metoderne
            • removeMin – metoden skal fjerne og returnere det mindste element i søgetræet.
            Metoden må ikke gå igennem træet flere gange, og må derfor ikke kalde den
            eksisterende delete metode.
            • removeMax – som removeMin, men her skal fjernes det største element
            • greaterThan(E element): ArrayList<E> – metoden skal returnere alle de
            elementer i træet der er større end element.
         */

    }

}
