package tada;

import tada.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPaymentViewHandler {


    @Autowired
    private MyPaymentRepository myPaymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDrivingCreated_then_CREATE_1 (@Payload DrivingCreated drivingCreated) {
        try {
            if (drivingCreated.isMe()) {
                // view 객체 생성
                MyPayment myPayment = new MyPayment();
                // view 객체에 이벤트의 Value 를 set 함
                myPayment.setCallId(drivingCreated.getCallId());
                myPayment.setDrivingStatus(drivingCreated.getDrivingStatus());
                myPayment.setStarting(drivingCreated.getStarting());
                myPayment.setDestination(drivingCreated.getDrivingStatus());
                // view 레파지 토리에 save
                myPaymentRepository.save(myPayment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDrivingCanceled_then_UPDATE_1(@Payload DrivingCanceled drivingCanceled) {
        try {
            if (drivingCanceled.isMe()) {
                // view 객체 조회
                Optional<MyPayment> myPaymentOptional = myPaymentRepository.findByCallId(drivingCanceled.getCallId());
                if( myPaymentOptional.isPresent()) {
                    MyPayment myPayment = myPaymentOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPayment.setDrivingStatus(drivingCanceled.getDrivingStatus());
                    // view 레파지 토리에 save
                    myPaymentRepository.save(myPayment);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDrivingFinished_then_UPDATE_2(@Payload DrivingFinished drivingFinished) {
        try {
            if (drivingFinished.isMe()) {
                // view 객체 조회
                Optional<MyPayment> myPaymentOptional = myPaymentRepository.findByCallId(drivingFinished.getCallId());
                if( myPaymentOptional.isPresent()) {
                    MyPayment myPayment = myPaymentOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPayment.setDrivingStatus(drivingFinished.getDrivingStatus());
                    // view 레파지 토리에 save
                    myPaymentRepository.save(myPayment);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentDone_then_UPDATE_3(@Payload PaymentDone paymentDone) {
        try {
            if (paymentDone.isMe()) {
                // view 객체 조회
                Optional<MyPayment> myPaymentOptional = myPaymentRepository.findByCallId(paymentDone.getCallId());
                if( myPaymentOptional.isPresent()) {
                    MyPayment myPayment = myPaymentOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPayment.setPaymentStatus(paymentDone.getPaymentStatus());
                    // view 레파지 토리에 save
                    myPaymentRepository.save(myPayment);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_4(@Payload PaymentCanceled paymentCanceled) {
        try {
            if (paymentCanceled.isMe()) {
                // view 객체 조회
                Optional<MyPayment> myPaymentOptional = myPaymentRepository.findByCallId(paymentCanceled.getCallId());
                if( myPaymentOptional.isPresent()) {
                    MyPayment myPayment = myPaymentOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPayment.setPaymentStatus(paymentCanceled.getPaymentStatus());
                    // view 레파지 토리에 save
                    myPaymentRepository.save(myPayment);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}