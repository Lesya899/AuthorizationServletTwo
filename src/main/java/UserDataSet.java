

import javax.persistence.*;
import java.io.Serializable;

@Entity  //указывает, что класс является сущностью
@Table(name = "users")  //задает основную таблицу для аннотируемого объекта
public class UserDataSet implements Serializable {

    @Id //определяет первичный ключ объекта
    @Column(name = "id") //задает сопоставленный столбец для постоянного свойства или поля
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GenerationType обеспечивает спецификацию стратегий генерации для значений первичных ключей
    //используется встроенный в БД тип данных столбца -identity - для генерации значения первичного ключа
    private long id;


    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "pwd", unique = true, updatable = false)
    private String pwd;


    @SuppressWarnings("UnusedDeclaration") //используется для запрета компилятору создавать предупреждающие сообщения
    public UserDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UserDataSet(long id, String name, String password) {
        this.setId(id);
        this.setName(name);
        this.setPwd(password);
    }

    public UserDataSet(String name, String password) {
        this.setId(-1);
        this.setName(name);
        this.setPwd(password);
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pswd='" + pwd + '\'' +
                '}';
    }
}