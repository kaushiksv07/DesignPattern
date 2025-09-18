Abstract Factory Example

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
interface Transaction{
    void execute();
}
class MySqlTransaction implements Transaction{
    public void execute(){
        System.out.println("MySql Transaction");
    }
}
class NoSQLTransaction implements Transaction{
    public void execute(){
        System.out.println("NoSQL Transaction");
    }
}   
interface DatabaseQueryFactory {
    TransactionQuery createTransactionQuery();
    UpdateQuery createUpdateQuery();
}
class MySqlDatabaseQueryFactory implements DatabaseQueryFactory {
    public Transaction createTransactionQuery() {
        return new MySqlTransaction();
    }
    public Query createUpdateQuery() {
        return new MySqlQuery();
    }
}
class NoSQLDatabaseQueryFactory implements DatabaseQueryFactory {
    public Transaction createTransactionQuery() {
        return new NoSQLTransaction();
    }
    public Query createUpdateQuery() {
        return new NoSQLQuery();
    }
}   
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        DatabaseQueryFactory sqlFactory = new SQLQueryFactory();
        sqlFactory.createTransactionQuery().createTransactional();
        sqlFactory.createUpdateQuery().createUpdate();

        DatabaseQueryFactory nosqlFactory = new NoSQLQueryFactory();
        nosqlFactory.createTransactionQuery().createTransactional();
        nosqlFactory.createUpdateQuery().createUpdate();
    }
}