package afleveringstuderende;

public class DDHTest {
    public static void main(String[] args) {
        DictionaryDoubleHashing ddh = new DictionaryDoubleHashing<>(10);

        System.out.println("\nNy DDH: " + ddh);

        System.out.println("\nSmider 4 entries ind: ");
        System.out.println(ddh.put("Jønke", "Revolver"));
        System.out.println(ddh.put("Ådsel", "Skovl"));
        System.out.println(ddh.put("Hunulven", "Pisk"));
        System.out.println(ddh.put("Jønke", "Glock"));      //burde ikke blive sat ind

        System.out.println("\nwriteOut()");
        ddh.writeOut();
        System.out.println();

        System.out.println("Get Hunulven");
        System.out.println(ddh.get("Hunulven"));
        System.out.println();

        System.out.println("Remove Hunulven");
        System.out.println("Pisk?: " + ddh.remove("Hunulven").equals("Pisk"));
        System.out.println("Post remove writeout()");
        ddh.writeOut();
    }
}
