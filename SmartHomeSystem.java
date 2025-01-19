import java.util.*;
interface SmartDevice{
    void turnOn();
    void turnOff();
    void turnSettings(String setting,Object value);
}
interface Commend{
    void execute();
}
class SmartLight implements SmartDevice{
    private int brightNess = 0;
    private String color = "White";
    public void turnOn(){
        System.out.println("The Smart Light is Turned ON"); 
    }
    public void turnOff(){
        System.out.println("The Smart Light is Turned OFF");
    }
    public void turnSettings(String settings,Object value){
        switch (settings.toLowerCase()) {
            case "brightness":
                brightNess = (int)value;
                System.out.println("Brightness is : "+brightNess);
                break;
            case "color":
                color = (String)value;
                System.out.println("Color set to : "+color);
                break;
            default:
                System.out.println("Invalid settings ");
                break;
        }
    }
} 
class Smartfan implements SmartDevice{
    private int speed = 0;
    private boolean swingMode = false;
    public void turnOn(){
        System.out.println("The Smart fan is Turned ON");
    }
    public void turnOff(){
        System.out.println("The Smart fan is Turned OFF");
    }
    public void turnSettings(String setting,Object value)
    {
        switch (setting.toLowerCase()) {
            case "speed":
                speed = (int)value;
                System.out.println("The fan speed set to : "+speed);
                break;
            case "swingmode":
                swingMode = (boolean)value;
                System.out.println("The fan is switched to : "+((swingMode)?"Yes":"No"));
                break;
            default:
                break;
        }
    }
}
class SmartAc implements SmartDevice{
    private int temp = 24;
    public void turnOn(){
        System.out.println("The Smart AC is turned ON");
    }
    public void turnOff(){
        System.out.println("The Smart Ac is turned OFF");
    }
    public void turnSettings(String setting,Object value)
    {
        if(setting.equalsIgnoreCase("temperature"))
        {
            temp = (int)value;
            System.out.println("The temperature set to : "+temp);
        }
        else{
            System.out.println("Enter the valid settings");
        }
    }
}
class turnOnCommend implements Commend{
    private SmartDevice device;

    public turnOnCommend(SmartDevice device) {
        this.device = device;
    }
    public void execute(){
        device.turnOn();
    }
}
class turnOffCommend implements Commend{
    private SmartDevice device;

    public turnOffCommend(SmartDevice device) {
        this.device = device;
    }
    public void execute(){
        device.turnOff();
    }
}
class turnSettingsCommend implements Commend{
    private SmartDevice device;
    private Object value;
    private String setting;
    public turnSettingsCommend(SmartDevice device, Object value, String setting) {
        this.device = device;
        this.value = value;
        this.setting = setting;
    }
    public void execute(){
        device.turnSettings(setting, value);
    }
}
class DeviceScheduler{
    public void scheduler(Commend commend,long delay)
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run(){
                commend.execute();
            }
        },delay);
    }
}
class SmartHomeController{
    private List<SmartDevice> devices = new ArrayList<>();
    public void addDevice(SmartDevice device)
    {
        devices.add(device);
    }
    public void executeCommend(Commend commend){
        commend.execute();
    }
    public void scheduleCommend(Commend commend,long delay)
    {
        DeviceScheduler scheduler = new DeviceScheduler();
        scheduler.scheduler(commend, delay);
    }
}
public class Main{
    public static void main(String[] args)
    {
        SmartHomeController controller = new SmartHomeController();
        SmartDevice light = new SmartLight();
        SmartDevice fan = new Smartfan();
        SmartDevice  ac = new SmartAc();
        controller.addDevice(ac);
        controller.addDevice(fan);
        controller.addDevice(light);
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================== Welcome to Smart Home System ============================");
        System.out.println(" ");
        System.out.println("The devices available are : ");
        System.out.println("1  --> Light");
        System.out.println("2  --> AC");
        System.out.println("3  --> Fan");
        while(true)
        {
            System.out.println("1....Light");
            System.out.println("2....AC");
            System.out.println("3....Fan");
            System.out.println("Enter Your choice : ");
            int choice = sc.nextInt();
            if(choice == 0)
            {
                System.out.println("Exiting Smart Home System. Goodbye!");
                break;
            }
            SmartDevice selectedDevice;
            switch (choice) {
                case 1:
                    selectedDevice = light;
                    break;
                case 2:
                    selectedDevice = fan;
                    break;
                case 3:
                    selectedDevice = ac;
                    break;
                default:
                    System.out.println("Enter the valid choice");
                    continue;
            }
            System.out.println("Enter Your choice  of commands : ");
            System.out.println("1  --> turnOn");
            System.out.println("2  --> turnOff");
            System.out.println("3  --> changeSettings");
            int commendChoice = sc.nextInt();
            switch (commendChoice) {
                case 1:
                    controller.executeCommend(new turnOnCommend(selectedDevice));
                    System.out.println("Turned on the device.");
                    break;

                case 2:
                    controller.executeCommend(new turnOffCommend(selectedDevice));
                    System.out.println("Turned off the device.");
                    break;

                case 3:
                    System.out.println("Enter setting name (e.g., brightness, speed, temperature): ");
                    String setting = sc.next();
                    System.out.println("Enter value (numeric or string): ");
                    String value = sc.next(); // Using String for simplicity
                    controller.executeCommend(new turnSettingsCommend(selectedDevice, setting, value));
                    System.out.println("Adjusted " + setting + " to " + value + ".");
                    break;

                case 4:
                    System.out.println("Enter command type (1: Turn On, 2: Turn Off, 3: Adjust Settings): ");
                    int scheduleCommandChoice = sc.nextInt();
                    System.out.println("Enter delay in milliseconds: ");
                    int delay = sc.nextInt();

                    Commend scheduledCommand;
                    if (scheduleCommandChoice == 1) {
                        scheduledCommand = new turnOnCommend(selectedDevice);
                    } else if (scheduleCommandChoice == 2) {
                        scheduledCommand = new turnOffCommend(selectedDevice);
                    } else if (scheduleCommandChoice == 3) {
                        System.out.println("Enter setting name (e.g., brightness, speed, temperature): ");
                        setting = sc.next();
                        System.out.println("Enter value (numeric or string): ");
                        value = sc.next();
                        scheduledCommand = new turnSettingsCommend(selectedDevice, setting, value);
                    } else {
                        System.out.println("Invalid command type for scheduling. Try again.");
                        continue;
                    }
                    controller.scheduleCommend(scheduledCommand, delay);
                    System.out.println("Scheduled command with delay of " + delay + " milliseconds.");
                    break;

                default:
                    System.out.println("Invalid command choice. Try again.");
            }
        }
        sc.close();
    }
}
