public class CylinderTest {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println("Default Cylinder:");
        c1.displayDetails();
        
        System.out.println("\nCustom Cylinder (length=8, radius=2):");
        Cylinder c2 = new Cylinder(8, 2);
        c2.displayDetails();
    }
}
