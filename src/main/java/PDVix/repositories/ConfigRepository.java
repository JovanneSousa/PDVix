package PDVix.repositories;

import PDVix.Entities.Config;
import PDVix.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.Optional;

public class ConfigRepository {
    public Optional<Config> findById(String chave) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Config config = session.get(Config.class, chave);
            return Optional.ofNullable(config);
        }
    }

    public void save(Config config) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(config);
            session.getTransaction().commit();
        }
    }

    public void delete(String chave) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Config config = session.get(Config.class, chave);
            if (config != null) {
                session.remove(config);
            }
            session.getTransaction().commit();
        }
    }
}
