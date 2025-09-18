Builder Design Pattern

    1. Helps to create Complex objects step by step
    2. Instead of having bug messy constructor with too many parameters. Builder gives a clean and flexible way to create objects.

Other option and advantage and dis advantages 
    1. Telescoping Constructor Pattern
        User u = new User("Kaushik", 25, "Bangalore", "Engineer");

        Issues:
        1. Too many parameters in constructor
        2. If wea add a new parameter, we need to change all the places where this constructor is called.
        3. If we have multiple constructors with different combinations of parameters, it becomes messy and hard to maintain.

    2. Setter Methods
        User u = new User();
        u.setName("Kaushik");
        u.setAge(25);
        u.setAddress("Bangalore");
        u.setOccupation("Engineer");

        Issues:
        1. Object get misused after creation
        2. Object creation possible without setting critera check
        3. Attributes whose setters are not presented values will not get set.

    3. Using Map 

        Map<Key, Value> map = new HashMap<>();
        map.put("name", "Kaushik");
        map.put("age", 25);
        map.put("address", "Bangalore");
        map.put("occupation", "Engineer");

        Issues:
        1. No type check for values
        2. Key names are not accurate


    4. Builder Pattern

        User u = new User.UserBuilder()
                        .setName("Kaushik")
                        .setAge(25)
                        .setAddress("Bangalore")
                        .setOccupation("Engineer")
                        .build();

        Advantages:
        1. Clean and readable code
        2. Flexible object creation
        3. Immutable object creation
        4. Type safety
