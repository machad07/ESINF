package Element;

/**
 * The type Element comparable atomic number.
 */
public class Element_Comparable_AtomicNumber extends Element {

    /**
     * Instantiates a new Element comparable atomic number.
     *
     * @param atomicNumber             the atomic number
     * @param element                  the element
     * @param symbol                   the symbol
     * @param atomicWeight             the atomic weight
     * @param atomicMass               the atomic mass
     * @param period                   the period
     * @param group                    the group
     * @param phase                    the phase
     * @param mostStableCrystal        the most stable crystal
     * @param type                     the type
     * @param ionicRadius              the ionic radius
     * @param atomicRadius             the atomic radius
     * @param electronegativity        the electronegativity
     * @param firstIonizationPotencial the first ionization potencial
     * @param density                  the density
     * @param meltingPoint             the melting point
     * @param boilingPoint             the boiling point
     * @param isotopes                 the isotopes
     * @param discoverer               the discoverer
     * @param yearOfDiscovery          the year of discovery
     * @param specificHeatCapacity     the specific heat capacity
     * @param electronConfiguration    the electron configuration
     * @param displayRow               the display row
     * @param displaayColumn           the displaay column
     */
    public Element_Comparable_AtomicNumber(int atomicNumber, String element, String symbol, float atomicWeight, float atomicMass, int period, int group, String phase, String mostStableCrystal, String type, float ionicRadius, float atomicRadius, float electronegativity, float firstIonizationPotencial, float density, double meltingPoint, double boilingPoint, int isotopes, String discoverer, int yearOfDiscovery, float specificHeatCapacity, String electronConfiguration, int displayRow, int displaayColumn) {
        super(atomicNumber, element, symbol, atomicWeight, atomicMass, period, group, phase, mostStableCrystal, type, ionicRadius, atomicRadius, electronegativity, firstIonizationPotencial, density, meltingPoint, boilingPoint, isotopes, discoverer, yearOfDiscovery, specificHeatCapacity, electronConfiguration, displayRow, displaayColumn);
    }

    /**
     * Instantiates a new Element comparable atomic number.
     *
     * @param atomicNumber the atomic number
     */
    public Element_Comparable_AtomicNumber(int atomicNumber){
        super(atomicNumber);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public int compareTo(Element o) {
        if (this.atomicNumber < o.atomicNumber)
            return -1;
        if (atomicNumber > o.atomicNumber)
            return 1;
        return 0;
    }
}
