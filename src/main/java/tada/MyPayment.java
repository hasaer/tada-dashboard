package tada;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MyPayment_table")
public class MyPayment {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long callId;
        private String drivingStatus;
        private String starting;
        private String destination;
        private String paymentStatus;
        private Integer charge;


        public Long getCallId() {
            return callId;
        }

        public void setCallId(Long callId) {
            this.callId = callId;
        }
        public String getDrivingStatus() {
            return drivingStatus;
        }

        public void setDrivingStatus(String drivingStatus) {
            this.drivingStatus = drivingStatus;
        }
        public String getStarting() {
            return starting;
        }

        public void setStarting(String starting) {
            this.starting = starting;
        }
        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }
        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }
        public Integer getCharge() {
            return charge;
        }

        public void setCharge(Integer charge) {
            this.charge = charge;
        }

}
