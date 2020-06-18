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
                MyPayment myPayment = new MyPayment();
                myPayment.setCallId(drivingCreated.getCallId());
                myPayment.setDrivingStatus(drivingCreated.getDrivingStatus());
                myPayment.setStarting(drivingCreated.getStarting());
                myPayment.setDestination(drivingCreated.getDestination());
                myPayment.setCharge(drivingCreated.getCharge());
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
                MyPayment myPayment = myPaymentRepository.findByCallId(drivingCanceled.getCallId());
                myPayment.setDrivingStatus(drivingCanceled.getDrivingStatus());
                myPaymentRepository.save(myPayment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDrivingFinished_then_UPDATE_2(@Payload DrivingFinished drivingFinished) {
        try {
            if (drivingFinished.isMe()) {
                MyPayment myPayment = myPaymentRepository.findByCallId(drivingFinished.getCallId());
                myPayment.setDrivingStatus(drivingFinished.getDrivingStatus());
                myPaymentRepository.save(myPayment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentDone_then_UPDATE_3(@Payload PaymentDone paymentDone) {
        try {
            if (paymentDone.isMe()) {
                MyPayment myPayment = myPaymentRepository.findByCallId(paymentDone.getCallId());
                myPayment.setPaymentStatus(paymentDone.getPaymentStatus());
                myPaymentRepository.save(myPayment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_4(@Payload PaymentCanceled paymentCanceled) {
        try {
            if (paymentCanceled.isMe()) {
                MyPayment myPayment = myPaymentRepository.findByCallId(paymentCanceled.getCallId());
                myPayment.setPaymentStatus(paymentCanceled.getPaymentStatus());
                myPaymentRepository.save(myPayment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}