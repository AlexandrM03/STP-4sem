import DAO.DAORequests;
import DAO.MyDAO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Starting program");

        MyDAO dao = new MyDAO();

        try {
            var connection = dao.getConnection();
            var requests = new DAORequests(connection);

            requests.getPlanetsWithLife();
            LOG.info("getPlanetsWithLife DONE");
            requests.smallestRadius();
            LOG.info("smallestRadius DONE");
            requests.maxSputnikRadius();
            LOG.info("maxSputnikRadius DONE");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
