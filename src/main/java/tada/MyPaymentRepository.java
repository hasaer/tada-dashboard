package tada;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyPaymentRepository extends CrudRepository<MyPayment, Long> {

    MyPayment findByCallId(Long callId);

}