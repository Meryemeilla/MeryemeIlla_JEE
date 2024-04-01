package ext;

import dao.IDao;

public class DaoImplVWS implements IDao {


    @Override
    public double getData() {
        System.out.println("Version web services");
        return 90;
    }
}
