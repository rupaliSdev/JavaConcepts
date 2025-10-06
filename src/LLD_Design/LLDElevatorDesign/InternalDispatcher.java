package LLD_Design.LLDElevatorDesign;

import java.util.List;

public class InternalDispatcher {

    List<ElevatorController>  elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar){
        int elevatorCarId;
        for(ElevatorController elevatorController:elevatorControllerList){
            if(elevatorController.elevatorCar.id==elevatorCar.id){
                elevatorController.submitInternalRequest(floor);
            }
        }

    }
}
