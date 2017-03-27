package util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

private static HibernateUtil instance = null;

   private static SessionFactory sessionFactory;
   //private static StandardServiceRegistry serviceRegistry;

   private HibernateUtil(){
        //Configuration configuration = new Configuration();
        //configuration.configure();
        //serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        //sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        //Session session = sessionFactory.openSession();
	   
       //sessionFactory = new Configuration().configure().buildSessionFactory();
	   
	   
	   //Configuration configuration = new Configuration().addResource("ConexionHibernate");
	   //sessionFactory = configuration.buildSessionFactory();

	   Configuration configuration = new Configuration();
       configuration.configure();
       sessionFactory = configuration.buildSessionFactory();
	   //sessionFactory = configuration.configure(new File("hibernate.cgf.xml")).buildSessionFactory();

   }

   public static HibernateUtil getInstance(){
        if(instance == null){
            instance  = new HibernateUtil();
        }
        return instance;
   }

   public static SessionFactory getSessionFactory() {
	   if(instance == null){
           instance  = new HibernateUtil();
	   }
        return sessionFactory;
   }

/*   
   private static StandardServiceRegistry serviceRegistry; 
   private static SessionFactory INSTANCE = null;
   public static SessionFactory getSessionFactory() {
        if(INSTANCE=null){
             createSessionFactory():
         }
         return sessionFactory;
   }
   private synchronized static void createSessionFactory(){
       if(INSTANCE!=null){return;}
       Configuration configuration = new Configuration();
       configuration.configure();
       SeviceRegistry=newStandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       }
     }
*/
}