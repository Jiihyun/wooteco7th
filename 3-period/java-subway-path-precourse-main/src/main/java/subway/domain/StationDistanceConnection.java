package subway.domain;

public class StationDistanceConnection {
    private final Station startStation;
    private final Station endStation;
    private final int distance;
    private final int time;

    public StationDistanceConnection(final Station startStation, final Station endStation, final int distance, final int time) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
        this.time = time;
    }

    public String getStartStationName() {
        return startStation.getName();
    }

    public String getEndStationName() {
        return endStation.getName();
    }

    public Station getStartStation() {
        return startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}