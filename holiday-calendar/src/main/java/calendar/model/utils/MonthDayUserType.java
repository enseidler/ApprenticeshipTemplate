package calendar.model.utils;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.Month;
import java.time.MonthDay;


public class MonthDayUserType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.VARCHAR };
    }

    @Override
    public Class returnedClass() {
        return MonthDay.class;
    }

    @Override
    public boolean equals(Object anObject, Object anotherObject) throws HibernateException {
        return anObject.equals(anotherObject);
    }

    @Override
    public int hashCode(Object anObject) throws HibernateException {
        assert (anObject != null);
        return anObject.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object anObject) throws HibernateException, SQLException {
        String monthDayValue = StandardBasicTypes.STRING.nullSafeGet(resultSet, strings[0], sessionImplementor);
        if (monthDayValue == null)
            return null;
        String month = StringUtils.split(monthDayValue, "-")[0];
        String day = StringUtils.split(monthDayValue, "-")[1];
        MonthDay monthDay = MonthDay.of(Integer.valueOf(month), Integer.valueOf(day));
        return  monthDay;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object anObject, int index, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        MonthDay monthDay = (MonthDay) anObject;
        String monthDayValue = monthDay.getMonthValue() + "-" + monthDay.getDayOfMonth();
        StandardBasicTypes.STRING.nullSafeSet(preparedStatement,
                monthDayValue, index, sessionImplementor);
    }

    // TODO
    @Override
    public Object deepCopy(Object anObject) throws HibernateException {
        if(anObject==null)
            return null;
        else{
            MonthDay existObj=(MonthDay)anObject;
            MonthDay newObj = MonthDay.of(existObj.getMonthValue(), existObj.getDayOfMonth());

            return newObj;
        }
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object anObject) throws HibernateException {
        Object  deepCopy=deepCopy(anObject);

        if(!(deepCopy instanceof Serializable))
            return (Serializable)deepCopy;
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object anObject) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object original, Object anotherObject, Object wtfObject) throws HibernateException {
        return deepCopy(original);
    }

}
