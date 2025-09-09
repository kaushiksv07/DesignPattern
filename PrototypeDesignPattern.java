Prototype and Registory Design Pattern:
    Allows to create a clone or copy of the object

Copy approch :
    Student st = new Student();
    Student st1 = new Student();
    st1.setName(st.getName());
    st1.setId(st.getId());
    st1.setAddress(st.getAddress());

      Issues in old approch:
        1. No resusability
        2. No maintenance and extensions
        3. Private members not able to set 
    
Copy constructor:
    Student :  name, age, psp
       |
       |
    IntelligentStudent ectends Student : iq

    void copyStudent(Student st){
        if(st instanceof IntelligentStudent){
            //call copy constructor of IntelligentStudent
        }else if(st instanceof Student){
            //call copy constructor of Student
        }
    }

    Issues:
        1. It breaks SRP and OCP

Solution: Prototype Design Pattern

Usages:
    1. Gaming industry
    2. Clone Browser tab 

Problem Statement:
    Testing framework for a user API of a social media platform. Each test case requires generating multiple mock users 
    with different attributes to simulate various scenarios. However, creating mock users for testing involves complex 
    setups and is time-consuming. To optimize the user creation process during testing, you decide to implement the Prototype pattern.

public interface PrototypeObject<T> {
    T cloneObject();
}
public interface UserPrototypeRegistory{
    void addProtoType(User user);
    User getProtoType(UserType type);
    User cloneUser(UserType type);
}
public enum UserType {
    ADMIN, READER, WRITER
}
@Getters
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements PrototypeObject<User>, UserPrototypeRegistory{
    HashMap<UserType, User> hashMap= new HashMap<>();
    private String name;
    private String email;
    private String userId;
    private String displayName;
    private UserType userType;

    @Override
    public User cloneObject() {
        return new User(this);
    }

    @Override
    public void addProtoType(User user) {
        hashMap.put(user.getUserType(), user);
    }

    @Override
    public User getProtoType(UserType type) {
        return hashMap.get(type);
    }

    @Override
    public User cloneUser(UserType type) {
        User prototype = hashMap.get(type);
        return prototype != null ? prototype.cloneObject() : null;
    }
}


What is Registry Pattern?
   A Registry Pattern is like a centralized storage (a map/registry).
   Instead of creating objects directly, the client asks the registry for an instance.

In the above code we are using Registory pattern 
    HashMap<UserType, User> hashMap= new HashMap<>();

And our methods:
    addProtoType(User user) → Adds an object to the registry.
    getProtoType(UserType type) → Fetches from the registry.
    cloneUser(UserType type) → Fetches prototype from registry, then clones it.