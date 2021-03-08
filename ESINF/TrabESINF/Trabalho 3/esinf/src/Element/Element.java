package Element;

import java.util.Objects;

/**
 * The type Element.
 */
public abstract class Element implements Comparable<Element>{
    /**
     * The Atomic number.
     */
    int atomicNumber;
    /**
     * The Element.
     */
    String element;
    /**
     * The Symbol.
     */
    String symbol;
    /**
     * The Atomic weight.
     */
    float atomicWeight;
    /**
     * The Atomic mass.
     */
    float atomicMass;
    /**
     * The Period.
     */
    int period;
    /**
     * The Group.
     */
    int group;
    /**
     * The Phase.
     */
    String phase;
    /**
     * The Most stable crystal.
     */
    String mostStableCrystal;
    /**
     * The Type.
     */
    String type;
    /**
     * The Ionic radius.
     */
    float ionicRadius;
    /**
     * The Atomic radius.
     */
    float atomicRadius;
    /**
     * The Electronegativity.
     */
    float electronegativity;
    /**
     * The First ionization potencial.
     */
    float firstIonizationPotencial;
    /**
     * The Density.
     */
    float density;
    /**
     * The Melting point.
     */
    double meltingPoint;
    /**
     * The Boiling point.
     */
    double boilingPoint;
    /**
     * The Isotopes.
     */
    int isotopes;
    /**
     * The Discoverer.
     */
    String discoverer;
    /**
     * The Year of discovery.
     */
    int yearOfDiscovery;
    /**
     * The Specific heat capacity.
     */
    float specificHeatCapacity;
    /**
     * The Electron configuration.
     */
    String electronConfiguration;
    /**
     * The Display row.
     */
    int displayRow;
    /**
     * The Displaay column.
     */
    int displaayColumn;

    /**
     * Instantiates a new Element.
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
    public Element(int atomicNumber, String element, String symbol, float atomicWeight, float atomicMass, int period,
                   int group, String phase, String mostStableCrystal, String type, float ionicRadius, float atomicRadius,
                   float electronegativity, float firstIonizationPotencial, float density, double meltingPoint, double boilingPoint,
                   int isotopes, String discoverer, int yearOfDiscovery, float specificHeatCapacity, String electronConfiguration,
                   int displayRow, int displaayColumn) {
        this.atomicNumber = atomicNumber;
        this.element = element;
        this.symbol = symbol;
        this.atomicWeight = atomicWeight;
        this.atomicMass = atomicMass;
        this.period = period;
        this.group = group;
        this.phase = phase;
        this.mostStableCrystal = mostStableCrystal;
        this.type = type;
        this.ionicRadius = ionicRadius;
        this.atomicRadius = atomicRadius;
        this.electronegativity = electronegativity;
        this.firstIonizationPotencial = firstIonizationPotencial;
        this.density = density;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.isotopes = isotopes;
        this.discoverer = discoverer;
        this.yearOfDiscovery = yearOfDiscovery;
        this.specificHeatCapacity = specificHeatCapacity;
        this.electronConfiguration = electronConfiguration;
        this.displayRow = displayRow;
        this.displaayColumn = displaayColumn;
    }

    /**
     * Instantiates a new Element.
     *
     * @param atomicNumber the atomic number
     */
    public Element(int atomicNumber){
        this.atomicNumber = atomicNumber;
    }

    /**
     * Instantiates a new Element.
     *
     * @param atomicNumber the atomic number
     * @param symbol       the symbol
     */
    public Element(int atomicNumber,String symbol){
        this.symbol = symbol;
    }

    /**
     * Instantiates a new Element.
     *
     * @param atomicMass the atomic mass
     */
    public Element(float atomicMass){
        this.atomicMass = atomicMass;
    }

    /**
     * Instantiates a new Element.
     *
     * @param element the element
     */
    public Element(String element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element1 = (Element) o;
        return atomicNumber == element1.atomicNumber && Float.compare(element1.atomicWeight, atomicWeight) == 0 && Float.compare(element1.atomicMass, atomicMass) == 0 && period == element1.period && group == element1.group && Float.compare(element1.ionicRadius, ionicRadius) == 0 && Float.compare(element1.atomicRadius, atomicRadius) == 0 && Float.compare(element1.electronegativity, electronegativity) == 0 && Float.compare(element1.firstIonizationPotencial, firstIonizationPotencial) == 0 && Float.compare(element1.density, density) == 0 && Double.compare(element1.meltingPoint, meltingPoint) == 0 && Double.compare(element1.boilingPoint, boilingPoint) == 0 && isotopes == element1.isotopes && yearOfDiscovery == element1.yearOfDiscovery && Float.compare(element1.specificHeatCapacity, specificHeatCapacity) == 0 && displayRow == element1.displayRow && displaayColumn == element1.displaayColumn && Objects.equals(element, element1.element) && Objects.equals(symbol, element1.symbol) && Objects.equals(phase, element1.phase) && Objects.equals(mostStableCrystal, element1.mostStableCrystal) && Objects.equals(type, element1.type) && Objects.equals(discoverer, element1.discoverer) && Objects.equals(electronConfiguration, element1.electronConfiguration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atomicNumber);
    }

