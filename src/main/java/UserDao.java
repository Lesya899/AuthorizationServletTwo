import org.hibernate.HibernateException;
import org.hibernate.Session; //работа с БД в Hibernate осуществляется через объект сессии
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDao {
    private Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    public UserDataSet get(long id) throws HibernateException {
        return session.get(UserDataSet.class, id); //получение из БД объекта класса-сущности с определённым Id в статусе persistent
    }

    public UserDataSet getUsers(String name) throws HibernateException {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();  //интерфейс CriteriaBuilder используется для построения критериев запросов
        CriteriaQuery<UserDataSet> criteria = criteriaBuilder.createQuery(UserDataSet.class); //создаем объект CriteriaQuery для составления дополнительных условий запроса
        Root<UserDataSet> root = criteria.from(UserDataSet.class); //интерфейс Root - корневой тип в предложении from. Корни запросов всегда ссылаются на сущности
        criteria.select(root); //указываем элемент, который должен быть возвращен в результате запроса
        criteria.where(criteriaBuilder.equal(root.get("name"), name)); //конструируем  условие для WHERE
        Query query = session.createQuery(criteria);
        return (UserDataSet) query.getSingleResult();
    }

    public long insertUser(String name, String pwd) throws HibernateException {
        return (Long) session.save(new UserDataSet(name, pwd));
    }
}
