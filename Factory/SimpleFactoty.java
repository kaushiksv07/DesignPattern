Factory Design Patterns

Simple Factory


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
class QueryFactory{
    public static Query getQuery(String dbType){
        if(dbType.equals("MySql")){
            return new MySqlQuery();
        }else if(dbType.equals("NoSQL")){
            return new NoSQLQuery();
        }
        return null;
    }
}
//Client
class Client{
    public static void main(String[] args){
        Query query = QueryFactory.getQuery("MySql");
        query.execute();
    }
}

The above represents the Simple Factory Design Pattern.


