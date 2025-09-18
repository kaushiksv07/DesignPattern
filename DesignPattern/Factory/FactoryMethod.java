Factory Method Example

interface Query{
	void execute();
} 
class MySqlQuery implements Query{
    public void execute(){
        System.out.println("MySql Query");
    }
}
class NoSQLQuery implements Query{
    public void execute(){
        System.out.println("NoSQL Query");
    }
}
interface QueryFactory{
    Query createQuery();
}
class MySqlQueryFactory implements QueryFactory{
    public Query createQuery(){
        return new MySqlQuery();
    }
}
class NoSQLQueryFactory implements QueryFactory{
    public Query createQuery(){
        return new NoSQLQuery();
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        QueryFactory factory = new MySqlQueryFactory();
        Query query = factory.createQuery();
        query.execute();

        factory = new NoSQLQueryFactory();
        query = factory.createQuery();
        query.execute();
    }
}