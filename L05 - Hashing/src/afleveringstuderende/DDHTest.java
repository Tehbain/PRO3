package afleveringstuderende;

public class DDHTest {
    public static void main(String[] args) {
        DictionaryDoubleHashing ddh = new DictionaryDoubleHashing<>(4);

        System.out.println("Nye DDH: " + ddh);

        System.out.println("Smider 4 entries ind: ");
        System.out.println(ddh.put("Jønke", "Revolver"));
        System.out.println(ddh.put("Ådsel", "Skovl"));
        System.out.println(ddh.put("Hunulven", "Pisk"));
        System.out.println(ddh.put("Jønke", "Glock"));

        ddh.writeOut();
    }
}
