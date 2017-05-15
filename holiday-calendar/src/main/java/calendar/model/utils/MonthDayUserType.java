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
    public boolean equals(Object o, Object o1) throws HibernateException {
        return o.equals(o1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        assert (o != null);
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        String monthDayValue = StandardBasicTypes.STRING.nullSafeGet(resultSet, strings[0], sessionImplementor);
        if (monthDayValue == null) {
            return null;
        }
        String month = StringUtils.split(monthDayValue, "-")[0];
        String day = StringUtils.split(monthDayValue, "-")[1];
        MonthDay monthDay = MonthDay.of(Integer.valueOf(month), Integer.valueOf(day));
        return  monthDay;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        MonthDay monthDay = (MonthDay) o;
        String monthDayValue = monthDay.getMonthValue() + "-" + monthDay.getDayOfMonth();
        StandardBasicTypes.STRING.nullSafeSet(preparedStatement,
                (monthDayValue != null) ? monthDayValue : null , i, sessionImplementor);
    }

    // TODO
    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }
}
