package src.plugger.Element;

import java.util.HashMap;
import java.util.Map;





public enum Element {
	//Shortname, id, name, weight, meltingPoint
    H(1,1, "Hydrogen", 1.00794, 13.99),
    He(2,18, "Helium", 4.002602, 0.95),
    Li(3,1, "Lithium", 6.941, 453.65),
    Be(4,2, "beryllium",9.012182, 1560),
    B(5,13, "Boron", 6.941, 1560),
    C(6,14, "Carbon", 6.941, 3800),
    
    N(7,15, "Nitrogen", 6.941, 63.15 ),
    ;

    private static class Holder {
        static Map<Integer, Element> map = new HashMap<Integer, Element>();
    }

    private final int atomicNumber;
    private final int group;
    private final String fullName;
    private final double atomicMass;
    private final double meltingPoint;

    private Element(int atomicNumber,int group, String fullName, double atomicMass, double meltingPoint) {
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