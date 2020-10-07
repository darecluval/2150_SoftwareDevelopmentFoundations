package cpsc2150.Speedster;

public class DirectionalSpeedster implements IDirectionalSpeedster {

    public double netDistance;
    private double totalDistance;
    private double totalTime;
    private double curXPos;
    private double curYPos;

    DirectionalSpeedster() {
        curXPos = 0.0;
        curYPos = 0.0;
        totalTime = 0.0;
    }

    public void addTravel(double xChange, double yChange, double time) {
        curXPos += xChange;
        curYPos += yChange;
        totalTime += time;
    }

    public double getTotalDistance() {
        return totalDistance = curXPos + curYPos;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public double getNetDistance() {
        return netDistance = Math.pow((Math.pow(curXPos, 2) + Math.pow(curYPos, 2)), 0.5);
    }

    public double getAverageSpeed() {
        return (totalDistance / totalTime);
    }

    public double getNetSpeed() {
        return (netDistance / totalTime);
    }

    public double getCurXPos() {
        return curXPos;
    }

    public double getCurYPos() {
        return curYPos;
    }

}