    @Override
    public String toString() {
        return String.format("Atomic Number: %d\nElement: %s\nSymbol: %s\nAtomic Weight: %f\nAtomic Mass: %f\n" +
                "Period: %d\nGroup: %d\nPhase: %s\nMost Stable Crystal: %s\nType: %s\nIonic Radius: %f\nAtomic Radius: %f\n" +
                "Electronegativity: %f\nFirst Ionization Potencial: %f\nDensity: %f\nMelting Point: %f\nBoiling Point: %f\n" +
                "Isotopes: %d\nDiscoverer: %s\nYear of Discovery: %d\nSpecific Heat Capacity: %f\nEletron Configuration: %s\n" +
                "Display Row: %d\nDisplay Column: %d",this.atomicNumber,this.element,this.symbol,this.atomicWeight,this.atomicMass,this.period
        ,this.group, this.phase, this.mostStableCrystal, this.type, this.ionicRadius,this.atomicRadius, this.electronegativity, this.firstIonizationPotencial,
                this.density, this.meltingPoint, this.boilingPoint, this.isotopes, this.discoverer, this.yearOfDiscovery, this.specificHeatCapacity,
                this.electronConfiguration, this.displayRow,this.displaayColumn);
    }

    @Override
    public abstract int compareTo(Element o);

    /**
     * Gets atomic number.
     *
     * @return the atomic number
     */
    public int getAtomicNumber() {
        return atomicNumber;
    }

    /**
     * Sets atomic number.
     *
     * @param atomicNumber the atomic number
     */
    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    /**
     * Gets element.
     *
     * @return the element
     */
    public String getElement() {
        return element;
    }

    /**
     * Sets element.
     *
     * @param element the element
     */
    public void setElement(String element) {
        this.element = element;
    }

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets symbol.
     *
     * @param symbol the symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets atomic weight.
     *
     * @return the atomic weight
     */
    public float getAtomicWeight() {
        return atomicWeight;
    }

