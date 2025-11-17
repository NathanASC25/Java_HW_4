public class Workbook {
    public static void main(String[] args) {
        Store bigStore = new Store();
	Store littleStore = new Store();

	bigStore.name = "SaveAll";
	bigStore.address = "1.23 E. 23rd";
	bigStore.sqFeet = 9894;

	littleStore.name = "Mom's Food";
	littleStore.address = "83 N. Oak";
	littleStore.sqFeet = 1213;

	System.out.println("Store: " + bigStore.name);
	System.out.println("at: " + bigStore.address);
	System.out.println("has: " + bigStore.sqFeet + " feet.");

	System.out.println("Store: " + littleStore.name);
	System.out.println("at: " + littleStore.address);
	System.out.println("has: " + littleStore.sqFeet + " feet.");
    }
    /* Output: 
     *
     *
     * Store: SaveAll
     * at: 1.23 E. 23rd
     * has: 9894 feet.
     * Store: Mom's Food
     * at: 83 N. Oak
     * has: 1213 feet.
     *
     *
     * */
}
