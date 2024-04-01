package metier;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class MetierImpl implements IMetier {
    // Couplage faible

    private IDao dao;
    public MetierImpl(IDao dao) {
        this.dao=dao;
    }
    @Override
    public double calcul() {

        double tmp = dao.getData();
        return tmp * 540 / Math.cos(tmp * Math.PI);
    }
    /*
    Injecter dans la variable dao un objet
    d'une classe qui implémente l'interface IDao
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
