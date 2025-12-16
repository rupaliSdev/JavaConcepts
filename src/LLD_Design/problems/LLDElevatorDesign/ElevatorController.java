package LLD_Design.problems.LLDElevatorDesign;


import java.util.List;
import java.util.PriorityQueue;

public  class ElevatorController {

    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    List<Integer> pendingTasks;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar){

        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a,b) -> b-a);

    }
     public void submitExternalRequest(int floor, Direction direction){

        if(direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
     }

    public void submitInternalRequest(int floor){
        if(elevatorCar.elevatorDirection==Direction.UP){
            if(upMinPQ.peek()>floor){
                pendingTasks.add(floor);
            }
            else{
            upMinPQ.offer(floor);
            }
        }

        else{
            if(downMaxPQ.peek()<floor){
                pendingTasks.add(floor);
            }
            else{

            downMaxPQ.offer(floor);}
        }
    }

    public void controlElevator(){
        while(true) {

            if(elevatorCar.elevatorDirection == Direction.UP){
                elevatorCar.moveElevator(Direction.UP,upMinPQ.poll());
                if (upMinPQ.size()==0){
                    elevatorCar.elevatorDirection=Direction.DOWN;
                    upMinPQ.addAll(pendingTasks);
                }
            }
            else{
                elevatorCar.moveElevator(Direction.DOWN,downMaxPQ.poll());
                if (upMinPQ.size()==0){
                    elevatorCar.elevatorDirection=Direction.UP;
                    downMaxPQ.addAll(pendingTasks);
                }
            }
        }
    }
}
