abstract class Device {
    int deviceId;

    abstract void deviceInfo();
    abstract void connect();
    abstract void disconnect();
    abstract void send();
    abstract void receive();

}

// UsbProt1
class UsbProt1 extends Device {
    UsbProt1(int id){
        this.deviceId = id;
    }

    @Override
    void deviceInfo() {
        System.out.println("id = " + this.deviceId);
    }

    @Override
    void connect() {
        System.out.println("연결 되었습니다.");
    }

    @Override
    void disconnect() {
        System.out.println("연결이 해제되었습니다.");
    }

    @Override
    void send() {
        System.out.println("데이터를 전송합니다.");
    }

    @Override
    void receive() {
        System.out.println("데이터를 수신합니다.");
    }
}

// Wifi
class Wifi extends Device {
    public Wifi(int id) {
        this.deviceId =  id;
    }

    @Override
    void deviceInfo() {

    }

    @Override
    void connect() {

    }

    @Override
    void disconnect() {

    }

    @Override
    void send() {

    }

    @Override
    void receive() {

    }
}

public class Pratice {

    public static void main(String[] args) {
        // Test Code
        UsbProt1 usb = new UsbProt1(1);

        Wifi wifi = new Wifi(0);
    }

}
