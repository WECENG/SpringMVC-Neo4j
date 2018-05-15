import cn.gdou.DAO.repository.OrderRepository;
import cn.gdou.services.OrderService;
import cn.gdou.web.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OrderTest {
    @Autowired
    private OrderService service;

    @Test
    public void orderSaveTest(){
        service.saveOrder();
    }
}
