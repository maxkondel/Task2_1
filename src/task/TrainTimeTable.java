package task;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@XmlRootElement(name="trainTimeTable")
public class TrainTimeTable {

    @XmlElement(name="train")
    private List<Train> trains = new ArrayList<Train>();

    public void add(Train train) {
        trains.add(train);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }

    public TrainTimeTable filter(Date from, Date before) throws ParseException {
        TrainTimeTable trainsFilter = new TrainTimeTable();
        for (Train train: trains) {
            SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy HH:mm");
            Date date = ft.parse(train.getDate()+ " " + train.getDeparture());
            if (date.compareTo(from)>=0 && date.compareTo(before)<=0) trainsFilter.add(train);
        }
        return trainsFilter;
    }

}