    /**
     * Sets atomic weight.
     *
     * @param atomicWeight the atomic weight
     */
    public void setAtomicWeight(float atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    /**
     * Gets atomic mass.
     *
     * @return the atomic mass
     */
    public float getAtomicMass() {
        return atomicMass;
    }

    /**
     * Sets atomic mass.
     *
     * @param atomicMass the atomic mass
     */
    public void setAtomicMass(float atomicMass) {
        this.atomicMass = atomicMass;
    }

    /**
     * Gets period.
     *
     * @return the period
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Sets period.
     *
     * @param period the period
     */
    public void setPeriod(int period) {
        this.period = period;
    }

    /**
     * Gets group.
     *
     * @return the group
     */
    public int getGroup() {
        return group;
    }

    /**
     * Sets group.
     *
     * @param group the group
     */
    public void setGroup(int group) {
        this.group = group;
    }

    /**
     * Gets phase.
     *
     * @return the phase
     */
    public String getPhase() {
        return phase;
    }

    /**
     * Sets phase.
     *
     * @param phase the phase
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * Gets most stable crystal.
     *
     * @return the most stable crystal
     */
    public String getMostStableCrystal() {
        return mostStableCrystal;
    }

    /**
     * Sets most stable crystal.
     *
     * @param mostStableCrystal the most stable crystal
     */
    public void setMostStableCrystal(String mostStableCrystal) {
        this.mostStableCrystal = mostStableCrystal;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets ionic radius.
     *
     * @return the ionic radius
     */
    public float getIonicRadius() {
        return ionicRadius;
    }

    /**
     * Sets ionic radius.
     *
     * @param ionicRadius the ionic radius
     */
    public void setIonicRadius(float ionicRadius) {
        this.ionicRadius = ionicRadius;
    }

    /**
     * Gets atomic radius.
     *
     * @return the atomic radius
     */
    public float getAtomicRadius() {
        return atomicRadius;
    }

    /**
     * Sets atomic radius.
     *
     * @param atomicRadius the atomic radius
     */
    public void setAtomicRadius(float atomicRadius) {
        this.atomicRadius = atomicRadius;
    }

    /**
     * Gets electronegativity.
     *
     * @return the electronegativity
     */
    public float getElectronegativity() {
        return electronegativity;
    }

    /**
     * Sets electronegativity.
     *
     * @param electronegativity the electronegativity
     */
    public void setElectronegativity(float electronegativity) {
        this.electronegativity = electronegativity;
    }

    /**
     * Gets first ionization potencial.
     *
     * @return the first ionization potencial
     */
    public float getFirstIonizationPotencial() {
        return firstIonizationPotencial;
    }

    /**
     * Sets first ionization potencial.
     *
     * @param firstIonizationPotencial the first ionization potencial
     */
    public void setFirstIonizationPotencial(float firstIonizationPotencial) {
        this.firstIonizationPotencial = firstIonizationPotencial;
    }

    /**
     * Gets density.
     *
     * @return the density
     */
    public float getDensity() {
        return density;
    }

    /**
     * Sets density.
     *
     * @param density the density
     */
    public void setDensity(float density) {
        this.density = density;
    }

    /**
     * Gets melting point.
     *
     * @return the melting point
     */
    public double getMeltingPoint() {
        return meltingPoint;
    }

    /**
     * Sets melting point.
     *
     * @param meltingPoint the melting point
     */
    public void setMeltingPoint(double meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    /**
     * Gets boiling point.
     *
     * @return the boiling point
     */
    public double getBoilingPoint() {
        return boilingPoint;
    }

    /**
     * Sets boiling point.
     *
     * @param boilingPoint the boiling point
     */
    public void setBoilingPoint(double boilingPoint) {
        this.boilingPoint = boilingPoint;
    }

    /**
     * Gets isotopes.
     *
     * @return the isotopes
     */
    public int getIsotopes() {
        return isotopes;
    }

    /**
     * Sets isotopes.
     *
     * @param isotopes the isotopes
     */
    public void setIsotopes(int isotopes) {
        this.isotopes = isotopes;
    }

    /**
     * Gets discoverer.
     *
     * @return the discoverer
     */
    public String getDiscoverer() {
        return discoverer;
    }

    /**
     * Sets discoverer.
     *
     * @param discoverer the discoverer
     */
    public void setDiscoverer(String discoverer) {
        this.discoverer = discoverer;
    }

    /**
     * Gets year of discovery.
     *
     * @return the year of discovery
     */
    public int getYearOfDiscovery() {
        return yearOfDiscovery;
    }

    /**
     * Sets year of discovery.
     *
     * @param yearOfDiscovery the year of discovery
     */
    public void setYearOfDiscovery(int yearOfDiscovery) {
        this.yearOfDiscovery = yearOfDiscovery;
    }

    /**
     * Gets specific heat capacity.
     *
     * @return the specific heat capacity
     */
    public float getSpecificHeatCapacity() {
        return specificHeatCapacity;
    }

    /**
     * Sets specific heat capacity.
     *
     * @param specificHeatCapacity the specific heat capacity
     */
    public void setSpecificHeatCapacity(float specificHeatCapacity) {
        this.specificHeatCapacity = specificHeatCapacity;
    }

    /**
     * Gets electron configuration.
     *
     * @return the electron configuration
     */
    public String getElectronConfiguration() {
        return electronConfiguration;
    }

    /**
     * Sets electron configuration.
     *
     * @param electronConfiguration the electron configuration
     */
    public void setElectronConfiguration(String electronConfiguration) {
        this.electronConfiguration = electronConfiguration;
    }

    /**
     * Gets display row.
     *
     * @return the display row
     */
    public int getDisplayRow() {
        return displayRow;
    }

    /**
     * Sets display row.
     *
     * @param displayRow the display row
     */
    public void setDisplayRow(int displayRow) {
        this.displayRow = displayRow;
    }

    /**
     * Gets displaay column.
     *
     * @return the displaay column
     */
    public int getDisplaayColumn() {
        return displaayColumn;
    }

    /**
     * Sets displaay column.
     *
     * @param displaayColumn the displaay column
     */
    public void setDisplaayColumn(int displaayColumn) {
        this.displaayColumn = displaayColumn;
    }


}
