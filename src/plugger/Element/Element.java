package plugger.Element;

import java.util.HashMap;
import java.util.Map;





public enum Element {
	//Shortname, id, name, weight, meltingPoint
    H((byte)1,(byte)1, "Hydrogen", 1.00794, 13.99),
    He((byte)2,(byte)18, "Helium", 4.002602, 0.95),
    Li((byte)3,(byte)1, "Lithium", 6.941, 453.65),
    Be((byte)4,(byte)2, "beryllium",9.012182, 1560),
    B((byte)5,(byte)13, "Boron", 6.941, 1560),
    C((byte)6,(byte)14, "Carbon", 6.941, 3800),
    
    N((byte)7,(byte)15, "Nitrogen", 6.941, 63.15 ),
    ;

    private static class Holder {
        static Map<Byte, Element> map = new HashMap<Byte, Element>();
    }

    private final Byte atomicNumber;
    private final Byte group;
    private final String fullName;
    private final double atomicMass;
    private final double meltingPoint;

    private Element(Byte atomicNumber,Byte group, String fullName, double atomicMass, double meltingPoint) {
        this.atomicNumber = atomicNumber;
        this.group=group;
        this.fullName = fullName;
        this.atomicMass = atomicMass;
        this.meltingPoint = meltingPoint;
        Holder.map.put(atomicNumber, this);
    }

    public static Element forAtomicNumber(int atomicNumber) {
        return Holder.map.get(atomicNumber);
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public double getAtomicMass() {
        return atomicMass;
    }

    public double getMeltingPoint() {
        return meltingPoint;
    }
}