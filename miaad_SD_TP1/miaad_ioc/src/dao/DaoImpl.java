package dao;

public class DaoImpl implements IDao{
    @Override
    public double getData() {
         /*
        Se connecter à la BD pour récupérer la température
         */
        System.out.println("Version base de données");
        return Math.random() * 40;
    }
}
