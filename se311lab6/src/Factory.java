import java.util.ArrayList;

//============================================================================
//Name        : FactoryMethod.cpp
//
//The classes and/or objects participating in this pattern are:
//1. Product  (Jacket,Trouser - Abstract)
//	 Defines the interface of objects the factory method creates
//2. ConcreteProduct  (Zara_Jacket, ASOS_Jacket,Tech_Jacket,Zara_Trouser,ASOS_Trouser,Tech_Trouser )
//	 Implements the Product interface
//3. Creator  (ClothingCreator)
//	 Declares the factory method, which returns an object of type Product.
//	 Creator may also define a default implementation of the factory method
//	 that returns a default ConcreteProduct object.
//	 May call the factory method to create a Product object.
//4. ConcreteCreator (ZaraBundleCreator, ASOSBundleCreator, TechWearBundleCreator)
//	 Overrides the factory method to return an instance of a ConcreteProduct.
//============================================================================


// Top "Abstract Product" Part class
abstract class Part {
    abstract public String displayName();
    abstract double getPrice();
}

// Product Class
class Jacket extends Part {
    protected double price;
    protected String name;
    public double getPrice(){ return price; }
    public String displayName() { return name; }
}

// Product Class
class Trouser extends Part {
    protected double price;
    protected String name;
    public double getPrice(){ return price; }
    public String displayName() { return name; }
}

//A 'ConcreteProduct' class
class Zara_Jacket extends Jacket {
    public Zara_Jacket(double p) {
        price = p;
        name = new String("Denim Wooly");
        System.out.println("Zara Jacket is created...");
    }
}

class ASOS_Jacket extends Jacket {
    public ASOS_Jacket(double p) {
        price = p;
        name = new String("Collusion Track");
        System.out.println("Collusion Track is created...");
    }
}

class Tech_Jacket extends Jacket {
    public Tech_Jacket(double p) {
        price = p;
        name = new String("Cyber Jacket");
        System.out.println("Tech Jacket is created...");
    }
}

//A 'ConcreteProduct ' class
class Zara_Trouser extends Trouser {
    public Zara_Trouser(double p) {
        price = p;
        name = new String("Cargo Jeans");
        System.out.println("Zara Trouser is created...");
    }
}

class ASOS_Trouser extends Trouser {
    public ASOS_Trouser(double p) {
        price = p;
        name = new String("Tux Trousers");
        System.out.println("Tux Trousers is created...");
    }
}
class Tech_Trouser extends Trouser {
    public Tech_Trouser(double p) {
        price = p;
        name = new String("Multi-pocket Pants");
        System.out.println("Tech Trouser is created...");
    }
}
//An 'Abstract Factory' class
abstract class ClothingCreator {
    // Object creation is delegated to factory.
    abstract public Part createPart(String type);

    public void createBundle() {
        parts = new ArrayList<Part>();
        parts.add(createPart("Jacket"));
        parts.add(createPart("Trouser"));
    }

    void displayClothes() {
        System.out.println("\tListing Clothing Bundle\n\t-------------");
        parts.forEach(p-> System.out.println("\t" + p.displayName() +
                " " + p.getPrice()));
    }

    private ArrayList<Part> parts;
}

//A 'ConcreteCreator' class
class ZaraBundleCreator extends ClothingCreator {
    // Factory Method implementation
    // We are overriding the factory method
    public Part createPart(String type) {
        if (type.equals("Jacket")) {
            return new Zara_Jacket (24.99);
        }
        else if (type.equals("Trouser")) {
            return new Zara_Trouser(9.99);
        }
        else {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}
class ASOSBundleCreator extends ClothingCreator {
    // Factory Method implementation
    // We are overriding the factory method
    public Part createPart(String type) {
        if (type.equals("Jacket")) {
            return new ASOS_Jacket (59.99);
        }
        else if (type.equals("Trouser")) {
            return new ASOS_Trouser(39.99);
        }
        else {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}

class TechWearBundleCreator extends ClothingCreator {
    // Factory Method implementation
    // We are overriding the factory method
    public Part createPart(String type) {
        if (type.equals("Jacket")) {
            return new Tech_Jacket (29.99);
        }
        else if (type.equals("Trouser")) {
            return new Tech_Trouser(19.99);
        }
        else {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}

public class Factory {
    //Factory Method Design Pattern.
    //Entry point into main application.
    public static void main(String[] args) {

        ClothingCreator creator = new ZaraBundleCreator();
        ClothingCreator creator2 = new TechWearBundleCreator();
        ClothingCreator creator3 = new ASOSBundleCreator();


        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Creating Bundle");
        creator.createBundle();
        creator.displayClothes();
        System.out.println(" ");
        System.out.println("++++++++++++++++++++++++++++++");


        System.out.println("Creating Bundle");
        creator2.createBundle();
        creator2.displayClothes();
        System.out.println(" ");
        System.out.println("++++++++++++++++++++++++++++++");

        System.out.println("Creating Bundle");
        creator3.createBundle();
        creator3.displayClothes();
        System.out.println(" ");
        System.out.println("++++++++++++++++++++++++++++++");


    }
}